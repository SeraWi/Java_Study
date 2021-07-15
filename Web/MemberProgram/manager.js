function Member(id,pw,name){
    this.userId = id;
    this.pw = pw;
    this.userName = name;
}


Member.prototype.makeHtml =function(){
    return'[id'+this.userId+',pw:'+this.pw+',name:'+this.userName+']';
}

var members =[];

//로드 시작
window.onload=function(){
     //회원리스트 보여주기
     setList();

    //사용자 입력한 값 캐스팅 -> 문자열 반환해서-> 저장하기
    var userId = document.querySelector('#userId'); //getter ->저장
    var pw = document.querySelector('#pw');
    var repw = document.querySelector('#repw');
    var userName = document.querySelector('#userName');


    //regForm 캐스팅
    var refForm = document.getElementById('regForm');

    regForm.onsubmit= function (){

       

        //등록 버튼을 눌렀을 때 발생하는 이벤트
        

        if(userId.value.trim().length < 1){
            //아이디 입력하지 않았을 경우
            //경고 메세지

            //캐스팅하고 , js ->html
            document.querySelector('#userId+div.msg').innerHTML ='필수 항목 입니다.';//setter
            document.querySelector('#userId+div.msg').style.display ='block';
            return false;

        }

        if(pw.value.trim().length < 1){
            //비밀번호 입력하지 않았을 경우
            //경고 메세지

            //캐스팅하고 , js ->html
            document.querySelector('#pw+div.msg').innerHTML ='필수 항목 입니다.';//setter
            document.querySelector('#pw+div.msg').style.display ='block';
            return false;

        }

        if(repw.value.trim().length<1){
            document.querySelector('#repw+div.msg').innerHTML ='필수 항목입니다.';
            document.querySelector('#repw+div.msg').style.display='block';
            return false;
        }


        //비밀번호와 비밀번호 확인 일치 하지 않을 경우
        if(pw.value.trim() != repw.value.trim()){
            document.querySelector('#repw+div.msg').innerHTML ='비밀번호가 일치하지 않습니다.';
            document.querySelector('#repw+div.msg').style.display ='block';
            return false;
        }


        if(userName.value.trim()<1){
            document.querySelector('#userName+div.msg').innerHTML ='필수 항목입니다.';
            document.querySelector('#userName+div.msg').style.display ='block';
            return false;
        }

        console.log(userId.value);
        console.log(pw.value);
        console.log(repw.value);
        console.log(userName.value);

        //배열에 사용자 정보 추가
        members.push(new Member(userId.value, pw.value, userName.value));

        //저장후 알림창
        alert('등록되었습니다.');
       console.log('회원리스트', members);

        

        //등록 버튼 누르고 등록창 확인 누른 후 form 초기화
        this.reset();

        //등록누르고 회원리스트 밑에 보여주기
        setList();
        

        return false;
    }

    //submit 버튼 누르는 거랑 별개로
    // 입력창에 커서 들어가면 경고메세지 없애기 = 공백을 만들기

    userId.addEventListener('focus',function(){
        //focus = 커서 들어갔을 때
        document.querySelector('#userId+div.msg').style.display ='none';
        document.querySelector('#userId+div.msg').innerHTML ='';
        
    });

    pw.addEventListener('focus',function(){
        document.querySelector('#pw+div.msg').style.display='none';
        document.querySelector('#pw+div.msg').innerHTML ='';
    });

    repw.addEventListener('focus',function(){
        document.querySelector('#repw+div.msg').style.display='none';
        document.querySelector('#repw+div.msg').innerHTML ='';
    });

    userName.addEventListener('focus',function(){
        document.querySelector('#userName+div.msg').style.display='none';
        document.querySelector('#userName+div.msg').innerHTML ='';
    });

}

function setList(){
    console.log(members);

    //table의 tbody캐스팅하기
    var list = document.querySelector('#list');

    var tbody = '<tr>';
    tbody += '  <th>순번(index)</th>';
    tbody += '  <th>아이디</th>';
    tbody += '  <th>비밀번호</th>';
    tbody += '  <th>이름</th>';
    tbody += '  <th>관리</th>';
    tbody += '</tr>';


    if(members.length <1){
        //데이터 존재X

        tbody += '<tr>';
        tbody += '<td colspan="5">데이터가 존재하지않습니다.</td>';
        tbody += '</tr>';

    }else{
        //데이터 있다

        for(var i= 0; i<members.length; i++){
            tbody +='<tr>';
            tbody +='   <td>'+i+'</td>'; //인덱스
            tbody +='   <td>'+members[i].userId+'</td>';
            tbody +='   <td>'+members[i].pw+'</td>';
            tbody +='   <td>'+members[i].userName+'</td>';
            tbody +='   <td><a href="javascript:editMember('+i+')">수정 </a> |<a href="javascript:deleteMember('+i+')"> 삭제</a></td>';
            tbody +='</tr>';
        }
       
    }
    list.innerHTML = tbody;

}

function deleteMember(index){
    if(confirm('삭제하시겠습니까?')){
         members.splice(index,1);
         alert('삭제되었습니다.');

         //테이블의 리스트를 갱신
         setList();
    }
}

/*function editMember(index){

    document.querySelector('#editFormArea').style.display ='block';
    //캐스팅 가져와서
    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex= document.querySelector('#index');
    //수정폼 열었을 때 기본 정보로 세팅
    editUserId.value= members[index].userId;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value =members[index].userName;
    editIndex.value= index; //인덱스 전달 받기


    
    //수정 버튼 눌렀을 때, 다시 캐스팅해서 가져오기
    document.querySelector('#editForm').onsubmit=function (){
        if(editPw.value.trim() != editRePw.value.trim()){
            alert('비밀번호가 일치하지 않습니다');
            return false;
        }

        if(!confirm('수정하시겠습니까?')){
            return false;
        }
        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName =editName.value;

        alert('수정되었습니다.');
        

        //리스트 갱신해주기
        setList();

        return false;
    };
}*/

function editMember(index){

    //수정 폼이 화면에 노출되도록 한다
    document.querySelector('#editFormArea').style.display ='block';



    //alert(index +'인덱스의 요소를 수정합니다.');

    //전달받은 index 값으로 members 배열의 객체 하나를 얻을 수 있다!
    //수정 누르는 순간 index받아서 콘솔에 보여주기
    console.log (index,members[index]);

    // editForm의 태그들의 value 값을 세팅
    //캐스팅
    var editUserId = document.querySelector('#editId');
    var editPw = document.querySelector('#editPw');
    var editRePw = document.querySelector('#editRePw');
    var editName = document.querySelector('#editName');
    var editIndex= document.querySelector('#index');

    //데이터 폼(회원리스트)에 세팅하기
    editUserId.value= members[index].userId;
    editPw.value = members[index].pw;
    editRePw.value = members[index].pw;
    editName.value =members[index].userName;
    editIndex.value= index; //인덱스 전달 받기
    

    //수정버튼 눌렀을 때!
    document.querySelector('#editForm').onsubmit= function(){
        
        //수정한 데이터 담는 객체
        //var member= new Member(editUserId.value,editPw.value,editName.value );
        //수정 누르면 콘솔에 인덱스와 정보 보여주기
        //console.log(editIndex.value,member);


        //비밀번호와 비밀번호 확인 같은지 체크
        if(editPw.value !== editRePw.value){
            //다르다!
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');

            return false; //종료: 밑에꺼 실행 안된다.
        }


        if(!confirm('수정하시겠습니까?')){
            //아니오!, 수정안함
            return false;
        }

        //변경된 사항을 다시 객체에 넣어주기(인덱스에 있는 객체를 찾아서!)
        // 수정된다!!
        members[editIndex.value].pw = editPw.value;
        members[editIndex.value].userName =editName.value;

        alert('수정되었습니다.');
        

        //리스트 갱신해주기
        setList();

        return false;
    };


}

function editMemberClose(){
    document.querySelector('#editFormArea').style.display ='none';
}