
    let all = document.getElementById("all");
	let ch = document.getElementsByClassName("ch");
    let result=true;

const  btn = document.getElementById("btn");

btn.addEventListener("click", function(){
	
	 if(all.checked){
	      location.href="./memberJoin";//GET
		}else{
			alert("약관동의는 필수 입니다")
		}
	
});
	
	
	
all.addEventListener("click", function(){
     for(let c of ch){
      c.checked=all.checked;
     }
 
});


	
for(let c of ch){
	
	c.addEventListener("click", function(){
	        let result= true;
			for (let c2 of ch){
			     if(!c2.checked){
			     result=false;
			     break;
			       }
			    }
			all.checked=result;
	
     });

}
	
	
	
	
	/*
function go(){
	
	alert("go");
	
	const all = document.getElementById("all");
	let ch = document.getElementsByClassName("ch");
	let result=true;


for(c of ch){
	if (!c.checked){
      result=false;
  }
}

all.checked = result;
}

*/
	
	

function check() {
	
	alert("check");
	
	let all = document.getElementById("all");
	let ch = document.getElementsByClassName("ch");
	
	
	for(let c of ch){
		c.checked = all.checked;
	}

}










