<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/12/15
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>PERSONAL INFORMATION SURFACE</title>
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/echarts/4.2.1-rc1/echarts.min.js"></script>
    <script>

        $(function ()
        {
            $("#listMenu").click(function ()
            {

                var foodName = $("#findFood").val();

                //发送ajax请求
                $.ajax({
                    url:"user/listMenu",
                    type:"post",
                    contentType:"application/json;charset=UTF-8",
                    data:JSON.stringify({"foodName":"asd", "foodId":2, "foodType":"food"}),
                    dataType:"json",
                    success:function (data)
                    {
                        //var place = document.getElementById("d1");
                        //var table = document.createElement("table");
                        //place.innerText = data;
                        alert("done");
                        alert(data.type);
                        alert(data);
                    },

                })
            })
        })
    </script>
</head>
<body>
    <div style="border:2px solid">
        <h3>Basic Information</h3>
        <%--用户的基本信息，包括id和username--%>
        <form>
            ID: ${user.accountId}<br>
            Your Name: ${user.accountName}<br>
        </form>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>Your Health about Diet</h3>
        <%--查询食物营养表，如果输入为空，则输出整张营养表--%>
         <%--<form id="food-name-form" action="user/listMenu" method="post">
            Search for the Nutrition of Food
            <input type="text" id="findFood" name="foodName"><br>
            <input type="submit" id="listMenu" name="listMenu" value="Search">
        </form>--%>
        <button id="btn">Test</button>
        <button id="listMenu">Search</button>
        <div id="d1"></div>
        <%--输入每餐的食物名称--%>
        <form action="user/saveRecord" method="post">
            Enter your diet data for today
            <input type="text" name="recordedName"><br>
            <%--保存输入的饮食数据，并返回所有饮食数据构建图表--%>
            <input type="button" name="saveRecord" value="Record"><br>
            <div id="chart" style="width: 800px;height: 400px">
            </div>
        </form>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>RecommendMenu</h3>
        <%--点击按钮显示推荐食谱--%>
        <form action="user/showRecommendMenu" method="get">
            <%--发送请求，显示返回的数据--%>
            <input type="button" name="showRecommendNutrition" value="show"><br>
        </form>
        <div id="d2"></div>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>Calculate Nutrition</h3>
        <%--计算摄入的营养--%>
        <form action="user/calculateNutrition" method="get">
            Food Name:<input type="text" name="foodName"><br>
            Food Weight:<input type="text" name="foodWeight"><br>
            <input type="submit" name="calculate" value="Calculate Nutrition">
        </form>

    </div>

    <script type="text/javascript">
        var myChart = echarts.init(document.getElementById('chart'));
        var option = {
            xAxis: {
                data: [],
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'line',
                data: [5, 20, 36, 10, 10, 20]
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>

</body>
</html>
