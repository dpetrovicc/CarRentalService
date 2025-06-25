/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import cordinator.Cordinator;
import domen.Zaposleni;
import forme.GlavnaForma;

/**
 *
 * @author User
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;
    
    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void otvoriFormu() {
        Zaposleni ulogovani = Cordinator.getInstance().getUlogovani();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(ulogovani.toString());
    }
}
