import java.util.Scanner;
public class Orcado{
	// atributos 
	private String palabra_secreta;
	private char palabra[];
	private boolean jugando;
	private char separar_letra[];

	// creamos el constructor

	public Orcado(){
		this.palabra_secreta="Esternocleidomastoideo";
		int cantidad=this.palabra_secreta.length();
		this.palabra=new char[cantidad];
		this.jugando=true;
		this.llenarAreglo();
		this.separar_letra=new char[cantidad];
		this.palabra_secre();
	}
	public void  palabra_secre(){
		for (int i=0;i<this.separar_letra.length ;i++ ) {
			separar_letra[i]=this.palabra_secreta.charAt(i);
		}
	}
	public void llenarAreglo(){
		for (int i=0;i<this.palabra.length ;i++) {
			palabra[i]='-';
		}
	}
	public void mostrarAreglo(){
		for (int i=0;i<this.palabra.length ;i++) {
			System.out.print(this.palabra[i]);
		}
		System.out.println("");
	}
	// metodo para validar  si la palabra esta ahi o no
	public boolean validarLetra(char letra){
		for (int j=0;j<this.palabra.length ;j++ ) {
			if(Character.toLowerCase(letra) == Character.toLowerCase(this.separar_letra[j])){
				return true;
			}
		}
		return false;
	}
	public void guardarLetra(char letra){
		int posicion=0;
		for (int j=0;j<this.palabra.length ;j++ ) {
			if(Character.toLowerCase(letra) == Character.toLowerCase(this.separar_letra[j])){
				posicion=j;
				this.palabra[posicion]=letra;
			}
		}
	}
	public void run(){
		Scanner entrada=new Scanner(System.in);
		do{
			this.mostrarAreglo();
			// ahora le pedimos que ingrese una letra 
			System.out.println("==>INGRESE UNA LETRA:");
			char letra=entrada.next().charAt(0);

			if(this.validarLetra(letra)){
				this.guardarLetra(letra);
			}else{
				jugando=true;
			}
			// aqui validamos si el areglo es igual que la palabra si es igual automaticamente se saldra sino continuara preguntad
			String unir_letras=String.copyValueOf(this.palabra);
			if(this.palabra_secreta.equalsIgnoreCase(unir_letras)){
                System.out.println("==>LA PALABRA SECRETA A SIDO ADIVINADA FELICIDADES :)");
                jugando=false;
            }
		}while(jugando);
		// ahora le mostramos la cantidad de intento que tuvo al poder reolver la palabra secreta 
	}
}