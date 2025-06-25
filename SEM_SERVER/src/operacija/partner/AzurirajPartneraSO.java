/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.partner;

import domen.PoslovniPartner;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class AzurirajPartneraSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) {
        if(param == null || !(param instanceof PoslovniPartner)){
            try {
                throw new Exception("Greska parametar nije instanca Poslovnog partnera");
            } catch (Exception ex) {
                Logger.getLogger(AzurirajPartneraSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        PoslovniPartner pp = (PoslovniPartner) param;
        
        if (pp.getImePrezime() == null || pp.getImePrezime().isEmpty()) {
            try {
                throw new Exception("Greska, ime i prezime ne moze biti prazno");
            } catch (Exception ex) {
                Logger.getLogger(AzurirajPartneraSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            broker.edit((PoslovniPartner) param);
        } catch (Exception ex) {
            Logger.getLogger(AzurirajPartneraSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
