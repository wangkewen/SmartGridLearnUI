/*
 *  Uer information
 */

package bean;

public class User {
	private Integer id;
    private String name;
    private String password;
    private String email;
    private String realname;
    private String college;
    private String type;
    private Integer logincount;
    
    public User(){
    	//default 
    }
    public User(String name,String password){
    	setName(name);
    	setPassword(password);
    }
    public User(Integer id,String name,String password,String email,
    		String realname,String college,String type,Integer logincount){
    	setId(id);
    	setName(name);
    	setPassword(password);
    	setEmail(email);
    	setRealname(realname);
    	setCollege(college);
    	setType(type);
    	setLogincount(logincount);
    }
    public Integer getId(){
    	return id;
    }
    public void setId(Integer id){
    	this.id=id;
    }
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getPassword(){
    	return password;
    }
    public void setPassword(String password){
    	this.password = password;
    }
    public String getEmail(){
    	return email;
    }
    public void setEmail(String email){
    	this.email=email;
    }
    public String getRealname(){
    	return realname;
    }
    public void setRealname(String realname){
    	this.realname=realname;
    }
    public String getCollege(){
    	return college;
    }
    public void setCollege(String college){
    	this.college=college;
    }
    public String getType(){
    	return type;
    }
    public void setType(String type){
    	this.type=type;
    }
    public Integer getLogincount(){
    	return logincount;
    }
    public void setLogincount(Integer logincount){
    	this.logincount=logincount;
    }
    
}
