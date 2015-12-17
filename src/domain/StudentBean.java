package domain;

public class StudentBean {
	private String sex;
	private String faculty;
	private String department;
	private String classnumber;
	private String dormnumber;
	private String qq;
	private String phone;
	
	public void setsex(String sex){
		this.sex=sex;
	}
	
	public String getsex(){
		return sex;
	}
	
	public void setfaculty(String faculty){
		this.faculty=faculty;
	}
	
	public String getfaculty(){
		return faculty;
	}
	
	public void setdepartment(String department){
		this.department=department;
	}
	
	public String getdepartment(){
		return department;
	}
	
	public void setclassnumber(String classnumber){
		this.classnumber=classnumber;
	}
	
	public String getclassnumber(){
		return classnumber;
	}
	
	public void setqq(String qq){
		this.qq=qq;
	}
	
	public String getqq(){
		return qq;
	}
	
	public void setphone(String phone){
		this.phone=phone;
	}
	
	public String getphone(){
		return phone;
	}
	
	public void setdormnumber(String dormnumber){
		this.dormnumber=dormnumber;
	}
	
	public String getdormnumber(){
		return dormnumber;
	}
}
