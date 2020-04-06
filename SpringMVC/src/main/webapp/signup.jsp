<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
</head>
<body>
	<t:template>
		<div class="container-fluid">


			<div class="row">
				<div class="col-md-5 mx-auto">
					<div class="panel panel-default">
						<div class="panel-heading">SignUp</div>
						<div class="panel-body">
							<div id="second">
								<div class="myform form ">
									<form action="signup" name="signup" method = "POST">
										<div class="form-group">
											<label for="exampleInputEmail1">First Name</label> <input
												type="text" name="firstName" class="form-control"
												id="firstname" aria-describedby="emailHelp"
												placeholder="Enter Firstname">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Last Name</label> <input
												type="text" name="lastName" class="form-control"
												id="lastname" aria-describedby="emailHelp"
												placeholder="Enter Lastname">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Email address</label> <input
												type="email" name="email" class="form-control" id="email"
												aria-describedby="emailHelp" placeholder="Enter email">
										</div>
										<div class="form-group">
											<label for="exampleInputEmail1">Password</label> <input
												type="password" name="password" id="password"
												class="form-control" aria-describedby="emailHelp"
												placeholder="Enter Password">
										</div>
										<div class="col-md-12 text-center mb-3">
											<button type="submit"
												class=" btn btn-block mybtn btn-primary tx-tfm">SignUp</button>
										</div>
										<div class="col-md-12 ">
											<div class="form-group">
												<p class="text-center">
													<a href="login.jsp" id="signin">Already have an
														account?</a>
												</p>
											</div>
										</div>
								</div>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</t:template>
</body>