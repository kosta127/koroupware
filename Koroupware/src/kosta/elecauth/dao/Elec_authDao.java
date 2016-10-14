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
import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_authDetailAR;
import kosta.elecauth.model.Elec_auth_referrer;
import kosta.elecauth.model.EmpDetail;
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
	
	public Elec_authDetailAR elec_authDetailAR(int elec_auth_no){
		SqlSession sqlSession=SessionFactory.getInstance().openSession();
		Elec_authDetailAR elec_authDetailAR=null;
		try {
			elec_authDetailAR=sqlSession.getMapper(Elec_authMapper.class).elec_authDetailAR(elec_auth_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return elec_authDetailAR;
	}
	
	public boolean insertElecAuth(Elec_auth ea, 
			List<Approval_list> approvals, List<Elec_auth_referrer> referrers ){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		int res = -1;
		boolean result = false;
		try {
			Elec_authMapper mapper = sqlSession.getMapper(Elec_authMapper.class);
			res = mapper.insertElecAuth(ea);
			if(res > 0){
				for(Approval_list al : approvals){
					if((res = mapper.insertApprovalList(al)) < 0) throw new Exception("APPROVAL LIST INSERT FAILED");
				}
				for(Elec_auth_referrer ref : referrers){
					if((res = mapper.insertElecAuthReferrer(ref)) < 0) throw new Exception("ELEC AUTH REFERRER INSERT FAILED");
				}
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(result){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
			sqlSession.close();
		}
		return result;
	}
	
	public List<EmpDetail> searchEmp(String keyword){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		List<EmpDetail> emps = null;
		try {
			emps = sqlSession.getMapper(Elec_authMapper.class).searchEmp("%"+keyword+"%");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return emps;
	}
}
