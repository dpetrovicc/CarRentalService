/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kola;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabeleKola extends AbstractTableModel{

    List<Kola> lista = new ArrayList<>();
    String[] kolone = {"idKola", "marka", "model", "kilometraza", "cena"};

    public ModelTabeleKola(List<Kola> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kola k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIdKola();
            case 1:
                return k.getMarka();
            case 2:
                return k.getModel();
            case 3:
                return k.getKilometraza();
            case 4:
                return k.getCena();
            default:
                return "NA";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Kola> getLista() {
        return lista;
    }

    public void setLista(List<Kola> lista) {
        this.lista = lista;
    }
    
    
    
    
}
