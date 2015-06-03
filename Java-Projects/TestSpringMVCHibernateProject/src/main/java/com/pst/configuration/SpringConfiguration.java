package com.pst.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.SimpleTransactionStatus;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.pst" })
public class SpringConfiguration {

	/**
	 * set up our application's view resolver - URL resolver with fallback to
	 * dynamic content resolver
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver setUpViewResolver() {
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();

		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
		UrlBasedViewResolver ubvr = new UrlBasedViewResolver();
		ubvr.setViewClass(JstlView.class);
		ubvr.setPrefix("/WEB-INF/jsp/");
		ubvr.setSuffix(".jsp");
		viewResolvers.add(ubvr);
		cnvr.setViewResolvers(viewResolvers);

		List<View> viewList = new ArrayList<View>();
		MappingJacksonJsonView mjjv = new MappingJacksonJsonView();
		mjjv.setPrefixJson(true);
		viewList.add(mjjv);
		cnvr.setDefaultViews(viewList);

		return cnvr;
	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new PlatformTransactionManager() {

			@Override
			public void rollback(TransactionStatus arg0)
					throws TransactionException {
				System.out
						.println(Thread.currentThread().getId() + "|Rollback");
			}

			@Override
			public TransactionStatus getTransaction(TransactionDefinition arg0)
					throws TransactionException {
				System.out.println(Thread.currentThread().getId()
						+ "|Get Transaction");
				SimpleTransactionStatus sts = new SimpleTransactionStatus();
				return sts;
			}

			@Override
			public void commit(TransactionStatus arg0)
					throws TransactionException {
				System.out.println(Thread.currentThread().getId() + "|Commit");
			}
		};
	}
}
