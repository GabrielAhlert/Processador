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
public class Ula{
    Memoria m = new Memoria();
    Registradores r = new Registradores();
    RE re = new RE();
    
    public void rodar(){
        this.novaIntrucao();
        this.decodificar(re.getRI());
    }
    
    public void novaIntrucao(){
        re.setRI(m.getInstrucao(re.getCI()));
    }
    
    
    public void decodificar(String in){
        // mov r1, r2
        in = in.replace(",","");
        String[] a = in.split(" ");
        
        ArrayList temp = null;
        int tempp = 0 , numa = 0, numb = 0;
        if(a[1].contains("&")){
            try {
            tempp = Integer.valueOf(a[1].replace("&", ""));
            }catch(NumberFormatException ex){
                tempp = 0;
            }
            temp=m.dados;
            numa = getnum(a[1]);
            numb = getnum(a[2]);
        }
        
        if(a[1].contains("R")){
            try {
            tempp = Integer.valueOf(a[1].replace("R", ""));
            }catch(NumberFormatException ex){
                tempp = 0;
            }
            temp=m.dados;
            numa = getnum(a[1]);
            numb = getnum(a[2]);
        }
    
        switch(a[0]){
            case "ADD":
                soma(temp,tempp,numa,numb);
            break;
            case "MOV":
                mover(temp,tempp,numb);
            break;
            case "SUB":
                subtrair(temp,tempp,numa,numb);
            break;
            default:
                System.out.println("LOL");
            break;
        }
        
        
        System.out.println("R = "+r.registradores.toString());
        System.out.println("M = "+m.dados.toString());
        System.out.println("");
        
        
        
        
    }

    public Memoria getM() {
        return m;
    }
    public int getnum(String a){
        if(a.contains("R"))
            return r.getDados(Integer.valueOf(a.replace("R", "")));
        if(a.contains("#"))
            return Integer.valueOf(a.replace("#", ""));
        if(a.contains("&"))
            return m.getDados(Integer.valueOf(a.replace("&", "")));
        return 0;
    }
    
    
    public void soma(ArrayList x , int xn, int a, int b){
        x.set(xn, String.valueOf(a+b));
    }
    
    public void mover(ArrayList x, int xn, int a){
        x.set(xn, String.valueOf(a));
    }
        
    public void subtrair(ArrayList x, int xn, int a, int b){
        x.set(xn, String.valueOf(a-b));
    }
    
    

}
