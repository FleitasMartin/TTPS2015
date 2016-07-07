TTPS 2015 Comedor UNLP.

A fin de lograr un correcto funcionamiento de la aplicación es necesario contar con una BD creada
llamada "comedor_unlp"; levantar el servidor de Tomcat para que cree el esquema, y realizar las
siguientes inserciones manualmente:

Datos que son necesarios ingresar manualmente en la BD:
	
	1) Ingresar tres tuplas en la tabla "rol", con los roles 
		ROLE_ADMIN, ROLE_RESPONSABLE, ROLE_USUARIO, con ids 0, 1, 2 respectivamente.

	2) Para ingresar administradores, deben ser ingresados todos en este punto de la siguiente manera:
	2.1) Ingresar una tupla en la tabla "persona" con id 0 (el primero e incrementar), 
		y enlazarle el id de rol 0.
	2.2) Ingresar una tupla en la tabla "administrador" enlazando el id de persona 0 
		(uno por cada uno de los creados en el punto anterior).

	3) En el navegador, ingresar a "localhost:8080/ComedorUNLP_TTPS_2015/" y logearse 
		con el dni y la contraseña especificada en el punto 2.
	
	4) Dar de alta al menos una sede, yendo a la opción del menú "Sedes" y luego clickeando "Alta sede".

	5) Dar de alta al menos un responsable, yendo a la opción del menú "Responsables" 
		y luego clickeando "Crear Responsable".
	
	6) Para ingresar usuarios de prueba, deben ser ingresados después de haber creado todos los 
		responsables y administradores, ya que, al ser ingresados manualmente, se rompe una restricción
		de hibernate y pasa a tirar excepción al intentar hacer un alta de alguno de los roles mencionados.
	6.1) Es necesario cargar manualmente en la tabla "persona" los datos de los usuarios de prueba
		deseados (siempre incrementando en 1 el id), enlazándoles el id de rol 2.
	6.2) Posteriormente, en la tabla "usuario" cargar el resto de los datos, y enlazarle el id de
		los generados en el punto anterior, y el id de la sede existente en la tabla "sede".
	
Como no pertenece al contexto de la aplicación la implementación de un módulo de operaciones CRUD
para el manejo de usuarios se presenta esta limitación de cargarlos manualmente.
Además, habiéndolos cargado manualmente, se produce un error en alguna secuencia de hibernate para esa tabla, por lo que
ya no estarán disponibles las operaciones de creación de administradores y responsables. En caso de utilizarlas
se producirá un error en pantalla impidiendo cualquier otra acción.
	
Nota: Respecto a las características, es necesario ingresar manualmente aquellas que sean necesarias.
	Esto debe hacerse en la tabla "caracteristica".
