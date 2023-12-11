<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="encuentros.dominio.Encuentro"%>
<%@ page import="equipo.dominio.Equipo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ranking de equipos | Olimpiadas AQP </title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<nav class="fixed top-0 z-50 w-full bg-white border-b border-gray-200 dark:bg-gray-800 dark:border-gray-700">
	<div class="px-3 py-3 lg:px-5 lg:pl-3">
		<div class="flex items-center justify-between">
			<div class="flex items-center justify-start rtl:justify-end">
				<button data-drawer-target="logo-sidebar"
					data-drawer-toggle="logo-sidebar" aria-controls="logo-sidebar"
						type="button" class="inline-flex items-center p-2 text-sm text-gray-500 rounded-lg sm:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600">
					<span class="sr-only">Open sidebar</span>
					<svg class="w-6 h-6" aria-hidden="true" fill="currentColor"
						viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
               			<path clip-rule="evenodd" fill-rule="evenodd" d="M2 4.75A.75.75 0 012.75 4h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 4.75zm0 10.5a.75.75 0 01.75-.75h7.5a.75.75 0 010 1.5h-7.5a.75.75 0 01-.75-.75zM2 10a.75.75 0 01.75-.75h14.5a.75.75 0 010 1.5H2.75A.75.75 0 012 10z"></path>
            		</svg>
				</button>
				<a href="https://flowbite.com" class="flex ms-2 md:me-24">
					<img src="https://flowbite.com/docs/images/logo.svg" class="h-8 me-3" alt="FlowBite Logo" />
					<span class="self-center text-xl font-semibold sm:text-2xl whitespace-nowrap dark:text-white">
						Olimpiadas AQP
					</span>
				</a>
			</div>
			<div class="flex items-center">
				<div class="flex items-center ms-3"><div>
					<button type="button" class="flex text-sm rounded-full focus:ring-4 focus:ring-red-300 focus:bg-red-300 dark:focus:ring-red-600"
						aria-expanded="false" data-dropdown-toggle="dropdown-user">
						<span class="sr-only">Open user menu</span>
						<svg class="flex-shrink-0 w-7 h-7 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
							aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
    						<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2"
								d="M10 19a9 9 0 1 0 0-18 9 9 0 0 0 0 18Zm0 0a8.949 8.949 0 0 0 4.951-1.488A3.987 3.987 0 0 0 11 14H9a3.987 3.987 0 0 0-3.951 3.512A8.948 8.948 0 0 0 10 19Zm3-11a3 3 0 1 1-6 0 3 3 0 0 1 6 0Z" />
  						</svg>
					</button></div>
			<div class="z-50 hidden my-4 text-base list-none bg-white divide-y divide-gray-100 rounded shadow dark:bg-gray-700 dark:divide-gray-600"
				id="dropdown-user">
					<div class="px-4 py-3" role="none">
						<p class="text-sm font-medium text-gray-900 truncate dark:text-gray-300"
							role="none">nombre@ejemplo.com
						</p>
					</div>
						<ul class="py-1" role="none">
							<li><a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
								role="menuitem">Ajustes</a>
							</li>
							
							<li><a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:text-gray-300 dark:hover:bg-gray-600 dark:hover:text-white"
									role="menuitem">Cerrar Sesión</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</nav>

<aside id="logo-sidebar" class="fixed top-0 left-0 z-40 w-64 h-screen pt-20 transition-transform -translate-x-full bg-white border-r border-gray-200 sm:translate-x-0 dark:bg-gray-800 dark:border-gray-700"
	aria-label="Sidebar">
	<div class="h-full px-3 pb-4 overflow-y-auto bg-white dark:bg-gray-800">
		<ul class="space-y-2 font-medium">
			<li><a href="../eventos" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 group-hover:text-gray-900 transition duration-75 dark:text-red-400 group-text-red-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
    				<path fill="currentColor"
								d="M6 1a1 1 0 0 0-2 0h2ZM4 4a1 1 0 0 0 2 0H4Zm7-3a1 1 0 1 0-2 0h2ZM9 4a1 1 0 1 0 2 0H9Zm7-3a1 1 0 1 0-2 0h2Zm-2 3a1 1 0 1 0 2 0h-2ZM1 6a1 1 0 0 0 0 2V6Zm18 2a1 1 0 1 0 0-2v2ZM5 11v-1H4v1h1Zm0 .01H4v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM10 11v-1H9v1h1Zm0 .01H9v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM10 15v-1H9v1h1Zm0 .01H9v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM15 15v-1h-1v1h1Zm0 .01h-1v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM15 11v-1h-1v1h1Zm0 .01h-1v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM5 15v-1H4v1h1Zm0 .01H4v1h1v-1Zm.01 0v1h1v-1h-1Zm0-.01h1v-1h-1v1ZM2 4h16V2H2v2Zm16 0h2a2 2 0 0 0-2-2v2Zm0 0v14h2V4h-2Zm0 14v2a2 2 0 0 0 2-2h-2Zm0 0H2v2h16v-2ZM2 18H0a2 2 0 0 0 2 2v-2Zm0 0V4H0v14h2ZM2 4V2a2 2 0 0 0-2 2h2Zm2-3v3h2V1H4Zm5 0v3h2V1H9Zm5 0v3h2V1h-2ZM1 8h18V6H1v2Zm3 3v.01h2V11H4Zm1 1.01h.01v-2H5v2Zm1.01-1V11h-2v.01h2Zm-1-1.01H5v2h.01v-2ZM9 11v.01h2V11H9Zm1 1.01h.01v-2H10v2Zm1.01-1V11h-2v.01h2Zm-1-1.01H10v2h.01v-2ZM9 15v.01h2V15H9Zm1 1.01h.01v-2H10v2Zm1.01-1V15h-2v.01h2Zm-1-1.01H10v2h.01v-2ZM14 15v.01h2V15h-2Zm1 1.01h.01v-2H15v2Zm1.01-1V15h-2v.01h2Zm-1-1.01H15v2h.01v-2ZM14 11v.01h2V11h-2Zm1 1.01h.01v-2H15v2Zm1.01-1V11h-2v.01h2Zm-1-1.01H15v2h.01v-2ZM4 15v.01h2V15H4Zm1 1.01h.01v-2H5v2Zm1.01-1V15h-2v.01h2Zm-1-1.01H5v2h.01v-2Z" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Eventos
  				</span></a>
  			</li>
			<li><a href="#" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20">
    				<path fill-rule="evenodd" d="M10 0a10 10 0 1 0 10 10A10.009 10.009 0 0 0 10 0Zm6.613 4.614a8.523 8.523 0 0 1 1.93 5.32 20.094 20.094 0 0 0-5.949-.274c-.059-.149-.122-.292-.184-.441a23.879 23.879 0 0 0-.566-1.239 11.41 11.41 0 0 0 4.769-3.366ZM8 1.707a8.821 8.821 0 0 1 2-.238 8.5 8.5 0 0 1 5.664 2.152 9.608 9.608 0 0 1-4.476 3.087A45.758 45.758 0 0 0 8 1.707ZM1.642 8.262a8.57 8.57 0 0 1 4.73-5.981A53.998 53.998 0 0 1 9.54 7.222a32.078 32.078 0 0 1-7.9 1.04h.002Zm2.01 7.46a8.51 8.51 0 0 1-2.2-5.707v-.262a31.64 31.64 0 0 0 8.777-1.219c.243.477.477.964.692 1.449-.114.032-.227.067-.336.1a13.569 13.569 0 0 0-6.942 5.636l.009.003ZM10 18.556a8.508 8.508 0 0 1-5.243-1.8 11.717 11.717 0 0 1 6.7-5.332.509.509 0 0 1 .055-.02 35.65 35.65 0 0 1 1.819 6.476 8.476 8.476 0 0 1-3.331.676Zm4.772-1.462A37.232 37.232 0 0 0 13.113 11a12.513 12.513 0 0 1 5.321.364 8.56 8.56 0 0 1-3.66 5.73h-.002Z" clip-rule="evenodd" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Deportes
  				</span></a>
  			</li>
			<li><a href="#" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 16">
    				<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2"
						d="M9 5h6M9 8h6m-6 3h6M4.996 5h.01m-.01 3h.01m-.01 3h.01M2 1h16a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1Z" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Categorías
  				</span></a>
  			</li>
			<li><a href="#" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
    				<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2"
						d="M4.333 6.764a3 3 0 1 1 3.141-5.023M2.5 16H1v-2a4 4 0 0 1 4-4m7.379-8.121a3 3 0 1 1 2.976 5M15 10a4 4 0 0 1 4 4v2h-1.761M13 7a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm-4 6h2a4 4 0 0 1 4 4v2H5v-2a4 4 0 0 1 4-4Z" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Equipos
  				</span></a>
			</li>
			<li><a href="#" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 16 18">
    				<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2"
						d="M1 1.984v14.032a1 1 0 0 0 1.506.845l12.006-7.016a.974.974 0 0 0 0-1.69L2.506 1.139A1 1 0 0 0 1 1.984Z" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Encuentros
  				</span></a>
  			</li>
			<li><a href="#" class="flex items-center p-2 text-red-900 rounded-lg dark:text-white bg-red-100 dark:bg-red-700 group">
				<svg class="flex-shrink-0 w-5 h-5 transition duration-75 dark:text-red-400 group-text-red-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 16">
    				<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2"
						d="M1 1v14h16M4 10l3-4 4 4 5-5m0 0h-3.207M16 5v3.207" />
  				</svg>
  				<span class="flex-1 ms-3 whitespace-nowrap">
  					Ranking de equipos
  				</span></a>
  			</li>
			<li><a href="#" class="flex items-center p-2 text-gray-900 rounded-lg dark:text-white hover:bg-gray-100 dark:hover:bg-gray-700 group">
				<svg class="flex-shrink-0 w-5 h-5 text-gray-500 transition duration-75 dark:text-gray-400 group-hover:text-gray-900 dark:group-hover:text-white"
					aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 18 16">
    				<path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2.2" d="M1 1v14h16m0-9-3-2-3 5-3-2-3 4" />
 				 </svg>
 				 <span class="flex-1 ms-3 whitespace-nowrap">
 				 	Ranking de jugadores
				</span></a>
			</li>
		</ul>
	</div>
</aside>

<div class="p-10 sm:ml-64">
	<div class="text-black-900 text-[25px] font-semibold mt-10">Ranking de equipos</div>
	<br></br>
	<div class="relative overflow-x-auto shadow-md sm:rounded-lg">
		<table class="w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
			<thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
				<tr>
					<th scope="col" class="px-6 py-3">Posición</th>
					<th scope="col" class="px-6 py-3">Equipo</th>
					<th scope="col" class="px-6 py-3">Puntos</th>
				</tr>
			</thead>
			<tbody>
				<%  
                    List<Equipo> equipos = (List<Equipo>) request.getAttribute("equipos");
                    Map<Equipo, Integer> puntosTotales = (Map<Equipo, Integer>) request.getAttribute("puntosTotales");

                    for (int i = 0; i < equipos.size(); i++) {
                        Equipo equipo = equipos.get(i);
                        int puntos = puntosTotales.get(equipo);
                %>
				<tr class="odd:bg-white odd:dark:bg-gray-900 even:bg-gray-50 even:dark:bg-gray-800 border-b dark:border-gray-700">
					<th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
					<%= i + 1 %>
					</th>
					<td class="px-6 py-4"><%= equipo.getNombre() %></td>
					<td class="px-6 py-4"><%= puntos %></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</div>


<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.0/flowbite.min.js">
</script>
</body>
</html>