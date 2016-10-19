package kosta.doc.mapper;

import java.util.List;

import kosta.doc.model.Doc;
import kosta.doc.model.DocBox;
import kosta.doc.model.DocFile;
import kosta.doc.model.DocHis;
import kosta.doc.model.DocManagement;

public interface DocMapper {
	public int insertDoc(Doc doc);
	public Integer selectDoc_no();
	public List<Doc> listDoc();
	public Doc detailDoc(int doc_no);
	public int insertDoc_box(DocBox doc_box);
	public Integer selectDoc_box_no();
	public List<DocBox> listDoc_box(int emp_no);
	public String selectEmp_name(int emp_no);
	public List<Doc> detailDoc_box(int doc_box_no);
	public Integer selectDoc_management_no();
	public int insertDoc_management(DocManagement doc_management);
	public int updateDoc_box_name(DocBox doc_box);
	public DocBox selectDoc_box(int doc_box_no);
	public Integer selectDoc_file_no();
	public int insertDoc_file(DocFile doc_file);
	public List<DocFile> selectDoc_file(int doc_no);
	
	public int deleteDoc_box(int doc_box_no);
	public int deleteDoc_box_management(int doc_management_no);
	public int deleteDoc(int doc_no);
	public int deleteDoc_management(DocManagement doc_management);
	public int insertDoc_his(DocHis doc_his);
	public Integer selectDoc_his_no();
	public int updateDoc(Doc doc);
	public List<DocHis> listDocHis();
}
