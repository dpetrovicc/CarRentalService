/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.partner;

import domen.PoslovniPartner;
import domen.Zaposleni;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class UcitajPartnereSO extends ApstraktnaGenerickaOperacija{

    List<PoslovniPartner> sviPartneri;
    
    @Override
    protected void preduslovi(Object param) {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            sviPartneri = broker.getAll(new PoslovniPartner(), "");
        } catch (Exception ex) {
            System.out.println("Greska u ucitajPartnereSO");
            ex.printStackTrace();
            Logger.getLogger(UcitajPartnereSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<PoslovniPartner> getSviPartneri() {
        return sviPartneri;
    }

    public void setSviPartneri(List<PoslovniPartner> sviPartneri) {
        this.sviPartneri = sviPartneri;
    }

    
    
    
    
    
    
}
