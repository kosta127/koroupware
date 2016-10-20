<%@page import="net.sf.json.JSONArray"%>
<%@page import="kosta.dept.model.OrgChartModel"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kosta.dept.model.OrgChartEmpDetailModel"%>
<%@page import="kosta.dept.dao.DeptDao"%>
<%@page import="kosta.etc.ETC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String empNo = request.getParameter("empNo");
	
	if(ETC.isNotNull(empNo)){
		DeptDao dao = DeptDao.getInstance();
		
		List<OrgChartEmpDetailModel> orgChartEmpDetailModelList 
				= new ArrayList<OrgChartEmpDetailModel>();
		
		OrgChartEmpDetailModel myEmp
				= dao.selectOrgChartEmpDetailModelByEmpNo(Integer.parseInt(empNo));
		
		if(ETC.isNotNull(myEmp)){
			myEmp.setClassification("myEmp");
			orgChartEmpDetailModelList.add(myEmp);
			
			if(myEmp.getEmp_superior() != 0){
				OrgChartEmpDetailModel superiorEmp
						= dao.selectOrgChartEmpDetailModelByEmpNo(myEmp.getEmp_superior());
				
				if(ETC.isNotNull(superiorEmp)){
					superiorEmp.setClassification("superiorEmp");
					orgChartEmpDetailModelList.add(superiorEmp);
				}
			}
			
			if(myEmp.getEmp_reporter() != 0){
				OrgChartEmpDetailModel reporterEmp
						= dao.selectOrgChartEmpDetailModelByEmpNo(myEmp.getEmp_reporter());
						
				if(ETC.isNotNull(reporterEmp)){
					reporterEmp.setClassification("reporterEmp");
					orgChartEmpDetailModelList.add(reporterEmp);
				}	
			}
		}
		
		if(!orgChartEmpDetailModelList.isEmpty()){
			String json = JSONArray.fromObject(orgChartEmpDetailModelList).toString();
			out.print(json);
		}else{
			out.print("[{\"fail\":\"fail\"}]");
		}
	}
 %>