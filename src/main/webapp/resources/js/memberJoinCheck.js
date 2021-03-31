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