package kosta.document.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.document.mapper.DocumentMapper;
import kosta.document.model.Doc;
import kosta.document.model.DocBox;

public class DocDao {
	private static DocDao dao = new DocDao();
	
	public static DocDao getInstance(){
		return dao;
	}
	
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try{
			input = Resources.getResourceAsStream(resource);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(input);
		
	}
	
	public int insertDoc(Doc document){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(DocumentMapper.class).insertDoc(document);
			if(re > 0){
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	public int selectDoc_no() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			if(sqlSession.getMapper(DocumentMapper.class).selectDoc_no() == null){
				return 0;
			}else {
				return sqlSession.getMapper(DocumentMapper.class).selectDoc_no();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	public int selectDoc_box_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			if(sqlSession.getMapper(DocumentMapper.class).selectDoc_box_no() == null){
				return 0;
			}else {
				return sqlSession.getMapper(DocumentMapper.class).selectDoc_box_no();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Doc> listDoc() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(DocumentMapper.class).listDoc();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<DocBox> listDoc_box(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(DocumentMapper.class).listDoc_box();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public Doc detailDoc(int doc_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.getMapper(DocumentMapper.class).detailDoc(doc_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public int insertDoc_box(DocBox documentbox){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocumentMapper.class).insertDoc_box(documentbox);
			if(re > 0){
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
		return re;
	}
}
