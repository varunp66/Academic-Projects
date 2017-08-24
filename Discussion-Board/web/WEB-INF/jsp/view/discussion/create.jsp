<!DOCTYPE html>
<html>
    <div align="center">
  <head>
      <title> Create Discussion </title>
    </head>
   
    <body>
        <br/>
        
        <h1 style="color:#8cb3f2;"><u>Create Discussion</u></h1>
        
     <a href="<c:url value="/discussion/list" />" style="color:#e89d07;">Return to List</a><br />
       
        <br />
        <form:form method="post" modelAttribute="discussionForm"><br/>
            <form:label path="user" style="color:#db971a" > Enter Your Email </form:label> &nbsp;
            <form:input path="user" type="email" /><br />
            <br />
            
            <form:label path="subject" style="color:#db971a"> Subject </form:label> &emsp;&emsp;&emsp;&emsp;
            <form:input path="subject" /><br />
            <br />
            <form:label path="message" style="color:#db971a"> Message </form:label> <br/>
            <form:textarea path="message" cols="40" rows="4" /><br />
            <br />
            
            <input type="submit" value="Submit" class="button button1"/>
            <input type="submit" value="Delete" class="button button2"/>
            
    </form:form>
    </body>
    <style>
        
.button {
    
    border: none;
    color: white;
    padding: 10px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

.button1 {background-color: #555555;} /* Black */
.button2 {background-color: #fafcc0; color: black;} /* Light yellow with black letters*/ 


</style>
</head>


</div>
</html>
