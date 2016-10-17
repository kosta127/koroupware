package kosta.elecauth.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.elecauth.model.Approval_list;
import kosta.elecauth.model.Elec_auth;
import kosta.elecauth.model.Elec_auth_referrer;
import kosta.elecauth.service.Elec_authService;

public class Elec_authSubmissionAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		String empNo = request.getParameter("emp_no");
		String docNo = request.getParameter("doc_no");
		String manageDept = request.getParameter("elec_auth_management_dept_no");
		String title = request.getParameter("elec_auth_title");
		String contents = request.getParameter("elec_auth_contents");
		String conDate = request.getParameter("elec_auth_con_period");
		String procDate = request.getParameter("elec_auth_processing_period"); //1111-11-11형식	
		String[] apps = request.getParameterValues("approval_emp_no");
		String[] refs = request.getParameterValues("refferer_emp_no");

		Elec_auth ea = new Elec_auth();
		ea.setEmp_no(Integer.parseInt(empNo));
		ea.setDoc_no(Integer.parseInt(docNo));
		ea.setElec_auth_title(title);
		ea.setElec_auth_contents(contents);
		ea.setElec_auth_management_dept_no(Integer.parseInt(manageDept));
		ea.setElec_auth_con_period(Date.valueOf(conDate));
		ea.setElec_auth_enddate(Date.valueOf(procDate));
	
		List<Approval_list> approvals = new ArrayList<Approval_list>();
		List<Elec_auth_referrer> referrers = new ArrayList<Elec_auth_referrer>();
		for(String appEmpNo : apps){
			Approval_list al = new Approval_list();
			al.setEmp_no(Integer.parseInt(appEmpNo));
			approvals.add(al);
		}
		for(String refEmpNo : refs){
			Elec_auth_referrer ref = new Elec_auth_referrer();
			ref.setEmp_no(Integer.parseInt(refEmpNo));
			referrers.add(ref);
		}
		
		Elec_authService service = Elec_authService.getInstance();
		boolean res = service.insertElecAuth(ea, approvals, referrers);
		
		forward.setRedirect(true);
		if(res){			
			forward.setUrl("elec_authList.do");
		}else{
			forward.setUrl("elec_authError.do");
		}		
		return forward;
	}

}
