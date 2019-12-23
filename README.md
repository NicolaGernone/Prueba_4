# Prueba_4
Calculadora

Para crear el api de servicios de la calculadora voy a utlizar una estructura de código con separacion de responsabilidades.
Model - Services - Controller
Constará de un objeto Model generico para lo store de los inputs. El objeto sera de tipo generico para ser mas usable a la hora de leer input y dar mas seguridad y evitar errores de lectura. He pesado a un api que se va ampliando con el tiempo insertando metodos mas complejos, necesitando una precision muy alta del dato sacado como resultado del operacón. He pensado usar un tipo BigDecimal de la libreria java.math para la clase que desarrolla los servicios que se llamarán desde el controller con llamadas de tipo POST.
No voy a utilizar librerias de java8 mas complejas por que se trata de implementar una suma y una resta, pero serían utiles con calculos mas complejos que reciben listas grandes de datos.
Voy a seguir con los pasos de creacion del projecto.

- Creo el repositorio en github, creo el projecto con el plugin de spring de eclipse. Integro el projecto en el repositorio de github y     empiezo a contruir la estructura.
- Creo el objeto generico Model -> OperationModel.
- Esta clase lleva 3 variables, dos son los inputs de entrada y una es el operador.
- No utilizo ahora el operador porque en los metodos de suma y resta uso directamente las operaciones del tipoBigDecimal como acción, pero se podria utilizar en un futuro para capturar operaciones que se repiten en calculos complejos para que se tenga traza de las mismas.
- He creado un Objeto generico de tipo T (generic types) para ver si lo adapto al tipo BigDecimal que voy a usar como tipo de resultado de los servicios.
- Creo La clase de los servicios para donde construyo los metodos de suma y resta, he elegido el tipo BigDecimal para obtener la maxima precision del decimal al utilizar numeros con coma para la calculadora. El tipo double no es tan preciso con decimales muy largos como lo que se podrían necesitar para implementación de calculos muy complejos en un futuro.
- Para capturar excepciones uso try/catch y la libreria tracer para sacar mensajes de error en el codigo de ambos metodos.
- Paso a la clase del controller donde construyo la capa de llamadas a los servicios. Utilizo un mapping de responses de SpringBoot para contruyr la url y el metodo que eligo POST porque tiene que enviar datos procesados por el servidor al front.
- Uso un template de thymeleaf para simular una calculadora.
-Termino con la clase main de spring boot para lazar la applicación.

Al compilar me doy cuenta que el objeto generico T no se puede utilizar con la clase de BigDecimal que conseguentemente no lee bien los inputs y no los traduce sacandome un error. Los imputs llegan en un formado no parseable por BigDecimal.
He cambiado entonces el objeto pasandolo a tipo Object para que los inputs se puedan parsear y pueda utilizar el tipo BigDecimal sin problemas.

# Tests

Para lost tests uso la libreria de Junit5 y he pensado desarrollar los tests sobre las llamadas de OperationControll para analizar la response de los servicios y estudiar la causistica de test.
Asi puedo analizar los datos devueltos y los tipos de errores que pueden surgir.

- Epiezo a construir los tests con las herramienta de spring boot para web-envirorment
- Llamo los metodos de la clase del controller.
- Set de los datos con los cuales quiero hacer los test y las Urls donde se apoyan.
- Empiezo los tests.
- He hecho test sobre responses positivas 200, negativas 400 y 500 por falta de headers o datos.
- He commentado los ultimos dos tests porque el asssertion resulta terminar fallido.
