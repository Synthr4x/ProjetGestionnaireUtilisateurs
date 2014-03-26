<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<c:if test="${!empty requestScope['message']}">         
    <div class="alert alert-info">${requestScope['message']}</div>
</c:if>

<c:if test="${!empty requestScope['messageErreur']}">
    <div class="alert alert-danger">${requestScope['messageErreur']}</div>
</c:if>  
<c:if test="${(sessionScope.isLoginOk == true)}"> 
    <center><img src='http://www.quickmeme.com/img/13/1376e62ac9a6e8c74514a47d0642f77904fa1b22c59d38fe79cd3e2b684e49ba.jpg'></center>
    </c:if>  
    <c:if test="${!(sessionScope.isLoginOk == true)}"> 
    <h3><center>Authentifiez vous si vous voulez avoir accès aux fonctionnalités du site (admin/admin)</center></h3>
</c:if>  