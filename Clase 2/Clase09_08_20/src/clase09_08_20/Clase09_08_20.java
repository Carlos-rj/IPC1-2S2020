package clase09_08_20;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Clase09_08_20 {

    public static void main(String[] args) {
        // NumerosPrimos();
        // Rectangulos();
        // Vectores();   
        // Matriz();
    }
    
    public static void NumerosPrimos(){
        // Scanner, para guardar valores desde consola
        Scanner sc = new Scanner(System.in);
        int numero1;
        int numero2;
        String mensaje = "Los numeros primos del rango son: ";
        String numeros = "";
        System.out.print("Numero inicial: ");
        numero1 = sc.nextInt();
        System.out.print("Numero final: ");
        numero2 = sc.nextInt();
        // Hacemos un for, que inicia desde el numero inicial
        // Y que ira hasta el numero final, porque queremos
        // Saber los numeros primos de un rango
        for(int i = numero1; i <= numero2; i++)
        {
            // Este contador, lo usamos para la condicion de que
            // un numero primo tiene 2 multiplos unicamente
            int contador = 0;
            // Queremos recorrer todos los numeros anteriores que vamos
            // Recorriendo en el rango, entonces hacemos este for
            for(int j = 1; j<= i; j++)
            {
                // % -> 5/2 -> 2, residuo 1
                // i = 4
                // j = 1; j<4
                // 4 % 1 = 0
                // j = j + 1 = 2
                // j<4
                // 4 % 2 = 0
                // LA DIVISION MODULAR % DEVUELVE EL RESIDUO DE UNA DIVISION
                if(i%j==0)
                {
                   contador++;
                   // contador = contador+1;
                   // contador += 1;
                }
                // Para este punto, se repite el for hasta cumplir la condicion
            }
            // Saliendo del segundo for, valuamos segun la condicion
            if(contador == 2)
            {
                // En este caso se estan guardando los numeros en una variable
                // Para ser mostrados despues
                numeros = numeros + i + " ";
            }
            // Para este punto, se repite el for hasta cumplir la condicion
        }
        // Imprimimos el mensaje
        System.out.println(mensaje + numeros);
    }
    
    public static void Rectangulos(){
        // Scanner para almacenar la infromacion del teclado
        Scanner sc = new Scanner(System.in);
        int alto;
        int ancho;
        // En este caso queremos dibujar un rectangulo
        // Para eso pedimos el alto y el ancho
        System.out.print("Alto del rectangulo: ");
        alto = sc.nextInt();
        System.out.print("Ancho del rectangulo: ");
        ancho = sc.nextInt();
        // Hacemos un for para recorrer por filas
        for(int i = 0; i < alto ; i++)
        {
            // Hacemos un for para recorrer por columnas
            for(int j=0; j < ancho; j++)
            {
               // Para este punto escribira *... segun el ancho 
               // Aqui estamos recorriendo la fila actual
               // Recorriendo lo que es la columna
               System.out.print("*");
            }
            // Para este punto, escribir el salto de linea, es decir
            // Empezaremos a recorrer la siguiente linea
            // hasta que se cumpla la condicion
            System.out.println("");
        }
    }
    
    public static void Vectores(){
        Scanner sc = new Scanner(System.in);
        // VECTOR CON TAMAÑO FIJO
        int [] vector1 = new int[10]; 
        // VECTOR DECLARADO, PERO SIN TAMAÑO
        int [] vector2;
        int tamaño;
        // EN ESTE CASO SE AGREGA EL TAMAÑO DESDE EL TECLADO
        System.out.print("Ingrese el tamaño del vector: ");
        tamaño = sc.nextInt();
        vector2 = new int[tamaño];

        // For de llenado
        // Este for es para recorrer el vector unidimensional
        // Para este ejemplo queremos guardar el cuadrado de la posicion del vector
        // Recordemos que posicion es (elemento del arreglo - 1)
        // EJEMPLO: Elemento 4 -> Posicion 3
        for(int i = 0; i< tamaño; i++)
        {
            int num = i*i;
            // Para guardar un valor
            // Nombre del vector [ posicion ] = Valor
            // En este caso es i, porque estamos llenando el vector
            // i sigue siendo un numero al final de cuentas
            vector2[i] = num;
            
            // Para obtener el valor de un arreglo
            // Nombre del vector [ posicion ]
            // Si quisieramos guardarlo en una variable seria
            // Variable = Nombre del vector [ posicion ]
            System.out.print(vector2[i] + " ");
        }
        
        // Queremos modificar el valor del vector segun una posicion ingresada por teclado
        // En este caso pondremos 0 al valor que ingresemos por el teclado
        int pos;
        System.out.print("Ingrese la posicion a eliminar del vector: ");
        // Como pos es una variable entera, es decir un numero, se puede usar como indice
        pos = sc.nextInt();
        // El indice puede ser cualquier valor, media vez sea numerico.
        vector2[pos] = 0;
        
    }
    
    public static void Matriz(){
        Scanner sc = new Scanner(System.in);
        // Entre un vector y matriz no hay mucha diferencia
        // Lo que los caracteriza es la cantida de indices a evaluar
        // el indice son los [] entonces si tengo [][] son 2 indices
        // Sabemos que una matriz necesita dos indices
        // Si quisieramos un cubo, se puede hacer con tres indices [][][]
        
        // La froma de declararlo es igual, solo que con otro indice
        int [][] matriz1 = new int [10][10]; // Matriz 10 x 10
        int [][] matriz2;
        int largo;
        int ancho;
        // En este caso, queremos guardar las dimensiones desde la consola
        System.out.println("Ingrese el largo de la matriz: ");
        largo = sc.nextInt();
        System.out.println("Ingrese el ancho de la matriz: ");
        ancho = sc.nextInt();
        // Para generalizar podemos trabajarlo asi
        // El primer [] trabajara las lineas
        // El segundo [] trabajar las columnas
        matriz2 = new int[largo][ancho];
        // LLENANDO LA MATRIZ
        // A diferencia del vector
        // Es que para acceder a la posicion como tal, tenemos que usar los dos indices
        // Entonces por cada indice si quieren verlo asi, se agrega un bucle para
        // recorrerlo
        for(int i = 0; i < largo; i++)
        {
            // Para que vean como se guarda los datos en la matriz
            // En este recorrido solo obtenemos los valores de
            // Matriz[i]
            System.out.println("FILA: " + i);
            for(int j = 0; j< ancho ; j++)
            {
                // Despues de asignarle un valor
                matriz2[i][j] = j;
                // En este caso estamos viendo como funciona linea por linea
                // matriz2[0][0] == 0 - matriz2[1][0] = 0
                // matriz2[0][1] == 0 - matriz2[1][0] = 0
                // matriz2[0][2] == 0 - matriz2[1][0] = 0
                System.out.print(matriz2[i][j]);
            }
            // Al final deberia de mostrar la fila y los datos que tiene cada columan de la fila
            System.out.println("");
        }
    }
}
