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
public class DodajPartneraSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) {
        if(param == null || !(param instanceof PoslovniPartner)){
            try {
                throw new Exception("Sistem ne može da kreira poslovnog partnera");
            } catch (Exception ex) {
                Logger.getLogger(DodajPartneraSO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            broker.add((PoslovniPartner)param);
        } catch (Exception ex) {
            Logger.getLogger(DodajPartneraSO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
