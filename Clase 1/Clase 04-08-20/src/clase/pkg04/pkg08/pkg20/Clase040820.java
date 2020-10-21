package clase.pkg04.pkg08.pkg20;
import java.util.Scanner;


public class Clase040820 {
        
    public static void main(String[] args) {
        // El Scanner para obtener la entrada del teclado
        // Recomendacion, agreguen uno para cadenas de texto y otro para los otros tipos
        // De datos, por cuestiones del buffer para que no nos pase lo que paso en lab
        Scanner teclado = new Scanner(System.in);
        Scanner cadenas = new Scanner(System.in);
        //Comando para escribir en consolo, recuerden que pueden escribir
        //sout + tab para escribir automaticamente un println
        //println deja un salto de linea y el print es sin salto de linea
        System.out.println("Laboratorio IPC1");
        //Para declarar variables se utiliza el tipo de dato y el nombre de la variable
        //Opcionalmente se puede inicializar, pero es cuestion del programador
        int numero;
        double decimal;
        String frase;
        
        
        System.out.print("Ingrese un numero entero: ");
        numero = teclado.nextInt();
        System.out.print("Ingrese un numero con decimal: ");
        decimal = teclado.nextDouble();
        System.out.print("Ingrese frase: ");
        frase = cadenas.nextLine();
        System.out.println("-----------------------------------");
        System.out.println("El numero ingresado es: " + numero);
        System.out.println("El decimal ingresado es: " + decimal); 
        System.out.println("Frase: " + frase);
        System.out.println("");
        System.out.println("");
        // El uso de un if, veanlo como un condicional, donde se cumple la condicion
        // Hara lo que este dentro de lo contrario se ira a la otra seccion
        int nota = 0;
        System.out.println("Ingrese la nota: ");
        numero = teclado.nextInt();
        if(numero < 61){
            System.out.println("Perdio el laboratorio");
        }else if(numero > 80){
            System.out.println("Gano laboratorio con una buena nota");
        }else{
            System.out.println("Felicidades, gano el laboratorio");
        }
        
        // A diferencia del if, podemos hacer un switch case.
        // Es preferible un Switch case cuando son casos puntuales
        int caso = 0;
        System.out.println("Ingrese un numero segun el dia de la semana: ");
        caso = teclado.nextInt();
        switch(caso){
            case 1:
                System.out.println("Es el dia Lunes");
                break;
            case 2:
                System.out.println("Es el dia Martes");
                break;
            case 3:
                System.out.println("Es el dia Miercoles");
                break;
            case 4:
                System.out.println("Es el dia Jueves");
                break;
            case 5:
                System.out.println("Es el dia Viernes");
                break;
            case 6:
                System.out.println("Es el dia Sabado");
                break;
            case 7:
                System.out.println("Es el dia Domingo");
                break;
            default:
                System.out.println("No es un dia de la semana");
                break;
        }

        //Tambien lo podemos hacer con caracteres o Strings
        char letra;
        System.out.println("Ingrese una letra: ");
        // En este caso para guardar una letra podemos hacerlo con un nextLine
        // Pero para asegurar, agregamos el .charAt(0)
        // Lo que hace esto es que guarda unicamente el primer caracter
        letra = cadenas.nextLine().charAt(0);
        switch(letra){
            case 'a':
                System.out.println("Es una a minuscula");
                break;
            case 'e':
                System.out.println("Es una e minuscula");
                break; 
            case 'i':
                System.out.println("Es una i minuscula");
                break;
            case 'o':
                System.out.println("Es una o minuscula");
                break;
            case 'u':
                System.out.println("Es una u minuscula");
                break;
            default:
                System.out.println("No es una vocal minuscula");
        }

        // Uso que se le puede dar a un char
        // Si guardamos el char entre comilla simple guardamos el caracter como tal
        // Pero si guardamos el char como un numero, estamos guardando su codigo ASCII
        char letra1 = 'A';
        char letra2 = 65;
        System.out.println(letra1);
        System.out.println(letra2);
        
        // CICLOS O BUCLES
        // Podemos ver la estructura de un for, este puede ser en incremento o decremento
        // En este caso vamos a hacer un conteo desde 1 al 10 y del 10 al 1
        // tengamos claro que el primer numero indica donde inicia y el segundo donde termina
        System.out.println("");
        System.out.println("");
        System.out.println("---- Los numeros del 1 al 10 ----");
        // Todo puede variar segun la condicion, recordemos que i<11 es igual a 1<=10
        for(int i=1; i<=10; i++){
           System.out.println("Iteracion: " + i);
        }
        System.out.println("");
        System.out.println("---- Los numeros del 10 al 1 ----");
        for(int i=10; i>0; i--){
           System.out.println("Iteracion: " + i);
        }
         
        // CICLO WHILE
        // Podria trabajar igual que un for, en este caso es cuestion del programador
        // Como quiere trabajarlo, depende de la situacion tambien.
        // Ojo, recordemos que el while no tiene iterador entonces es una condicion
        // Que como programador debemos de reconocer antes de hacer un while
        // Si no, se puede enciclar

        int inicio, fin;
        System.out.println("");
        System.out.println("Se quiere saber los numeros en un rango de numeros");
        System.out.print("Ingrese el numero inicial: ");
        inicio = teclado.nextInt();
        System.out.print("Ingrese el numero final: ");
        fin = teclado.nextInt();

        while(inicio <= fin){
            System.out.print(inicio + "-");
            inicio++;
        }
  
        System.out.println("");
        System.out.println("----------------------------------------------");
        // EL USO DE UN DO WHILE, PARA HACER UN MENU
        // Sabemos que el Do While, va a ejecutar una opcion al menos una vez,
        // Entonces es perfecto para hacer un menu
        // La estructura del menu quedaria asi.
        
        // Usamos una variable para guardar la opcion, podriamos hacerlo con
        // Un numero o un caracter, los dos son validos
        int opcion = 0;
        do{
            System.out.println("1. Sumar dos numeros");
            System.out.println("2. Sumar dos numeros con una funcion");
            System.out.println("3. Rango de numeros");
            System.out.println("4. Rango de numeros con parametros");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = teclado.nextInt();
            // En este caso, como son opciones puntuales, se puede hacer el
            // Uso de un Switch Case, pero es valido hacerlo con un ifs anidados
            switch (opcion) {
                case 1:
                    {
                        // Recordemos que dentro de cada opcion es un ambito nuevo
                        // Entonces el codigo dentro de este if, no es valido para el siguiente if
                        // Pero lo que esta arriba si es valido.
                        int n1 = 5;
                        int n2 = 10;
                        int resultado = n1 + n2;
                        System.out.println("Se hara la suma de 5 + 10");
                        System.out.println("Resultado: " + resultado);
                        break;
                    }
                case 2:
                    {
                        int n1, n2;
                        double resultado, resta;
                        System.out.print("Ingrese el primer numero: ");
                        n1 = teclado.nextInt();
                        System.out.print("Ingrese el segundo numero: ");
                        n2 = teclado.nextInt();
                        resultado = SumaDosNumeros(n1, n2);
                        resta = RestaDosNumeros(n1, n2);
                        System.out.println("El resultado es: " + resultado);
                        // es lo mismo que decir
                        System.out.println("El resutlado es: " + SumaDosNumeros(n1,n2));
                        break;
                    }
                case 3:
                    // Podriamos facilmente venir y agregar el codigo que tenemos arriba
                    // Ya que programamos como encontrar el rango de numeros y es valido
                    // Pero para esta ocasion, podemos hacer uso de metodos
                    // Ya con el metodo declarado, entonces podemos mandar a llamarlo
                    // En este caso, como estamos trabajando con un metodo static
                    // Las llamadas tienen que ser static tambien
                    RangoNumeros();
                    break;
                case 4:
                    {
                        int n1, n2;
                        System.out.println("");
                        System.out.println("Se quiere saber los numeros en un rango de numeros");
                        System.out.print("Ingrese el numero inicial: ");
                        n1 = teclado.nextInt();
                        System.out.print("Ingrese el numero final: ");
                        n2 = teclado.nextInt();
                        RangoNumeros2(n1, n2);
                        break;
                    }
                case 5:
                    System.out.println("Gracias por usar el programa");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion != 5);
    }

    // LOS METODOS SE DEBEN DE DECLARA FUERA DEL METODO MAIN
    // Recordemos que un Metodo no tiene retorno, entonces es tipo void.
    
    // METODOO SIN PARAMETROS
    public static void RangoNumeros(){
        // En este metodo no existe un Scanner, por lo tanto se vuelve a declarar
        Scanner sc = new Scanner(System.in);
        int inicio, fin;
        System.out.println("");
        System.out.println("Se quiere saber los numeros en un rango de numeros");
        System.out.print("Ingrese el numero inicial: ");
        inicio = sc.nextInt();
        System.out.print("Ingrese el numero final: ");
        fin = sc.nextInt();

        while(inicio <= fin){
            System.out.print(inicio + "-");
            inicio++;
        }
        System.out.println("--------------------------");
    }

    // METODO CON PARAMETROS
    public static void RangoNumeros2(int inicio, int fin){
        // De esta forma, podemos usar las variables inicio y fin, porque fueron 
        // declaradas a la hora de crear el metodo y los valores se declaran a la hora de
        // llamar el metodo
        while(inicio <= fin){
            System.out.print(inicio + "-");
            inicio++;
        }
        System.out.println("");
        System.out.println("--------------------------");
    }

    // FUNCIONES
    // A diferencia de los metodos, estos trabajan con un return
    // El return es el valor que toma esta funcion, veanlo asi
    // La funcion sera una variable que ejecuta un codigo y el resultado
    // Se manda por medio de un return
    // En este caso, no trabajamos con void, si no que trabajamos con el tipo
    // De dato que queremos utilizar, por ejemplo para una operacion aritmetica
    public static double SumaDosNumeros(int numero1, int numero2){
        double resultado = numero1 + numero2;
        return resultado;
        // Si se dan cuenta en el return, estamos retornando un double
    }
        
    public static double RestaDosNumeros(int numero1, int numero2){
        return numero1 - numero2;
    }
}
