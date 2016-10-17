package kosta.elecauth.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Elec_authDetail implements Serializable{
	private int elec_auth_no;
	private Date elec_auth_processing_period;
	private Date elec_auth_regdate;
	private Date elec_auth_con_period;
	private String elec_auth_title;
	private String elec_auth_contents;
	
	private String doc_title;
	private String emp_name;
	
	private int emp_no;
	private String approval_list_pass;
	private int approval_list_step;
	private Date approval_list_date;
	
	
}
