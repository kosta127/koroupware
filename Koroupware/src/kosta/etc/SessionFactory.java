package kosta.etc;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {
	//SessionFactory를 singleton pattern 처리
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance(){
		if(sqlSessionFactory == null){
			String resource = "mybatis-config.xml";
			InputStream is = null;
			
			try {
				is = Resources.getResourceAsStream(resource);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		
		return sqlSessionFactory;
	}
}
