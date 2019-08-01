/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processador;

import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Registradores {
    ArrayList<String> registradores = new ArrayList<>();
    int CI = 0;
    String RI;

    public Registradores() {
        for (int i = 0; i < 8; i++) {
            this.registradores.add("");
        }
        
    }
        public Registradores(int tam) {
        for (int i = 0; i < tam; i++) {
            this.registradores.add("");
        }
        
    }
    
    
    public int getDados(int pos) {
        try{
            return Integer.valueOf(registradores.get(pos));
        }catch(NumberFormatException ex){
            return 0;
        }
    }
    
    
}
