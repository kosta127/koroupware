package kosta.document.mapper;

import java.util.List;

import kosta.document.model.Doc;
import kosta.document.model.DocBox;

public interface DocumentMapper {
	public int insertDoc(Doc document);
	public Integer selectDoc_no();
	public List<Doc> listDoc();
	public Doc detailDoc(int doc_no);
	public int insertDoc_box(DocBox documentbox);
	public Integer selectDoc_box_no();
	public List<DocBox> listDoc_box();
	
}
