<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<style>
.form{
   border-style:solid;
   border-color:gray;
   border-width:5px;
   width: 40%;
}

h3{
   text-align:center;
}

.btn{
   display:flex;
   justify-content:center;
   align-items:center;
}
td:nth-child(1) {
    width: 50%;
    text-align: center;
}
td:nth-child(2) {
    width: 70%;
    text-align: center;
}
</style>
</head>
<body>
    <h2>Registration Form</h2>
    <div>
    <form class ="form" action="/hw1-helloMVC/doRegister" method="post">
        <table cellpadding="5">
                <h3>Enter Information Here</h3>
            <tr>
                <td>아이디</td>
                <td><input type="text" class="formtag" name="id"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" class="formtag" name="password"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input type="text" class="formtag"  name="name"></td>
            </tr>
            <tr>
                <td>성별</td>
                <td>
                    <input type="radio" class="formtag"  name="gender" value="male">남자
                    <input type="radio"class="formtag"   name="gender" value="female">여자
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td><input type="text"class="formtag" name="email"></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit"> register</button> </td>
            </tr>
        </table>
    </form>    
    </div>

   
</body>
</html>