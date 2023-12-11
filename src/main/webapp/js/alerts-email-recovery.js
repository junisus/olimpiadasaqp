document.getElementById('email-recovery').addEventListener('submit', function(event) {
	event.preventDefault();

	var email = document.getElementById('email').value;

	var xhr = new XMLHttpRequest();
	xhr.open('POST', '../SvPassRecovery', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('email=' + encodeURIComponent(email));

	xhr.onload = function() {
		if (xhr.status === 200) {
			var response = xhr.responseText;
			
			if (response === 'successful') {
				document.querySelector('[data-modal-toggle="alert-successful-email"]').click();
				
			} else if (response === 'error-email') {
				document.querySelector('[data-modal-toggle="alert-error-email"]').click();
			}
		}
	};
});