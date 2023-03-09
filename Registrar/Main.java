import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner numero=new Scanner(System.in);
        Scanner texto=new Scanner(System.in);
        int opcion=0;
        int registros=0;
        Personas datos[]=new Personas[5];
        do {
            System.out.println("||----------------------------------         ||");
			System.out.println("||------------ PERSONAS ------------         ||");
			System.out.println("||----------------------------------         ||");
			System.out.println("||------- Clientes Registradas:          "+((registros<10)? "0":"")+registros+" -||");
			System.out.println("||                                           ||");
			System.out.println("||   1. Registrar cliente.                   ||");
			System.out.println("||   2. Ver clientes registrados.            ||");
			System.out.println("||   3. Modificar informacion del cliente .  ||");
			System.out.println("||   4. Ver informacion cliente.             ||");
			System.out.println("||   5. Eliminar cliente.                    ||");
			System.out.println("||   6.Salir .                               ||");
			System.out.println("||                                           ||");
			System.out.println("||-------------------------------------------||");
			System.out.print("||=> Ingrese una opcion: ");
			opcion = numero.nextInt(); 
            if(opcion==1){
                System.out.println("Ingrese sus nombres");
                String nombre=texto.nextLine();
                System.out.println("Ingrese sus apellidos");
                String apellidos=texto.nextLine();
                System.out.print("Ingrese su documento");
                Long documento=numero.nextLong();
                Personas temporal=new Personas(nombre, apellidos, documento);
                boolean valido=true;

                for(int i=0;i<registros;i++){
                    if(temporal.documento==datos[i].getDocumento()){
                        valido=false;
                        System.out.println("||===> EL DOCUMENTO YA EXISTE, NO SE PUEDE REGISTRAR. \n\n");
                        break;
                    }
                }
                if(valido==true){
                    datos[registros]=temporal;
                    registros++;
                     System.out.println("||===> REGISTRADO CON EXITO. \n\n");
                }
            }else if(opcion==2){
                for(int i=0;i<registros;i++){
                    datos[i].mostrarDatos();
                }
            }else if (opcion==3){
                 // mostramos todos los clientes registrado y le pedimos que escriba el documento que desea ver
                for (int i=0;i<registros ;i++ ) {
                    datos[i].mostrarDatos();
                }
                System.out.print("Ingrese el documento del cliente a modificar:");
                int number_cliente=numero.nextInt();
                boolean encontrado=false;
                int posicion=0;
                for (int j=0;j<registros ;j++ ) {
                    if(number_cliente==datos[j].documento){
                        encontrado=true;
                        posicion=j;
                        break;
                    }else{
                        encontrado=false;
                    }
                }
                if(encontrado==false){
                    System.out.println("EL documento ingresado no se encuentra");
                }else{
                    datos[posicion].mostrarDatos();
                    System.out.println("INGRESE EL DATO QUE DESEA MODIFICAR:");
                    int entrada=3;
                    // Personas validar=new Personas(nombre, apellidos, documento);
                    while(entrada<=3){
                        System.out.println("1.NOMBRES:");
                        System.out.println("2.APELLIDOS");
                        System.out.println("3.DOCUMENTO");
                        System.out.println("4.SALIR");
                        System.out.println("Ingrese opcion:");
                        int cambio=numero.nextInt();
                        if(cambio==1){
                            System.out.println("Ingrese el nuevo nombre que desea agregar");
                            String nombre_nuevo=texto.nextLine();
                            datos[posicion].Nombre(nombre_nuevo);
                            System.out.println("=> NOMBRE CAMBIADO CON EXITO :)");
                        }else if(cambio==2){
                            System.out.println("Ingrese los nuevos apellidos");
                            String apellidos_nuevos=texto.nextLine();
                            datos[posicion].apellidos=apellidos_nuevos;
                            System.out.println("=> APELLIDOS CAMBIADOS CON EXITO :)");
                        }else if(cambio==3){
                            System.out.println("Ingrese el nuevo documento que desea agregar");
                            Long nuevo_documento=numero.nextLong();
                            boolean cambio_invalido=false;
                            for(int i=0;i<registros;i++){
                                if(datos[i].getDocumento()==nuevo_documento){
                                 cambio_invalido=true;
                                }
                            }
                            if(cambio_invalido==false){
                                System.out.println("=> DOCUMENTO CAMBIADO CON EXITO :)");
                                datos[posicion].documento=nuevo_documento;
                            }else{
                                System.out.println("||===> EL DOCUMENTO YA EXISTE, NO SE PUEDE REGISTRAR. \n\n");
                            }
                        }else if(cambio==4){
                            entrada=4;

                        }else{
                            entrada=3;
                        }
                    }
                }   
            }else if(opcion==4){
                // toca mostrar la informacion y mostrar depediendo del documento todos los datos de ese documento
                for(int i=0;i<registros;i++){
                    datos[i].mostrarDatos();
                }
                System.out.println("Ingrese el documento el cual dese ver la informacion");
                long leer_doc=numero.nextLong();
                boolean doc_encontrado=false;
                int posicion=0;
                for(int i=0;i<registros;i++){
                    if(leer_doc==datos[i].documento){
                        doc_encontrado=true;
                        posicion=i;
                        break;
                    }
                }
                if(doc_encontrado){
                    datos[posicion].personal();
                }else{
                    System.out.println("El documento ingresado no se encuentra en nuestra base de datos");
                }
            }else if(opcion==5){
                for(int i=0;i<registros;i++){
                    datos[i].mostrarDatos();
                }
                System.out.println("Ingrese el documento de la persona registrada la cual dese eliminar");
                long delete_document=numero.nextLong();

                int posicion_a_eliminar=0;
                boolean encontrado_position=true;
                for (int i=0;i<registros ;i++ ) {
                    if(delete_document==datos[i].getDocumento()){
                        posicion_a_eliminar=i;
                        encontrado_position=false;
                    }
                }
                if(encontrado_position==false){
                    for (int j=posicion_a_eliminar;j<datos.length-1; j++) {
                        datos[j] = datos[j + 1];
                    }
                    System.out.println("||===> ELIMINADO CON EXITO \n\n");
                    registros--;
                }else{
                    System.out.println("||===> NUMERO DE IDENTIDAD NO ENCONTRADA \n\n");
                }
            }
        } while (opcion!=6);
    }
}
