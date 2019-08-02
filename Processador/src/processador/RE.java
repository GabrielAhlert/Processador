/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processador;

/**
 *
 * @author gabri
 */
public class RE{ //Registradores Especiais
    String RI = "";
    int CI = 0;
    
    public String[] getDados(){
        String[] a ={RI , String.valueOf(CI)};
        return a;
    }
    
    public String getInstrucao(){
        return RI;
    }
    
    public String getRI() {
        this.CI++;
        return RI;
    }

    public void setRI(String RI) {
        this.RI = RI;
    }

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }
    
    public void resetCI(){
        CI = 0;
    }
    
}
