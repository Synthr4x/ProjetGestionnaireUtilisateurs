<button type="button" class="btn btn-primary" onclick="self.location.href='CreerUtilisateurs?action=creerUtilisateursDeTest'" >Créer 4 utilisateurs de test</button>
</br></br></br>
<h3>Créer un utilisateur</h3>  
<form action="CreerUtilisateurs" method="get">  
    <label for="nom" >Nom : </label><input type="text" name="nom"/><br>
    <label for="prenom" >Prénom : </label><input type="text" name="prenom"/><br>  
    <label for="login" >Login : </label><input type="text" name="login"/><br>  
    <!-- Astuce pour passer des paramètres à une servlet depuis un formulaire JSP !-->  
    <input type="hidden" name="action" value="creerUnUtilisateur"/>  
    <input type="submit" class="btn btn-primary" value="Créer l'utilisateur" name="submit"/>  
</form>  
