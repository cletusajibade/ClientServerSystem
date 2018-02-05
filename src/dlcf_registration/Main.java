/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dlcf_registration;

import javax.swing.JFrame;

/**
 *
 * @author AJIBADE
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationServer().setVisible(true);
            }
        });
    }

}
