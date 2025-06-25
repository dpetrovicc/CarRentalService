/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Mesto;
import domen.PoslovniPartner;
import forme.PrikazPoslovniPartnerForma;
import forme.model.ModelTabelePoslovniPartner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;

/**
 *
 * @author User
 */
public class PrikazPoslovniPartnerController {
    private final PrikazPoslovniPartnerForma pppf;

    public PrikazPoslovniPartnerController(PrikazPoslovniPartnerForma pppf) {
        this.pppf = pppf;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        pppf.setVisible(true);
    }

    private void pripremiFormu() {
        List<PoslovniPartner> partneri = Komunikacija.getInstance().ucitajPartnere();
        System.out.println("Lista parnera pppc: " + partneri);
        ModelTabelePoslovniPartner mtpp = new ModelTabelePoslovniPartner(partneri);
        pppf.getjTablePoslovniPartner().setModel(mtpp);
        
    }

    private void addActionListener() {
        pppf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selektovaniRed = pppf.getjTablePoslovniPartner().getSelectedRow();
                if (selektovaniRed == -1) {
                    JOptionPane.showMessageDialog(pppf, "Nije selektovan red", "Greska red", JOptionPane.ERROR_MESSAGE);
                } else{
                    ModelTabelePoslovniPartner mtpp = (ModelTabelePoslovniPartner) pppf.getjTablePoslovniPartner().getModel();
                    PoslovniPartner pp = mtpp.getLista().get(selektovaniRed);
                    try {
                        Komunikacija.getInstance().obrisiPartnera(pp);
                        JOptionPane.showMessageDialog(pppf, "Sistem je obrisao poslovnog partnera", "Uspešno", JOptionPane.INFORMATION_MESSAGE);
                        pripremiFormu();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(pppf, "Sistem ne može da obriše poslovnog partnera", "Greška", JOptionPane.ERROR_MESSAGE);                        
                    }
                }
                
            }
        });
        
        pppf.addBtnAzurirajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selektovaniRed = pppf.getjTablePoslovniPartner().getSelectedRow();
                if (selektovaniRed == -1) {
                    JOptionPane.showMessageDialog(pppf, "Nije selektovan red", "Greska red", JOptionPane.ERROR_MESSAGE);
                } else{
                    ModelTabelePoslovniPartner mtpp = (ModelTabelePoslovniPartner) pppf.getjTablePoslovniPartner().getModel();
                    PoslovniPartner pp = mtpp.getLista().get(selektovaniRed);
                    
                    Cordinator.getInstance().dodajParametar("poslovniPartner", pp);
                    Cordinator.getInstance().otvoriAzurirajPartneraFormu();
                    
                }
                
            }
        });
        
        pppf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String imePrezime = pppf.getjTextFieldImePrezime().getText().trim();
                Mesto m = (Mesto) pppf.getjComboBoxMesta().getSelectedItem();
               
                ModelTabelePoslovniPartner mtpp = (ModelTabelePoslovniPartner) pppf.getjTablePoslovniPartner().getModel();
                mtpp.pretrazi(imePrezime, m);
                
                
            }
        });
        
        pppf.addBtnOsveziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                pripremiFormu();
                
                
            }
        });
        
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
    
    
}
