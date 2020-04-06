<%@taglib prefix="t" tagdir="/WEB-INF/tags/"%>

<t:profileTemplate>
	 


			<form action="abc" method="POST" name = "abc" class="foo">
				<input id="file-input"  type="file" class="btn btn-secondary"  multiple/>
					<div id="preview" class = "image-fluid myImage"></div>
					</br>
				<input type="submit" class="btn btn-primary" value = "Upload"/>
			</form>


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
		 
		/* function readURL(input) {

			
				if (input.files && input.files[0]) {
					var reader = new FileReader();

					reader.onload = function(e) {
						$('#blah').attr('src', e.target.result).width(150)
								.height(200);
					};

					reader.readAsDataURL(input.files[0]);
				}
			} */
	</script>
</t:profileTemplate>