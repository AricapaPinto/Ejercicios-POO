
public class Registrar {
    // atributos
    int documento;
    int telefono;
    String nombres;
    String apellidos;
    String direccion;
    String email;
// este es el nuevo valor que se le va asignar int documento
    public Registrar(int documento, int telefono, String nombres, String apellidos, String direccion, String email) {
        this.documento = documento;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email; 
    }
    // creo otro constructor que solo reciba el parametro de nombre
    public void imprimirCartaPresentacion(){
        System.out.println("------------------------------------------");
        System.out.println("--DATOS PERSONA");
        System.out.println("------------------------------------------");
        System.out.println("|  Documento:"+this.documento);
        System.out.println("|  Telefono:"+this.telefono);
        System.out.println("|  nombres:"+this.nombres);
        System.out.println("|  apellidos:"+this.apellidos);
        System.out.println("|  direccion:"+this.direccion);
        System.out.println("|  email:"+this.email);
        System.out.println("-------------------------------------------");
    }
   

    
}
