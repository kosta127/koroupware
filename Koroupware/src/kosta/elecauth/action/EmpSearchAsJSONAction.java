package kosta.elecauth.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.action.Action;
import kosta.action.ActionForward;
import kosta.elecauth.model.EmpDetail;
import kosta.elecauth.service.Elec_authService;
import net.sf.json.JSONArray;

public class EmpSearchAsJSONAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		Elec_authService service = Elec_authService.getInstance();
		List<EmpDetail> empList = service.searchEmp();
				//service.searchEmp("%"+request.getParameter("searchKey")+"%");
		
		String jsonStr = JSONArray.fromObject(empList).toString();
		request.setAttribute("empListAsJSON", jsonStr);
		
		forward.setRedirect(false);
		forward.setPath("/elec_auth/searchEmpListAsJSON.jsp");
		return forward;
	}

}
