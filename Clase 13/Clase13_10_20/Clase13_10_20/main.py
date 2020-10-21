#Primero instalamos las librerias de Python con pip
#en la presentacion esta un enlace por si no llegase a funcionar
#Utilizamos 3 librerias
#Flask  que es para la construccion de la API
from flask import Flask, jsonify, request
#flask_cors que es para permitir que el Front End se comunique con la API
from flask_cors import CORS
#json porque necesitamos mover objetos JSON
import json
#Este import es de nuestro archivo Persona.py y exportamos la clase como tal.
from Personas import Persona

#Variable = Flask(__name__) esto debe de ir siempre, el app puede ser cualquier nombre
app = Flask(__name__)
#CORS(variable) habilita los CORS es para el FrontEnd
CORS(app)
#Variable = [] significa que estamos declarando una lista
#Si quisieramos declarar un arreglo usamos {}
Usuarios = []

#lista.append(objeto) le estamos diciendo que queremos agregar ese objeto al final de la lista
#En este caso estamos usando guardando un objeto tipo Persona
Usuarios.append(Persona('Carlos','Jimenez',22))
Usuarios.append(Persona('Juan','Chorizo',25))
Usuarios.append(Persona('Paco','De la mar',26))
Usuarios.append(Persona('Pedro','Perez',27))

#Esta es una ruta, es la direccion a la que vamos a hacer la peticion
#Para que nuestra API haga lo que estamos solicitando en el metodo
#app.route('URL', methods=['METODO HTTPS'])
#Donde URL es el complemento es decir lo que va despues de nuestro localhost
#Donde METODO HTTPS corresponde a uno de los 4 metodos GET, POST, PUT, DELETE
@app.route('/', methods=['GET'])
#Declaramos el metodo con el que va a funcionar la ruta
#Para declarar un metodo utilizamos la palabra def nombre_metodo(*parametros*):
def rutaInicial():
    #Ya aqui depende de la logica de cada quien que es lo que hara cada metodo
    print("Hola alumnos")
    #El return es lo que se mostrara al consultar la ruta
    return("Hola alumnos")

#En este caso creamos la ruta localhost:3000/Personas
#Esta ruta sera un metodo GET
@app.route('/Personas', methods=['GET'])
#Queremos que en esta ruta nos devuelva los datos de las personas
def obtenerPersonas():
    #Usamos la variable global para usar una variable declarada en el ambito global
    global Usuarios
    Datos = []
    #Los for se pueden trabajar como un for each, es decir un objeto dentro de los objetos
    for usuario in Usuarios:
        #Formando el JSON, segun la estructura del JSON lo formamos como un objeto
        #Que tenga almacenado su nombre y su valor.
        Dato = {
            'nombre': usuario.getNombre(), 
            'apellido': usuario.getApellido(), 
            'edad': usuario.getEdad()
            }
        Datos.append(Dato)
    #En este caso usamos jsonify para convertir nuestro arreglo en un objeto JSON
    #Para que sea reconocible en el navegador y tengamos la respuesta no como 
    #un arreglo, si no como un objeto JSON
    respuesta = jsonify(Datos)
    #Usamos el return para terminar el metodo
    return(respuesta)

#Agregando parametros a nuestras rutas.
#A veces necesitamos enviar parametros que son diferentes al cuerpo del JSON
#Para este caso agregamos el parametro como parte de la ruta
#Agregamos nuestra URL y por ultimo ponemos <tipodato: varible>
@app.route('/Personas/<string:nombre>', methods=['GET'])
#Y a la hora de definir el metodo, agregamos variable como metodo
def ObtenerPersona(nombre):
    global Usuarios
    for usuario in Usuarios:
        if usuario.getNombre() == nombre:
            Dato = {
                'nombre': usuario.getNombre(), 
                'apellido': usuario.getApellido(), 
                'edad': usuario.getEdad()
                }
            break
    respuesta = jsonify(Dato)
    return(respuesta)

@app.route('/Personas/<string:nombre>', methods=['PUT'])
def ActualizarPersona(nombre):
    global Usuarios
    #Otra forma de usar el for es como la manera tradicional
    #Con un indice y para eso utilizamos el range(numero)
    #Donde dara el rango de numeros desde 0 hasta el numero enviado como parametro
    for i in range(len(Usuarios)):
        if nombre == Usuarios[i].getNombre():
            Usuarios[i].setNombre(request.json['nombre'])
            Usuarios[i].setApellido(request.json['apellido'])
            Usuarios[i].setEdad(request.json['edad'])
            break
        #El retorno del mensaje depende de cada estudiante
        #Recuerden que una peticion puede tener multiples salidas
        #Como "No se encontro", "No hay datos", etc.
        #Todo depende del estudiante
    return jsonify({'message':'Se actualizo el dato exitosamente'})

@app.route('/Personas/<string:nombre>', methods=['DELETE'])
def EliminarPersona(nombre):
    global Usuarios
    for i in range(len(Usuarios)):
        if nombre == Usuarios[i].getNombre():
            #En este caso, para eliminar un objeto de un arreglo utilizamos
            #La palabra reservada del arreglo[indice]
            del Usuarios[i]
            break
    return jsonify({'message':'Se elimino el dato exitosamente'})

@app.route('/Personas', methods=['POST'])
def AgregarUsuario():
    global Usuarios
    nuevo = Persona(request.json['nombre'],request.json['apellido'],request.json['edad'])
    Usuarios.append(nuevo)
    return("Se agrego el usuario")

#Esto tambien se necesita para correr la aplicacion
#El host no es necesario, el puerto no tiene que ser 3000 a fuerzas
#Puede ser cualquiera, pero es recomendable dejarlo en 3000
#El debug es para que se cierre si y solo si hay una equivocacion en el codigo.
if __name__ == "__main__":
    app.run(host="0.0.0.0",port=3000, debug=True)