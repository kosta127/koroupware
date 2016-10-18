package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.doc.model.Doc;
import kosta.elecauth.model.EmpDetail;
import kosta.elecauth.service.Elec_authService;
import kosta.emp.model.Emp;

public class Elec_authWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		//양식 가져옴
		Elec_authService service = Elec_authService.getInstance();
		List<Doc> docFormList = service.getDocFormList();
		
		HttpSession session = request.getSession();
		//회원 정보 가져옴
		Emp emp = (Emp)session.getAttribute("emp");
		EmpDetail empDetail = service.getEmpDetail(emp.getEmp_no());
		
		if(docFormList != null && empDetail != null){
			session.setAttribute("empDetail", empDetail);
			request.setAttribute("docFormList", docFormList);
			forward.setRedirect(false);
			forward.setPath("/elec_auth/elec_auth_write.jsp");
		}else{
			forward.setRedirect(true);
			forward.setPath("elec_authError.do");
		}
		
		return forward;
	}

}
