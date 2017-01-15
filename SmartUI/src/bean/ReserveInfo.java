/*
 * Reserve information for usage of Smart-Grid Common Open Research Emulator (SCORE) 
 */

package bean;

public class ReserveInfo {
    private Integer id;
    private String startyear;
    private String startmonth;
    private String startday;
    private String starthour;
    private String startmin;
    private String endyear;
    private String endmonth;
    private String endday;
    private String endhour;
    private String endmin;
    private String title;
    private String body;
    
    public ReserveInfo(Integer id,String startyear,String startmonth,String startday,String starthour,String startmin,
    		                                      String endyear,String endmonth,String endday,String endhour,String endmin,String title,String body){
    	setId(id);
    	setStartyear(startyear);
    	setStartmonth(startmonth);
    	setStartday(startday);
    	setStarthour(starthour);
    	setStartmin(startmin);
    	setEndyear(endyear);
    	setEndmonth(endmonth);
    	setEndday(endday);
    	setEndhour(endhour);
    	setEndmin(endmin);
    	
    	setTitle(title);
    	setBody(body);
    }
    public Integer getId(){
    	return id;
    }
    public void setId(Integer id){
    	this.id=id;
    }
    public String getStartyear(){
    	return startyear;
    }
    public void setStartyear(String startyear){
    	this.startyear=startyear;
    }
    public String getStartmonth(){
    	return startmonth;
    }
    public void setStartmonth(String startmonth){
    	this.startmonth=startmonth;
    }
    public String getStartday(){
    	return startday;
    }
    public void setStartday(String startday){
    	this.startday=startday;
    }
    public String getStarthour(){
    	return starthour;
    }
    public void setStarthour(String starthour){
    	this.starthour=starthour;
    }
    public String getStarmin(){
    	return startmin;
    }
    public void setStartmin(String startmin){
    	this.startmin=startmin;
    }
    public String getEndyear(){
    	return endyear;
    }
    public void setEndyear(String endyear){
    	this.endyear=endyear;
    }
    public String getEndmonth(){
    	return endmonth;
    }
    public void setEndmonth(String endmonth){
    	this.endmonth=endmonth;
    }
    public String getEndday(){
    	return endday;
    }
    public void setEndday(String endday){
    	this.endday=endday;
    }
    public String getEndhour(){
    	return endhour;
    }
    public void setEndhour(String endhour){
    	this.endhour=endhour;
    }
    public String getEndmin(){
    	return endmin;
    }
    public void setEndmin(String endmin){
    	this.endmin=endmin;
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
}
