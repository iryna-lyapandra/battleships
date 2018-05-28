<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login Form Design One | Fazt</title>
    <link rel="stylesheet" href="resources/css/master.css">
    <script type="text/javascript">

        function ajaxAsyncRequest(reqURL)
        {
            //Creating a new XMLHttpRequest object
            var xmlhttp;
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var url = reqURL + "?username=" + username + "&password=" + password;

            if (window.XMLHttpRequest){
                xmlhttp = new XMLHttpRequest(); //for IE7+, Firefox, Chrome, Opera, Safari
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //for IE6, IE5
            }
            //Create a asynchronous GET request
            xmlhttp.open("GET", url, true);

            //When readyState is 4 then get the server output
            xmlhttp.onreadystatechange = function() {

                if (xmlhttp.readyState == 4) {
                    if (xmlhttp.status == 200)
                    {
                        var result = xmlhttp.responseText;
//                        alert(result);
                        if (result == "true") {
                            window.location='about.html'
                        }
                        else {
                            alert("Enter the right username&password")
                        }


//                        document.getElementById("message").innerHTML = xmlhttp.responseText;
                        //alert(xmlhttp.responseText);
                    }
                    else
                    {
                        alert('Something is wrong !!');
                    }
                }
            };

            xmlhttp.send(null);
        }

    </script>
  </head>
  <body>

    <div class="login-box">
      <img src="resources/images/logo.png" class="avatar" alt="Avatar Image">
      <h1>Login Here</h1>
      <form>
        <!-- USERNAME INPUT -->
        <label for="username">Username</label>
        <input type="text" id="username" placeholder="Enter Username">
        <!-- PASSWORD INPUT -->
        <label for="password">Password</label>
        <input type="password" id="password" placeholder="Enter Password">
        <input type="submit" value="Log In" onclick='ajaxAsyncRequest("login-servlet")'/>
        <%--<a href="#">Lost your Password?</a><br>--%>
        <%--<a href="#">Don't have An account?</a>--%>
      </form>
    </div>
  </body>
</html>
