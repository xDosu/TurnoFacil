**Template Login :**

**Nombre del caso de uso: Login**

***Nombre representativo de dicha funcionalidad*.**

**Descripción breve: Este caso de uso permite que los médicos puedan loguearse en el sistema para la gestión de turnos.**

**Descripción en un párrafo de lo que hace ese caso de uso.**

**Actor primario/secundario(s): Médico como actor primario y único.**

**#Actores involucrados en el CU.**

**Trigger: El caso de uso comienza cuando el médico quiere loguearse en el sistema.** 

**Situación por la que el caso de uso se activa.**

**Curso básico:** 

1. **El caso de uso comienza cuando el médico quiere loguearse en el sistema.**
2. **El sistema solicita los datos de ingreso.**
3. **El médico ingresa su DNI y contraseña.**
4. **El sistema verifica que exista el DNI.**
5. **El sistema verifica que la contraseña ingresada esté asociada con ese DNI.**
6. **El médico tiene acceso a las funcionalidades del sistema.**
7. **El caso de uso finaliza.**

**Flujo de ejecución ideal.**

**Curso alternativo: El DNI ingresado no existe.**

`	`**4.    El sistema verifica que exista el DNI.**

`	`**4.1. El sistema muestra un mensaje de error.**

`	`**4.2. El sistema solicita que se vuelva a ingresar otro DNI.**

`	`**4.3. El flujo vuelve al paso 3.**

**Curso alternativo: La contraseña no concuerda con el DNI ingresado.**

**5.    El sistema verifica que la contraseña ingresada esté asociada con ese DNI.**

`	`**5.1. El sistema muestra un mensaje de error.**

`	`**5.2. El sistema solicita que se vuelva a ingresar otra contraseña para el mismo                    DNI.**

`	`**5.3. El flujo vuelve al paso 3.**

**Desviaciones del flujo de ejecución ideal.**

**Precondición: El médico debe estar registrado por el administrador.**

**#Algo que debe ser verdadero (chequeado por el caso de uso) antes de desarrollar su funcionalidad.**

**Postcondición: El médico tiene acceso a las funcionalidades del sistema.**

**Algo que debe ser verdadero (chequeado por el caso de uso) después de desarrollar su funcionalidad.**

**Casos de uso que extiende: ListarTurnos**

**Casos de uso a los que incorpora nueva funcionalidad en situaciones particulares.**

**Finalización del caso de uso: En todo momento se va a contar con una opción de cerrar la aplicación estando o no logueado.**

` `**Situaciones por las cuales un caso de uso termina**

`		`**(se desarrolló correctamente, hubo algún alternativa que terminó el desarrollo del caso de uso, cancelación)** 

**—------------------------------------------------------------------------------------------------------------------------**



**Template Listar Turnos :**

**Nombre del caso de uso: Listar Turnos**

***Nombre representativo de dicha funcionalidad*.**

**Descripción breve: Este caso de uso permite que los médicos puedan listar sus propios turnos.**

**Descripción en un párrafo de lo que hace ese caso de uso.**

**Actor primario/secundario(s): Médico como actor primario y único.**

**#Actores involucrados en el CU.**

**Trigger: El caso de uso comienza cuando el médico quiere listar sus propios turnos.** 

**Situación por la que el caso de uso se activa.**

**Curso básico:** 

1. **[PTO. EXT.] Login** 
2. **El caso de uso comienza cuando el médico quiere listar sus propios turnos.**
3. **El sistema solicita al médico que indique un rango de fechas**
4. **El médico indica el rango de fechas.**
5. **El sistema solicita al médico que indique si quiere los turnos de mañana, tarde o ambos.**
6. **El médico indica el turno de mañana, tarde o ambos.**
7. **El sistema muestra la lista de turnos con los criterios aplicados.**
8. **El caso de uso finaliza.**

**Flujo de ejecución ideal.**

**Cursos alternativos: El médico ingresa un rango de fechas invalido.**

`	`**3.    El médico indica el rango de fechas.**

`	`**3.1. El sistema muestra un mensaje de error.**

`	`**3.2. El sistema solicita que se vuelva a ingresar un rango de fechas válido.**

`	`**3.3. El flujo vuelve al paso 3.**

**Desviaciones del flujo de ejecución ideal.**

**Postcondición: El médico tiene acceso a su lista de turnos.**

**Algo que debe ser verdadero (chequeado por el caso de uso) después de desarrollar su funcionalidad.**


