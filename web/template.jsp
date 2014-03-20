
<%@ page language="java" contentType="text/html; charset=UTF-8"  
         pageEncoding="UTF-8"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE HTML>  
<html>  
    <head>  
        <title>${param.title}</title>  
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

        <link rel="stylesheet" type="text/css" href="https://googledrive.com/host/0B_t_48Rr2t_4bkliaUNpanBYQnM">

        <!-- Les glyphs des images de bootstrap -->
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    </head>  
    <body>  
        <jsp:include page="header.jsp"/>  
        <div class="container-fluid">
            <div class="row">
                <!-- Si la personne n'est pas connectée, elle n'a pas accès au menu de navigation -->
                <c:choose>
                    <c:when test="${sessionScope.isLoginOk == true}"><jsp:include page="menu.jsp"/> 
                        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                        </c:when>
                        <c:otherwise>
                            <div class="monPaddingDegueulasse">
                            </c:otherwise>
                        </c:choose>



                        <div class="jumbotron">
                            <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
                            <h1>${param.glyph} ${param.title}</h1> 


                        </div>

                        <!-- Si la personne n'est pas connectée, on la redirige obligatoirement vers l'accueil -->
                        <c:choose>
                            <c:when test="${sessionScope.isLoginOk == true}"><jsp:include page="${param.content}.jsp"/></c:when>
                            <c:otherwise><jsp:include page="accueil-content.jsp"/></c:otherwise>
                        </c:choose>

                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"/>  

            <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
            <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    </body>  
</html>  