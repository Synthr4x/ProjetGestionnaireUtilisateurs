<%--  
    Document   : index  
    Created on : 16 sept. 2009, 16:54:32  
    Author     : michel buffa  
--%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
    "http://www.w3.org/TR/html4/loose.dtd">  

<!-- Ne pas oublier cette ligne sinon tous les tags de la JSTL seront ignorés ! -->  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <title>Gestionnaire d'utilisateurs</title>  

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

        <link rel="stylesheet" href="/ressources/css/style.css">
    </head>  
    <body>  

        <div class="container-fluid">
            <div class="row">


                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <div class="jumbotron">
                        <!-- Message qui s'affiche lorsque la page est appelé avec un paramètre http message -->  
                        <h1>Gestionnaire d'utilisateurs</h1>

                        <c:if test="${!empty param['message']}">  
                            <h2>Reçu message : ${param.message}</h2>  
                        </c:if>  
                    </div>


                    <h2>Menu de gestion des utilisateurs</h2>  
                    <ul>  
                        <li><h3><a href="ServletUsers?action=listerLesUtilisateurs">Afficher/raffraichir la liste de tous les utilisateurs</a></h3></li>  

                        <li><h3><a href="ServletUsers?action=creerUtilisateursDeTest">Créer 4 utilisateurs de test</a></h3></li>  

                        <li><h3>Créer un utilisateur</h3></li>  

                        <form role="form" action="ServletUsers" method="get">
                            <div class="form-group">
                                <label for="nom">Nom :</label>
                                <input type="text" class="form-control" id="nom" name="nom" placeholder="entrer nom">
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="entrer prenom">
                            </div>
                            <div class="form-group">
                                <label for="login">Login :</label>
                                <input type="text" class="form-control" id="login" name="login" placeholder="entrer login">
                            </div>

                            <input type="hidden" name="action" value="creerUnUtilisateur"/>  
                            <input type="submit" value="Créer l'utilisateur" class="btn btn-default" name="submit"/> 
                        </form>


                        <li><h3>Afficher les détails d'un utilisateur</h3></li>  
                        <form role="form" action="ServletUsers" method="get"> 
                            <div class="form-group">
                                <label for="login">Login :</label>
                                <input type="text" class="form-control" id="login" name="login" placeholder="entrer login">
                            </div>
                            <input type="hidden" name="action" value="chercherParLogin"/>  
                            <input type="submit" class="btn btn-default" value="Chercher" name="submit"/>  
                        </form> 
                        <li><h3>Modifier les détails d'un utilisateur :</h3></li>  
                        <form role="form" action="ServletUsers" method="get"> 
                            <div class="form-group">
                                <label for="nom">Nom :</label>
                                <input type="text" class="form-control" id="nom" name="nom" placeholder="entrer nom">
                            </div>
                            <div class="form-group">
                                <label for="prenom">Prenom :</label>
                                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="entrer prenom">
                            </div>
                            <div class="form-group">
                                <label for="login">Login :</label>
                                <input type="text" class="form-control" id="login" name="login" placeholder="entrer login">
                            </div>  
                            <input type="hidden" name="action" value="updateUtilisateur"/>  
                            <input type="submit" class="btn btn-default" value="Mettre à jour" name="submit"/>  
                        </form>  
                    </ul>  

                    <!-- Fin du menu -->  

                    <br>
                    <!-- Zone qui affiche les utilisateurs si le paramètre action vaut listerComptes -->  
                    <c:if test="${param['action'] == 'listerLesUtilisateurs'}" >  
                        <h2>Liste des utilisateurs</h2>  
                        <br>
                        <table  class="table table-hover">  
                            <!-- La ligne de titre du tableau des comptes -->  
                            <tr>  
                                <td><b>Login</b></td>  
                                <td><b>Nom</b></td>  
                                <td><b>Prénom</b></td>  
                            </tr>  

                            <!-- Ici on affiche les lignes, une par utilisateur -->  
                            <!-- cette variable montre comment on peut utiliser JSTL et EL pour calculer -->  
                            <c:set var="total" value="0"/>  

                            <c:forEach var="u" items="${requestScope['listeDesUsers']}">  
                                <tr>  
                                    <td>${u.login}</td>  
                                    <td>${u.lastname}</td>  
                                    <td>${u.firstname}</td>  
                                    <!-- On compte le nombre de users -->  
                                    <c:set var="total" value="${total+1}"/>  
                                </tr>  
                            </c:forEach>  

                            <!-- Affichage du solde total dans la dernière ligne du tableau -->  
                            <tr><td><b>TOTAL</b></td><td></td><td><b>${total}</b></td><td></td></tr>  
                        </table>  

                    </c:if>  

                    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
                    <br>
                    <hr>

                </div>
            </div>

        </div>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

    </body>  
    <!-- Latest compiled and minified JavaScript -->
</html>