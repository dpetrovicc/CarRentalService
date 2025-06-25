/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kola;

import domen.Kola;
import domen.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class UcitajKolaSO extends ApstraktnaGenerickaOperacija {
    List<Kola> svaKola;
    
    @Override
    protected void preduslovi(Object param) {
        if(param == null || !(param instanceof Zaposleni)){
            try {
                throw new Exception("Koirsničko ime i šifra nisu ispravni");
            } catch (Exception ex) {
                Logger.getLogger(ObrisiKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            svaKola = broker.getAll(new Kola(), "");
        } catch (Exception ex) {
            System.out.println("Greska u ucitajKolaSO");
            ex.printStackTrace();
            Logger.getLogger(UcitajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Kola> getSvaKola() {
        return svaKola;
    }

    public void setSvaKola(List<Kola> svaKola) {
        this.svaKola = svaKola;
    }
    
    
    
}
