/*
 *   Download result file
 */

package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;

   	public Download() {
                super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/x-download");
		String filename=null;
		String path=null;
		String split=null;
		String fullpath=null;
		File file =null;
		InputStream in=null;
		BufferedInputStream input=null;
		BufferedOutputStream output=null;
		String osname= System.getProperty("os.name");
    	 	if(osname!=null && osname!="" && osname.toLowerCase().indexOf("win")!=-1)
    		    split="\\";	    	 
    		else
    		    split="/";
		filename=request.getParameter("filename");
		path=this.getServletContext().getRealPath("download");
		fullpath=path+split+filename;
		file = new File(fullpath);
		if(file.exists()){
			response.addHeader("Content-Disposition", "attachment;filename="+filename);
			in = new FileInputStream(file);
			input = new BufferedInputStream(in);
			output= new BufferedOutputStream(response.getOutputStream());
			int k=0;
			while((k=input.read())!=-1){
				output.write(k);
				output.flush();
			}
			input.close();
			output.close();
				
		}else{
		    response.addHeader("Content-Disposition", "attachment;filename="+"NotFinished");
		}
		
	}

}
