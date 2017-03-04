/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradocesar;

import java.util.Scanner;

/**
 * @author Juan David Ojeda
 * @author Tatiana Almansa
 */
public final class CifradoCesar {

     char[]vectorLetras={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ',';',','};
     
    int clave;
    int deseo;
    char letraTexto;
    String texto= new String();
    Scanner teclado = new Scanner(System.in);
    int localizacionLetra = 0;
    int nuevaLetra;
    int longTexto;
    char [] textoDecifrado;
    char [] textoCifrado;
    
    public CifradoCesar(){
        introducirTexto();
        solicitud();
        if(deseo==1){
            cifrar();
        }else{
            decifrar();
        }
    }
    void introducirTexto(){
        System.out.print("introduca texto a cifrar:");
        texto = teclado.nextLine();
        System.out.print("introduca numero de desplasamiento:");
        clave = teclado.nextInt(); 
    }
    void solicitud(){
        System.out.println("desea cifrar(1) o decifrar(2) el texto");
        deseo = teclado.nextInt();
    }
    void cifrar(){
        longTexto = texto.length();
        textoCifrado = new char[longTexto];
        for(int i=0;i<longTexto;i++){
            letraTexto=texto.charAt(i);
            for(int j=0;j<29;j++){
                if(letraTexto==vectorLetras[j]){
                    localizacionLetra=j;               
                }
            }
            nuevaLetra = localizacionLetra+clave;
            nuevaLetra = nuevaLetra % 28;
            textoCifrado[i]=vectorLetras[nuevaLetra];
        }
        System.out.print("el texto cifrado es:");
        for(int i=0;i<longTexto;i++){
        System.out.print(textoCifrado[i]);
        }
        System.out.println("");
                
    }
    void decifrar(){
        
        longTexto = texto.length();
        textoDecifrado= new char[longTexto];
        for(int i=0;i<longTexto;i++){
            letraTexto=texto.charAt(i);
            for(int j=0;j<29;j++){
                if(letraTexto==vectorLetras[j]){
                    localizacionLetra=j;               
                }
            }
            nuevaLetra = localizacionLetra-clave;
            if(nuevaLetra<0){
                nuevaLetra=nuevaLetra*(-1);
            }
            nuevaLetra = nuevaLetra % 28;
            textoDecifrado[i]=vectorLetras[nuevaLetra];    
        }
        System.out.print("el texto decifrado es:");
        for(int i=0;i<longTexto;i++){
            System.out.print( textoDecifrado[i]);
        }
        System.out.println("");
    }    
    
    
    public static void main(String[] args) {
         CifradoCesar cifradoCesar = new CifradoCesar();
    }
}