x	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Olimpiadas AQP</title>
<script src="https://cdn.tailwindcss.com"></script>
<body>
	<nav
		class="bg-white dark:bg-gray-900 fixed w-full z-20 top-0 start-0 border-b border-gray-200 dark:border-gray-600">
		<div
			class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
			<a href="https://flowbite.com/"
				class="flex items-center space-x-3 rtl:space-x-reverse"> <img
				src="https://flowbite.com/docs/images/logo.svg" class="h-8"
				alt="Flowbite Logo"> <span
				class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Olimpiadas
					AQP</span>
			</a>

			<div
				class="flex md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
				<button data-modal-target="authentication-modal"
					data-modal-toggle="authentication-modal" type="button"
					class="text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-blue-300 -medium rounded-lg text-sm px-4 py-2 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
					Iniciar Sesión</button>
				<div class="flex items-center space-x-6 rtl:space-x-reverse">
					<a href="#" data-modal-target="register-modal"
						data-modal-toggle="register-modal"
						class="text-sm ml-6 text-blue-600 dark:text-blue-500 hover:underline">Registrate</a>
				</div>
				<button data-collapse-toggle="navbar-sticky" type="button"
					class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
					aria-controls="navbar-sticky" aria-expanded="false">
					<span class="sr-only">Open main menu</span>
					<svg class="w-5 h-5" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
            <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="M1 1h15M1 7h15M1 13h15" />
        </svg>
				</button>
			</div>

			<div
				class="items-center justify-between hidden w-full md:flex md:w-auto md:order-1 z-50"
				id="navbar-sticky">
				<ul
					class="flex flex-col p-4 md:p-0 mt-4 font-medium border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
					<li><a href="#"
						class="block py-2 px-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 md:dark:text-blue-500"
						aria-current="page">Inicio</a></li>
					<li><a href="#"
						class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Nosotros</a>
					</li>
					<li><a href="#"
						class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Servicios</a>
					</li>
					<li><a href="#"
						class="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 md:dark:hover:text-blue-500 dark:text-white dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700">Contacto</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main modal -->
	<div id="authentication-modal" tabindex="-1" aria-hidden="true"
		class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<!-- Modal content -->
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<!-- Modal header -->
				<div
					class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
					<h3 class="text-xl font-semibold text-gray-900 dark:text-white">
						Ingresa a nuestra plataforma</h3>
					<button type="button"
						class="end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
						data-modal-hide="authentication-modal">
						<svg class="w-3 h-3" aria-hidden="true"
							xmlns="http://www.w3.org/2000/svg" fill="none"
							viewBox="0 0 14 14">
                        <path stroke="currentColor"
								stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
								d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                    </svg>
						<span class="sr-only">Close modal</span>
					</button>
				</div>
				<!-- Modal body -->
				<div class="p-4 md:p-5">
					<form class="space-y-4" action="SvLogin" method="POST">
						<div>
							<label for="email"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Correo
								electrónico</label> <input type="email" name="email" id="email"
								class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
								placeholder="nombre@ejemplo.com" required>
						</div>
						<div>
							<label for="password"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Contraseña</label>
							<input type="password" name="password" id="password"
								placeholder="••••••••"
								class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
								required>
						</div>
						<div class="flex justify-between">
							<div class="flex items-start">
								<div class="flex items-center h-5">
									<input id="remember" type="checkbox" value=""
										class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-600 dark:border-gray-500 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800">
								</div>
								<label for="remember"
									class="ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">Recuerdame</label>
							</div>
							<a href="#"
								class="text-sm text-blue-700 hover:underline dark:text-blue-500">¿Ovidaste
								tu contraseña?</a>
						</div>
						<button type="submit"
							class="w-full text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800">Iniciar
							Sesión</button>
						<div class="text-sm font-medium text-gray-500 dark:text-gray-300">
							¿No estas registrado? <a href="#"
								data-modal-target="register-modal"
								data-modal-toggle="register-modal"
								data-modal-hide="authentication-modal"
								class="text-blue-700 hover:underline dark:text-blue-500">Crea
								una cuenta</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- Main modal -->
	<div id="register-modal" tabindex="-1" aria-hidden="true"
		class="hidden overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<!-- Modal content -->
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<!-- Modal header -->
				<div
					class="flex items-center justify-between p-4 md:p-5 border-b rounded-t dark:border-gray-600">
					<h3 class="text-xl font-semibold text-gray-900 dark:text-white">
						Registrate en nuestra plataforma</h3>
					<button type="button"
						class="end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
						data-modal-hide="register-modal">
						<svg class="w-3 h-3" aria-hidden="true"
							xmlns="http://www.w3.org/2000/svg" fill="none"
							viewBox="0 0 14 14">
                        <path stroke="currentColor"
								stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
								d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                    </svg>
						<span class="sr-only">Close modal</span>
					</button>
				</div>
				<!-- Modal body -->
				<div class="p-4 md:p-5">
					<form class="space-y-4" action="SvRegister" method="POST">
						<div>
							<label for="email"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Correo
								electrónico</label> <input type="email" name="email" id="email-register"
								class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
								placeholder="nombre@ejemplo.com" required>
						</div>
						<div>
							<label for="password-1"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Contraseña</label>
							<input type="password" name="password-1" id="password-1"
								placeholder="••••••••"
								class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
								required>
						</div>
						<div>
							<label for="password-2"
								class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Vuelve
								a ingresar la contraseña</label> <input type="password"
								name="password-2" id="password-2" placeholder="••••••••"
								class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white"
								required>
						</div>
						<button type="submit"
							class="w-full text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:outline-none focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-800">Registrarse</button>
						<div class="text-sm font-medium text-gray-500 dark:text-gray-300">
							¿Ya estas registrado? <a href="#"
								data-modal-target="authentication-modal"
								data-modal-toggle="authentication-modal"
								data-modal-hide="register-modal"
								class="text-blue-700 hover:underline dark:text-blue-500">Inicia
								Sesión</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="relative z-10	">
		<img alt="" src="img/volleyball-wp.jpg">

		<div
			class="absolute top-0 left-0 w-full h-full bg-black bg-opacity-60"></div>

		<div
			class="ml-10 absolute top-0 left-0 w-full h-full flex items-center justify-start z-50">
			<div class="p-4 rounded-lg shadow text-left">
				<p class="mb-4 text-white text-4xl font-bold">GESTIONA TUS
					EVENTOS DEPORTIVOS.</p>
				<p class="mb-4 text-white text-2xl font-bold">Hazlo junto a
					Olimpiadas AQP.</p>
				<button data-modal-target="register-modal"
					data-modal-toggle="register-modal" type="button"
					class="font-bold text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 focus:outline-none dark:focus:ring-red-800">Empezar</button>
			</div>
		</div>
	</div>

	<button data-modal-target="alert-error-login-modal"
		data-modal-toggle="alert-error-login-modal"
		class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		type="button">Toggle modal</button>

	<div id="alert-error-login-modal" tabindex="-1"
		class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<button type="button"
					class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
					data-modal-hide="alert-error-login-modal">
					<svg class="w-3 h-3" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
					<span class="sr-only">Close modal</span>
				</button>
				<div class="p-4 md:p-5 text-center">
					<img
						class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
						aria-hidden="true" src="img/icons/error-icon.png">
					<path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
					</img>
					<h3
						class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">Correo
						electrónico o contraseña incorrectos</h3>
					<button data-modal-hide="alert-error-login-modal" type="button"
						class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Aceptar</button>
				</div>
			</div>
		</div>
	</div>

	<button data-modal-target="alert-email-error-register-modal"
		data-modal-toggle="alert-email-error-register-modal"
		class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		type="button">Toggle modal</button>

	<div id="alert-email-error-register-modal" tabindex="-1"
		class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<button type="button"
					class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
					data-modal-hide="alert-email-error-register-modal">
					<svg class="w-3 h-3" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
					<span class="sr-only">Close modal</span>
				</button>
				<div class="p-4 md:p-5 text-center">
					<img
						class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
						aria-hidden="true" src="img/icons/error-icon.png">
					<path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
					</img>
					<h3
						class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">El
						correo electrónico ingresado ya esta asociado a una cuenta</h3>
					<button data-modal-hide="alert-email-error-register-modal"
						type="button"
						class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Aceptar</button>
				</div>
			</div>
		</div>
	</div>


	<button data-modal-target="alert-password-error-register-modal"
		data-modal-toggle="alert-password-error-register-modal"
		class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		type="button">Toggle modal</button>

	<div id="alert-password-error-register-modal" tabindex="-1"
		class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<button type="button"
					class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
					data-modal-hide="alert-password-error-register-modal">
					<svg class="w-3 h-3" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
					<span class="sr-only">Close modal</span>
				</button>
				<div class="p-4 md:p-5 text-center">
					<img
						class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
						aria-hidden="true" src="img/icons/error-icon.png">
					<path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
					</img>
					<h3
						class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">Las
						contraseñas ingresadas no coinciden</h3>
					<button data-modal-hide="alert-password-error-register-modal"
						type="button"
						class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Aceptar</button>
				</div>
			</div>
		</div>
	</div>

	<button data-modal-target="alert-successful-register-modal"
		data-modal-toggle="alert-successful-register-modal"
		class="hidden block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
		type="button">Toggle modal</button>

	<div id="alert-successful-register-modal" tabindex="-1"
		class="hidden bg-black bg-opacity-40 overflow-y-auto overflow-x-hidden fixed top-0 right-0 left-0 z-50 justify-center items-center w-full md:inset-0 h-[calc(100%-1rem)] max-h-full">
		<div class="relative p-4 w-full max-w-md max-h-full">
			<div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
				<button type="button"
					class="absolute top-3 end-2.5 text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm w-8 h-8 ms-auto inline-flex justify-center items-center dark:hover:bg-gray-600 dark:hover:text-white"
					data-modal-hide="alert-successful-register-modal">
					<svg class="w-3 h-3" aria-hidden="true"
						xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 14">
                    <path stroke="currentColor" stroke-linecap="round"
							stroke-linejoin="round" stroke-width="2"
							d="m1 1 6 6m0 0 6 6M7 7l6-6M7 7l-6 6" />
                </svg>
					<span class="sr-only">Close modal</span>
				</button>
				<div class="p-4 md:p-5 text-center">
					<img
						class="mx-auto mb-4 text-gray-400 w-12 h-12 dark:text-gray-200"
						aria-hidden="true" src="img/icons/successful-icon.png">
					<path stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2"
						d="M10 11V6m0 8h.01M19 10a9 9 0 1 1-18 0 9 9 0 0 1 18 0Z" />
					</img>
					<h3
						class="mb-5 text-lg font-normal text-gray-500 dark:text-gray-400">Usuario
						registrado correctamente</h3>
					<button data-modal-hide="alert-successful-register-modal"
						type="button"
						class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-sm font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600">Aceptar</button>
				</div>
			</div>
		</div>
	</div>


	<footer class="bg-white rounded-lg shadow m-4 dark:bg-gray-800">
		<div
			class="w-full mx-auto max-w-screen-xl p-4 md:flex md:items-center md:justify-between">
			<span class="text-sm text-gray-500 sm:text-center dark:text-gray-400">©
				2023 <a href="https://flowbite.com/" class="hover:underline">OlimpiadasAQP</a>.
				Todos los derechos reservados.
			</span>
			<ul
				class="flex flex-wrap items-center mt-3 text-sm font-medium text-gray-500 dark:text-gray-400 sm:mt-0">
				<li><a href="#" class="hover:underline me-4 md:me-6">Nosotros</a>
				</li>
				<li><a href="#" class="hover:underline me-4 md:me-6">Politicas
						de privacidad</a></li>
				<li><a href="#" class="hover:underline">Contacto</a></li>
			</ul>
		</div>
	</footer>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.1.1/flowbite.min.js">
	</script>
	<script type="text/javascript" src="js/alerts-login-register.js"></script>
</body>
</html>