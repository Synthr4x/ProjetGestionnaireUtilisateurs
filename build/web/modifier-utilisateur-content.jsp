<form class="form-horizontal" action="ModifierUtilisateurs" method="get">
  <div class="form-group">
    <label for="nom" class="col-sm-2 control-label">Nom</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="nom" placeholder="Nom" name="nom">
    </div>
  </div>
  <div class="form-group">
    <label for="prenom" class="col-sm-2 control-label">Prénom</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="prenom" placeholder="Prénom" name="prenom">
    </div>
  </div>
  <div class="form-group">
    <label for="login" class="col-sm-2 control-label">Login</label>
    <div class="col-sm-2">
      <input type="text" class="form-control" id="login" placeholder="Login" name="login">
    </div>
  </div>
  <input type="hidden" name="action" value="updateUtilisateur"/>  
     
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Mettre à jour" name="submit"/> 
    </div>
  </div>
</form>