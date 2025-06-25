/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Mesto;
import domen.PoslovniPartner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class ModelTabelePoslovniPartner extends AbstractTableModel {

    List<PoslovniPartner> lista = new ArrayList<>();
    String[] kolone = {"ID", "Ime i prezime", "Mesto"};

    public ModelTabelePoslovniPartner(List<PoslovniPartner> lista) {
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
        PoslovniPartner pp = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return pp.getIdPoslovniPartner();
            case 1:
                return pp.getImePrezime();
            case 2:
                return pp.getMesto().getNaziv();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<PoslovniPartner> getLista() {
        return lista;
    }

    public void setLista(List<PoslovniPartner> lista) {
        this.lista = lista;
    }

    public void pretrazi(String imePrezime, Mesto m) {
    List<PoslovniPartner> filteredList = lista.stream()
        .filter(pp -> imePrezime == null || imePrezime.isEmpty() || 
                      pp.getImePrezime().toLowerCase().contains(imePrezime.toLowerCase()))
        .filter(pp -> m == null || pp.getMesto().equals(m)) 
        .collect(Collectors.toList());
    
    this.lista = filteredList;
    fireTableDataChanged();
}

    
    
    
    
}
