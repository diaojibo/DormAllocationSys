package Controller;

import javax.swing.JOptionPane;

public class Usefulfun {
	public void wrong(String msg){
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showMessageDialog(null, msg,"发生错误",type);
	}
	public void right(String msg){
		int type=JOptionPane.YES_NO_CANCEL_OPTION;
		JOptionPane.showMessageDialog(null, msg,"信息提示",type);
	}
}
