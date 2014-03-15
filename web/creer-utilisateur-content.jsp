<h3><a href="ServletUsers?action=creerUtilisateursDeTest">Créer 4 utilisateurs de test</a></h3></li>  

<h3>Créer un utilisateur</h3>  
<form action="ServletUsers" method="get">  
    Nom : <input type="text" name="nom"/><br>  
    Prénom : <input type="text" name="prenom"/><br>  
    Login : <input type="text" name="login"/><br>  
    <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
    <input type="hidden" name="action" value="creerUnUtilisateur"/>  
    <input type="submit" value="Créer l'utilisateur" name="submit"/>  
</form>  