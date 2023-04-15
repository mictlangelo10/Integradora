# Integradora II: SGSG (Sistema de Gestión de Sportacus Gym)
Repositoro dedicado para integrar la documentación, los procesos y el código sobre la elaboración del proyecto Sportacus Gym, solicitado por la empresa iTTiVA, siendo más especificos, al módulo de clases.

## Integrantes del Equipo
- Cruz Breña Daniela Janeth 	(1221100295).
- Hernández Solís Miguel Ángel  (1220100587).
- Jaime García Miguel Ángel  (1220100319).
- Navarro Grifaldo Filiberto  (1221100296).  

## Generalidades del Proyecto
### Descripción 

El proyecto consiste en el desarrollo de un sistema para la gestión y administración de un gimnasio llamado "Sportacus Gym". El sistema cuenta con diferentes servicios y consultorías que deben ser cubiertos, y el módulo de clases es una parte importante del sistema que permite al Administrador agregar, modificar, eliminar y visualizar las clases disponibles. Además, el módulo de clases también permite al Administrador gestionar fácilmente las características de las clases, como el nombre, la descripción, el nivel de dificultad y la duración.

El módulo de clases tiene una relación con otros módulos del sistema, en particular con el módulo de gestión de empleados, ya que es necesario mantener un control sobre las asignaciones de empleados con roles de instructor a las clases creadas.

Por otro lado, el módulo de inscripciones es otra parte del sistema que permite al usuario Administrador/Recepcionista inscribir a los clientes en las clases existentes utilizando un código QR. Este código QR se genera para cada cliente y se modifica según el estado de pago del cliente. Si el cliente tiene un adeudo, se le niega el acceso a las clases y se envía una alerta al personal del sistema, mientras que si el cliente está al día en sus pagos, se le permite inscribirse y se envía una alerta indicando que el registro se ha realizado correctamente.# Objetivo general del proyecto
Llevar un mejor control administrativo en base a los clientes y empleados, productos y proveedores, así como las máquinas operantes y el manejo de todo aquello necesario para el óptimo funcionamiento del gimnasio llamado Sportacus (capital, chekin de empleados, inventario de productos).

En resumen, el proyecto es un sistema de gestión y administración de un gimnasio llamado "Sportacus Gym". El módulo de clases permite al Administrador agregar, modificar, eliminar y visualizar las clases disponibles, lo que garantiza un mejor control y organización del sistema. El módulo de inscripciones permite al usuario inscribir a los clientes en las clases existentes utilizando un código QR, que varía según el estado de pago del cliente. Si el cliente tiene un adeudo, se les niega el acceso a las clases y se envía una alerta al personal del sistema, pero si el cliente está al día en sus pagos, se le permite inscribirse y se envía una alerta que indica que el registro se ha realizado correctamente.

### Objetivo General
Llevar un mejor control administrativo en base a los clientes y empleados, productos y proveedores, así como las máquinas operantes y el manejo de todo aquello necesario para el óptimo funcionamiento del gimnasio llamado Sportacus (capital, chekin de empleados, inventario de productos).

### Objetivos Específicos
- Implementar un software para una buena gestión administrativa.
- Administrar de mejor manera la suscripción de los clientes al gimnasio.
- Administrar inventario de productos operantes en el gimnasio.
- Tener administrado de mejor manera los ingresos y egresos monetarios del gimnasio.

### Estandares de Codificación
Los estándares de codificación son un conjunto de directrices y buenas prácticas que se utilizan para escribir código limpio y legible en un proyecto de software. Estas normas establecen reglas sobre la estructura del código, la nomenclatura de variables, la indentación, la longitud de las líneas, la documentación, el manejo de errores y otras prácticas de programación.

A continuación, se muestran unos posibles estandares del proyecto

#### En el Código
- Utilizar camelCase para los nombres de variables, funciones y métodos.
- Utilizar PascalCase para los nombres de clases y componentes.
- Utilizar nombres descriptivos y significativos para las variables, funciones y métodos.
- Documentar autores del código
- Documentar funciones, métodos y variables

#### En Software
- Usar Angular CLI en su versión 14.0.2 
- Usar Spring Boot en su versión 4.18.0
- Usar Git en su versión 2.40.0
- Usar Visual Studio en su versión 1.60.2
- Usar TypeScript en su versión 4.4.4
- Usar JDK en su versión 7.0.0 

### Sitios de Apoyo para Documentos y Archivos
- Trello
- Github

### Trello del Equipo
- [Equipo1](https://trello.com/b/WCiXKg3x/actividades)

## Análisis y Diseño de Solución
### Historias de Usuario

![image](https://user-images.githubusercontent.com/123588416/229188068-267446b9-6d48-42de-8e61-74f339d520ba.PNG)

### Diagrama de Casos de Uso

<p align="center">
<img src="https://user-images.githubusercontent.com/115411941/232179630-0ef31f43-a035-49b2-88cb-7093fa5b0c51.png">
</p>


### Diagramas de Actividades

<p align="center">
<img src="https://user-images.githubusercontent.com/123588416/229188338-e4f07879-9c93-4ede-b5b5-2bb7773ee94e.png">
</br>Cargar Horarios</br>
<img src="https://user-images.githubusercontent.com/123588416/229188457-05454914-53f5-4643-80f9-088a4830ad70.png">
</br>Visualizar Detalles</br>
<img src="https://user-images.githubusercontent.com/123588416/229188494-6108f913-b2eb-4484-b135-6b13db204929.png">
</br>Visualizar Clases</br>
<img src="https://user-images.githubusercontent.com/123588416/229188565-a4ecfa5d-5daf-4582-89ce-a1a67a302953.png">
</br>Eliminar Clases</br>
<img src="https://user-images.githubusercontent.com/115411941/232179072-4f8ca9ae-59bd-4f17-8651-bd286c8a8e34.png">
</br>Eliminar Cliente</br>
<img src="https://user-images.githubusercontent.com/123588416/229188639-15ece435-94dc-4fa5-8b7a-5d20c1313d53.png">
</br>Agregar Clase</br>
<img src="https://user-images.githubusercontent.com/115411941/232179215-1d7aafd1-3c4a-4905-82f5-c0b1087fbd99.png">
</br>Agregar Cliente</br>
<img src="https://user-images.githubusercontent.com/123588416/229188758-be0b96bb-44cb-40be-8737-a20ed8ac8873.png">
</br>Modificar Clases</br>
<img src="https://user-images.githubusercontent.com/115411941/232179321-c5b7278b-831e-4a6b-a6c4-db4638683950.png">
</br>Modificar Cliente</br>
<img src="https://user-images.githubusercontent.com/123588416/229188894-bf181a6e-f7e4-4259-821c-85374947074f.png">
</br>Cargar Registros</br>
<img src="https://user-images.githubusercontent.com/123588416/229188924-cc924a4c-553b-4853-8861-50d30a16bb41.png">
</br>Inscribir a Cliente</br>
<img src="https://user-images.githubusercontent.com/123588416/229188964-4cf90bd3-7d7b-450b-abca-84bc18d86960.png">
</br>Filtrar por Hora y Fecha</br>
<img src="https://user-images.githubusercontent.com/123588416/229188994-d919c8ab-e7f7-428c-a886-efc887e290c9.png">
</br>Buscar Clase
</p>

### Diagrama de Interfaces

![image](https://user-images.githubusercontent.com/123588416/229189114-a24203a5-2010-4442-936e-73d4e4ad6ea0.png)

### Diagrama de Colecciones para la Base de Datos

![image](https://user-images.githubusercontent.com/123588416/229189155-895dc007-4b78-41c2-b816-2b84b920ba99.png)

### Modelo de la Base de Datos
La base de datos a utilizar será no relacioonal, en la que mediante el uso del gestor MongoDB Atlas se adminstraran ños datos del módulo. La base de datos se basa en la siguiente propuesta:

#### Colección Customer

La colección Customer esta dedicada a almacenar los registros de los clientes registrados en el sistema, cuenta con los siguientes atributos:
</br>
• "CustomerName": Nombre del Cliente (cadena de caracteres)</br>
• "Class": Clase a la que esta inscrito el Cliente, valor que sera seleccionado a traves de un menú precargad con el nombre de las clases existentes (cadena de caracteres)</br>
• "Age": Edad del cliente (valor numérico)</br>
• "Email": Dirección de correo del cliente (cadena de caracteres)</br>
• "Phone": Telefono del cliente (valor numérico)</br>
• "Suscription": Tipo de suscrioción del cliente (valor numérico)</br>

<p align="center"><img width="450" alt="image" src="https://user-images.githubusercontent.com/115411941/232182273-d95a0da1-e95b-4db1-898d-367ae1774ac8.png"></p>

#### Colección Class

La colección Clase esta diseñada para almacenar los registros de las clases registradas en el sistema, cuenta con diferentes atributos que complementan la información de las clases, los cuales son:
</br>
• "ClassName": Nombre de la Clase (cadena de caracteres)</br>
• "Photo": Imagen representativa de la Clase (archivo de imagen)</br>
• "Description": Descripción de la Clase (cadena de caracteres)</br>
• "Price": Precio de la Clase (valor numérico)</br>
• "Instructor": Nombre del Instructor de la clase, extraído del registro de Empleados con rol de Instructor, mostrado en la interfaz como un menu desplegable (cadena de caracteres)</br>
• "Date": Fecha de la Clase (formato de fecha dd/mm/aa)</br>
• "Hour": Hora de laClase (formato de hora hh:mm)</br>
• "Quota": Cupo de la clase (valor numérico)</br>


<p align="center"><img width="450" alt="image" src="https://user-images.githubusercontent.com/115411941/232182282-67422409-85c7-4a41-9de8-e9b0e681352f.png"></p>

## Modelo Vista Controlador 
El modelo vista controlador (MVC) es un patrón de diseño de software utilizado en la construcción de aplicaciones de software para separar la lógica de la aplicación en tres componentes principales: el modelo, la vista y el controlador.

El modelo representa los datos y la lógica de negocio de la aplicación, mientras que la vista se encarga de la presentación de los datos al usuario. El controlador actúa como intermediario entre el modelo y la vista, y se encarga de manejar la entrada del usuario y actualizar el modelo en consecuencia.

La separación de estas responsabilidades permite una mayor modularidad y flexibilidad en el desarrollo de la aplicación, lo que facilita la evolución y mantenimiento del software. Además, permite la reutilización de componentes y la realización de pruebas unitarias de manera más sencilla.

- Diagrama General del Modelo Vista Controlador

![image](https://user-images.githubusercontent.com/123588416/232230475-58f8fe22-eeaa-461e-aea2-8c3154d4901b.png)


- Diagrama de MVC del módulo de clases
- 
![image](https://user-images.githubusercontent.com/123588416/232230608-89a9b86a-8f48-4872-a1cc-af6890db6d7c.png)

### Diagrama de Componentes
![Componentes](https://user-images.githubusercontent.com/115411941/232181428-5dafc65a-3f2f-4e7f-9afe-6e9d1df044ec.png)

## Proceso de Instalación de la Aplicación 
En el siguiente manual de instalación se habla acerca de la manera en la cual se puede instalar la aplicación dentro de un dispositivo para un entorno de desarrollo, haciendo que de esta manera el lector del mismo, una vez finalizado, tenga a su disposición el proyecto para modificarlo en caso de ser conveniente, a continuación se muestra el manual en el que se mencionan requisitos para la instalación y el proceso de la misma.

- [Manual de instalación](https://drive.google.com/file/d/1h4ZyVRgPXkRTytfTcG6S53x4-45oyeKB/view?usp=share_link)

## Manual de Funcionamiento
Con el fin de facilitar la comprensión del funcionamiento del proyecto, se proporcionará un manual detallado para su uso. Este documento tiene como objetivo garantizar que el cliente comprenda plenamente el proyecto y sea capaz de utilizarlo de manera efectiva. El manual explicará las funcionalidades del sistema y las características clave, así como los pasos necesarios para su correcto uso. Además, se brindará asistencia y soporte para el cliente en caso de que se presenten dudas o inconvenientes durante el proceso de uso del proyecto.

- [Manual de usuario](https://drive.google.com/file/d/1U7vrPfcj-QFQRvG6XFWvc8Gqzp1gC46Q/view?usp=share_link)

## Documentación del Código Fuente
Se anexa la documentación del código desarrollado a lo largo del proyecto, esto con el objetivo de darle los respectivos créditos a los trabajadores del mismo y de comprender el funcionamiento que se tiene en el sistema.

- [Front-End](https://github.com/mictlangelo10/Integradora/tree/main/Frontend)
- [Back-End](https://github.com/mictlangelo10/Integradora/tree/main/Backend)

## Casos de Prueba
Con el propósito de verificar el desempeño adecuado del componente y garantizar que el artículo entregado al comprador no presente ningún defecto, se llevaron a cabo varios ensayos que se detallan a continuación junto con los resultados correspondientes.

[Casos de prueba](https://docs.google.com/spreadsheets/d/1HHsbVE49IEYQMTA9IPGYHlhNp8qOx0ug/edit?usp=share_link&ouid=103096531010844924896&rtpof=true&sd=true)

## Contacto
- Hernández Solís Miguel Ángel</br>
Correo electrónico: miguehdzss29@gmail.com</br>
Teléfono: 4181446580</br>
- Cruz Breña Daniela Janeth</br>
Correo electrónico: daniela122cruz.11@gmail.com</br>
Teléfono: 4681025325 
