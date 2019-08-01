/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processador;

/**
 *
 * @author Administrador
 */
public class Processador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ula a = new Ula();
        a.decodificar("ADD &0, #4");
        a.decodificar("ADD &1, #3");
        a.decodificar("ADD &0, &1");
        a.decodificar("SUB &1, &0");
    }
    
}
