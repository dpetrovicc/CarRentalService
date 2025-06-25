/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija;

import java.util.logging.Level;
import java.util.logging.Logger;
import repository.Repository;
import repository.db.impl.DbRepositoryGeneric;

/**
 *
 * @author User
 */
public abstract class ApstraktnaGenerickaOperacija {

    protected final Repository broker;

    public ApstraktnaGenerickaOperacija() {
        this.broker = new DbRepositoryGeneric();
    }

    public final void izvrsi(Object objekat, String kljuc) {
        try {
            preduslovi(objekat);
            zapocniTransakciju();
            izvrsiOperaciju(objekat, kljuc);
            potvrdiTransakciju();
        } catch (Exception e) {
            ponistiTransakciju();
            throw e;
        }finally{
            //ugasiKonekciju();
        }

    }

    private void zapocniTransakciju() {
        try {
            ((DbRepositoryGeneric) broker).connect();
        } catch (Exception ex) {
            Logger.getLogger(ApstraktnaGenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void potvrdiTransakciju() {
        try {
            ((DbRepositoryGeneric) broker).commit();
        } catch (Exception ex) {
            Logger.getLogger(ApstraktnaGenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ponistiTransakciju() {
        try {
            ((DbRepositoryGeneric) broker).rollback();
        } catch (Exception ex) {
            Logger.getLogger(ApstraktnaGenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ugasiKonekciju() {
        try {
            ((DbRepositoryGeneric) broker).disconnect();
        } catch (Exception ex) {
            Logger.getLogger(ApstraktnaGenerickaOperacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    protected abstract void preduslovi(Object param);

    protected abstract void izvrsiOperaciju(Object param, String kljuc);

}
