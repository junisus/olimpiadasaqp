document.getElementById('authentication-modal').addEventListener('submit', function(event) {
	event.preventDefault();

	var email = document.getElementById('email').value;
	var password = document.getElementById('password').value;

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'SvLogin', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('email=' + encodeURIComponent(email) + '&password=' + encodeURIComponent(password));

	xhr.onload = function() {
		if (xhr.status === 200) {
			var response = xhr.responseText;
			
			if (response === 'login-successful') {
				window.location.href = 'eventos';
				
			} else if (response === 'login-error') {
				document.querySelector('[data-modal-toggle="alert-error-login-modal"]').click();
			}
		}
	};
});

document.getElementById('register-modal').addEventListener('submit', function(event) {
	event.preventDefault();

	var email = document.getElementById('email-register').value;
	var password1 = document.getElementById('password-1').value;
	var password2 = document.getElementById('password-2').value;

	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'SvRegister', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('email=' + encodeURIComponent(email) + '&password-1=' + encodeURIComponent(password1) + '&password-2=' + encodeURIComponent(password2));

	xhr.onload = function() {
		if (xhr.status === 200) {
			var response = xhr.responseText;
			
			if (response === 'register-successful') {
				document.querySelector('[data-modal-toggle="alert-successful-register-modal"]').click();
				window.location.href = 'index.jsp';
				
			} else if (response === 'register-error-email') {
				document.querySelector('[data-modal-toggle="alert-email-error-register-modal"]').click();
			
			} else if (response === 'register-error-password') {
				document.querySelector('[data-modal-toggle="alert-password-error-register-modal"]').click();
			}
		}
	};
});	
