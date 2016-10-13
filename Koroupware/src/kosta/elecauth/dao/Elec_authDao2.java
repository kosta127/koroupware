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
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.elecauth.mapper.Elec_authMapper;
import kosta.elecauth.model.Elec_auth;
import kosta.etc.SessionFactory;

public class Elec_authDao2 {
	private static Elec_authDao2 dao=new Elec_authDao2();
	public final int LIST_SIZE=10;
	
	public static Elec_authDao2 getInstance(){
		return dao;
	}
	
	public int insertElecAuth(Elec_auth ea){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(Elec_authMapper.class).insertElecAuth(ea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
}
