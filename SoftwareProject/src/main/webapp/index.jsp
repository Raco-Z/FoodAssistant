<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/11/17
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN SURFACE</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function ()
        {
            $("#btn").click(function ()
            {
                //alert("HELLO BTN");
                $.ajax({
                    //编写json格式，设置属性和值
                    url:"param/testAjax2",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"zzc", "age":20, "password":"123"}',
                    dataType:"json",
                    type:"post",
                    success:function (data)
                    {
                        //解析服务器返回的数据data
                        alert(data);
                        alert(data.username);
                        alert(data.age);
                        alert(data.password);
                    }
                })
            });
        })
    </script>
</head>
<body>
    <h3>LOGIN</h3>
    <button id="btn">TEST</button>
    <form action="login/userLogin" method="post" target="_self">
        <fieldset>
            <legend>User Login</legend>
            <input type="radio" name="level" value="normal" checked="checked">Normal
            <input type="radio" name="level" value="admin">Admin<br>
            Username:<input type="text" id="username" name="username" pattern="^\w*$" required><br>
            Password:<input type="password" id="password" name="password" pattern="^\w{6,18}$" required><br>
            <input type="submit" name="login" value="login"><br>
        </fieldset>
    </form>

    <script>
        var ctrl = document.querySelector("#username");
        function invalid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            if (tag.validity.valueMissing)
            {
                ctrl.setCustomValidity("输入不能为空");
            }
            else if (tag.validity.patternMismatch)
            {
                ctrl.setCustomValidity("只能输入字母、数字、下划线");
            }
        }
        ctrl.addEventListener("invalid",invalid,false);
        function valid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            ctrl.setCustomValidity("");
        }
        ctrl.addEventListener("input",valid,false);
    </script>
    <script>
        var ctrl = document.querySelector("#password");
        function invalid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            if (tag.validity.valueMissing)
            {
                ctrl.setCustomValidity("输入不能为空");
            }
            else if (tag.validity.patternMismatch)
            {
                ctrl.setCustomValidity("请输入6-18位的字母、数字");
            }
        }
        ctrl.addEventListener("invalid",invalid,false);
        function valid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            ctrl.setCustomValidity("");
        }
        ctrl.addEventListener("input",valid,false);
    </script>

    <hr/>

    <h3>REGISTER</h3>
    <form action="login/userRegister" method="post" target="_self">
        <fieldset>
            <legend>User Register</legend>
            <input type="radio" name="level" value="normal" checked="checked">Normal
            <input type="radio" name="level" value="admin">Admin<br>
            Username:<input type="text" id="regusername" name="username" pattern="^\w*$" required><br>
            Password:<input type="password" id="regpassword" name="password" pattern="^\w{6,18}$" required><br>
            <input type="submit" name="register" value="register and login"><br>
        </fieldset>
    </form>

    <script>
        var ctrl = document.querySelector("#regusername");
        function invalid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            if (tag.validity.valueMissing)
            {
                ctrl.setCustomValidity("输入不能为空");
            }
            else if (tag.validity.patternMismatch)
            {
                ctrl.setCustomValidity("只能输入字母、数字、下划线");
            }
        }
        ctrl.addEventListener("invalid",invalid,false);
        function valid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            ctrl.setCustomValidity("");
        }
        ctrl.addEventListener("input",valid,false);
    </script>
    <script>
        var ctrl = document.querySelector("#regpassword");
        function invalid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            if (tag.validity.valueMissing)
            {
                ctrl.setCustomValidity("输入不能为空");
            }
            else if (tag.validity.patternMismatch)
            {
                ctrl.setCustomValidity("请输入6-18位的字母、数字");
            }
        }
        ctrl.addEventListener("invalid",invalid,false);
        function valid(e)
        {
            var tag = e.target;
            console.info(tag.validity);
            ctrl.setCustomValidity("");
        }
        ctrl.addEventListener("input",valid,false);
    </script>
</body>
</html>
