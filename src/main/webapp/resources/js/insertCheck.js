/**
 * 
 */


function insertCheck(){
	alert("insert check");
	
	let writer = document.getElementById("writer");
	let title = document.getElementById("title");
	
	if(writer.value=="" ||title.value == ""){
  
		alert("로그인을 하시고 제목을 꼭 작성해주세요");
	}
	return false;
}