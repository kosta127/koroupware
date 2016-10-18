package kosta.search.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.doc.model.Doc;
import kosta.emp.model.Emp;
import kosta.search.mapper.SearchMapper;
import kosta.search.model.Search;

public class SearchDao {
	private static SearchDao dao = new SearchDao();

	public static SearchDao getInstance() {
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

	public List<Emp> ListEmp() {
		// 로그인 용 리스트

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			return sqlSession.getMapper(SearchMapper.class).ListEmp();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}

	}

	public List<Doc> ListDoc() {
		// 로그인 용 리스트

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			return sqlSession.getMapper(SearchMapper.class).ListDoc();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}

	}

	public List<Search> SearchName(String search_content) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(SearchMapper.class).SearchName(search_content);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}
	}

	public List<Doc> SearchDoc(String search_content) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println(search_content);
		try {
			return sqlSession.getMapper(SearchMapper.class).SearchDoc(search_content);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}

	}

	public List<Doc> SearchDocEmpName(String search_content) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println(search_content);
		try {
			return sqlSession.getMapper(SearchMapper.class).SearchDocEmpName(search_content);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			sqlSession.close();
		}

	}
}
