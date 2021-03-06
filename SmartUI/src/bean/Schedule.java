/*
 *  Schedule information
 */

package bean;

public class Schedule {
    private Integer id;
    private String begintime;
    private String endtime;
    private Integer userid;
    private String username;
    private String title;
    private String body;
    private String filepath;
    private String filename;
    
    public Schedule(Integer id,String begintime,String endtime,
    		Integer userid,String username,String title,String body,String filepath, String filename){
    	setId(id);
    	setBegintime(begintime);
    	setEndtime(endtime);
    	setUserid(userid);
    	setUsername(username);
    	setTitle(title);
    	setBody(body);
    	setFilepath(filepath);
    	setFilename(filename);
    }
    
    public Integer getId(){
    	return id;
    }
    public void setId(Integer id){
    	this.id=id;
    }
    public String getBegintime(){
    	return begintime;
    }
    public void setBegintime(String begintime){
    	this.begintime=begintime;
    }
    public String getEndtime(){
    	return endtime;
    }
    public void setEndtime(String endtime){
    	this.endtime=endtime;
    }
    public Integer getUserid(){
    	return userid;
    }
    public void setUserid(Integer userid){
    	this.userid=userid;
    }
    public String getUsername(){
    	return username;
    }
    public void setUsername(String username){
    	this.username=username;
    }
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    public String getBody(){
    	return body;
    }
    public void setBody(String body){
    	this.body=body;
    }
    public String getFilepath(){
    	return filepath;
    }
    public void setFilepath(String filepath){
    	this.filepath=filepath;
    }
    public String getFilename(){
    	return filename;
    }
    public void setFilename(String filename){
    	this.filename=filename;
    }
}
