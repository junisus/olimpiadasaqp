<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva contraseña | Olimpiadas AQP</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	
<div class="flex items-center justify-center h-screen">
	<form class="max-w-sm mx-auto" action="" method="POSY">
	<h5 class="mb-6 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
	    Creación de nueva contraseña
	</h5>
	  <div class="mb-5">
	    <label for="password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
	    	Ingrese una contraseña
	    </label>
	    <input type="password" id="password" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" required>
	  </div>
	  <div class="mb-5">
	    <label for="repeat-password" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">
	    	Ingrese nuevamente la contraseña
	    </label>
	    <input type="password" id="repeat-password" class="shadow-sm bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 dark:shadow-sm-light" required>
	  </div>
	  <button type="submit" class="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800">
		Guardar nueva contraseña
	  </button>
	</form>
</div>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.0/flowbite.min.js">
</script>
</body>
</html>