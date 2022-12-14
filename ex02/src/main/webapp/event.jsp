<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		/*$(function(){ //$(window).ready(function(){})
			//버튼 클릭 : 텍스트 필트 입력값을 li태크 생성해서 추가
			$('[type=button]').on("click", function () {
				let tx = $('#inTxt').val();
				let li = $('<li/>').append(tx);
				$('#list').prepend(li);
				$('#inTxt').val('');
				//list.append($('<li>').html($("#inTxt").val()))
			})
			 li.on('click', function(){ //동적인 것에는 적용안됨
				$(this).css('backgroundColor','red');
			})
			 
			 //그릅이벤트 (위임)
			 $('ul').on('click', 'li' , function(){//실제 이벤트가 걸릴 자식을 위임함
				$(this).css('backgroundColor','red');
			})
		})*/
		window.addEventListener("load", function(){
			btnAdd.addEventListener("click",function(){//동적인 것에는 적용안됨
				let txt = inTxt.value;
				let li = document.createElement('li');
				li.append(txt); //li.innerHtml = inTxt.value;
				list.append(li);
				inTxt.value='';
			})
			list.addEventListener('click', function(ev){
				console.dir(ev) //dir
				console.log('ev',ev);
				console.log('ev.target',ev.target); //li
				console.log('this',this); //ul
				console.log('event.target.nodeName',event.target.nodeName); //LI
				console.log('event.target',event.target); //li
				/* if( this.nodename == 'LI'){
					
				} */
				if( event.target.nodeName == 'LI'){
					event.target.style.backgroundColor = 'yellow';
				}
			})
		})
	</script>
</head>
<body>
	<!-- li태그 클릭시 배경색 변경 css('','')-->
	<input id="inTxt"><button type="button" id="btnAdd">등록</button>
	<ul id="list">
		<li>사과</li>
		<li>바나나</li>
	</ul>
</body>
</html>