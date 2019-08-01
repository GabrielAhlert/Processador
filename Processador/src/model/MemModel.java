/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.AbstractTableModel;
import processador.Memoria;

/**
 *
 * @author Windows
 */
public class    MemModel extends AbstractTableModel {

    Memoria m = new Memoria();
    String[] Colunas={"Endereço","Valores"};
    
    @Override
    public int getRowCount() {
        return m.getD().size();
    }

    @Override
    public int getColumnCount() {
        return Colunas.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch (i){
            case 0:
                return "&"+String.valueOf(i1);
            case 1:
                return m.getDados(i1);
        }
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return this.Colunas[i];
    }

    public void setM(Memoria m) {
        this.m = m;
    }
    
    
}
