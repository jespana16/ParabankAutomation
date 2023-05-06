# language: es

Característica: Registro en Parabank

  @RegisterParabank
  Esquema del escenario: Registro multiple de parabank
    Dado se necesita registrar un nuevo usuario
    Cuando se ingresan todos los datos del usuario
      | firsname   | lastname   | address   | city   | state   | zipcode   | phone   | ssn   | user   | pass   | confir   |
      | <firsname> | <lastname> | <address> | <city> | <state> | <zipcode> | <phone> | <ssn> | <user> | <pass> | <confir> |
    Entonces se valida la bienvenida al usuario <user>
    Ejemplos:
      | firsname | lastname | address | city | state           | zipcode | phone | ssn  | user     | pass  | confir |
      | jeferson | espana   | calle   | cali | Valle del Cauca | 123     | 12345 | 0000 | jespana4 | 12345 | 12345  |

  @RegisterParabankDatadriven
  Esquema del escenario: Registro multiple de parabank
    Dado se necesita registrar un nuevo usuario
    Cuando se ingresan todos los datos del usuario
      | firsname   | lastname   | address   | city   | state   | zipcode   | phone   | ssn   | user   | pass   | confir   |
      | <firsname> | <lastname> | <address> | <city> | <state> | <zipcode> | <phone> | <ssn> | <user> | <pass> | <confir> |
    Entonces se valida la bienvenida al usuario <user>
    Ejemplos:
      | firsname | lastname | address | city | state           | zipcode | phone | ssn  | user     | pass  | confir |
      ##@externaldata@./src/test/resources/datadriven/data.xlsx@DatosParabank


  @ExistingRecord
  Esquema del escenario: Registro multiple existente de parabank
    Dado el usario <firsname> se registra en la plataforma de parabank
      | firsname   | lastname   | address   | city   | state   | zipcode   | phone   | ssn   | user   | pass   | confir   |
      | <firsname> | <lastname> | <address> | <city> | <state> | <zipcode> | <phone> | <ssn> | <user> | <pass> | <confir> |
    Cuando se intenta realizar nuevamente el registro del usario <firsname>
      | firsname   | lastname   | address   | city   | state   | zipcode   | phone   | ssn   | user   | pass   | confir   |
      | <firsname> | <lastname> | <address> | <city> | <state> | <zipcode> | <phone> | <ssn> | <user> | <pass> | <confir> |
    Entonces se valida el error 'This username already exists' en el nuevo registro
    Ejemplos:
      | firsname | lastname | address | city | state           | zipcode | phone | ssn  | user     | pass  | confir |
      | jeferson | espana   | calle   | cali | Valle del Cauca | 123     | 12345 | 0000 | jespana43 | 12345 | 12345  |
