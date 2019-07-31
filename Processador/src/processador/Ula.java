/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processador;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class Ula{
    Memoria m = new Memoria();
    Registradores r = new Registradores();
    
    public static void decodificar(String in){
        // mov r1, r2
        in = in.replace(",","");
        String[] a = in.split(" ");
        
        switch(a[0]){
            case "ADD":
                
            break;
            case "MOV":
                
            break;
            case "SUB":
                
            break;
            default:
                System.out.println("LOL");
            break;
        }
        
        
    }
    
    public static void soma(){
        
    }
    
    public static void mover(){
        
    }
        
    public static void subtrair(){
        
    }
    
    
    public static void main(String[] args) {
        decodificar("ADD R1, R2");
    }
}
