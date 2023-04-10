# Sportacus Gym
Repositorio dedicado integramente a la elaboración del proyecto asignado por la empresa Ittiva

# Integrantes del equipo
- Daniela Janeth Cruz Breña	(1221100295).
- Miguel Ángel Hernández Solís (1220100587).
- Miguel Ángel Jaime García (1220100319).
- Filiberto Navarro Grifaldo (1221100296).  

# Descripción del proyecto

El proyecto está basado en el desarrollo de un sistema que permita la gestión y administración de un Gimnasio que lleva por nombre “Sportacus Gym” el cual cuenta con diferentes servicios y consultorías que deberán de ser cubiertas por el sistema, brindando con ello una alternativa tecnológica y accesible para la administración de este, contando con diferentes módulos de acceso, en este documento se presentara la solución propuesta para el modulo de Clases y su conformación con el resto de los módulos del sistema. El módulo de clases es una parte del sistema que proporciona al Administrador la capacidad de realizar diversas acciones en relación con las clases disponibles en el sistema. 

El Administrador tendrá la capacidad de agregar nuevas clases al sistema, modificar las clases existentes, eliminar clases que ya no se necesiten y visualizar todas las clases disponibles. Este módulo también proporciona una interfaz clara y precisa para que el Administrador pueda gestionar fácilmente las características de las clases. Por ejemplo, el Administrador puede agregar información como el nombre de la clase, la descripción, el nivel de dificultad, la duración y cualquier otro detalle relevante. Además, el Administrador puede cambiar esta información en cualquier momento si es necesario. En resumen, el módulo de clases es una herramienta esencial para el Administrador del sistema, ya que le permite manejar y mantener fácilmente las clases disponibles, lo que garantiza un mejor control y organización del sistema en su conjunto.


Su relación con otros módulos depende solo de la gestión de empleados ya que en relación con los datos que maneja el modulo de clases es necesario mantener un control sobre las asignaciones de empleados con roles de instructor a las clases creadas, para esto el modulo de clases necesita tener acceso a los datos de los empleados con este rol, para así seleccionar y asignar los datos del instructor con los datos de la Clase.
Continuando con la funcionalidad, el módulo de inscripciones es una parte del sistema que permite al usuario Administrador/Recepcionista inscribir a los clientes en las clases existentes dentro del sistema. Para lograr esto, el módulo utiliza un código QR, que se genera para cada cliente y se modifica según el estado de pago de este.


Si un cliente tiene un adeudo pendiente, el sistema genera un código QR que impide que el cliente acceda a las clases. Este código QR envía una alerta de adeudamiento al personal del sistema. Por otro lado, si el cliente tiene sus pagos al día, el sistema permite inscribirse en las clases y envía una alerta que indica que el registro se ha realizado correctamente.


En resumen, el proyecto es un sistema de gestión y administración de un gimnasio llamado "Sportacus Gym". El módulo de clases permite al Administrador agregar, modificar, eliminar y visualizar las clases disponibles, lo que garantiza un mejor control y organización del sistema. El módulo de inscripciones permite al usuario inscribir a los clientes en las clases existentes utilizando un código QR, que varía según el estado de pago del cliente. Si el cliente tiene un adeudo, se les niega el acceso a las clases y se envía una alerta al personal del sistema, pero si el cliente está al día en sus pagos, se le permite inscribirse y se envía una alerta que indica que el registro se ha realizado correctamente.


# Lista de requisitos priorizada del proyecto refinada
Historias de usuario
<img width="746" alt="Historias de Usuario" src="https://user-images.githubusercontent.com/123588416/229188068-267446b9-6d48-42de-8e61-74f339d520ba.PNG">

Casos de uso:
![image](https://user-images.githubusercontent.com/123588416/229188250-38e8fe23-1850-4bbc-bdda-e8efd0fc65de.png)
Ilustración 1. Diagrama de Casos de Uso

Diagrama de actividades:
![image](https://user-images.githubusercontent.com/123588416/229188338-e4f07879-9c93-4ede-b5b5-2bb7773ee94e.png)
Ilustración 2. Diagrama de Actividades-Cargar Horarios	

![image](https://user-images.githubusercontent.com/123588416/229188457-05454914-53f5-4643-80f9-088a4830ad70.png)
Ilustración 3. Diagrama de Actividades- Visualizar Detalles

![image](https://user-images.githubusercontent.com/123588416/229188494-6108f913-b2eb-4484-b135-6b13db204929.png)
Ilustración 4. Diagrama de Actividades- Visualizar Clases.

![image](https://user-images.githubusercontent.com/123588416/229188528-1aa6df21-9ee6-4e36-ad23-e706ddaeafbc.png)
Ilustración 5. Diagrama de Actividades- Visualizar Instructor

![image](https://user-images.githubusercontent.com/123588416/229188565-a4ecfa5d-5daf-4582-89ce-a1a67a302953.png)
Ilustración 6. Diagrama de Actividades- Eliminar Clases

![image](https://user-images.githubusercontent.com/123588416/229188604-cec897f4-ddc4-4b7c-8a09-ce2e37405466.png)
Ilustración 7. Diagrama de Actividades- Eliminar Instructor

![image](https://user-images.githubusercontent.com/123588416/229188639-15ece435-94dc-4fa5-8b7a-5d20c1313d53.png)
Ilustración 8.Diagrama de Actividades- Agregar Clase

![image](https://user-images.githubusercontent.com/123588416/229188710-259bd10e-29b5-45d8-b702-49bc0feb7434.png)
Ilustración 9.Diagrama de Actividades- Agregar Instructor

![image](https://user-images.githubusercontent.com/123588416/229188758-be0b96bb-44cb-40be-8737-a20ed8ac8873.png)
Ilustración 10. Diagrama de Actividades- Modificar Clases

![image](https://user-images.githubusercontent.com/123588416/229188853-d8cb15f4-c8d8-42a7-9458-10e6ca8bde85.png)
Ilustración 11. Diagrama de Actividades- Modificar Instructor

![image](https://user-images.githubusercontent.com/123588416/229188894-bf181a6e-f7e4-4259-821c-85374947074f.png)
Ilustración 12. Diagrama de Actividades-Cargar Registros

![image](https://user-images.githubusercontent.com/123588416/229188924-cc924a4c-553b-4853-8861-50d30a16bb41.png)
Ilustración 13. Diagrama de Actividades- Inscribir a Cliente

![image](https://user-images.githubusercontent.com/123588416/229188964-4cf90bd3-7d7b-450b-abca-84bc18d86960.png)
Ilustración 14. Diagrama de Actividades- Filtrar por Hora y Fecha

![image](https://user-images.githubusercontent.com/123588416/229188994-d919c8ab-e7f7-428c-a886-efc887e290c9.png)
Ilustración 15. Diagrama de Actividades-Buscar Clase

![image](https://user-images.githubusercontent.com/123588416/229189022-d793309e-2f83-4c64-b5f7-9570981ab374.png)
Ilustración 16. Diagrama de Actividades- Buscar Instructor

# Modelo de Base de Datos
Diagrama de Interfaces: 
![image](https://user-images.githubusercontent.com/123588416/229189114-a24203a5-2010-4442-936e-73d4e4ad6ea0.png)
Ilustración 17. Diagrama de Interfaces-Clases.

Modelo de Base de Datos 
![image](https://user-images.githubusercontent.com/123588416/229189155-895dc007-4b78-41c2-b816-2b84b920ba99.png)
Ilustración 18. Modelo Base de Datos -Clases

*Arquitectura MVC
Aplicación del patrón MVC
Diagrama de Componentes
Proceso de Instalación de la Aplicación
Manual de Usuario
Código y Pruebas
Plan de Iteraciones 
