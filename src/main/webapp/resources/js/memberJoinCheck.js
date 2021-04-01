/**
 * 
 */

function check() {
	
	alert("check");
	
	let all = document.getElementById("all");
	let ch = document.getElementsByClassName("ch");
	
	
	for(let c of ch){
		c.checked = all.checked;
	}

}




function go(){
	
	alert("go");
	
	
	let all = document.getElementById("all");
	let ch = document.getElementsByClassName("ch");
	let text;
	
	
	if(all.checked){
		for(let c of ch){
			if(c.checked==false){
				all.checked =false;
			}
		}
	} else if(all.checked==false){
		for(let c of ch){
		 text += c.checked;
		}
		if(text="truetruetrue"){
		all.checked = true;

	    }
		
	}
}

function confirm(){

	alert("start confirm")
	
let id = document.getElementById("id");
  let id_n = id.value.length;
  
  let pw = document.getElementById("pw");
  let pw_n = pw.value.length;
  
  let pw2 = document.getElementById("pw2");
  
  let name = document.getElementById("name");
  let nv= name.value;
  
  let phone = document.getElementById("phone");
  let pv=phone.value;
  
  let email = document.getElementById("email");
  let ev=email.value;
  
   if(id_n < 6||pw_n <8 ||pw.value!=pw2.value||nv==""||pv==""||ev==""){
   alert("Please write again");
  }



}



