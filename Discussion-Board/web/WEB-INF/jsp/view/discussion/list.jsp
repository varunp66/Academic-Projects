<%--@elvariable id="discussions" type="java.util.List<com.wrox.site.entity.Discussion>"--%>


<!DOCTYPE html>
<html>
   <div align="center">
    <head>
        <br/>
        <br/>
        <title>Discussion List</title>
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("/discussion/list").click(function(){
        $(this).hide();
    });
});
</script>

    </head>
    
    <table>
         
    <tbody>
        
    <h1 style="color:#93c0ff;"><u>Discussions</u> </h1>
       
        [<a href="<c:url value="/discussion/create" />" style="color:#e89d07;">Start a New Discussion</a>]<br />
        <br />
        <c:choose>
            <c:when test="${fn:length(discussions) > 0}">
                <c:forEach items="${discussions}" var="discussion">
                    <a href="<c:url value="/discussion/${discussion.id}/${discussion.uriSafeSubject}" />">
                        <c:out value="${discussion.subject}" /></a><br />
                    (<c:out value="${discussion.user}" />)<br/>
                </c:forEach>
            </c:when>
            <c:otherwise >
                There are no discussions yet
            </c:otherwise>
        </c:choose><br/>
        <br/>                                          
               
                <br/>
                
                <td>
                    <form>
        
                       <input type="submit" name="discussion/delete" value="Delete" class="button button2"/> 
                    </form>
                    
                    
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

.button2 {background-color: #fdc67f; color: black;} /* Cream */ 


</style>
        
    </form>
</td>
                
    </tbody>
    </table>
   </div>
</html>
