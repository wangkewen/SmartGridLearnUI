window.onload=function(){
	var name=document.getElementById("userName");
	var password=document.getElementById("userPwd");
	name.onblur=checkName;
	password.onblur=checkPassword;
	
	var usernameObj=document.getElementById("username");
	var pwdObj=document.getElementById("pwd");
	var pwdconfirmObj=document.getElementById("pwdconfirm");
	var emailObj=document.getElementById("email");
	var realnameObj=document.getElementById("realname");
	var collegeObj=document.getElementById("college");
	usernameObj.onblur=checkUsername;
	pwdObj.onblur=checkPwd;
	pwdconfirmObj.onblur=checkPwdconfirm;
	emailObj.onblur=checkEmail;
	realnameObj.onblur=checkRealname;
	collegeObj.onblur=checkCollege;
	function trim(s){
		return s.replace(/^\s+|\s+$/g,"");
	}
	
	function checkName(){
		var v=name.value;
		var inputname=trim(v);
		var nameError=document.getElementById("nameCheck");
		if(inputname==null || inputname==""){
			nameError.innerHTML="Name is null";
			return false;
		}
		else
			return true;
	}
	function checkPassword(){
		var inputpwd=password.value;
		var pwdError=document.getElementById("pwdCheck");
		if(inputpwd==null || inputpwd==""){
			pwdError.innerHTML="Password is null";
			return false;
		}
		else 
			return true;
	}
	
	var f=document.getElementById("login");
	f.onsubmit=function(){
		var eName=checkName();
		var ePwd=checkPassword();
		return eName&&ePwd;
	};
	
	function checkUsername(){
		var inputname=usernameObj.value;
		var name=trim(inputname);
		var error=document.getElementById("usernameE");
		
		if(name==null || name==""){
			error.innerHTML="Name is null";
	        return false;
	    }else if(inputname!=name){
	        error.innerHTML="No space in Name";
	        return false;
	    }else if(name.length<3 || name.length>6){
			error.innerHTML="Name length is 3-6";
			return false;
		}else{
			
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
			}
		}
	function checkPwd(){
		var pwd=pwdObj.value;
		var error=document.getElementById("pwdE");
		if(pwd==null || pwd==""){
			error.innerHTML="Password is null";
			return false;
		}else if(pwd.length<6 || pwd.length>20){
			error.innerHTML="Password length is 6-20";
			return false;
		}else{
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
		}
	}
	function checkPwdconfirm(){
		var pwd=pwdObj.value;
		var pwdconfirm=pwdconfirmObj.value;
		var error=document.getElementById("pwdconfirmE");
		if(pwdconfirm==null || pwdconfirm==""){
			error.innerHTML="Password confirm is null";
			return false;
		}else if(pwd!=pwdconfirm){
			error.innerHTML="Different passwords";
			return false;
		}else{
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
		}
	}
	function checkEmail(){
		var email=emailObj.value;
		var error=document.getElementById("emailE");
		var emailRegex=/^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,3}$/;
		if(email==null || email==""){
			error.innerHTML="Email is null";
			return false;
		}else if(!emailRegex.test(email)){
			error.innerHTML="Invalid email pattern";
			return false;
		}else{
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
		}
	}
	function checkRealname(){
		var realname=document.getElementById("realname").value;
		var realnameF=trim(realname);
		var error=document.getElementById("realnameE");
		if(realnameF==null || realnameF==""){
			error.innerHTML="Name is null";
			return false;
		}else if(realname.length>30){
			error.innerHTML="Name length is within 30";
			return false;
		}else{
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
		}
	}
	function checkCollege(){
		var college=document.getElementById("college").value;
		var collegeF=trim(college);
		var error=document.getElementById("collegeE");
		if(collegeF==null || collegeF==""){
			error.innerHTML="College name is null";
			return false;
		}else if(college.length>50){
			error.innerHTML="College name length is within 50";
			return false;
		}else{
			error.innerHTML="<img src='pic/reg_check.gif' alt='Pass'/>";
			return true;
		}
	}
	var form=document.getElementById("register");
	form.onsubmit=function(){
		var cUsername=checkUsername();
		var cPwd=checkPwd();
		var cPwdconfirm=checkPwdconfirm();
        var cEmail=checkEmail();
        var cRealname=checkRealname();
        var cCollege=checkCollege();
		return cUsername&&cPwd&&cPwdconfirm&&cEmail&&cRealname&&cCollege;
	};
	
};
function isHidden(oDiv){
    var vDiv = document.getElementById(oDiv);
    vDiv.style.display = (vDiv.style.display == 'none')?'block':'none'; 
};

function check(){
	function trim(s){
		return s.replace(/^\s+|\s+$/g,"");
	}
	var name=trim(document.getElementById("userName").value);
	var password=document.getElementById("userPwd").value;
	$.ajax
	({
		type:"POST",
		url:"LoginValidate?userName="+name+"&userPassword="+password,
		success: function(data){
			if(data == "Name not exists"){
				$("#nameCheck").html(data);
			    $("#pwdCheck").empty();
			    }
			else if(data == "Password error"){
				$("#nameCheck").empty();
				$("#pwdCheck").html(data);
				}
			else
				window.location.href="index.jsp";
		}
	});
};