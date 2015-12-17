package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import Model.DatabaseBean;
import domain.Info;

public class FensuModel {
	private ArrayList<Info> al=new ArrayList();
	private ArrayList<String> others=new ArrayList();
	private ArrayList<String> availabledorm=new ArrayList();
	private double zx=0.0;
	private double xx=0.0;
	private double enter=0.0;
	private double chara=0.0;
	private double jt=0.0;
	private double ws=0.0;
	private double sh=0.0;
	private double zhx=0.0;
	private Hashtable quanzhong=new Hashtable();
	private double qz=0.0;
	int zuoxi=0;
	private int xuexi=0;
	private int entertain=0;
	private int character=0;
	private static int jiating=0;
	private int weisheng=0;
	private int shenghuo=0;
	private int zhuxiao=0;
	
	public FensuModel(){
		quanzhong();
	}
	
	public void quanzhong(){
		String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url=DatabaseBean.url;
			String dbuser=DatabaseBean.db_user;
			String dbpwd=DatabaseBean.db_pwd;
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//System.out.println("connect success");
			//String name = "王媛";
			//String sql="select * from users where name='"+name+"'";
			String sql="select * from qzsummary";
			stmt=con.createStatement();
			//System.out.println(sql);
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				//System.out.println(rs.getString("id")+" "+rs.getString("name"));
				calquanzhong(rs);
			}
		}catch(Exception ex){
			System.out.println("here has some wrong");
			ex.printStackTrace();
		}finally{
			if (rs != null)    
                try {    
                    rs.close();    
                } catch (Exception e) {    
                }    
            if (stmt != null)    
                try {    
                    stmt.close();    
                } catch (Exception e) {    
                }    
            if (con != null)    
                try {    
                    con.close();    
                } catch (Exception e) {    
                } 
            double total=(double)(zuoxi+xuexi+entertain+character+jiating+weisheng+shenghuo+zhuxiao);
            zx=zuoxi/total;
            xx=xuexi/total;
            enter=entertain/total;
            chara=character/total;
            jt=jiating/total;
            ws=weisheng/total;
            sh=shenghuo/total;
            zhx=zhuxiao/total;
		}
	}
	
	public void calquanzhong(ResultSet rs){
		try{
			zuoxi+=rs.getInt("zuoxi");
			xuexi+=rs.getInt("xuexi");
			entertain+=rs.getInt("entertainment");
			character+=rs.getInt("character");
			jiating+=rs.getInt("jiating");
			weisheng+=rs.getInt("weisheng");
			shenghuo+=rs.getInt("shenghuo");
			zhuxiao+=rs.getInt("zhuxiao");
		}catch(Exception ex){
			
		}
		//System.out.println(zuoxi+" "+xuexi);
	}
		
	public void calothers(String[] faculties,String xiaoqu){
		String sexs[] ={"男","女"};
		//for(int j=0;j<departments.length;j++){
			//String department=departments[j];
			//for(int k=1;k<4;k++){
				//int m=0;
		for(int i=0;i<faculties.length;i++){
			String faculty=faculties[i];
				for(int n=0;n<sexs.length;n++){
					others.clear();
					availabledorm.clear();
					String sex=sexs[n];
//					String sql="select * from users where users.id not in(select id from dormitoryinfo) " +
//							"and faculty='"+faculty+"' and department='"+department+
//							"' and classnumber='"+k+"' and sex='"+sex+"';";
					String sql="select * from users where users.id not in(select id from dormitoryinfotest) " +
							"and faculty='"+faculty+"' and sex='"+sex+"' order by department,classnumber;";
					dodatabase(sql,"selectothers");
//					if(others.isEmpty()){
//						break;
//					}
					int dormnumber=getdorm(faculty,sex);
					String dnumber=dormnumber+"";
					if(xiaoqu.equals("north")){
						dnumber="北校"+dnumber;
					}
					//System.out.println(dormnumber);
					String sql1="select * from availabledormtest where renshu='0' and dormitorynumber like'"+dnumber+"-%';";
					//System.out.println(sql1);
					dodatabase(sql1,"availabledorm");
					int dorm=0;
					for(int number=0;number<others.size();number++){
						//System.out.println();
						String dn=availabledorm.get(dorm);
//						if(xiaoqu.equals("north")){
//							dn="北校"+dn;
//						}
						String id=others.get(number);
						//System.out.println(dn+" "+id);
						String sql2="insert into dormitoryinfotest values('"+dn+"','"+id+"');";
						dodatabase(sql2,"insert");
						//System.out.println(sql2);
						if((number+1)%4==0){
							dorm++;
							//System.out.println("update"+dn+"to4");
							String sql3="update availabledormtest set renshu='"+4+"' where dormitorynumber='"+dn+"';";
							dodatabase(sql3,"update");
							//System.out.println(sql3);
						}
						if(number==others.size()-1){
							int lastnumber=(number+1)%4;
							if(lastnumber !=0){
								//System.out.println("update"+dn+"to"+lastnumber);
							String sql3="update availabledormtest set renshu='"+lastnumber+"' where dormitorynumber='"+dn+"';";
							dodatabase(sql3,"update");
							//System.out.println(sql3);
							}
						}
					}
				}
			}
		//}
	//}
}

public void calsushe(String[] faculties,String xiaoqu){
	String yyyywhxy[] = {"英语（语言信息管理）","英语（国际会展与旅游）","英语（文化与传播）",
			 "英语（高级翻译）","英语（英美文学）","英语（语言学）"};
	String gjjjmyxy[] = {"金融工程","保险","经济学","金融学","国际经济与贸易"};
	String gjswyyxy[] = {"国际商务","英语"};
	String gjgsglxy[] = {"市场营销","人力资源管理","物流管理","工商管理","电子商务"};
	//String gjgsglxy1[] = {"物流管理"};
	String cjxy[] = {"财政学","税务","审计学","财务管理","会计学"};
	String xfyywhxy[] = {"葡萄牙语","意大利语","西班牙语","俄语","德语","法语"};
	String dfyywhxy[] = {"阿拉伯语","朝鲜语","越南语","泰语","印度尼西亚语","日语"};
	String zgyywhxy[] = {"对外汉语","汉语言","汉语言文学"};
	String fxy[] = {"国际政治","外交学","法学"};
	String yyjyxy[] = {"教育学"};
	String skxxxy[] = {"信息管理与信息系统","数学与应用数学","统计学","网络工程","软件工程","计算机科学与技术"};
	//String skxxxy1[] = {"软件工程"};
	String zzyggglxy[] = {"社会工作","应用心理学","公共事业管理","行政管理"};
	String gjfyxy[] = {"翻译"};
	String xwycbxy[] = {"播音与主持艺术","广告学","新闻学"};
	String ysxy[] = {"音乐学","舞蹈学","艺术设计","音乐表演"};
	String sexs[] ={"男","女"};
	//String sexs[] ={"男"};
	//getResultStatment("国际经济贸易学院","经济学",2,"女");
	//System.out.println(al.get(0).getid()+" "+al.get(0).getfaculty());
	String[] dorm={"","","","","","","","","","","","","",""};
	for(int i=0;i<faculties.length;i++){
		String faculty=faculties[i];
		String[] departments;
		if(faculty.equals("英语语言文化学院")){
			departments=yyyywhxy;
		}else if(faculty.equals("国际经济贸易学院")){
			departments=gjjjmyxy;
		}else if(faculty.equals("国际商务英语学院")){
			departments=gjswyyxy;
		}else if(faculty.equals("国际工商管理学院")){
			departments=gjgsglxy;
		}else if(faculty.equals("财经学院")){
			departments=cjxy;
		}else if(faculty.equals("西方语言文化学院")){
			departments=xfyywhxy;
		}else if(faculty.equals("东方语言文化学院")){
			departments=dfyywhxy;
		}else if(faculty.equals("中国语言文化学院")){
			departments=zgyywhxy;
		}else if(faculty.equals("法学院")){
			departments=fxy;
		}else if(faculty.equals("英语教育学院")){
			departments=yyjyxy;
		}else if(faculty.equals("思科信息学院")){
			departments=skxxxy;
		}else if(faculty.equals("政治与公共管理学院")){
			departments=zzyggglxy;
		}else if(faculty.equals("高级翻译学院")){
			departments=gjfyxy;
		}else if(faculty.equals("新闻与传播学院")){
			departments=xwycbxy;
		}else{
			departments=ysxy;
		}
		for(int j=0;j<departments.length;j++){
			String department=departments[j];
			for(int k=1;k<4;k++){
			//for(int k=0;k<3;k++){
				int m=0;
				for(int n=0;n<sexs.length;n++){
					al.clear();
					String sex=sexs[n];
					String lastres="";
					int dormnumber=0;
					String information=faculty+" "+department+" "+k+" "+sex+"\n";
					//System.out.print(faculty+" "+department+" "+k+" "+sex+" ");
					String sql="select * from information,users where information.id=users.id " +
							"and faculty='"+faculty+"' and department='"+department+
							"' and classnumber='"+k+"' and sex='"+sex+"';";
					//System.out.println(sql);
					dodatabase(sql,"select");
					//getResultStatment(faculty,department,k,sex);
					if(al.size()>4){
						lastres=fensushe();
					}
					else{
						continue;
					}
					//number+=al.size()/4;
					//System.out.print("最终分配结果："+"\n"+lastres);
					String[] everydorm=lastres.split("\n");
					String newlastres="";
					for(int dn=0;dn<everydorm.length;dn++){
						String[] everystudent=everydorm[dn].split("-");
						for(int es=0;es<everystudent.length;es++){
							int sn=Integer.parseInt(everystudent[es]);
							newlastres+=al.get(sn).getid()+"-";
						}
						newlastres+="\n";
					}
					dormnumber=getdorm(faculty,sex);
					//System.out.println(dormnumber);
					dorm[dormnumber]+=information+newlastres+"@";
				}
			}
		}
	}
	for(int i=1;i<dorm.length;i++){//i is dorm dongnumber
		//System.out.println(dorm[i]);
		availabledorm.clear();
		String dnumber=i+"";
		if(xiaoqu.equals("north")){
			dnumber="北校"+dnumber;
		}
		String sql1="select * from availabledormtest where renshu='0' and dormitorynumber like'"+dnumber+"-%';";
		//System.out.println(sql1);
		dodatabase(sql1,"availabledorm");
		String[] everyxi=dorm[i].split("@");
		int dormnumber=0;
		//int dormnumber2=0;
		int dormn=0;
		for(int j=0;j<everyxi.length;j++){
			String sushe="";
			String[] everyclass=everyxi[j].split("\n");
			for(int k=1;k<everyclass.length;k++){//cause 0 is the information
				
				//System.out.println(everyclass[k]);
				//System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				String[] everystudent=everyclass[k].split("-");
				String dn=availabledorm.get(dormn);
				for(int n=0;n<everystudent.length;n++){//length must be 4
					String id=everystudent[n];
					
//					if(xiaoqu.equals("north")){
//						dn="北校"+dn;
//					}
					//System.out.println(dn+" "+id);
					String sql2="insert into dormitoryinfotest values('"+dn+"','"+id+"');";
					dodatabase(sql2,"insert");
					
				}
				//System.out.println("update"+dn+"to4");
				String sql3="update availabledormtest set renshu='"+4+"' where dormitorynumber='"+dn+"';";
				dodatabase(sql3,"update");
				dormn++;
//				if(dormnumber+k<41){
//					sushe=i+"-"+(2*100+dormnumber+k);
//					if(xiaoqu.equals("north")){
//						sushe="北校"+sushe;
//					}
//					for(int n=0;n<everystudent.length;n++){
//						String sql = "insert into dormitoryinfo values('"+sushe+"','"+everystudent[n]+"');";
//						System.out.println(sushe+" "+everystudent[n]);
//						/////dodatabase(sql,"insert");
//					}
//				}
//				else{
//					sushe=i+"-"+(3*100+dormnumber+k-40);
//					if(xiaoqu.equals("north")){
//						sushe="北校"+sushe;
//					}
//					for(int n=0;n<everystudent.length;n++){
//						String sql = "insert into dormitoryinfo values('"+sushe+"','"+everystudent[n]+"');";
//						System.out.println(sushe+" "+everystudent[n]);
//						/////dodatabase(sql,"insert");
//					}
//				}
//				//String sql="delete availabledorm where dormitorynumber='"+sushe+"' and renshu='"+4+"';";
//				String sql="update availabledorm set renshu='"+4+"' where dormitorynumber='"+sushe+"';";
//				/////dodatabase(sql,"insert");
			}
		}
		//System.out.println(dorm[i]);
	}
}
	
	public void dodatabase(String sql,String operation){
		//String JDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//String connectionUrl="jdbc:sqlserver://localhost:1433;databaseName=dormitory;integratedSecurity=true;";
		Connection con=null;
		Statement stmt=null;
		//PreparedStatement ps=null;
		ResultSet rs=null;
		//int number=0;
		//int totalnumber=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url=DatabaseBean.url;
			String dbuser=DatabaseBean.db_user;
			String dbpwd=DatabaseBean.db_pwd;
			con=DriverManager.getConnection(url,dbuser,dbpwd);
			//System.out.println("connect success");
			//String name = "王媛";
			//String sql="select * from users where name='"+name+"'";
			//String sql="select * from availabledorm";
			
			stmt=con.createStatement();
			//System.out.println(sql);
			if(operation.equals("select")){
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					
					Info information=new Info();
					information.setid(rs.getString("id"));
					information.setsleeptime(rs.getInt("sleeptime"));
					information.sethsleeptime(rs.getInt("hsleeptime"));
					information.setdahu(rs.getInt("dahu"));
					information.sethdahu(rs.getInt("hdahu"));
					information.setmenghua(rs.getInt("menghua"));
					information.sethmenghua(rs.getInt("hmenghua"));
					information.setstudy(rs.getInt("study"));
					information.sethstudy(rs.getInt("hstudy"));
					information.setgame(rs.getInt("game"));
					information.sethgame(rs.getInt("hgame"));
					information.setsport(rs.getInt("sport"));
					information.sethsport(rs.getInt("hsport"));
					information.setcharacteristic(rs.getInt("characteristic"));
					information.sethcharacteristic(rs.getInt("hcharacteristic"));
					information.setmoney(rs.getInt("money"));
					information.sethmoney(rs.getInt("hmoney"));
					information.setwaisheng(rs.getInt("waisheng"));
					information.sethwaisheng(rs.getInt("hwaisheng"));
					information.setshower(rs.getInt("shower"));
					information.sethshower(rs.getInt("hshower"));
					information.setzhuxiao(rs.getInt("zhuxiao"));
					information.sethzhuxiao(rs.getInt("hzhuxiao"));
//					information.setfaculty(faculty);
//					information.setdepartment(department);
//					information.setsex(sex);
					al.add(information);
					
					}
				}
			else if(operation.equals("selectothers")){
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					others.add(rs.getString("id"));
				}
			}
			else if(operation.equals("availabledorm")){
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					//System.out.println(rs.getString("dormitorynumber"));
					availabledorm.add(rs.getString("dormitorynumber"));
				}
			}
			else{
			int i=stmt.executeUpdate(sql);

			if(i==1){
				//System.out.println(" "+"修改成功");
			}else{
				//System.out.print(" "+"修改失败");
			}
		}
		}catch(Exception ex){
			System.out.println("here has some wrong");
			ex.printStackTrace();
		}finally{
			if (rs != null)    
                try {    
                    rs.close();    
                } catch (Exception e) {    
                }    
            if (stmt != null)    
                try {    
                    stmt.close();    
                } catch (Exception e) {    
                }    
            if (con != null)    
                try {    
                    con.close();    
                } catch (Exception e) {    
                } 
		}
		//System.out.println(number);
		//System.out.println(totalnumber);
	}
	
	public String fensushe(){
		for(int i=0;i<al.size()-1;i++){
			for(int j=i+1;j<al.size();j++){
				//System.out.print(i+"-"+j+"  ");
				double res=calquanzhong(al.get(i),al.get(j));
				quanzhong.put(i+"-"+j, res);
				quanzhong.put(j+"-"+i, res);
			}
		}
		double temp=0.0;
		int max=0;
		
		String lastres="";
		for(int k=0;k<al.size();k++){
			Hashtable change=new Hashtable();
			change.putAll(quanzhong);
			int j=0;
			qz=0.0;
			String fenshe="";
			for(int i=k;i<al.size()+10;i++){
				if(i>=al.size()){
					i=i%al.size();
				}
				if(j<(al.size()/4)){
					String first=i+"";
					if(change.containsKey(((i+1)%al.size())+"-"+i)){
						for(int cishu=0;cishu<3;cishu++){
							first+="-"+getmaxquanzhong(first,change);
						}
						j++;
						fenshe+=first+"\n";
					}
				}else{
					break;
				}
			}
			if(temp<qz){
				temp=qz;
				max=k;
				lastres=fenshe;
			}
		}
		return lastres;
	}
	
	public int getdorm(String faculty,String sex){
		int dorm=0;
		if(faculty.equals("国际经济贸易学院")&&sex.equals("男")){
			dorm=1;
		}
		if(faculty.equals("国际经济贸易学院")&&sex.equals("女")){
			dorm=2;
		}
		if(faculty.equals("国际工商管理学院")&&sex.equals("男")){
			dorm=3;
		}
		if(faculty.equals("国际工商管理学院")&&sex.equals("女")){
			dorm=4;
		}
		if(faculty.equals("财经学院")&&sex.equals("男")){
			dorm=5;
		}
		if(faculty.equals("财经学院")&&sex.equals("女")){
			dorm=6;
		}
		if(faculty.equals("法学院")&&sex.equals("男")){
			dorm=7;
		}
		if(faculty.equals("法学院")&&sex.equals("女")){
			dorm=8;
		}
		if(faculty.equals("英语教育学院")&&sex.equals("男")){
			dorm=9;
		}
		if(faculty.equals("英语教育学院")&&sex.equals("女")){
			dorm=10;
		}
		if(faculty.equals("思科信息学院")&&sex.equals("男")){
			dorm=11;
		}
		if(faculty.equals("思科信息学院")&&sex.equals("女")){
			dorm=12;
		}
		if(faculty.equals("政治与公共管理学院")&&sex.equals("男")){
			dorm=13;
		}
		if(faculty.equals("政治与公共管理学院")&&sex.equals("女")){
			dorm=12;
		}
		if(faculty.equals("新闻与传播学院")&&sex.equals("男")){
			dorm=11;
		}
		if(faculty.equals("新闻与传播学院")&&sex.equals("女")){
			dorm=10;
		}
		if(faculty.equals("艺术学院")&&sex.equals("男")){
			dorm=9;
		}
		if(faculty.equals("艺术学院")&&sex.equals("女")){
			dorm=8;
		}
		if(faculty.equals("英语语言文化学院")&&sex.equals("男")){
			dorm=1;
		}
		if(faculty.equals("英语语言文化学院")&&sex.equals("女")){
			dorm=2;
		}
		if(faculty.equals("国际商务英语学院")&&sex.equals("男")){
			dorm=3;
		}
		if(faculty.equals("国际商务英语学院")&&sex.equals("女")){
			dorm=4;
		}
		if(faculty.equals("西方语言文化学院")&&sex.equals("男")){
			dorm=5;
		}
		if(faculty.equals("西方语言文化学院")&&sex.equals("女")){
			dorm=6;
		}
		if(faculty.equals("东方语言文化学院")&&sex.equals("男")){
			dorm=7;
		}
		if(faculty.equals("东方语言文化学院")&&sex.equals("女")){
			dorm=8;
		}
		if(faculty.equals("中国语言文化学院")&&sex.equals("男")){
			dorm=9;
		}
		if(faculty.equals("中国语言文化学院")&&sex.equals("女")){
			dorm=8;
		}
		if(faculty.equals("高级翻译学院")&&sex.equals("男")){
			dorm=7;
		}
		if(faculty.equals("高级翻译学院")&&sex.equals("女")){
			dorm=6;
		}

		return dorm;
	}
	
	public String getmaxquanzhong(String a,Hashtable change){
		double temp=0.0;
		String max="";
		String[] everynumber={a};
		try{
			everynumber=a.split("-");
		}catch(Exception ex){}
		for(int i=0;i<al.size();i++){
			try{
				double thisone=0.0;
				for(int j=0;j<everynumber.length;j++){
					thisone+=Double.parseDouble(change.get(everynumber[j]+"-"+i).toString());
				}
				thisone=thisone/everynumber.length;//get average
				
				if(temp<thisone){
					temp=thisone;
					max=i+"";
				}
			}catch(Exception ex){
				continue;
			}
		}
		qz+=temp;
		for(int i=0;i<al.size();i++){
			try{
			change.remove(i+"-"+everynumber[everynumber.length-1]);
			}catch(Exception ex){
				continue;
			}
		}
		if(everynumber.length==3){
			for(int i=0;i<al.size();i++){
				try{
				change.remove(i+"-"+max);
				}catch(Exception ex){
					continue;
				}
			}
		}
		return max;
	}
	
	public double calquanzhong(Info a,Info b){
		int a_sleeptime=a.getsleeptime();
		int b_hsleeptime=b.gethsleeptime();
		int a_dahu=a.getdahu();
		int b_hdahu=b.gethdahu();
		int a_menghua=a.getmenghua();
		int b_hmenghua=b.gethmenghua();
		int a_study=a.getstudy();
		int b_hstudy=b.gethstudy();
		int a_game=a.getgame();
		int b_hgame=b.gethgame();
		int a_sport=a.getsport();
		int b_hsport=b.gethsport();
		int a_characteristic=a.getcharacteristic();
		int b_hcharacteristic=b.gethcharacteristic();
		int a_money=a.getmoney();
		int b_hmoney=b.gethmoney();
		int a_waisheng=a.getwaisheng();
		int b_hwaisheng=b.gethwaisheng();
		int a_shower=a.getshower();
		int b_hshower=b.gethshower();
		int a_zhuxiao=a.getzhuxiao();
		int b_hzhuxiao=b.gethzhuxiao();
		int b_sleeptime=b.getsleeptime();
		int a_hsleeptime=a.gethsleeptime();
		int b_dahu=b.getdahu();
		int a_hdahu=a.gethdahu();
		int b_menghua=b.getmenghua();
		int a_hmenghua=a.gethmenghua();
		int b_study=b.getstudy();
		int a_hstudy=a.gethstudy();
		int b_game=b.getgame();
		int a_hgame=a.gethgame();
		int b_sport=b.getsport();
		int a_hsport=a.gethsport();
		int b_characteristic=b.getcharacteristic();
		int a_hcharacteristic=a.gethcharacteristic();
		int b_money=b.getmoney();
		int a_hmoney=a.gethmoney();
		int b_waisheng=b.getwaisheng();
		int a_hwaisheng=a.gethwaisheng();
		int b_shower=b.getshower();
		int a_hshower=a.gethshower();
		int b_zhuxiao=b.getzhuxiao();
		int a_hzhuxiao=a.gethzhuxiao();
		double res=0.0;
		
		//b's requirement and a's character
		if(b_hsleeptime==2){
			res+=5*zx;
		}else{
			if(a_sleeptime==b_hsleeptime){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(b_hdahu==2){
			res+=5*zx;
		}else{
			if(a_dahu==b_hdahu){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(b_hmenghua==2){
			res+=5*zx;
		}else{
			if(a_menghua==b_hmenghua){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(b_hstudy==2){
			res+=5*xx;
		}else{
			if(a_study==b_hstudy){
				res+=5*xx;
			}else{
				res+=0;
			}
		}

		if(b_hgame==2){
			res+=5*enter;
		}else{
			if(a_game==b_hgame){
				res+=5*enter;
			}else{
				res+=0;
			}
		}

		if(b_hsport==2){
			res+=5*enter;
		}else{
			if(a_sport==b_hsport){
				res+=5*enter;
			}else{
				res+=0;
			}
		}

		if(b_hcharacteristic==2){
			res+=5*chara;
		}else{
			if(a_characteristic==b_hcharacteristic){
				res+=5*chara;
			}else{
				res+=0;
			}
		}

		if(b_hmoney==4){
			res+=5*jt;
		}else{
			if(a_money==b_hmoney){
				res+=5*jt;
			}else{
				int chazhi = Math.abs(a_money-b_hmoney);
				if(chazhi==1){
					res+=4*jt;
				}
				else if(chazhi==2){
					res+=3*jt;
				}
				else{
					res+=2*jt;
				}
			}
		}

		if(b_hwaisheng==2){
			res+=5*ws;
		}else{
			if(a_waisheng==b_hwaisheng){
				res+=5*ws;
			}else{
				res+=0;
			}
		}

		if(b_hshower==2){
			res+=5*sh;
		}else{
			if(a_shower==b_hshower){
				res+=5*sh;
			}else{
				res+=0;
			}
		}

		if(b_hzhuxiao==2){
			res+=5*zhx;
		}else{
			if(a_zhuxiao==b_hzhuxiao){
				res+=5*zhx;
			}else{
				res+=0;
			}
		}
		
		//a's requirement and b's character
		if(a_hsleeptime==2){
			res+=5*zx;
		}else{
			if(b_sleeptime==a_hsleeptime){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(a_hdahu==2){
			res+=5*zx;
		}else{
			if(b_dahu==a_hdahu){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(a_hmenghua==2){
			res+=5*zx;
		}else{
			if(b_menghua==a_hmenghua){
				res+=5*zx;
			}else{
				res+=0;
			}
		}

		if(a_hstudy==2){
			res+=5*xx;
		}else{
			if(b_study==a_hstudy){
				res+=5*xx;
			}else{
				res+=0;
			}
		}

		if(a_hgame==2){
			res+=5*enter;
		}else{
			if(b_game==a_hgame){
				res+=5*enter;
			}else{
				res+=0;
			}
		}

		if(a_hsport==2){
			res+=5*enter;
		}else{
			if(b_sport==a_hsport){
				res+=5*enter;
			}else{
				res+=0;
			}
		}

		if(a_hcharacteristic==2){
			res+=5*chara;
		}else{
			if(b_characteristic==a_hcharacteristic){
				res+=5*chara;
			}else{
				res+=0;
			}
		}

		if(a_hmoney==4){
			res+=5*jt;
		}else{
			if(b_money==a_hmoney){
				res+=5*jt;
			}else{
				int chazhi = Math.abs(b_money-a_hmoney);
				if(chazhi==1){
					res+=4*jt;
				}
				else if(chazhi==2){
					res+=3*jt;
				}
				else{
					res+=2*jt;
				}
			}
		}

		if(a_hwaisheng==2){
			res+=5*ws;
		}else{
			if(b_waisheng==a_hwaisheng){
				res+=5*ws;
			}else{
				res+=0;
			}
		}

		if(a_hshower==2){
			res+=5*sh;
		}else{
			if(b_shower==a_hshower){
				res+=5*sh;
			}else{
				res+=0;
			}
		}

		if(a_hzhuxiao==2){
			res+=5*zhx;
		}else{
			if(b_zhuxiao==a_hzhuxiao){
				res+=5*zhx;
			}else{
				res+=0;
			}
		}

		//System.out.println(res);
		return res;
	}


}
