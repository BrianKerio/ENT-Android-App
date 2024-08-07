
<?php

include('server.php');
include('include/connections.php');


?>

<html>

<script src="js/jquery.min.js"></script>
<script>
    if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    }
</script>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta charset="utf-8" />
<title>Hope Ent</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta content="" name="description" />
<meta content="" name="author" />

<link href="assets/plugins/bootstrapv3/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrapv3/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
<link href="assets/plugins/animate.min.css" rel="stylesheet" type="text/css" />


<link href="webarch/css/webarch.css" rel="stylesheet" type="text/css" />

</head>


<body class="error-body no-top">
<div class="container">
    
<div class="row login-container column-seperation">
    <h1 class="center-text"><?php echo $siteName?></h1>
<div class="col-md-4 col-md-offset-4">


<br>

    <div class="col-md-12 card-body bg-primary">
    <form  class="login-form validate" id="login-form" method="post" name="login-form" autocomplete="off">
      <div class="row">
       <div class="form-group col-md-10">

   <label class="form-label text-center" style="color: white">Username</label>
   <input class="form-control" id="txtusername" name="username"  type="text" required>
    </div>
    </div> 
    <div class="row">
    <div class="form-group col-md-10">
<label class="form-label text-center"style="color: white">Password</label> <span class="help"></span>
<input class="form-control"  id="txtpassword" name="password"  type="password" required>
</div>
</div>
<div class="row">
<div class="control-group col-md-10">

</div>
</div>
<div class="row">
<div class="col-md-10">
<button class="btn btn-primary btn-cons pull-right" type="submit" name="login_user">Login</button>
</div>
</div>
</form>
</div>
</div>
</div>
</div>

<script src="assets/plugins/pace/pace.min.js" type="text/javascript"></script>

<script src="assets/plugins/jquery/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrapv3/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-block-ui/jqueryblockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-validation/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-select2/select2.min.js" type="text/javascript"></script>


<script src="webarch/js/webarch.js" type="text/javascript"></script>
<script src="assets/js/chat.js" type="text/javascript"></script>

</body>

</html>