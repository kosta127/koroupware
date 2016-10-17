package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.doc.model.Doc;
import kosta.elecauth.service.Elec_authService;

public class Elec_authWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		//양식 가져옴
		Elec_authService service = Elec_authService.getInstance();
		List<Doc> docFormList = service.getDocFormList();		
		
		if(docFormList != null){
			request.setAttribute("docFormList", docFormList);
			forward.setRedirect(false);
			forward.setUrl("/elec_auth/elec_auth_write.jsp");
		}else{
			forward.setRedirect(true);
			forward.setUrl("elec_authError.do");
		}
		
		return forward;
	}

}
