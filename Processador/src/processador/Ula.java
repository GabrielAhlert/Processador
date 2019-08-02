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
    
    public void pulse(){
        if(!re.getInstrucao().contains("HALT")){
            this.novaIntrucao();
            this.decodificar(re.getRI());
        }
    }
    
    public void rodar(){
        do{
            this.novaIntrucao();
            this.decodificar(re.getRI());
        }while(!re.getInstrucao().contains("HALT"));
    }
    
    public void novaIntrucao(){
        re.setRI(m.getInstrucao(re.getCI()));
    }
    
    
    public void decodificar(String in){
        
        in = in.replace(",","");
        String[] a = in.split(" ");
        
        ArrayList temp = null;
        int tempp = 0 , numa = 0, numb = 0;
        if(a.length>1){

            if(a[1].contains("&")){
                try {
                    tempp = Integer.valueOf(a[1].replace("&", ""));
                }catch(NumberFormatException ex){
                    tempp = 0;
                }
                temp=m.dados;
                numa = getnum(a[1]);
                if(a.length>2)
                    numb = getnum(a[2]);
            }
        
            if(a[1].contains("R")){
                try {
                tempp = Integer.valueOf(a[1].replace("R", ""));
                }catch(NumberFormatException ex){
                    tempp = 0;
                }
                temp=r.registradores;
                numa = getnum(a[1]);
                if(a.length>2)
                    numb = getnum(a[2]);
            }
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
            case "JMP":
                re.getRI();
                break;
            case "GOTO":
                System.out.println(numa);
                setgoto(a[1]);
                break;
            case "JB":
                if(numa>numb)
                    re.getRI();
                break;
            case "JL":
                if(numa<numb)
                    re.getRI();
                break;
            default:
                System.out.println("Fim!");
                break;
        }
        
        
        System.out.println("R = "+r.registradores.toString());
        System.out.println("M = "+m.dados.toString());
        System.out.println("");
             
    }
    
    public void setIntrucao(String[] a){
        m.setIntrucao(a);
    }
    
    public String[] getRE(){
        return this.re.getDados();
    }

    public Memoria getM() {
        return m;
    }

    public Registradores getR() {
        return r;
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
    
    public void setgoto(String in){
        re.setCI(Integer.valueOf(in.replace("&", "")));
    }
    
    

}
