/*
 *   Add user schedule and execute scheduled command
 */

package servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Schedule;
import bean.ScheduleDAO;

public class AddSchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	public AddSchedule() {
        	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=null;
		Integer userid=null;
		String username=null;
		String title= null;
    	String body= null;
    	String[] begintime= null;
    	String[] endtime = null;
    	String begin=null;
    	String end=null;
    	String filename=null;
    	String command1=null;
    	String command2=null;
    	String fullpath=null;
    	String welcomefile=null;
    	String split=null;
    	String resultpath=null;
    	File dirs=null;
    	String resultfile=null;
    	String monBegin=null;
    	String monEnd=null;
    	Boolean flag=false;
    	DateFormat df= null;
        long cur=0;
    	long start=0;
    	Boolean future=true;
    	String[] m={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		Map<String,Integer> mon=new HashMap<String,Integer>();
		for(int i=0;i<m.length;i++)
		mon.put(m[i], i);
    	session=request.getSession();
    	userid=(Integer)session.getAttribute("userId");
    	username=(String)session.getAttribute("userName");
    	title=request.getParameter("title");
    	body=request.getParameter("body");
    	System.out.println(" TT "+request.getParameter("begintime"));
    	//Thu Jan 23 2014 11:15:00 GMT-0800
    	begintime=request.getParameter("begintime").split(" ");
    	endtime=request.getParameter("endtime").split(" ");
    	filename=request.getParameter("filename");
    	
    	if(mon.get(begintime[1])<9) monBegin="0"+(mon.get(begintime[1])+1);
    	else monBegin=""+(mon.get(begintime[1])+1);
    	if(mon.get(endtime[1])<9) monEnd="0"+(mon.get(endtime[1])+1); 
    	else monEnd=""+(mon.get(endtime[1])+1);
    	System.out.println("begintime4:"+begintime[4]);
    	
    	begin=begintime[3]+"-"+monBegin+"-"+begintime[2]+" "+begintime[4];
    	//begintime[4].substring(0, 3)+minstr+":00";
    	System.out.println("begin:"+begin);
    	end=endtime[3]+"-"+monEnd+"-"+endtime[2]+" "+endtime[4];
    	
    	df =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try {
		start=(df.parse(begin)).getTime();
		cur=System.currentTimeMillis();
		if(start<=cur) future=false;
	     } catch (ParseException e) {
			e.printStackTrace();
		}
    	if(future)
    	{
    	ScheduleDAO sd= new ScheduleDAO();
    	flag=sd.checkConflict(begin, end);
    	if(!flag)
    	{
        // add new schedule
    	sd.addSchedule(new Schedule(0,begin,end,userid,username,title,body,"",filename));
        System.out.println(begin.compareTo(end));
    	fullpath=this.getServletContext().getRealPath("upload");
	System.out.println("fullpath:"+fullpath);	
	welcomefile="WelcomeToSCORE.imn";
    	String osname= System.getProperty("os.name");
        // check win or linux system environment
    	if(osname!=null && osname!="" && osname.toLowerCase().indexOf("win")!=-1)
    		 split="\\";	    	 
    	else
    		 split="/";
    	welcomefile=fullpath+split+welcomefile;
	fullpath = fullpath+split+filename;
        if(filename==null||filename.length()<4)
		fullpath=welcomefile;
	else if(!((filename.substring(filename.length()-3)).equals("imn"))||!((new File(fullpath)).exists()))
		fullpath=welcomefile;
        resultpath=this.getServletContext().getRealPath("download");
	dirs=new File(resultpath);
	if(!dirs.exists())
		dirs.mkdirs();
	resultfile=""+sd.findScheduleId(begin);
    	resultpath=resultpath+split+resultfile;
	String minstrA=null;
    	int minA=(int) ((begintime[4].charAt(3)-48)*10+begintime[4].charAt(4)-48+1);
    	if(minA<10) minstrA="0"+minA;
    	else minstrA=""+minA;
    	System.out.println("min:"+minstrA);
    	String beginA=begintime[3]+"-"+monBegin+"-"+begintime[2]+" "+begintime[4].substring(0, 3)+minstrA;
    	String shpath="/home/wkw/develop/smart/";
    	String head="#!/bin/sh";
    	File spdir= new File(shpath);
    	if(!spdir.exists())
    		spdir.mkdirs();
    	File runsh=new File(shpath+"run.sh");
    	if(!runsh.exists()){
    		FileWriter rfw=new FileWriter(runsh);
    		BufferedWriter rbw=new BufferedWriter(rfw);
    		rbw.write(head+"\n"+"at $2 $1 -f "+shpath+"$1-$2.sh");
    		rbw.close();
    	}	
    	File startsh= new File(shpath+"start.sh");
    	if(!startsh.exists()){
    		FileWriter stfw=new FileWriter(startsh);
    		BufferedWriter stbw=new BufferedWriter(stfw);
    		stbw.write(head+"\n"+"sudo /etc/init.d/score start"+"\n"
    				+"sudo /etc/init.d/score start");
    		stbw.close();
    	}
    	File stopsh = new File(shpath+"stop.sh");
    	if(!stopsh.exists()){
    		FileWriter spfw=new FileWriter(stopsh);
    		BufferedWriter spbw=new BufferedWriter(spfw);
    		spbw.write(head+"\n"+"sudo /etc/init.d/score stop"+"\n"
    				+ "sudo /etc/init.d/score stop"+"\n"
    				+ "sudo killall python" +"\n"
    				+ "sudo killall python" +"\n");
    		spbw.close();
    	}
    	File schedulesh=new File(shpath+"schedule.sh");
    	if(!schedulesh.exists()){
    		FileWriter fw = new FileWriter(schedulesh);
    		BufferedWriter shw= new BufferedWriter(fw);
    		shw.write(head+"\n"+"at $2 $1 -f "+ shpath+"start.sh"+"\n"
    				+"at $4 $3 -f "+ shpath+"stop.sh");
    		shw.close();
    	}
    	
    	String minstrB=null;
    	int minB=(int) ((begintime[4].charAt(3)-48)*10+begintime[4].charAt(4)-48+2);
    	if(minB<10) minstrB="0"+minB;
    	else minstrB=""+minB;
    	String beginB=begintime[3]+"-"+monBegin+"-"+begintime[2]+" "+begintime[4].substring(0, 3)+minstrB;
        
    	String shfilename=begintime[3]+"-"+monBegin+"-"+begintime[2]+"-"+begintime[4].substring(0, 3)+minstrB;
    	FileWriter shfile= new FileWriter(shpath+shfilename+".sh");
    	BufferedWriter bw = new BufferedWriter(shfile);
    	bw.write(head+"\n"+"score -b "+fullpath+" "+resultpath);
    	bw.close();
    	
    	end=end.substring(0,end.length()-3);
    	
    	command1="sh "+ schedulesh + " " + beginA + " " + end;
    	//2013-10-13 15:38:00
    	System.out.println(command1);
    	/* schedule.sh
    	 * #!/bin/sh
         * at $2 $1 -f /home/smart/start.sh
         * at $4 $3 -f /home/smart/stop.sh
    	 */
    	/* start.sh
    	 * #!/bin/sh
         * sudo /etc/init.d/score start
         * sudo /etc/init.d/score start
    	 */
    	/* stop.sh
    	 * #!/bin/sh
         * sudo /etc/init.d/score stop
         * sudo /etc/init.d/score stop
    	 */
    	
    	command2="sh " + runsh + " " + beginB;
    	System.out.println(command2);
    	/* run.sh
    	 * #!/bin/sh
         * at $2 $1 -f /home/smart/$1-$2.sh
    	 */
    	/*
    	 * #!/bin/sh
         * score -b   $3 $4
    	 */
    	
        // execute scheduled command to run SCORE
    	try{
    	Runtime.getRuntime().exec(command1);
    	}catch(IOException e){
    		System.out.println("IOException..." +e);
    	}
    	try{
    	Runtime.getRuntime().exec(command2);
    	}catch(IOException e){
    		System.out.println("IOException..." +e);
    	}
	
    	}
	}
	}

}
