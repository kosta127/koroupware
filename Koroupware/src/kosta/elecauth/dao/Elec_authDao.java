package kosta.elecauth.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.elecauth.mapper.Elec_authMapper;
import kosta.elecauth.model.Elec_auth;

public class Elec_authDao {
	private static Elec_authDao dao=new Elec_authDao();
	
	public static Elec_authDao getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource="mybatis-config.xml";
		InputStream input=null;
		try {
			input=Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(input);
	}
	
	public List<Elec_auth> elec_authList(){
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		List<Elec_auth> list=null;
		
		try {
			list=sqlSession.getMapper(Elec_authMapper.class).elec_authList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return list;
	}
	
}
