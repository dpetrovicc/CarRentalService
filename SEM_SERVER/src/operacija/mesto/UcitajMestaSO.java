/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.mesto;

import domen.Mesto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;
import operacija.partner.UcitajPartnereSO;

/**
 *
 * @author User
 */
public class UcitajMestaSO extends ApstraktnaGenerickaOperacija {

    List<Mesto> svaMesta;
    
    @Override
    protected void preduslovi(Object param) {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            svaMesta = broker.getAll(new Mesto(), "");
        } catch (Exception ex) {
            System.out.println("Greska u ucitajMestaSO");
            ex.printStackTrace();
            Logger.getLogger(UcitajMestaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Mesto> getSvaMesta() {
        return svaMesta;
    }

    public void setSvaMesta(List<Mesto> svaMesta) {
        this.svaMesta = svaMesta;
    }
    
    
    
}
