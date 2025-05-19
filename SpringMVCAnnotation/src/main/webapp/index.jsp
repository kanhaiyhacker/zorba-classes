<%@ page isELIgnored="false" %>
<html>
    

<head>
    <style>
        body {
            background-color: grey;
        }

        .container {
            background-color: white;
            padding: 20Px;
            margin: 20px;
            border-radius: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <H2 style="text-align: center;">Air Ticket booking System</H2>
        <h4>Are you a new user? If yes <a href='${pageContext.request.contextPath}/user/register'>register here</a></h4>
        <h4>Are you the existing new user? If yes <a href='${pageContext.request.contextPath}/user/login'>login here</a></h4>
    </div>

</body>

</html>