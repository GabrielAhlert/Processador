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
        for (int i = 0; i < 16; i++) {
            dados.add("");
            intrucao.add("");
        }
    }

    public ArrayList<String> getD() {
        return dados;
    }
    
    public Memoria(int tamd, int tami){
        for (int i = 0; i < tamd; i++) {
            dados.add("");
        }
        for (int i = 0; i < tami; i++) {
            intrucao.add("");
        }
    }

    public int getDados(int pos) {
        try{
            return Integer.valueOf(dados.get(pos));
        }catch(NumberFormatException ex){
            return 0;
        }
    }
    public String getInstrucao(int id){
        return this.intrucao.get(id);
    }
    
    public void setIntrucao(String[] in){
        for (int i = 0; i < in.length; i++) {
            this.intrucao.set(i, in[i]);
        }
    }
    
}
