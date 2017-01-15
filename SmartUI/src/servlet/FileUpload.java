/*
 *    Upload script file to run SCORE
 */


package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	public FileUpload() {
        	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        DiskFileItemFactory factory= new DiskFileItemFactory();
        ServletFileUpload upload= new ServletFileUpload(factory);
        PrintWriter out = response.getWriter();
        try {
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> it = items.iterator();	
		System.out.println(items.size());
		while(it.hasNext()){
			FileItem item = it.next();
			String fullpath=null;
			File dirs=null;
			String split=null;	
			if(!item.isFormField()){
				String path=item.getName();		
			if(path==""||path==null){
				fullpath=null;	
			}else{
				fullpath=this.getServletContext().getRealPath("upload");
				System.out.println("fullpath:"+fullpath);
				dirs=new File(fullpath);
				if(!dirs.exists())
				dirs.mkdirs();									
			        String osname= System.getProperty("os.name");
			        if(osname!=null && osname!="" && osname.toLowerCase().indexOf("win")!=-1)
			        	split="\\";	    	 
			        else
			        	split="/";
				fullpath = fullpath+split+path;
				System.out.println(fullpath);
				item.write(new File(fullpath));		
				out.write(path);
				out.flush();
				out.close();
				}
			}		
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
