package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_authDetail;
import kosta.elecauth.model.Elec_authDetailApproval;
import kosta.elecauth.model.Elec_authDetailReferrer;
import kosta.elecauth.service.Elec_authService;

public class Elec_authDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		Boolean isOk = false;
		String elec_no=request.getParameter("elec_auth_no");
		
		if(elec_no!=null){
			int elec_auth_no=Integer.parseInt(elec_no);
			Elec_authService service=Elec_authService.getInstance();
			Elec_authDetail elec_authDetail=service.elec_authDetail(elec_auth_no);
			List<Elec_authDetailApproval> elec_authDetailApproval=service.elec_authDetailApproval(elec_auth_no);
			List<Elec_authDetailReferrer> elec_authDetailReferrer=service.elec_authDetailReferrer(elec_auth_no);
			
			request.setAttribute("elec_authDetail", elec_authDetail);
			request.setAttribute("elec_authDetailApproval", elec_authDetailApproval);
			request.setAttribute("elec_authDetailReferrer", elec_authDetailReferrer);
			forward.setRedirect(false);
			forward.setPath("/elec_auth/elec_auth_detail.jsp");
			isOk=true;
		}
		if(!isOk){
			forward.setRedirect(false);
			forward.setPath("error.do");
		}
		return forward;
	}

}
