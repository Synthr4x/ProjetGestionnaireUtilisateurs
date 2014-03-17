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



            <c:choose>
                <c:when test="${sessionScope.isLoginOk == false}">
                    <form class="navbar-form navbar-right" action="${pageContext.servletContext.contextPath}/Accueil" method="post">
                        <input class="form-control" type="text" placeholder="Login" name="login">
                        <input class="form-control" type="password" name="password">
                        <input type="submit" class="btn btn-primary" value="Connexion" name="submit"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </form>
                </c:when>
                <c:otherwise>
                    <form class="navbar-form navbar-right" action="${pageContext.servletContext.contextPath}/Accueil?action=deco" method="post">
                         <input type="submit" class="btn btn-default" value="Se déconnecter" name="mdp"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </form>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>