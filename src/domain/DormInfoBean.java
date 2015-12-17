package domain;

public class DormInfoBean extends StudentBean{
	private String name;
	private String id;
	public void setname(String name){
		this.name=name;
	}
	public String getname(){
		return name;
	}
	
	public void setid(String id){
		this.id=id;
	}
	public String getid(){
		return id;
	}
}
