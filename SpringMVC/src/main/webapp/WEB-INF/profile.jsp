<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:profileTemplate>
	<div class="container">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					Profile
					<div class="nav navbar-right pull-right">
						<a href="settings.jsp" class="glyphicon glyphicon-cog">Account
							Settings</a>
					</div>
				</div>
				<div class="panel-body">


					<div class="profile-sidebar" style="padding: 5px">
						<img id="blah" src="resources/images/image.jpeg" alt="your image"
							class="img img-profile-pic"
							style="max-height: 100px; max-width: 100px" />

					</div>

				</div>
				<div class="profile-userbuttons" style="padding: 20px">
					<input type='file' onchange="readURL(this);" />
				</div>

				<div class="row">

					<ul>
						<c:forEach var="loginUser" items="${loginUser}">
							<h4 class="group inner list-group-item-heading">
								<c:out value="${loginUser.firstName}" />
								<c:out value="${loginUser.lastName}" />
							</h4>
						</c:forEach>

					</ul>

				</div>

				<div class="profile-userbuttons" style="padding: 0px 0px 20px 20px">
					<button type="button" class="btn btn-info btn-sm">Following</button>
					<button type="button" class="btn btn-info btn-sm">Followers</button>


					<button type="button" class="btn btn-info btn-sm"
						data-toggle="modal" data-target="#myModal">UploadImages</button>
					<button type="button" class="btn btn-info btn-sm"
						data-toggle="modal" data-target="#myImages" onclick="showImages()">ShowImages</button>

					<!-- =================== -->

					<div class="modal fade" id="myModal" role="dialog">
						<div class="modal-dialog">
							<form action="upload" method="POST" name="upload"
								enctype="multipart/form-data" class="foo">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Upload Images</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<div class="modal-body"
										style="overflow-y: scroll; max-height: 350px;">

										<input id="file-input" type="file" name="fileupload"
											class="btn btn-secondary" multiple />
										<div id="preview" class="image-fluid myImage"></div>
									</div>

									<div class="modal-footer">
										<input type="submit" class="btn btn-primary pull-left"
											value="Upload" />
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- ============================ -->

					<div class="modal fade" id="myImages" role="dialog">
						<div class="modal-dialog">
							<form class="foo">
								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title">Images</h4>

										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<div class="modal-body"
										style="overflow-y: scroll; max-height: 350px;">
										<div class="profile-sidebar" style="padding: 5px">

											<div id="image-grid" class="image-fluid myImage"></div>

											<div id="myImagegrid" class="modal">
												<span class="close" onclick="imageZoomOut()">&times;</span>
												<img class="modal-content" id="img01">

											</div>


										</div>


									</div>

									<div class="modal-footer">
										<!-- 	<input type="submit" class="btn btn-primary pull-left" value="Upload" /> -->
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</form>
						</div>
					</div>

					<!-- ========================== -->
				</div>
				<!-- end of profile user buttons -->


			</div>



		</div>
	</div>

	<script>
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result).width(150).height(
							200);
				};

				reader.readAsDataURL(input.files[0]);
			}
		}
	</script>

	<script>
		function previewImages() {

			var $preview = $('#preview').empty();
			if (this.files)
				$.each(this.files, readAndPreview);

			function readAndPreview(i, file) {

				if (!/\.(jpe?g|png|gif)$/i.test(file.name)) {
					return alert(file.name + " is not an image");
				} // else...

				var reader = new FileReader();

				$(reader).on("load", function() {
					$preview.append($("<img/>", {
						src : this.result,
						height : 100,
						width : 150

					}));
					$("img").addClass("img-thumbnail");
				});

				reader.readAsDataURL(file);
			}
		}

		$('#file-input').on("change", previewImages);
	</script>
	<script>
		function showImages() {

			var imag = "";
			var imagesData = "";
			$
					.post(
							"${pageContext.request.contextPath}/imagelist",
							function(data, status) {

								for (i = 0; i < data.length; i++) {

									imagesData += '<img id='
											+ i
											+ " "
											+ 'src="resources/images/uploadedImages/'
											+ data[i]
											+ '" alt="your image" class="img-thumbnail"  style = "height:100px; width:150px;" onclick="imageZoomIn()"/>';
								}
								$("#image-grid").html(imagesData);

							});
		}
	</script>
	<script>
		function imageZoomIn() {

			var modal = document.getElementById('myImagegrid');
			var modalImg = document.getElementById("img01");

			modal.style.display = "block";
			modalImg.src = this.src;
			alert("cgasdfga");
		}

		function imageZoomOut() {
			var modal = document.getElementById('myImagegrid');
			var span = document.getElementsByClassName("close");
			modal.style.display = "none";
			alert("cgasdfga");
		}
	</script>

</t:profileTemplate>