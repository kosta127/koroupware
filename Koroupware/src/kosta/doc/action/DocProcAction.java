package kosta.doc.action;


import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.doc.dao.DocDao;
import kosta.doc.model.Doc;
import kosta.doc.model.DocFile;

public class DocProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward forward = new ActionForward();
		DocDao dao = DocDao.getInstance();
		Doc doc = new Doc();
		DocFile doc_file = new DocFile();
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024;	//20MB
		
		
			MultipartRequest multi = 
					new MultipartRequest(request, uploadPath, size,
							"utf-8",new DefaultFileRenamePolicy());
		int emp_no = Integer.parseInt(multi.getParameter("emp_no"));
		int doc_box_no = Integer.parseInt(multi.getParameter("doc_box_no"));
		request.setAttribute("emp_no", emp_no);
		request.setAttribute("doc_box_no", doc_box_no);
		SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
		Date date= null;
		try {
			System.out.println(request.getParameter("doc_con_period"));
			date = format.parse(multi.getParameter("doc_con_period"));
			System.out.println(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
			doc.setDoc_no(dao.selectDoc_no()+1);
			doc.setDoc_con_period(date);
			doc.setDoc_title(multi.getParameter("doc_title"));
			doc.setDoc_explain(multi.getParameter("doc_explain"));
			doc.setDoc_contents(multi.getParameter("doc_contents"));
			doc.setEmp_no(emp_no);
			doc.setDoc_formYN(multi.getParameter("doc_formYN"));
			doc_file.setDoc_no(doc.getDoc_no());
			
			
		if(multi.getFilesystemName("doc_file_real_name") != null) {
			String doc_file_real_name = multi.getFilesystemName("doc_file_real_name");	//���� ���ε�� ���� �̸� ������ �Լ�
			UUID uid = UUID.randomUUID();
			doc_file.setDoc_file_real_name(doc_file_real_name);
			String doc_file_save_name = uid.toString() + "_" + doc_file_real_name;
			 doc_file.setDoc_file_real_name(doc_file_real_name);
	         doc_file.setDoc_file_save_name(doc_file_save_name);
	         doc_file.setDoc_file_no(dao.selectDoc_file_no()+1);
	            
	         }else{
	            doc_file.setDoc_file_real_name("");
	         }
		
		
		System.out.println(doc);
		
		
		int re = dao.insertDoc(doc);
		int ref = dao.insertDoc_file(doc_file);
		if(re > 0) {
			if(ref > 0){
				forward.setRedirect(false);
				forward.setPath("listDoc.do");
			}
			
		}
		
		
		return forward;
	}
}


