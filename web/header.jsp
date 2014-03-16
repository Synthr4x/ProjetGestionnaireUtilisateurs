<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><i class="glyphicon glyphicon-music"></i> TP2 - Pavinich & Siddi</a>
        </div>
        
        <ul class="nav navbar-nav navbar-right">
            <!--<li>
                <a href="#">Dashboard</a>
            </li>
            <li>
                <a href="#">Settings</a>
            </li>
            <li>
                <a href="#">Profile</a>
            </li>
            <li>
                <a href="#">Help</a>
            </li>-->
            
            <!-- -->
            <c:if test="${!(sessionScope.isLoginOk == true)}"> 
                    <form class="navbar-form navbar-right" action="${pageContext.servletContext.contextPath}/Accueil" method="get">
                        <input class="form-control" type="text" placeholder="Login" name="login">
                        <input class="form-control" type="password" placeholder="Mot de passe" name="password">
                        <input type="submit" class="btn btn-primary" value="Connexion" name="submit"/>
                    </form> 
            </c:if>  
            
            <c:choose>
                <c:when test="${sessionScope.isLoginOk == true}">
                    
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>