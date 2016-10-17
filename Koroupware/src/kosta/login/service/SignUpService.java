package kosta.login.service;
import kosta.login.dao.SignUpDao;
import kosta.login.model.ImageUtil;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.emp.model.Emp;
import kosta.emp.model.Tel;

public class SignUpService {
	private static SignUpDao dao;
	private static SignUpService service = new SignUpService();
	private static int tel_emp_no;
	private static MultipartRequest multipartRequest;
	public static SignUpService getInstance() {
		dao = SignUpDao.getInstance();
		return service;
	}

	public int NewSignUpService(HttpServletRequest request) throws IOException{
		Emp emp = new Emp();
		String uploadPath = request.getRealPath("/upload");
		System.out.println(uploadPath);
		int size = 20 * 1024 * 1024; // 20mb
		
		multipartRequest = new MultipartRequest(request, uploadPath, size, "utf-8",
					new DefaultFileRenamePolicy());
		System.out.println(multipartRequest.getParameter("emp_id"));
		tel_emp_no = dao.selectEmp_no() + 1;
		emp.setEmp_no(tel_emp_no);
		emp.setDept_no(1);
		emp.setEmp_id(multipartRequest.getParameter("emp_id"));
		emp.setEmp_password(multipartRequest.getParameter("emp_password"));
		emp.setEmp_name(multipartRequest.getParameter("emp_name"));
		emp.setEmp_residentnumber(multipartRequest.getParameter("emp_residentnumber"));
		emp.setEmp_email(multipartRequest.getParameter("emp_email"));
		emp.setEmp_address(multipartRequest.getParameter("emp_address"));
		emp.setEmp_elec_auth_signkey(multipartRequest.getParameter("emp_elec_auth_signkey"));
		
		if (multipartRequest.getFilesystemName("emp_img") != null) {// getFilesystemName
			// - file이름
			// 추출해주는 함수
			String emp_img = multipartRequest.getFilesystemName("emp_img");
			emp.setEmp_img(emp_img);
			System.out.println("썸네일이미지");
			// 썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
			String pattern = emp_img.substring(emp_img.lastIndexOf(".") + 1); // gif
			String headName = emp_img.substring(0, emp_img.lastIndexOf(".")); // aaa

			// 원본파일 이미지 => File 객체화
			String imagePath = uploadPath + "\\" + emp_img;
			File src = new File(imagePath);

			// 썸네일 이미지 => File 객체화
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			System.out.println("파일생성");
			// 썸네일 이미지 생성
			if (pattern.equals("jpg") || pattern.equals("gif")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			System.out.println("썸네일 이미지 생성");
		} else {
			emp.setEmp_img("test");
		}
		
		if (multipartRequest.getFilesystemName("emp_elec_auth_img") != null) {// getFilesystemName
			// - file이름
			// 추출해주는 함수
			String emp_elec_auth_img = multipartRequest.getFilesystemName("emp_elec_auth_img");
			emp.setEmp_elec_auth_img(emp_elec_auth_img);
			System.out.println("썸네일이미지");
			// 썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
			String pattern = emp_elec_auth_img.substring(emp_elec_auth_img.lastIndexOf(".") + 1); // gif
			String headName = emp_elec_auth_img.substring(0, emp_elec_auth_img.lastIndexOf(".")); // aaa

			// 원본파일 이미지 => File 객체화
			String imagePath = uploadPath + "\\" + emp_elec_auth_img;
			File src = new File(imagePath);

			// 썸네일 이미지 => File 객체화
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			System.out.println("파일생성");
			// 썸네일 이미지 생성
			if (pattern.equals("jpg") || pattern.equals("gif")) {
				ImageUtil.resize(src, dest, 150, ImageUtil.RATIO);
			}
			System.out.println("썸네일 이미지 생성");
		} else {
			emp.setEmp_elec_auth_img("test");
		}
		
		System.out.println(emp);
		
		System.out.println("?");
		System.out.println("됨");
		return dao.SignUp(emp);
	}

	public int TelInsertService(Tel tel) {
		tel.setTel_no(dao.selectTel_no() + 1);
		tel.setEmp_no(tel_emp_no);
		tel.setTel_type(multipartRequest.getParameter("tel_type"));
		tel.setTel_telephone(multipartRequest.getParameter("tel_telephone"));
		
		return dao.TelInsert(tel);
	}
	
	public int EmpUpdateService(HttpServletRequest request) throws IOException{
		Emp emp = new Emp();
		String uploadPath = request.getRealPath("/upload");
		System.out.println(uploadPath);
		int size = 20 * 1024 * 1024; // 20mb
		
		multipartRequest = new MultipartRequest(request, uploadPath, size, "utf-8",
					new DefaultFileRenamePolicy());
		
		emp.setEmp_no(tel_emp_no);
		emp.setDept_no(1);
		emp.setEmp_id(multipartRequest.getParameter("emp_id"));
		emp.setEmp_password(multipartRequest.getParameter("emp_password"));
		emp.setEmp_name(multipartRequest.getParameter("emp_name"));
		emp.setEmp_residentnumber(multipartRequest.getParameter("emp_residentnumber"));
		emp.setEmp_email(multipartRequest.getParameter("emp_email"));
		emp.setEmp_address(multipartRequest.getParameter("emp_address"));
		emp.setEmp_elec_auth_signkey(multipartRequest.getParameter("emp_elec_auth_signkey"));
		
		if (multipartRequest.getFilesystemName("emp_img") != null) {// getFilesystemName
			// - file이름
			// 추출해주는 함수
			String emp_img = multipartRequest.getFilesystemName("emp_img");
			emp.setEmp_img(emp_img);
			System.out.println("썸네일이미지");
			// 썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
			String pattern = emp_img.substring(emp_img.lastIndexOf(".") + 1); // gif
			String headName = emp_img.substring(0, emp_img.lastIndexOf(".")); // aaa

			// 원본파일 이미지 => File 객체화
			String imagePath = uploadPath + "\\" + emp_img;
			File src = new File(imagePath);

			// 썸네일 이미지 => File 객체화
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			System.out.println("파일생성");
			// 썸네일 이미지 생성
			if (pattern.equals("jpg") || pattern.equals("gif")) {
				ImageUtil.resize(src, dest, 150, ImageUtil.RATIO);
			}
			System.out.println("썸네일 이미지 생성");
		} else {
			emp.setEmp_img("test");
		}
		
		if (multipartRequest.getFilesystemName("emp_elec_auth_img") != null) {// getFilesystemName
			// - file이름
			// 추출해주는 함수
			String emp_elec_auth_img = multipartRequest.getFilesystemName("emp_elec_auth_img");
			emp.setEmp_elec_auth_img(emp_elec_auth_img);
			System.out.println("썸네일이미지");
			// 썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
			String pattern = emp_elec_auth_img.substring(emp_elec_auth_img.lastIndexOf(".") + 1); // gif
			String headName = emp_elec_auth_img.substring(0, emp_elec_auth_img.lastIndexOf(".")); // aaa

			// 원본파일 이미지 => File 객체화
			String imagePath = uploadPath + "\\" + emp_elec_auth_img;
			File src = new File(imagePath);

			// 썸네일 이미지 => File 객체화
			String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
			File dest = new File(thumImagePath);
			System.out.println("파일생성");
			// 썸네일 이미지 생성
			if (pattern.equals("jpg") || pattern.equals("gif")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			System.out.println("썸네일 이미지 생성");
		} else {
			emp.setEmp_elec_auth_img("test");
		}
		
		return dao.empUpdate(emp);
	}
	

	public int TelUpdateService(Tel tel) {
		tel.setTel_type(multipartRequest.getParameter("tel_type"));
		tel.setTel_telephone(multipartRequest.getParameter("tel_telephone"));
		return dao.telUpdate(tel);
	}
}
