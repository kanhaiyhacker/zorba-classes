<%@ page isELIgnored="false" %>

<html>

<head>
    <style>
        #continer {
            background-color: white;
            margin: auto;
            width: 400px;
            padding: 20px;
            border-radius: 20px;
        }

        h3 {
            text-align: center;
        }

        input {
            margin-left: 5px;
        }

        label {
            font-weight: 600;
            min-width: 140px;
        }

        .inputDiv {
            margin-bottom: 10px;
        }

        input,
        select {
            background-color: lightblue;
            min-width: 200px;
            padding: 5px;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: green;
            color: white;
            border-radius: 10px;
            border-color: green;
            height: 30px;
            width: 200px;
            align-self: center;
            font-size: medium;
            font-weight: 600;
            margin-top: 20px;
        }

        .inputDiv {
            justify-content: center;
            display: flex;
        }
    </style>
</head>

<body bgcolor="grey">
    <div id="continer">
        <h3>Login User</h3>
        <form action="${pageContext.request.contextPath}/user/login" method="post">

            <div class="inputDiv">
                <label>Username </label>
                <input type="text" name="username" , placeholder="john232" id="username" required />
            </div>
            <div class="inputDiv">
                <label>Password </label>
                <input type="password" name="password" , placeholder="123456" id="password" required />
            </div>
            <div class="inputDiv">
                <label>User Type </label>
                <select name="role">
                    <option>Admin</option>
                    <option>Passenger</option>
                </select>
            </div>
            <div style="justify-content: center; display: flex;"><input type="submit" value="Login"/></div>

        </form>
    </div>
</body>

</html>