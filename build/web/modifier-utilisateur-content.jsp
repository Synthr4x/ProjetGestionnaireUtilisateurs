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