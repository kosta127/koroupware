package kosta.community.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	private static SqlSessionFactory sessionFactory;
	
	static {
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sessionFactory = new SqlSessionFactoryBuilder().build(input);
	}
	
	public static SqlSessionFactory getInstance(){
		return sessionFactory;
	}
}
