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

                var fName = $("#findFood").val();

                //发送ajax请求
                $.ajax({
                    url:"user/listMenu",
                    contentType:"application/json;charset=UTF-8",
                    data:fName,
                    type:"post",
                    success:function (data)
                    {
                        if (data=="")
                        {
                            alert("没有找到这种食物");
                        }
                        else
                        {
                            var strary1 = data.match(/{[^{}]+}/g);
                            //console.info(strary1);
                            var strary2 = new Array();
                            var strary4 = new Array();
                            for (var str1 in strary1)
                            {
                                str1 = strary1[str1];
                                var str3 = str1.substring(1,str1.length-1);
                                //console.info(str3);
                                var strary3 = str3.split(', ');
                                //console.info(strary3);
                                strary2 = strary2.concat(strary3);
                            }
                            for (var str2 in strary2)
                            {
                                str2 = strary2[str2];
                                var strary3 = str2.split('=');
                                //console.info(strary3);
                                strary4.push(strary3);
                            }
                            for (var str4 in strary4)
                            {
                                str4 = strary4[str4];
                                str4[1] = str4[1].replace(/'/g,"");
                                //console.info(str4[0]+'='+str4[1]+'<br/>');
                            }
                            oneRowTab("d1", "Food Nutrition", strary4);
                        }
                    },
                    error:function (data)
                    {
                        alert("查询出错了，请重新查询")
                    }

                })
            })
        })

        function oneRowTab(id, caption, data)
        {
            var tag = document.getElementById(id);
            tag.innerText="";
            var tab = document.createElement("table");
            tab.width="700"
            tab.border="1"
            var cap = tab.createCaption();
            cap.innerHTML=caption;
            var thead = tab.createTHead();
            var th = thead.insertRow();
            var len =data.length;
            var row;
            for (var k=0;k<len;k++)
            {
                var cell = th.insertCell();
                cell.innerHTML=data[k][0];
            }
            row = tab.insertRow();
            for (var i=0;i<len;i++)
            {
                var cell = row.insertCell();
                cell.innerHTML=data[i][1];
            }
            document.getElementById(id).append(tab);
        }
    </script>
</head>
<body>
    <div style="border:2px solid">
        <h3>Basic Information</h3>
        <%--用户的基本信息，包括id和username--%>
        <form>
            ID: ${user.accountId}<br>
            Your Name: ${user.accountName}<br>
            Height: <input type="text" id="height" value="10"><br>
            Weight: <input type="text" id="weight" value="10"><br>
            <input type="button" id="saveinfo" value="Save" onclick="saveInfo()">
        </form>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>Your Health about Diet</h3>
        <%--查询食物营养表，如果输入为空，则输出整张营养表--%>
        <form  action="user/listMenu" method="post">
            Search for the Nutrition of Food
            <input type="text" id="findFood" name="foodName"><br>
        </form>
        <div id="d1"></div>
        <button id="listMenu">Search</button>
        <%--输入每餐的食物名称--%>
        <form action="user/saveRecord" method="post">
            Enter your diet data for today<br>
            Food Name: <input type="text" id="recordName"><br>
            Food Weight: <input type="text" id="recordWeight"><br>
            <%--保存输入的饮食数据，并返回所有饮食数据构建图表--%>
            <input type="button" id="saveRecord" value="Record" onclick="record()">
        </form>
        <div id="d3"></div>
        <div id="chart1" style="width: 800px;height: 400px" hidden></div>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>RecommendMenu</h3>
        <%--点击按钮显示推荐食谱--%>
        <form action="user/showRecommendMenu" method="post">
            <%--发送请求，显示返回的数据--%>
            <input type="button" name="showRecommendNutrition" value="show" onclick="showRecommendMenu()"><br>
        </form>
        <div id="d2"></div>
    </div>

    <hr/>

    <div style="border:2px solid">
        <h3>Calculate Nutrition</h3>
        <%--计算摄入的营养--%>
        <form action="user/calculateNutrition" method="post">
            Food Name:<input type="text" id="calName" name="foodName"><br>
            Food Weight:<input type="text" id="calWeight" name="foodWeight"><br>
            <input type="button" name="calculate" value="Calculate Nutrition" onclick="calNutrition()">
        </form>
        <div id="d4"></div>
        <div id="chart2" style="width: 600px;height:400px;" hidden></div>

    </div>
    <script>
        function saveInfo()
        {
            var username = "${user.accountName}";
            var height = $("#height").val();
            var weight = $("#weight").val();
            $.ajax({
                url:"user/saveInfo",
                //contentType:"application/json;charset=UTF-8",
                data:{"username":username, "height":height, "weight":weight},
                type:"post",
                success:function (data)
                {
                    alert(data);
                }
            })
        }
    </script>

    <script>
        function record()
        {
            var username = "${user.accountName}";
            var foodName = $("#recordName").val();
            var foodWeight = $("#recordWeight").val();
            $.ajax({
                url:"user/saveRecord",
                //contentType:"application/json;charset=UTF-8",
                data:{"username":username, "foodName":foodName, "foodWeight":foodWeight},
                type:"post",
                success:function (data)
                {
                    if (data=="")
                    {
                        alert("食物名称输入错误");
                    }
                    else
                    {
                        var cht = document.getElementById("chart1");
                        cht.removeAttribute("hidden");
                        //数据处理
                        var strary1 = data.match(/{[^{}]+}/g);
                        //console.info(strary1);
                        var strary2 = new Array();
                        for (var str1 in strary1)
                        {
                            str1 = strary1[str1];
                            var str2 = str1.substring(1,str1.length-1);
                            //console.info(str2);
                            var strary3 = str2.split(', ');
                            //console.info(strary3);
                            var strary4 = new Array();
                            for (var str3 in strary3)
                            {
                                str3 = strary3[str3];
                                var strary5 = str3.split('=');
                                strary4.push(strary5);
                            }
                            strary2.push(strary4);
                        }
                        var id_data = new Array();
                        var fname_data = new Array();
                        var weight_data = new Array();
                        var protein_data = new Array();
                        var calorie_data = new Array();
                        var fat_data = new Array();
                        var carbohydrate_data = new Array();
                        for (var str2 in strary2)
                        {
                            str2 = strary2[str2];
                            id_data.push(str2[0][1]);
                            fname_data.push(str2[2][1]);
                            weight_data.push(str2[3][1]);
                            protein_data.push(str2[4][1]);
                            calorie_data.push(str2[5][1]);
                            fat_data.push(str2[6][1]);
                            carbohydrate_data.push(str2[7][1]);
                        }
                        recordTab("d3",id_data,fname_data,weight_data,protein_data,calorie_data,fat_data,carbohydrate_data)
                        createChart('chart1',id_data,weight_data,protein_data,calorie_data,fat_data,carbohydrate_data);
                    }
                }
            })
        }
    </script>

    <script type="text/javascript">
        function createChart(name,id_data,weight_data,protein_data,calorie_data,fat_data,carbohydrate_data) {
            var cht = document.getElementById(name);
            var myChart = echarts.init(cht);
            var option = {
                xAxis: {
                    data: id_data,
                },
                yAxis: {},
                tooltip: {},
                legend: {
                    data: ['weight', 'protein', 'calorie', 'fat', 'carbohydrate']
                },
                series: [
                    {
                        name: 'weight',
                        type: 'line',
                        data: weight_data,
                    },
                    {
                        name: 'protein',
                        type: 'bar',
                        data: protein_data,
                    },
                    {
                        name: 'calorie',
                        type: 'bar',
                        data: calorie_data,
                    },
                    {
                        name: 'fat',
                        type: 'bar',
                        data: fat_data,
                    },
                    {
                        name: 'carbohydrate',
                        type: 'bar',
                        data: carbohydrate_data,
                    },
                ]
            }
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }

        function recordTab(id,id_data,fname_data,weight_data,protein_data,calorie_data,fat_data,carbohydrate_data)
        {
            var tag = document.getElementById(id);
            tag.innerText="";
            var tab = document.createElement("table");
            tab.width = "700";
            tab.border = "1";
            tab.id = "tab";
            var row;
            var len = id_data.length;
            var cap = tab.createCaption();
            cap.innerHTML = "All Record of ${user.accountName}";
            var thead = tab.createTHead();
            var th = thead.insertRow()
            var th_str = ["id","food name","weight","protein","calorie","fat","carbohydrate"];
            for (var k=0;k<7;k++)
            {
                var cell = th.insertCell();
                cell.innerHTML = th_str[k];
            }
            for (var i=0;i<len;i++)
            {
                var cell;
                row = tab.insertRow(-1);
                cell = row.insertCell(-1);
                cell.innerHTML = id_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = fname_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = weight_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = protein_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = calorie_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = fat_data[i];
                cell = row.insertCell(-1);
                cell.innerHTML = carbohydrate_data[i];
            }
            document.getElementById(id).append(tab);
        }
    </script>

    <script>
        function showRecommendMenu()
        {
            var username = "${user.accountName}";
            $.ajax({
                url:"user/showRecommendMenu",
                contentType:"application/json;charset=UTF-8",
                data:username,
                type:"post",
                success:function (data)
                {
                    var place = document.getElementById("d2");
                    if (data=="")
                    {
                        place.innerText = "没有可推荐的食物"
                    }
                    else
                    {
                        var strary1 = data.match(/{[^{}]+}/g);
                        //console.info(strary1);
                        var strary2 = new Array();
                        var strary4 = new Array();
                        for (var str1 in strary1)
                        {
                            str1 = strary1[str1];
                            var str3 = str1.substring(1,str1.length-1);
                            //console.info(str3);
                            var strary3 = str3.split(', ');
                            //console.info(strary3);
                            strary2 = strary2.concat(strary3);
                        }
                        for (var str2 in strary2)
                        {
                            str2 = strary2[str2];
                            var strary3 = str2.split('=');
                            //console.info(strary3);
                            strary4.push(strary3);
                        }
                        for (var str4 in strary4)
                        {
                            str4 = strary4[str4];
                            str4[1] = str4[1].replace(/'/g,"");
                            //console.info(str4[0]+'='+str4[1]+'<br/>');
                        }
                        oneRowTab("d2","Need Nutrition",strary4);
                    }
                }
            })
        }
    </script>

    <script>
        function calNutrition()
        {
            var foodName = $("#calName").val();
            var foodWeight = $("#calWeight").val();
            $.ajax({
                url:"user/calNutrition",
                //contentType:"application/json;charset=UTF-8",
                data:{"foodName":foodName, "foodWeight":foodWeight},
                type:"post",
                success:function (data)
                {
                    var place = document.getElementById("d4");
                    if (data=="")
                    {
                        place.innerText = "食物名称输入错误"
                    }
                    else
                    {
                        //初始化图表
                        var cht = document.getElementById("chart2");
                        cht.removeAttribute("hidden");
                        var chart = echarts.init(cht);
                        //数据处理
                        var strary1 = data.match(/{[^{}]+}/g);
                        //console.info(strary1);
                        var strary2 = new Array();
                        var strary4 = new Array();
                        for (var str1 in strary1)
                        {
                            str1 = strary1[str1];
                            var str3 = str1.substring(1,str1.length-1);
                            //console.info(str3);
                            var strary3 = str3.split(', ');
                            //console.info(strary3);
                            strary2 = strary2.concat(strary3);
                        }
                        for (var str2 in strary2)
                        {
                            str2 = strary2[str2];
                            var strary3 = str2.split('=');
                            //console.info(strary3);
                            strary4.push(strary3);
                        }
                        var data_ary = new Array();
                        for (var str4 in strary4)
                        {
                            str4 = strary4[str4];
                            str4[1] = str4[1].replace(/'/g,"");
                            //格式化数据为键值对
                            var obj = {value:str4[1], name:str4[0]};
                            data_ary.push(obj);
                            //console.info(str4[0]+'='+str4[1]+'<br/>');
                        }
                        //构建饼图数据
                        var option = {
                            tooltip: {},
                            series : [
                                {
                                    name: 'Nutrition',
                                    type: 'pie',
                                    radius: '55%',
                                    roseType: 'angle',
                                    data:data_ary
                                }
                            ]
                        };
                        //显示饼图
                        chart.setOption(option);
                    }
                }
            })
        }
    </script>
</body>
</html>
