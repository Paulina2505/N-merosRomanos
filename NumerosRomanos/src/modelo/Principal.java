package modelo;
import static javax.swing.JOptionPane.*;
public class Principal {

	public static void main(String[] args) {
		int numero=0;
		do {
			numero=Integer.parseInt(showInputDialog("Ingrese un número entre 1 a 1000"));
			if (numero<1 || numero>1000) {
				showMessageDialog(null, "No ingresaste un valor valido\nfavor de ingresar un número valido");
			}
		} while (numero<1 || numero>1000);
		String numeroRomano=romano(numero);
		showMessageDialog(null, "El número "+numero+" en su representación romana es: "+numeroRomano);
	}
	
	static String romano(int numero){
		String resultado="";
		int n1=numero/100%10;
		int n2=numero/10%10;
		int n3=numero%10;
		String num=String.valueOf(numero);
		int tamaño=num.length();
		if (numero>1 && numero<1000) {
			if (tamaño==3) {
				if(numero>=900){
					resultado+="CM";
					numero-=900;
				}
				else if(numero>=500){
					resultado+="D";
					for (int i = 5; i < n1; i++) {
						resultado+="C";
						numero-=100;
					}
					numero-=500;
				}
				else if(numero>=400){
					resultado+="CD";
					numero-=400;
				}
				else {
					for (int i = 0; i < n1; i++) {
						resultado+="C";
						numero-=100;
					}
				}
				tamaño-=1;
			}
			if (tamaño==2) {
				if(numero>=90){
					resultado+="XC";
					numero-=90;
				}
				else if(numero>=50){
					resultado+="L";
					for (int i = 5; i < n2; i++) {
						resultado+="X";
						numero-=10;
					}
					numero-=50;
				}
				else if(numero>=40){
					resultado+="XL";
					numero-=40;
				}
				else {
					for (int i = 0; i < n2; i++) {
						resultado+="X";
						numero-=10;
					}
				}
				tamaño-=1;
			}
			if (tamaño==1) {
				if(numero>=9){
					resultado+="IX";
					numero-=9;
				}
				else if(numero>=5){
					resultado+="V";
					for (int i = 5; i < n3; i++) {
						resultado+="I";
						numero-=1;
					}
					numero-=5;
				}
				else if(numero>=4){
					resultado+="IV";
					numero-=40;
				}
				else {
					for (int i = 0; i < n3; i++) {
						resultado+="I";
						numero-=1;
					}
				}
				tamaño-=1;
			}
		}
		else if (numero==1) 
			resultado="I";
		else
			resultado="M";
		return resultado;
	}

}
