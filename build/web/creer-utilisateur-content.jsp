
<form class="form-horizontal" action="CreerUtilisateurs" method="get">
  <div class="form-group">
    <label for="nom" class="col-sm-2 control-label">Nom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="nom" placeholder="Nom" name="nom">
    </div>
  </div>
  <div class="form-group">
    <label for="prenom" class="col-sm-2 control-label">Pr�nom</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="prenom" placeholder="Pr�nom" name="prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="login" class="col-sm-2 control-label">Login</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="login" placeholder="Login" name="login">
    </div>
  </div>
  <input type="hidden" name="action" value="creerUnUtilisateur"/>  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Cr�er l'utilisateur" name="submit"/> 
    </div>
  </div>
</form>
</br></br></br></br></br></br>
<center><button type="button" class="btn btn-primary" onclick="self.location.href='CreerUtilisateurs?action=creerUtilisateursDeTest'" >Cr�er pleins d'utilisateurs de test</button></center>

