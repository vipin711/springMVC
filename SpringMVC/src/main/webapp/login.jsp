<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="----- your google client id here -----------">
<t:template>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-5 mx-auto">
				<div class="panel panel-default">
					<div class="panel-heading">Login</div>
					<div class="panel-body">
						<div id="first">
							<div class="myform form ">
								<form action="login" method="POST" name="login">
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" name="email" class="form-control" id="email"
											aria-describedby="emailHelp" placeholder="Enter email">
										<form:errors path="email" cssClass="error" />
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Password</label> <input
											type="password" name="password" id="password"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Enter Password">
										<form:errors path="password" cssClass="error" />
									</div>
									<div class="form-group">
										<p class="text-center">
											By signing up you accept our <a href="#">Terms Of Use</a>
										</p>
									</div>
									<div class="col-md-12 text-center ">
										<button type="submit"
											class=" btn btn-block mybtn btn-primary tx-tfm">Login</button>
									</div>
									<div class="form-group">
										<br />
										<p class="text-center">
											Don't have account? <a href="signup.jsp" id="signup">Sign
												up here</a>
										</p>
									</div>
								</form>
							</div>
						</div>
					</div>
					<div class="panel-footer">

						<div class="g-signin2" data-onsuccess="onSignIn" align="center">
							
						</div>


					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		//google callback. This function will redirect to our login servlet
		function onSignIn(googleUser) {
			var profile = googleUser.getBasicProfile();
			console.log('ID: ' + profile.getId());
			console.log('Name: ' + profile.getName());
			console.log('Image URL: ' + profile.getImageUrl());
			console.log('Email: ' + profile.getEmail());
			console.log('id_token: ' + googleUser.getAuthResponse().id_token);

			//do not post all above info to the server because that is not secure.
			//just send the id_token

			var redirectUrl = 'OAuth';

			//using jquery to post data dynamically
			var form = $('<form action="' + redirectUrl + '" method="post">'
					+ '<input type="text" name="id_token" value="'
					+ googleUser.getAuthResponse().id_token + '" />'
					+ '</form>');
			$('body').append(form);
			form.submit();
		}
	</script>

</t:template>
