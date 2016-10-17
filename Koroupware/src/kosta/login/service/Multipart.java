package kosta.login.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.emp.model.Emp;
import kosta.login.model.ImageUtil;

public class Multipart {
	
	public Multipart (HttpServletRequest request) throws IOException {
		
		Emp emp = new Emp();

		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; // 20mb
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, size, "utf-8",
				new DefaultFileRenamePolicy());
		
	if (multipartRequest.getFilesystemName("emp_img") != null) {// getFilesystemName
		// - file이름
		// 추출해주는 함수
		String emp_img = multipartRequest.getFilesystemName("emp_img");
		emp.setEmp_img(emp_img);

		// 썸네일 이미지(jpg, gif) aaa.gif => aaa_small.gif
		String pattern = emp_img.substring(emp_img.lastIndexOf(".") + 1); // gif
		String headName = emp_img.substring(0, emp_img.lastIndexOf(".")); // aaa

		// 원본파일 이미지 => File 객체화
		String imagePath = uploadPath + "\\" + emp_img;
		File src = new File(imagePath);

		// 썸네일 이미지 => File 객체화
		String thumImagePath = uploadPath + "\\" + headName + "_small." + pattern;
		File dest = new File(thumImagePath);

		// 썸네일 이미지 생성
		if (pattern.equals("jpg") || pattern.equals("gif")) {
			ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
		}

	} else {
		emp.setEmp_img("test");
	}
	}
}
