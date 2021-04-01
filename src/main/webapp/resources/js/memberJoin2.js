/**
 * 
 */



let id = document.getElementById("id");
  let id_n = id.value.length;
let iv = id.value !="";
  
  let pw = document.getElementById("pw");
  let pw_n = pw.value.length;
let pv= pw.value !="";
  
  let pw2 = document.getElementById("pw2");
let pv2= pw.value !="";
  
  let name = document.getElementById("name");
  let nv= name.value!="";
  
  let phone = document.getElementById("phone");
  let pv= phone.value!="";
  
  let email = document.getElementById("email");
  let ev=  email.value!="";

let btn= document.getElementById("btn");
let frm= document.getElementById("frm");

btn.addEventListener("click", function(){
	
	alert("test");
	
	if(iv && pv && p2 && nv && pv && ev){
		frm.submit();
	} else{
		
		alert("입력 항목을 확인 하세요");
	}
	
	
});

