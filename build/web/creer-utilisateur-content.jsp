
<form class="form-horizontal" action="CreerUtilisateurs" method="get">
  <div class="form-group">
    <label for="nom" class="col-sm-2 control-label">Nom</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="nom" placeholder="Nom" name="nom">
    </div>
  </div>
  <div class="form-group">
    <label for="prenom" class="col-sm-2 control-label">Pr�nom</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="prenom" placeholder="Pr�nom" name="prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="login" class="col-sm-2 control-label">Login</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="login" placeholder="Login" name="login">
    </div>
  </div>
    <div class="form-group">
    <label for="mdp" class="col-sm-2 control-label">Mot de passe</label>
    <div class="col-sm-2">
      <input type="password" class="form-control" id="mdp" placeholder="Mot de passe" name="mdp">
    </div>
  </div>
    <div class="form-group">
    <label for="ville" class="col-sm-2 control-label">Ville</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="ville" placeholder="Ville" name="ville">
    </div>
  </div>
    <div class="form-group">
    <label for="cp" class="col-sm-2 control-label">Code postal</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="cp" placeholder="Code postal" name="cp">
    </div>
  </div>
    
  <input type="hidden" name="action" value="creerUnUtilisateur"/>  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Cr�er l'utilisateur" name="submit"/> 
    </div>
  </div>
</form>
</br>
<center><button type="button" class="btn btn-primary" onclick="self.location.href='CreerUtilisateurs?action=creerUtilisateursDeTest'" >Cr�er pleins d'utilisateurs de test</button></center>

