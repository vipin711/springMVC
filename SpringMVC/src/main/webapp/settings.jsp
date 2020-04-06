<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:profileTemplate>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div class="panel panel-default">
					<div class="panel-heading">Settings</div>
					<div class="panel-body">
						<div id="second">
							<div class="myform form ">
								<form action="signup" name="signup" method="POST">
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
										<label for="exampleInputEmail1">Age</label> <input
											type="text" name="Age" class="form-control"
											id="Age" aria-describedby="emailHelp"
											placeholder="Enter age">
									</div>
									
									<div class="form-group">
										<label for="exampleInputEmail1">Old Password:</label> <input
											type="password" name="password" id="password"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Enter Password">
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">New Password:</label> <input
											type="password" name="password" id="password"
											class="form-control" aria-describedby="emailHelp"
											placeholder="Enter Password">
									</div>
									<div class="col-md-12 text-center mb-3">
										<button type="submit"
											class=" btn btn-block mybtn btn-primary tx-tfm">Submit</button>
									</div>
									
									</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</t:profileTemplate>