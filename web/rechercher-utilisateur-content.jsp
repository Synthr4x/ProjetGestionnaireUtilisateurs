<form class="form-horizontal" action="RechercherUtilisateurs" method="get">
  <div class="form-group">
    <label for="login" class="col-sm-2 control-label">Login</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="login" placeholder="Login" name="login">
    </div>
  </div>
  <input type="hidden" name="action" value="chercherParLogin"/>  
     
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" class="btn btn-primary" value="Chercher" name="submit"/> 
    </div>
  </div>
</form>