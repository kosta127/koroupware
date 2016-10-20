package kosta.sendRandomPwd.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.emp.model.Emp;
import kosta.sendRandomPwd.mapper.SendPwd;

public class sendRandomPwdDao {
	private static sendRandomPwdDao dao = new sendRandomPwdDao();

	public static sendRandomPwdDao getInstance() {
		return dao;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(input);
	}



	public int changpwd(Emp list) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(SendPwd.class).SendPwd(list);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
		return re;
	}
}
