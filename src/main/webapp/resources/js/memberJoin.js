/**
 * 
 */
let id = document.getElementById("id");
let pw = document.getElementById("pw");
let etc =document.getElementsByClassName("etc");
let btn= document.getElementById("btn");

let idCheckResult =false; // id chenk 결과
let pwCheckResult =false; // pw chenk 결과
let pwEqualResult =false;// ps equal 결과
let etcResult =true; // name, phone, email 결과

//*** ID CHECK---------------------------------

//*** ID CHECK---------------------------------	
id.addEventListener("blur", function(){
	alert(id.value.length);
	messege="아이디를 6자 이상 입력하시오";
	let c ="r1";

	
	if(id.value.length>5){
      messege="아이디가 6자 이상 입니다.";
		c="r2";
		idCheckResult= true;
	}else{
		idCheckResult=false;
	}

	let idResult = document.getElementById("idResult");
       idResult.setAttribute("class", c);
	idResult.innerHTML= messege;
	
});



//*** PW CHECK---------------------------------
pw.addEventListener("change", function(){
	alert("change")
	
});

    pw.addEventListener("blur", function(){
	pwCheckResult=false;
	alert(pw.value.length);
	let messege="비밀번호를 8자 이상 입력하시오.";
	let c ="r1";
	
	if(pw.value.length>7){
		messege="비밀번호가 8자 이상 입니다. ";
		c="r2";
		pwCheckResult=true;
	}
	
	let pwResult = document.getElementById("pwResult");
	    pwResult.setAttribute("class", c);
	    pwResult.innerHTML=messege;
	
});


    
//*** PW EQUAL CHECK---------------------------------
pw2.addEventListener("blur", function(){
		if(pw.value!=pw2.value){
			pw2.value="";
		} else{
			pwEqualResult=true;
			}
	});

//****************************

btn.addEventListener("click", function(){
    for(let e of etc){
		if(e.value==""){
			etcResult=false;
		
		}
	
    }

	//조건이 만족하면 
	if(idCheckResult && pwCheckResult && etcResult){
	let frm = document.getElementById("frm");
	   frm.submit();
      
       }else{
		alert("필수 항목을 입력하세요");
	}
	
});

//************************** id 중복 조회

$("#id").blur(function(){
	let id= $("#id").val();
	$.get("./memberIdCheck?id="+id, function(result){
		
		result =result.trim();
		
		let str="사용가능한 ID입니다.";
		
		if(result=='0') {
			str="중복 ID입니다.";
		}
		
		$("#idCheckResult").html(str);
		
		
		alert(result);
		alert(result=='0');
		console.log(result);
		
	});
});


