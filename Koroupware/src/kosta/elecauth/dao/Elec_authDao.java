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
import kosta.elecauth.model.Elec_authDetail;
import kosta.etc.SessionFactory;

public class Elec_authDao {
	private static Elec_authDao dao=new Elec_authDao();
	public final int LIST_SIZE=10;
	
	public static Elec_authDao getInstance(){
		return dao;
	}	
	
	public List<Elec_auth> elec_authList(int startRow){
		SqlSession sqlSession=SessionFactory.getInstance().openSession();
		List<Elec_auth> list=null;
		
		try {
			list=sqlSession.getMapper(Elec_authMapper.class).elec_authList(
					new RowBounds(startRow, LIST_SIZE));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return list;
	}
	
	public int getTotalCount(){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		int totalCount = 0;
		try {
			totalCount = sqlSession.getMapper(Elec_authMapper.class).getTotalCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return totalCount;
	}
	
	public Elec_authDetail elec_authDetail(int elec_auth_no){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		Elec_authDetail elec_authDetail=null;
		try {
			elec_authDetail=sqlSession.getMapper(Elec_authMapper.class).elec_authDetail(elec_auth_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return elec_authDetail;
	}
	
	public int insertElecAuth(Elec_auth ea){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		int res = -1;
		try {
			res = sqlSession.getMapper(Elec_authMapper.class).insertElecAuth(ea);
			if(res>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return res;
	}
}
