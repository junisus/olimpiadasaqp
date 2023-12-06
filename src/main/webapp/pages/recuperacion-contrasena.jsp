<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recuperación de contraseña</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>


<div class="flex items-center justify-center h-screen">
	<div class="max-w-sm p-6 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
	    <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
	    	Recuperación de contraseña
	    </h5>
	    <label for="input-group-1" class="mt-5 block mb-2 text-sm font-medium text-gray-900 dark:text-white">
	    	Ingresa tu correo electronico
	    </label>
		<div data-element="fields" data-stacked="false" class="flex items-center w-full max-w-md mb-3 seva-fields formkit-fields">
        	<div class="relative w-full mr-3 formkit-field">
            	<div class="absolute inset-y-0 left-0 flex items-center pl-3.5 pointer-events-none">
                	<svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 16">
                    	<path d="m10.036 8.278 9.258-7.79A1.979 1.979 0 0 0 18 0H2A1.987 1.987 0 0 0 .641.541l9.395 7.737Z"></path>
						<path d="M11.241 9.817c-.36.275-.801.425-1.255.427-.428 0-.845-.138-1.187-.395L0 2.6V14a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V2.5l-8.759 7.317Z"></path>
                	</svg>
                </div>
                <form action="" method="POST">
                <input id="email" class="formkit-input bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" 
                	name="email" placeholder="nombre@ejemplo.com" required="" type="email">
            	</form>
            </div>
			<button type="submit" data-element="submit" class="formkit">
				<div class="formkit-spinner">
		            <div></div>
		            <div></div>
		            <div></div>
	           	</div>
	            <span class="px-5 py-3 text-sm font-medium text-center text-white bg-blue-700 rounded-lg cursor-pointer hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
	            	Enviar
	            </span>
            </button>
    	</div>
	</div>
</div>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.0/flowbite.min.js">
</script>
</body>
</html>