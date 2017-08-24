<%--@elvariable id="discussion" type="com.wrox.site.entity.Discussion"--%>
<%--@elvariable id="replies" type="java.util.List<com.wrox.site.entity.Reply>"--%>
<!DOCTYPE html>
<html>
    <div align="center">
    <head>
        <title>Discussion: <c:out value="${discussion.subject}" /></title>
    </head>
    <body>
        <h2 style="color:#8cb3f2;"><u>Discussion:</u> <c:out value="${discussion.subject}" /></h2>
        [<a href="<c:url value="/discussion/list" />" style="color:#e89d07;">Return to List</a>]<br />
    <i style="color: #7c857b;">User: <c:out value="${discussion.user}" /> / Created: <c:out value="${discussion.created}" /></i>
        <br />
        <c:out value="${discussion.message}" /><br />
        <br />
        <c:choose>
            <c:when test="${fn:length(replies) > 0}">
                <c:forEach items="${replies}" var="reply" varStatus="i">
                    <b>Reply #${i.count}</b><i> - <c:out value="${reply.user}" /> -
                    <c:out value="${reply.created}" /></i><br />
                    <c:out value="${reply.message}" /><br />
                    <br />
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i style="color:#ff3b3b"> There are no replies yet. </i><br />
                <br />
            </c:otherwise>
        </c:choose>
        <b style="color: #2cde55">Post Reply</b><br />
        <br />
        <c:set var="action"><c:url value="/discussion/${discussion.id}/reply" /></c:set>
        <form:form method="post" action="${action}" modelAttribute="replyForm">
            <form:label path="user" style="color:#e89d07;">Your Email</form:label><br />
            <form:input path="user" type="email" /><br />
            <br />
            <form:label path="message" style="color:#e89d07;">Message</form:label><br />
            <form:textarea path="message" cols="40" rows="4" /><br />
            <br />
            
            <form>
            <input type="submit" value="Submit" class="button button1" />     
            <input type="submit" value="Delete" class="button button2" />
            </form>
            
         </form:form>
             
                 
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
.button2 {background-color: #fafcc0; color: black;} /* Cream */ 


</style>
</head>
<body>



    </body>
    </div>
</html>
