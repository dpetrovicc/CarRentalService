/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.partner;

import domen.PoslovniPartner;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiPartneraSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) {
        if (param == null || !(param instanceof PoslovniPartner)) {
            try {
                throw new Exception("Sistem ne moze da obrise poslovnog partnera");
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(ObrisiPartneraSO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) {
        try {
            broker.delete((PoslovniPartner)param);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(ObrisiPartneraSO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
