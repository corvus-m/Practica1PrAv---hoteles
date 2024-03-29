TriLazy

Este programa desarrollado en java se encarga de buscar todos los hoteles en los que puedes alojarte, teniendo en cuenta fechas, número de personas y presupuesto, además de calcularte precios y descuentos según las condiciones. Tras encontrar estos te detallará sus instalaciones y las habitaciones que tiene disponibles para ti.


Durante las ultimas semanas se ha evaluado la situación del proyecto y se han decidido llevar a cabo cambios en su orientación. pensando en la posibilidad de detallar mas tipos de habitacion y asi dar un mejor soporte y detallar caracteristicas de estas se ha decidido implementar una interfaz habitación, por ello se ha tenido que estender a los tipos ya usados, necesitando con ello una refactorización de codigo. En aras de una correcta implementacion, se ha sacrificado encapsulamiento de los metodos protegidos de habitacion, siendo ahora publicos para pertenecer a la nueva IHabitacion. Se prevé implementar asi mismo una interfaz para hoteles, facilitando la creacion de nuevas clases hotel, que nos permitan llegar a nuevos negocios familiares o menos tradicionales que antes no se vieran bien representados. Por todo esto se ha rediseñado el diagrama de clases para sacar mas provecho a nuestro proyecto, cambiando desde el codigo nuestro modelo de negocio para hacerlo mas escalable.


![imagen](https://github.com/corvus-m/Practica1PrAv/blob/master/Diagramaclases.jpg)






Para su utilización, este programa tiene preparadas funciones para insertar los detalles de los hoteles que se desean promocionar.

Además ahora el proyecto cuenta con una interfaz en 100 idiomas gracias a la google apps script.
La clase Traductor no es mas que una llamada a una funcion implementada en Google Apps Script, esta usa la clase [LanguageApp](https://developers.google.com/apps-script/reference/language/language-app) de google para traducir la frase introducida al idioma deseado.
![imagen](https://github.com/corvus-m/Practica1PrAv/blob/master/traductor.jpeg)
Se prevee implementar esta traduccion en los detalles de los hoteles y sus habitaciones asi como en el resto del programa.

Hemos agregado un login para usuarios. Nuestra prioridad es su seguridad, por eso hemos añadido una base de datos donde guardar la información codificada de forma que no se pueda acceder a ella sin conocimiento de la clave. Ahora mismo se trata de un prototipo y solo cuenta con una seguridad simetrica, pero se prevee implementar encriptacion asimetrica en las proximas versiones.mm

Los distintos test se encargan de comprobar el correcto funcionamiento de las funciones del programa:
  -Datetest comprueba que las funciones de estancia y reserva de dias funcionan correctamente, dando los dias que hay entre dos fechas.
  -DistributionTest mira que la función distribución de personas, filtra correctamente las habitaciones disponibles para X personas 
  -Filtrotest se encarga como su nombre indica de comprobar que el filtro de habitaciones por días, presupuesto y numero de personas, funciona.
  -FiltroHotelTest y AlbergeFiltroTest comprueban la implementacion del filtro principal de hotel y de su clase hija alberge.



El programa ha sido desarrollado en java con eclipse IDE 2020-06 y en Google Apps Script. 




Agradecimientos:
 -Quisiera agradecer a Maksym Pecheniuk, usuario de stack overflow que explica como utilizar la translate API de google script y sin la que la internacionalizacion del programa
  no habria sido posible : https://stackoverflow.com/questions/8147284/how-to-use-google-translate-api-in-my-java-application
  
 Otras referencias que han ayudado en la investigación de como implementar la interfaz multilenguaje han sido:
 -https://developers.google.com/apps-script/reference/language/language-app
 
 -https://www.discoduroderoer.es/como-hacer-una-aplicacion-multi-idioma-en-java/
 
 -https://java.dokry.com/58429/cuales-son-las-mejores-practicas-para-la-api-de-middleware.html
 
 -https://code.google.com/archive/p/java-google-translate-text-to-speech/
 
 -https://github.com/jrichardsz/lib-java-google-translate-text-to-speech
 
 -https://java.dokry.com/3032/como-usar-google-translate-api-en-mi-aplicacion-java.html
 
 -https://cloud.google.com/translate/docs/setup?hl=es#windows
 
 -https://www.programmersought.com/article/96325538810/
 
 



Práctica creada por Mateo Orive
