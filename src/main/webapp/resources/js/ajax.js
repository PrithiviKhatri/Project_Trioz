function sendProfessorDetails() {

	dataToSend = JSON.stringify(serializeObject($('#profileForm')));
	console.log("inside function");
	$.ajax({

				url : "/TriozProject/professor/saveProfile",
				type : 'POST',
				dataType : "json", // Accepts
				data : dataToSend,
				contentType : 'application/json', // Sends
				success : function(employee) {
					console.log("inside success");
					$('#error').html("");
					$("#success")
							.append(
									'<H3 align="center"> Profile saved successfully!!!');
					
						

					make_visible('success');
					make_hidden('errors');
				}
			});
}

toggle_visibility = function(id) {
	var element = document.getElementById(id);
	if (element.style.display == 'block')
		element.style.display = 'none';
	else
		element.style.display = 'block';
}

make_hidden = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'none';
}

make_visible = function(id) {
	var element = document.getElementById(id);
	element.style.display = 'block';
}

resetForm = function(id) {
	var element = document.getElementById(id);
	$(element)[0].reset();

}


// Translate form to array
// Then put in JSON format
function serializeObject(form) {
	var jsonObject = {};
	var array = form.serializeArray();
	$.each(array, function() {
		jsonObject[this.name] = this.value;
	});
	return jsonObject;

};

