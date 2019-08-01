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
public class Memoria {
    ArrayList<String> dados = new ArrayList();
    ArrayList<String> intrucao = new ArrayList();
    
    public Memoria(){
        for (int i = 0; i < 32; i++) {
            dados.add("0");
            intrucao.add("");
        }
    }

    public int getDados(int pos) {
        return Integer.valueOf(dados.get(pos));
    }
    
    
}
