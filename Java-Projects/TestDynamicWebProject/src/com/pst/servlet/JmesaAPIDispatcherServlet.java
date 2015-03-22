/**
 * 
 */
package com.pst.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.prefs.Preferences;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jmesa.model.TableModel;
import org.jmesa.view.editor.DateCellEditor;
import org.jmesa.view.html.component.HtmlColumn;
import org.jmesa.view.html.component.HtmlRow;
import org.jmesa.view.html.component.HtmlTable;

import com.pst.domain.Person;
import com.pst.jmesa.editor.ListCellEditor;
import com.pst.jmesa.view.CustomColumnSort;
import com.pst.jmesa.view.CustomTableView;

/**
 * Create/Configure JMesa Table
 */
@WebServlet(urlPatterns="/jmesaApiTest")
public class JmesaAPIDispatcherServlet extends JmesaBaseServlet {

	private static final long serialVersionUID = 2674371989839794165L;

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.info("JmesaAPIDispatcherServlet : doGet invoked");
		
		//set up data
		createAndStorePersonList(req);

		TableModel tableModel = new TableModel("apiTestTable", req);
		tableModel.setView(new CustomTableView());
		tableModel.setColumnSort(new CustomColumnSort());
		tableModel.setItems((Collection<Person>) req.getSession().getAttribute("personList"));

		HtmlTable htmlTable = new HtmlTable();
		
		HtmlRow htmlRow = new HtmlRow();
		htmlTable.setRow(htmlRow);

		HtmlColumn firstName = new HtmlColumn("personName").title("Person Name");
		firstName.setSortable(true);
		htmlRow.addColumn(firstName);

		HtmlColumn lastName = new HtmlColumn("age").title("Age");
		lastName.setSortable(true);
		htmlRow.addColumn(lastName);

		HtmlColumn term = new HtmlColumn("birthDate").title("Pagan Birth Date").cellEditor(new DateCellEditor("MM/dd/yyyy"));
		term.setSortable(true);
		htmlRow.addColumn(term);

		HtmlColumn career = new HtmlColumn("hireDate").title("Hire Date").cellEditor(new DateCellEditor("MM/dd/yyyy"));
		career.setSortable(true);
		htmlRow.addColumn(career);

		HtmlColumn born = new HtmlColumn("favoriteColor").title("Favorite Color");
		born.setSortable(true);
		htmlRow.addColumn(born);

		HtmlColumn hobbies = new HtmlColumn("hobbies").title("Hobbies").cellEditor(new ListCellEditor());
		hobbies.setSortable(true);
		htmlRow.addColumn(hobbies);

		tableModel.setTable(htmlTable);

		String html = tableModel.render();

		req.getSession().setAttribute("tableModel", tableModel);
		req.getSession().setAttribute("apiTestTable", html);
		
		//dispatch to view
		req.getRequestDispatcher("/jmesaApiTest.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.info("JmesaAPIDispatcherServlet : doPost invoked");
		
		
		//dispatch to view
		req.getRequestDispatcher("/jmesaApiTest.jsp").forward(req, resp);		
	}
	
}
