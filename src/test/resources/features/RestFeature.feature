#Author: your.email@your.domain.com

@tag
Feature: Prueba con servicios de Serenity Rest
 Yo como postulado al cargo de automatizador deseo hacer operaciones con Servicios REST

  @Get1
  Scenario: Consultar servicio de Empleado unico por ID
    When consultar usuario con id 5
    Then Deberia ver la insofrmacion del usuario
      | id | employee_name | employee_salary | employee_age | message                                |
      | 5  | Airi Satou    | 162700          | 33           | Successfully! Record has been fetched. |

 #Ctl ALT L  --- para ajustar formato
  @Get2
  Scenario: Consulta exitosa de la lista de todos los empleados
    When se consulta el servicio web de todos los empleados
    Then se ve un mensaje de exito: Successfully! All records has been fetched.


  @Post
  Scenario: Crear un empleado de forma exitosa
    When se crea un empleado por medio del servicio
      | name          | salary | age |
      | Angel Marzola | 300000 | 20  |
    Then se ve el usurio creado con codigo de exito 200

  @Delete
  Scenario: Eliminar un empleado de manera exitosa
    When se busca el empleado a eliminar por id 5
    Then se observa el mensaje de eliminación "Successfully! Record has been deleted"

