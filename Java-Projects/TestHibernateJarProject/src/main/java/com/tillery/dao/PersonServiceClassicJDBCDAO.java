package com.tillery.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.tillery.model.Person;

public class PersonServiceClassicJDBCDAO {

	/**
	 * expects a mysql server to be running containing:
	 *  database: 'richdb' 
	 *  table: 'person' 
	 *  columns: 'firstname' and 'lastname'
	 * @return
	 * @throws Exception
	 */
	public List<Person> fetchAllPersons() throws Exception {
		List<Person> people = new ArrayList<Person>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			//open up connection, fetch people
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "blahblah");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", properties);
			statement = connection.prepareStatement("SELECT * FROM richdb.person");
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Person person = new Person();
				person.setFirstName(resultSet.getString("firstname"));
				person.setLastName(resultSet.getString("lastName"));
				people.add(person);
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				resultSet.close();				
			}
			if(statement != null) {
				statement.close();				
			}
			if(connection != null) {
				connection.close();				
			}
		}

		return people;
	}


	public void addPerson(int id, String firstName, String lastName) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			//open up connection, add person
			Properties properties = new Properties();
			properties.put("user", "root");
			properties.put("password", "blahblah");
			properties.put("allowMultiQueries", "true");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", properties);
			String sql = "INSERT INTO richdb.person (id, firstname, lastname) VALUES (" + id + ", \"" + firstName + "\", \"" + lastName + "\")";
			System.out.println(sql);
			statement = connection.prepareStatement(sql);	
			statement.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(statement != null) {
				statement.close();				
			}
			if(connection != null) {
				connection.close();				
			}
		}

	}

}
