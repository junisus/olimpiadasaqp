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


<div id="email-recovery" class="flex items-center justify-center h-screen">
	<div class="max-w-sm p-6 bg-white border border-gray-200 rounded-lg shadow dark:bg-gray-800 dark:border-gray-700">
	    <h5 class="mb-2 text-2xl font-bold tracking-tight text-gray-900 dark:text-white">
	    	Recuperación de contraseña
	    </h5>
	    <label for="email" class="mt-5 block mb-2 text-sm font-medium text-gray-900 dark:text-white">
	    	Ingresa tu correo electronico
	    </label>
		<div data-element="fields" data-stacked="false" class="flex items-center w-full max-w-md mb-3 seva-fields formkit-fields">
        	<form action="SvPassRecovery" method="POST">
        	<div class="relative w-full mr-3 formkit-field">
            	<div class="absolute inset-y-0 left-0 flex items-center pl-3.5 pointer-events-none">
                	<svg class="w-4 h-4 text-gray-500 dark:text-gray-400" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 16">
                    	<path d="m10.036 8.278 9.258-7.79A1.979 1.979 0 0 0 18 0H2A1.987 1.987 0 0 0 .641.541l9.395 7.737Z"></path>
						<path d="M11.241 9.817c-.36.275-.801.425-1.255.427-.428 0-.845-.138-1.187-.395L0 2.6V14a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V2.5l-8.759 7.317Z"></path>
                	</svg>
                </div>
                
                <input id="email" class="formkit-input bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-10 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" 
                	name="email" placeholder="nombre@ejemplo.com" required="" type="email">
            	
            </div>
			<button type="submit" data-element="submit" class="formkit mt-5">
				<div class="formkit-spinner">
		            <div></div>
		            <div></div>
		            <div></div>
	           	</div>
	            <span class="px-5 py-3 text-sm font-medium text-center text-white bg-blue-700 rounded-lg cursor-pointer hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
	            	Enviar
	            </span>
            </button>
            </form>
    	</div>
	</div>
</div>


<button data-modal-target="alert-error-email" data-modal-toggle="alert-error-email"
	class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
	Toggle modal
</button>

<div id="alert-error-email" tabindex="-1" class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
	<div class="relative p-4 w-full max-w-md max-h-full">
		<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
			<button type="button" class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
				data-modal-hide="alert-error-email">
				<svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                   <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
               </svg>
				<span class="sr-only">Close modal</span>
			</button>
			<div class="p-4 md:p-5 text-center">
				<img class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
					aria-hidden="true" src="../img/icons/error-icon.png">
					<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
				</img>
				<h3 class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
					El correo electronico ingresado no tiene una cuenta asociada
				</h3>
				<button data-modal-hide="alert-error-email" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">
					Aceptar
				</button>
			</div>
		</div>
	</div>
</div>

<button data-modal-target="alert-successful-email" data-modal-toggle="alert-successful-email"
	class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
	Toggle modal
</button>

<div id="alert-successful-email" tabindex="-1" class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
	<div class="relative p-4 w-full max-w-md max-h-full">
		<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
			<button type="button" class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
				data-modal-hide="alert-successful-email">
				<svg class="w-3 h-3" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                   <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
               </svg>
				<span class="sr-only">Close modal</span>
			</button>
			<div class="p-4 md:p-5 text-center">
				<img class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
					aria-hidden="true" src="../img/icons/successful-icon.png">
					<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
				</img>
				<h3 class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">
					Correo enviado con exito, revisa tu bandeja de entrada
				</h3>
				<button data-modal-hide="alert-successful-email" type="button" class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">
					Aceptar
				</button>
			</div>
		</div>
	</div>
</div>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.0/flowbite.min.js">
</script>
<script type="text/javascript" src="../js/alerts-email-recovery.js"></script>
</body>
</html>