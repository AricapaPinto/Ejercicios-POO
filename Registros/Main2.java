import java.util.Scanner;
import java.io.IOException;
public class Main2 {
    public static void main(String[] args) {
        // para cambiar color a la consola
        try{new ProcessBuilder("cmd","/c","color 7d").inheritIO().start().waitFor();}catch(Exception e){}
        
        Scanner numero = new Scanner(System.in);
        Scanner texto = new Scanner(System.in);
        // creamos el contador para saber la cantidad de personas registradas
        boolean registar = true;
        
        // Registrar aux=new Registrar(0, 0, "", "", "", "");
        int cont_documento = 0;
        Registrar lista[] = new Registrar[5];
        int document_user[] = new int[5];
        while (registar) {
            try{new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();}catch(Exception e){}
            System.out.println("|| ----------------------------------------------||");
            System.out.println("|| ------------------ PERSONAS ----------------- ||");
            System.out.println("||                     Personas Registradas:     " + cont_documento);
            System.out.println("||                                               ||");
            System.out.println("|| 1. Registrar Persona.                         ||");
            System.out.println("|| 2. Ver listas de personas.                    ||");
            System.out.println("|| 3. Ordenar listas de personas.                ||");
            System.out.println("|| 4. Salir.                                     ||");
            System.out.print("Ingrese opcion:");
            int opcion = numero.nextInt();
            if (opcion == 1) {
                System.out.println("Ingrese Documento");
                int documento = numero.nextInt();
                System.out.println("Ingrese telefono");
                int telefono = numero.nextInt();
                System.out.println("Ingrese nombres");
                String nombres = texto.nextLine();
                System.out.println("Ingrese apellidos");
                String apellidos = texto.nextLine();
                System.out.println("Ingrese direccion");
                String direccion = texto.nextLine();
                System.out.println("Ingrese email");
                String email = texto.nextLine();
                // el primer areglo solo recibe una parametro del constructo nombre
                document_user[cont_documento] = documento;
                // el segundo recibe el otro constructor con todos los datos del usuario
                // null signifca que hay algo pero no existe nada 
                lista[cont_documento] = new Registrar(documento, telefono, nombres, apellidos, direccion, email);
                cont_documento++;
            } else if (opcion == 2) {
                for (int i = 0; i < cont_documento; i++) {
                    if (lista[i] != null) {
                        lista[i].imprimirCartaPresentacion();
                    }
                }

            } else if (opcion == 3) {
               
                for (int i = 1; i < cont_documento; i++) {
                    for (int j = 0; j < cont_documento - 1; j++) {
                        if (lista[j].documento > lista[j + 1].documento) {
                            Registrar aux=lista[j];
                            lista[j] = lista[j + 1];
                            lista[j + 1] =aux;
                        }
                    }
                }
                for (int i = 0; i < lista.length; i++) {
                    if (lista[i] != null) {
                        lista[i].imprimirCartaPresentacion();
                    }
                }

            }
        }
    }
}
