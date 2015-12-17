package domain;

import java.util.ArrayList;

public class PersonalInfoBean extends StudentBean{
	
	//private ArrayList<String> roommate=new ArrayList<String>();
	private String roommate;
	public void setroommate(String name){
		roommate=name;
	}
	
	public String getroommate(){
		return roommate;
	}
}
