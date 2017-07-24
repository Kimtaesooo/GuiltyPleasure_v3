<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
<!-- 

	회원가입 등록 폼

 -->
        <meta charset="UTF-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>GuiltyPleasure</title>
        <script src="/resources/ajax.js"></script>
        <!-- Bootstrap -->
        <link href="/resources/design/bootstrap332/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="/resources/image/icon/HalfLife.ico" rel="shortcuticon">
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="//code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="/resources/design/bootstrap332/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="/resources/design/bootstrap332/js/bootstrap.js"></script>
        
        
<script>
	/*
	// AJAX 아이디 유효성 검사 부분
	function fnSubmit(){
    	var u_id = document.getElementById("u_id").value;
    	var param = "u_id=" + u_id;
    	sendRequest("POST", "/GuiltyPleasure/logcheck?cmd=idcheck", param, callback);
    }  
    function callback(){
    	if(httpRequest.readyState==4){
    		if(httpRequest.status == 200){
    			var idcheck = document.getElementById("idcheck");
    			idcheck.innerHTML = httpRequest.responseText;
    		}
    		else{
    			alert(httpRequest.status);
    		}
    	}
    }
    */
</script>

    </head>
    <body>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
    	<!-- 이미지 깨짐
    	<a class="navbar-brand" href="#">
    		<img alt="Brand" src="/images/quiz.jpg">
    	</a>
    	 -->
    	<a class="navbar-brand" href="${pageContext.servletContext.contextPath}/"><font color="red">Guilty Pleasure</font></a>
    </div>
    <div>
    <!-- 좌측정렬 네비 바
      <ul class="nav navbar-nav">
        <li><a href="#">홈</a></li>
        <li><a href="#">메뉴1</a></li>
        <li><a href="#">메뉴2</a></li> 
        <li><a href="#">메뉴3</a></li> 
      </ul>
    -->
    <!-- 우측 정렬 네비 바 -->
    </div>
  </div>
</nav>
        <div class="container">
            <!-- 모달창 -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 -->
            <hr/>
                <!-- 본문 들어가는 부분 -->
 
 
        <form class="form-horizontal" role="form" method="post" action="/logCheck/POSTaddUser" name="logreg" id="logreg">
            <div class="form-group">
                <label for="provision" class="col-lg-2 control-label">회원가입약관</label>
                <div class="col-lg-10" id="provision">
                    <textarea class="form-control" rows="8" style="resize:none">
약관동의
                    </textarea>
                    <div class="radio">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="Y" autofocus="autofocus" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" id="provisionYn" name="provisionYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="memberInfo" class="col-lg-2 control-label">개인정보취급방침</label>
                <div class="col-lg-10" id="memberInfo">
                    <textarea class="form-control" rows="8" style="resize:none">
개인정보의 항목 및 수집방법
                    </textarea>
                    <div class="radio">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y" checked>
                            동의합니다.
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">
                            동의하지 않습니다.
                        </label>
                    </div>
                </div>
            </div>
            
            <!-- 입력부분 시작!!!!!!!! -->
            <!-- for은 누구를 위한 속성인가로, 그 텍스트 박스 값 안으로 찾아 간다. -->
            <!-- 참고로 name이 넘어간다. -->
            <div class="form-group" id="divId">
                <label for="u_id" class="col-lg-2 control-label">아이디</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyAlphabetAndNumber" name="u_id" id="u_id" data-rule-required="true" placeholder="20자이내의 알파벳, 숫자만 입력 가능합니다." maxlength="20">
                </div>
            </div>
            
            <div class="form-group" id="divIdCheck">
                <label  class="col-lg-2 control-label"></label>
                <div class="col-lg-10">
                	<div id="idcheck"></div>
                </div>
            </div>
            
            <div class="form-group" id="divPassword">
                <label for="u_pw" class="col-lg-2 control-label">패스워드</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" name="u_pw" id="u_pw" name="excludeHangul" data-rule-required="true" placeholder="패스워드" maxlength="20">
                </div>
            </div>
            <div class="form-group" id="divPasswordCheck">
                <label for="passwordCheck" class="col-lg-2 control-label">패스워드 확인</label>
                <div class="col-lg-10">
                    <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="20">
                </div>
            </div>
            <div class="form-group" id="divName">
                <label for="u_name" class="col-lg-2 control-label">이름</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyHangul" name="u_name" id="u_name" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="5">
                </div>
            </div>
             
            <div class="form-group" id="divNickname">
                <label for="u_nickname" class="col-lg-2 control-label">별명</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name="u_nickname" id="u_nickname" data-rule-required="true" placeholder="별명" maxlength="10">
                </div>
            </div>
             
            <div class="form-group" id="divEmail">
                <label for="u_email" class="col-lg-2 control-label">이메일</label>
                <div class="col-lg-10">
                    <input type="email" class="form-control" name="u_email" id="u_email" data-rule-required="true" placeholder="이메일" maxlength="30">
                </div>
            </div>
            <div class="form-group" id="divPhoneNumber">
                <label for="u_phone" class="col-lg-2 control-label">휴대폰 번호</label>
                <div class="col-lg-10">
                    <input type="tel" class="form-control onlyNumber" name="u_phone" id="u_phone" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11">
                </div>
            </div>
            <div class="form-group">
                <label for="u_gender" class="col-lg-2 control-label">성별</label>
                <div class="col-lg-10">
                    <select class="form-control" name="u_gender" id="u_gender">
                        <option value="M">남</option>
                        <option value="W">여</option>
                    </select>
                </div>
            </div>            
            <div class="form-group" id="divAddr">
                <label for="u_addr" class="col-lg-2 control-label">주소</label>
                <div class="col-lg-8">
                    <input type="text" class="form-control" name="u_addr" id="u_addr" readonly>
                    <input type="hidden" class="form-control" name="u_postnumber" id="u_addr" readonly>
                </div>
                <div class="col-lg-2">
                    <a class="btn btn-default" href="https://www.naver.com" role="button" onClick="window.open(this.href, '', 'width=500, height=530'); return false;">검색</a>
                </div>
            </div>
            <div class="form-group" id="divBirth">
                <label for="u_birth" class="col-lg-2 control-label">생년월일</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control onlyNumber" name="u_birth" id="u_birth" data-rule-required="true" placeholder="20170101 형식으로입력하세요." maxlength="8">
                </div>
            </div>
            
            <div class="form-group">
                <label for="u_introduce" class="col-lg-2 control-label">자기소개</label>
                <div class="col-lg-10" id="u_introduce">
                    <textarea class="form-control" rows="3" name="u_introduce" maxlength="250"></textarea>
                </div>
            </div>
            
            <div class="form-group">
                <label for="u_question" class="col-lg-2 control-label">아이디 찾기 질문</label>
                <div class="col-lg-10">
                    <select class="form-control" name="u_question" id="u_question">
  						<option>첫째 자녀의 이름은?</option>
  						<option>자신의 인생 좌우명은?</option>
  						<option>가장 기억에 남는 선생님 성함은?</option>
  						<option>다시 태어나면 하고 싶은 것은?</option>
  						<option>가장 감명깊게 본 영화는?</option>
  						<option>기억에 남는 추억의 장소는?</option>
  						<option>인상 깊게 읽은 책 이름은?</option>
  						<option>자신의 보물 제 1호는?</option>
  						<option>아버지의 성함은?</option>
  						<option>내가 좋아하는 운동은?</option>
					</select>
                </div>                 
            </div>
            
            <div class="form-group" id="divAnswerCheck">
                <label for="u_answer" class="col-lg-2 control-label" maxlength="10">질문 답</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name="u_answer" id="u_answer">
                </div>                 
            </div>
            
            <div class="form-group" id="divComment">
                <label for="u_comment" class="col-lg-2 control-label">한줄 소개</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control" name="u_comment" id="u_comment" placeholder="랭킹에 표시됩니다. 50자까지 입력할 수 있습니다." maxlength="50">
                </div>                 
            </div>
                        
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <button type="submit" class="btn btn-default">신청</button>
                </div>
            </div>
        </form>
         
         
        <script>         
            $(function(){
                //모달을 전역변수로 선언
                var modalContents = $(".modal-contents");
                var modal = $("#defaultModal");
                  
                $('.onlyAlphabetAndNumber').keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val($(this).val().replace(/[^_a-z0-9]/gi,'')); //_(underscore), 영어, 숫자만 가능
                    }
                });
                 
                $(".onlyHangul").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[a-z0-9]/gi,''));
                    }
                });
             
                $(".onlyNumber").keyup(function(event){
                    if (!(event.keyCode >=37 && event.keyCode<=40)) {
                        var inputVal = $(this).val();
                        $(this).val(inputVal.replace(/[^0-9]/gi,''));
                    }
                });
                 
                //------- 검사하여 상태를 class에 적용
                $('#u_id').keyup(function(event){
                	fnSubmit();
                    var divId = $('#divId');
                    
                    if($("#idcheck").text().indexOf("불가") != -1){
                    	divId.removeClass("has-success");
                    	divId.addClass("has-error");
                    }else{
                    	divId.removeClass("has-error");
                    	divId.addClass("has-success");
                    }
                });
                 
                $('#u_pw').keyup(function(event){
                     
                    var divPassword = $('#divPassword');
                     
                    if($('#u_pw').val()==""){
                        u_pw.removeClass("has-success");
                        u_pw.addClass("has-error");
                    }else{
                        u_pw.removeClass("has-error");
                        u_pw.addClass("has-success");
                    }
                });
                 
                $('#passwordCheck').keyup(function(event){
                     
                    var passwordCheck = $('#passwordCheck').val();
                    var password = $('#u_pw').val();
                    var divPasswordCheck = $('#divPasswordCheck');
                     
                    if((passwordCheck=="") || (password!=passwordCheck)){
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                });
                 
                $('#u_name').keyup(function(event){
                	fnSubmit();
                    var divName = $('#divName');
                    
                    if($.trim($('#u_name').val())==""){
                        divName.removeClass("has-success");
                        divName.addClass("has-error");
                    }else{
                        divName.removeClass("has-error");
                        divName.addClass("has-success");
                    }
                });
                 
                $('#u_nickname').keyup(function(event){
                     
                    var divNickname = $('#divNickname');
                     
                    if($.trim($('#u_nickname').val())==""){
                        divNickname.removeClass("has-success");
                        divNickname.addClass("has-error");
                    }else{
                        divNickname.removeClass("has-error");
                        divNickname.addClass("has-success");
                    }
                });
                 
                $('#u_email').keyup(function(event){
                     
                    var divEmail = $('#divEmail');
                     
                    if($.trim($('#u_email').val())==""){
                        divEmail.removeClass("has-success");
                        divEmail.addClass("has-error");
                    }else{
                        divEmail.removeClass("has-error");
                        divEmail.addClass("has-success");
                    }
                });
                 
                /* 널가능
                $('#u_phone').keyup(function(event){
                     
                    var divPhoneNumber = $('#divPhoneNumber');
                     
                    if($.trim($('#u_phone').val())==""){
                        divPhoneNumber.removeClass("has-success");
                        divPhoneNumber.addClass("has-error");
                    }else{
                        divPhoneNumber.removeClass("has-error");
                        divPhoneNumber.addClass("has-success");
                    }
                });
                */
                
                $('#u_answer').keyup(function(event){
                    
                    var divAnswerCheck = $('#divAnswerCheck');
                     
                    if($.trim($('#u_answer').val())==""){
                    	divAnswerCheck.removeClass("has-success");
                    	divAnswerCheck.addClass("has-error");
                    }else{
                    	divAnswerCheck.removeClass("has-error");
                    	divAnswerCheck.addClass("has-success");
                    }
                });
                
				$('#u_comment').keyup(function(event){
                    
                    var divComment = $('#divComment');
                     
                    if($.trim($('#u_comment').val())==""){
                    	divComment.removeClass("has-success");
                    	divComment.addClass("has-error");
                    }else{
                    	divComment.removeClass("has-error");
                    	divComment.addClass("has-success");
                    }
                });
                 
                //------- validation 검사
                $( "form" ).submit(function( event ) {
                     
                    var provision = $('#provision');
                    var memberInfo = $('#memberInfo');
                    var divId = $('#divId');
                    var divPassword = $('#divPassword');
                    var divPasswordCheck = $('#divPasswordCheck');
                    var divName = $('#divName');
                    var divNickname = $('#divNickname');
                    var divEmail = $('#divEmail');
                    var divPhoneNumber = $('#divPhoneNumber');
                    var divAnswerCheck = $('#divAnswerCheck');
                    var divComment = $('#divComment');
                     
                    //회원가입약관
                    if($('#provisionYn:checked').val()=="N"){
                        modalContents.text("회원가입약관에 동의하여 주시기 바랍니다."); //모달 메시지 입력
                        modal.modal('show'); //모달 띄우기
                         
                        provision.removeClass("has-success");
                        provision.addClass("has-error");
                        $('#provisionYn').focus();
                        return false;
                    }else{
                        provision.removeClass("has-error");
                        provision.addClass("has-success");
                    }
                     
                    //개인정보취급방침
                    if($('#memberInfoYn:checked').val()=="N"){
                        modalContents.text("개인정보취급방침에 동의하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        memberInfo.removeClass("has-success");
                        memberInfo.addClass("has-error");
                        $('#memberInfoYn').focus();
                        return false;
                    }else{
                        memberInfo.removeClass("has-error");
                        memberInfo.addClass("has-success");
                    }
                     
                    //아이디 검사
                    if($('#idcheck').text().indexOf("불가") != -1){
                        modalContents.text("아이디를 확인하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divId.removeClass("has-success");
                        divId.addClass("has-error");
                        $('#u_id').focus();
                        return false;
                    }else{
                    	divId.removeClass("has-error");
                    	divId.addClass("has-success");
                    }
                     
                    //패스워드 검사
                    if($('#u_pw').val()==""){
                        modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPassword.removeClass("has-success");
                        divPassword.addClass("has-error");
                        $('#password').focus();
                        return false;
                    }else{
                    	divPassword.removeClass("has-error");
                    	divPassword.addClass("has-success");
                    }
                     
                    //패스워드 확인
                    if($('#passwordCheck').val()==""){
                        modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                        $('#passwordCheck').focus();
                        return false;
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                     
                    //패스워드 비교
                    if($('#u_pw').val()!=$('#passwordCheck').val() || $('#passwordCheck').val()==""){
                        modalContents.text("패스워드가 일치하지 않습니다.");
                        modal.modal('show');
                         
                        divPasswordCheck.removeClass("has-success");
                        divPasswordCheck.addClass("has-error");
                        $('#passwordCheck').focus();
                        return false;
                    }else{
                        divPasswordCheck.removeClass("has-error");
                        divPasswordCheck.addClass("has-success");
                    }
                     
                    //이름
                    if($('#u_name').val()==""){
                        modalContents.text("이름을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divName.removeClass("has-success");
                        divName.addClass("has-error");
                        $('#name').focus();
                        return false;
                    }else{
                        divName.removeClass("has-error");
                        divName.addClass("has-success");
                    }
                     
                    //별명
                    if($('#u_nickname').val()==""){
                        modalContents.text("별명을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divNickname.removeClass("has-success");
                        divNickname.addClass("has-error");
                        $('#u_nickname').focus();
                        return false;
                    }else{
                        divNickname.removeClass("has-error");
                        divNickname.addClass("has-success");
                    }
                     
                    //이메일
                    if($('#u_email').val()==""){
                        modalContents.text("이메일을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divEmail.removeClass("has-success");
                        divEmail.addClass("has-error");
                        $('#u_email').focus();
                        return false;
                    }else{
                        divEmail.removeClass("has-error");
                        divEmail.addClass("has-success");
                    }
                    
                    /* 널 가능
                    //휴대폰 번호
                    if($('#u_phone').val()==""){
                        modalContents.text("휴대폰 번호를 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divPhoneNumber.removeClass("has-success");
                        divPhoneNumber.addClass("has-error");
                        $('#u_phone').focus();
                        return false;
                    }else{
                        divPhoneNumber.removeClass("has-error");
                        divPhoneNumber.addClass("has-success");
                    }
                    */
                    
                    //질문 답
                    if($('#u_answer').val()==""){
                        modalContents.text("아이디 찾기 질문 답을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divAnswerCheck.removeClass("has-success");
                        divAnswerCheck.addClass("has-error");
                        $('#u_answer').focus();
                        return false;
                    }else{
                    	divAnswerCheck.removeClass("has-error");
                    	divAnswerCheck.addClass("has-success");
                    }
                  
                    
                  /* 널가능
                  //한줄소개
                    if($('#u_comment').val()==""){
                        modalContents.text("아이디 찾기 질문 답을 입력하여 주시기 바랍니다.");
                        modal.modal('show');
                         
                        divComment.removeClass("has-success");
                        divComment.addClass("has-error");
                        $('#u_comment').focus();
                        return false;
                    }else{
                    	divComment.removeClass("has-error");
                    	divComment.addClass("has-success");
                    }
                  */
                });
                 
            });
             
        </script>
                <!--// 본문 들어가는 부분 -->
            <hr/>
            <!-- 푸터 들어가는 부분 -->
             
            <div>
                <p class="text-center">
                    <small><strong>GuiltyPleasure</strong></small><br>
                    <small>대표 : GP ㆍ 주소 :  역삼역 ㆍ 사업자등록번호:123-12-12345 ㆍ 전화 : 064-123-1234</small><br>
                    <small>Copyrightⓒ test.com All rights reserved.</small>
                </p>
            </div>
            <!--// 푸터 들어가는 부분 -->
        </div>
    </body>
</html>