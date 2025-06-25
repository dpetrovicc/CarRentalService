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
public class DodajKolaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) {
        if(param == null || !(param instanceof Kola)){
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                System.out.println("Greska u DodajKolaSO");
                Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Kola k = (Kola) param;
        if(k.getMarka() == null || k.getMarka().isEmpty()){
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                System.out.println("Greska u DodajKolaSO");
                Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(k.getModel()== null || k.getModel().isEmpty()){
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                System.out.println("Greska u DodajKolaSO");
                Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(k.getCena() < 0 || (String.valueOf(k.getCena())).isEmpty()){
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                System.out.println("Greska u DodajKolaSO");
                Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(k.getKilometraza()< 0 || (String.valueOf(k.getKilometraza())).isEmpty()){
            try {
                throw new Exception("Sistem ne može da doda kola");
            } catch (Exception ex) {
                System.out.println("Greska u DodajKolaSO");
                Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            broker.add((Kola) param);
        } catch (Exception ex) {
            System.out.println("Greska u DodajKolaSO");
            Logger.getLogger(DodajKolaSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
