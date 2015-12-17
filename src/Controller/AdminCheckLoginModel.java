package Controller;

public class AdminCheckLoginModel {
	public boolean checklogin(String id){
		if(id.equals("admin")){
		return true;
		}
		return false;
	}
}
