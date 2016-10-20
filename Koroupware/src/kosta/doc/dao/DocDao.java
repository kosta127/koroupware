package kosta.doc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.doc.mapper.DocMapper;
import kosta.doc.model.Doc;
import kosta.doc.model.DocBox;
import kosta.doc.model.DocFile;
import kosta.doc.model.DocHis;
import kosta.doc.model.DocManagement;

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
	
	public int insertDoc(Doc doc){
		SqlSession sqlSession = getSqlSessionFactory().openSession();

		int re = 0;
		try {
			re = sqlSession.getMapper(DocMapper.class).insertDoc(doc);
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
			if(sqlSession.getMapper(DocMapper.class).selectDoc_no() == null){
				return 0;
			}else {
				return sqlSession.getMapper(DocMapper.class).selectDoc_no();
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
			if(sqlSession.getMapper(DocMapper.class).selectDoc_box_no() == null){
				return 0;
			}else {
				return sqlSession.getMapper(DocMapper.class).selectDoc_box_no();
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
			return sqlSession.getMapper(DocMapper.class).listDoc();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public List<DocBox> listDoc_box(int emp_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(DocMapper.class).listDoc_box(emp_no);
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
			return sqlSession.getMapper(DocMapper.class).detailDoc(doc_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public int insertDoc_box(DocBox doc_box){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).insertDoc_box(doc_box);
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
	
	public String selectEmp_name(int emp_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(DocMapper.class).selectEmp_name(emp_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
		
	}
	public List<Doc> detailDoc_box(int doc_box_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			return sqlSession.getMapper(DocMapper.class).detailDoc_box(doc_box_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	public int selectDoc_management_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			if(sqlSession.getMapper(DocMapper.class).selectDoc_management_no() == null){
				return 0;
			}else {
				return sqlSession.getMapper(DocMapper.class).selectDoc_management_no();
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	public int insertDoc_management(DocManagement doc_management){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).insertDoc_management(doc_management);
			if(re > 0) {
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
	public int updateDoc_box_name(DocBox doc_box){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(DocMapper.class).updateDoc_box_name(doc_box);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	public DocBox selectDoc_box(int doc_box_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.getMapper(DocMapper.class).selectDoc_box(doc_box_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public int selectDoc_file_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try{
			if(sqlSession.getMapper(DocMapper.class).selectDoc_file_no() == null){
				return 0;
			}else{
				return sqlSession.getMapper(DocMapper.class).selectDoc_file_no();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	
	public int insertDoc_file(DocFile doc_file){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).insertDoc_file(doc_file);
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
	
	public List<DocFile> selectDoc_file(int doc_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.getMapper(DocMapper.class).selectDoc_file(doc_no);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	
	
	public int deleteDoc_box(int doc_box_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(DocMapper.class).deleteDoc_box(doc_box_no);
			if(re > 0){
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	
	public int deleteDoc_box_management(int doc_management_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(DocMapper.class).deleteDoc_box_management(doc_management_no);
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
	
	
	public int deleteDoc(int doc_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).deleteDoc(doc_no);
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
	
	public int deleteDoc_management(DocManagement doc_management){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).deleteDoc_management(doc_management);
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
	
	public int insertDoc_his(DocHis doc_his){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			re = sqlSession.getMapper(DocMapper.class).insertDoc_his(doc_his);
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
	
	public int selectDoc_his_no(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try{
			if(sqlSession.getMapper(DocMapper.class).selectDoc_his_no()==null){
				re = 0;
			}else {
				re = sqlSession.getMapper(DocMapper.class).selectDoc_his_no();
			}
		}catch (Exception e) {
			e.printStackTrace();
			re = 0;
		}finally{
			sqlSession.close();
		}
		return re;
	}
	
	public int updateDoc(Doc doc){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(DocMapper.class).updateDoc(doc);
			if(re > 0){
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		}catch (Exception e) {
			e.printStackTrace();
			re = 0;
		}finally{
			sqlSession.close();
		}
		return re;
	}
	
	public List<DocHis> listDocHis(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try{
			return sqlSession.getMapper(DocMapper.class).listDocHis();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
}
