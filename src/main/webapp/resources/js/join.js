// 전역 변수
// var
const pw = document.getElementById("pw");
const pw2 = document.getElementById("pw2");
const pwResult = document.getElementById("pwResult");
const pwResult2 = document.getElementById("pwResult2");

const idx = document.getElementById("idx");
const idResult = document.getElementById("idResult");

const frm = document.getElementById("frm");
const btn = document.getElementById("btn");

let idCheck=false;
let pwCheck=false;

btn.addEventListener("click", function(){
    
    frm.submit();
});


idx.addEventListener("blur", function(){
    idCheck=false;
    let v = idx.value;
    
    if(v==''){ //v.length == 0
        idResult.innerHTML = '필수 입력'
        idCheck=true;
    }
});


pw2.addEventListener("blur", function(){
    pwCheck=true;
    let v1 = pw.value;
    let v2 = pw2.value;
    let message = "비번이 일치 하지 않음"
    
    if(v1 == v2){
        message = "비번이 일치 함"
        pwCheck= false;
    }

    pwResult2.innerHTML=message;

});

pw.addEventListener("keyup", function(){
    let length = pw.value.length;
    let message = '잘못된 비번';
    if(length>=8 && length<=12){
        message = '정상 비번';
    }

    pwResult.innerHTML=message;

});