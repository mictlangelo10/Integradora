# Integradora II: SGSG (Sistema de Gestión de Sportacus Gym)
Repositoro dedicado para inetgrar documentación, procesos, código sobre la elaboración del proyecto Sportacus Gym, solicitado por la empresa iTTiVA

# Miembros del equipo
- Daniela Janeth Cruz Breña	(1221100295).
- Miguel Ángel Hernández Solís (1220100587).
- Miguel Ángel Jaime García (1220100319).
- Filiberto Navarro Grifaldo (1221100296).  

# Descripción del proyecto

El proyecto consiste en el desarrollo de un sistema para la gestión y administración de un gimnasio llamado "Sportacus Gym". El sistema cuenta con diferentes servicios y consultorías que deben ser cubiertos, y el módulo de clases es una parte importante del sistema que permite al Administrador agregar, modificar, eliminar y visualizar las clases disponibles. Además, el módulo de clases también permite al Administrador gestionar fácilmente las características de las clases, como el nombre, la descripción, el nivel de dificultad y la duración.

El módulo de clases tiene una relación con otros módulos del sistema, en particular con el módulo de gestión de empleados, ya que es necesario mantener un control sobre las asignaciones de empleados con roles de instructor a las clases creadas.

Por otro lado, el módulo de inscripciones es otra parte del sistema que permite al usuario Administrador/Recepcionista inscribir a los clientes en las clases existentes utilizando un código QR. Este código QR se genera para cada cliente y se modifica según el estado de pago del cliente. Si el cliente tiene un adeudo, se le niega el acceso a las clases y se envía una alerta al personal del sistema, mientras que si el cliente está al día en sus pagos, se le permite inscribirse y se envía una alerta indicando que el registro se ha realizado correctamente.# Objetivo general del proyecto
Llevar un mejor control administrativo en base a los clientes y empleados, productos y proveedores, así como las máquinas operantes y el manejo de todo aquello necesario para el óptimo funcionamiento del gimnasio llamado Sportacus (capital, chekin de empleados, inventario de productos).

En resumen, el proyecto es un sistema de gestión y administración de un gimnasio llamado "Sportacus Gym". El módulo de clases permite al Administrador agregar, modificar, eliminar y visualizar las clases disponibles, lo que garantiza un mejor control y organización del sistema. El módulo de inscripciones permite al usuario inscribir a los clientes en las clases existentes utilizando un código QR, que varía según el estado de pago del cliente. Si el cliente tiene un adeudo, se les niega el acceso a las clases y se envía una alerta al personal del sistema, pero si el cliente está al día en sus pagos, se le permite inscribirse y se envía una alerta que indica que el registro se ha realizado correctamente.


# Objetivo general del proyecto
Llevar un mejor control administrativo en base a los clientes y empleados, productos y proveedores, así como las máquinas operantes y el manejo de todo aquello necesario para el óptimo funcionamiento del gimnasio llamado Sportacus (capital, chekin de empleados, inventario de productos).

# Objetivos específicos
• Implementar un software para una buena gestión administrativa.
• Administrar de mejor manera la suscripción de los clientes al gimnasio.
• Administrar inventario de productos operantes en el gimnasio.
• Tener administrado de mejor manera los ingresos y egresos monetarios del gimnasio.

# Lista de requisitos priorizada del proyecto refinada
- Historias de usuario

![image](https://user-images.githubusercontent.com/123588416/229188068-267446b9-6d48-42de-8e61-74f339d520ba.PNG)

- Casos de uso

<p align="center">
<img src="https://user-images.githubusercontent.com/123588416/229188250-38e8fe23-1850-4bbc-bdda-e8efd0fc65de.png">
</p>


- Diagrama de actividades

<p align="center">
<img src="https://user-images.githubusercontent.com/123588416/229188338-e4f07879-9c93-4ede-b5b5-2bb7773ee94e.png">
</br>Cargar Horarios</br>
<img src="https://user-images.githubusercontent.com/123588416/229188457-05454914-53f5-4643-80f9-088a4830ad70.png">
</br>Visualizar Detalles</br>
<img src="https://user-images.githubusercontent.com/123588416/229188494-6108f913-b2eb-4484-b135-6b13db204929.png">
</br>Visualizar Clases</br>
<img src="https://user-images.githubusercontent.com/123588416/229188528-1aa6df21-9ee6-4e36-ad23-e706ddaeafbc.png">
</br>Visualizar Instructor</br>
<img src="https://user-images.githubusercontent.com/123588416/229188565-a4ecfa5d-5daf-4582-89ce-a1a67a302953.png">
</br>Eliminar Clases</br>
<img src="https://user-images.githubusercontent.com/123588416/229188604-cec897f4-ddc4-4b7c-8a09-ce2e37405466.png">
</br>Eliminar Instructor</br>
<img src="https://user-images.githubusercontent.com/123588416/229188639-15ece435-94dc-4fa5-8b7a-5d20c1313d53.png">
</br>Agregar Clase</br>
<img src="https://user-images.githubusercontent.com/123588416/229188710-259bd10e-29b5-45d8-b702-49bc0feb7434.png">
</br>Agregar Instructor</br>
<img src="https://user-images.githubusercontent.com/123588416/229188758-be0b96bb-44cb-40be-8737-a20ed8ac8873.png">
</br>Modificar Clases</br>
<img src="https://user-images.githubusercontent.com/123588416/229188853-d8cb15f4-c8d8-42a7-9458-10e6ca8bde85.png">
</br>Modificar Instructor</br>
<img src="https://user-images.githubusercontent.com/123588416/229188894-bf181a6e-f7e4-4259-821c-85374947074f.png">
</br>Cargar Registros</br>
<img src="https://user-images.githubusercontent.com/123588416/229188924-cc924a4c-553b-4853-8861-50d30a16bb41.png">
</br>Inscribir a Cliente</br>
<img src="https://user-images.githubusercontent.com/123588416/229188964-4cf90bd3-7d7b-450b-abca-84bc18d86960.png">
</br>Filtrar por Hora y Fecha</br>
<img src="https://user-images.githubusercontent.com/123588416/229188994-d919c8ab-e7f7-428c-a886-efc887e290c9.png">
</br>Buscar Clase</br>
<img src="https://user-images.githubusercontent.com/123588416/229189022-d793309e-2f83-4c64-b5f7-9570981ab374.png">
</br>Buscar Instructor
</p>

# Modelo de Base de Datos
- Diagrama de Interfaces

![image](https://user-images.githubusercontent.com/123588416/229189114-a24203a5-2010-4442-936e-73d4e4ad6ea0.png)

- Modelo de Base de Datos

![image](https://user-images.githubusercontent.com/123588416/229189155-895dc007-4b78-41c2-b816-2b84b920ba99.png)
