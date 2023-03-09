public class Personas{

    // atributos 
    public String nombres;
    public String apellidos;
    public Long documento;

    // metodo constructor
    public Personas(String nombres,String apellidos,long documento){
       this.nombres=nombres;
       this.apellidos=apellidos;
       this.documento=documento;
    }
    // metodo para mostrar los datos 

    public long getDocumento(){
        return this.documento;
    }


    public void Nombre(String nombres){
        this.nombres=nombres;
    }
    public void mostrarDatos(){
        System.out.print(" Nombres: "+nombres);
        System.out.print(" Apellidos: "+apellidos);
        System.out.print(" Documento: "+documento);
        System.out.println("");
    }
    public void personal(){
        System.out.println(" Nombres: "+nombres);
        System.out.println(" Apellidos: "+apellidos);
        System.out.println(" Documento: "+documento);
    }
}