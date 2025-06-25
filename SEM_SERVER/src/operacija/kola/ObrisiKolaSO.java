/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kola;

import domen.Kola;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiKolaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) {
        if(param == null || !(param instanceof Kola)){
            try {
                throw new Exception("Sistem ne moze da obrise kola");
            } catch (Exception ex) {
                Logger.getLogger(ObrisiKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            broker.delete((Kola) param);
        } catch (Exception ex) {
            Logger.getLogger(ObrisiKolaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
