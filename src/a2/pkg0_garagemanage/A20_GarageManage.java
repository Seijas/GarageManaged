package a2.pkg0_garagemanage;

import javax.swing.JOptionPane;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class A20_GarageManage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JOptionPane.showMessageDialog(null, "Bienvenido a 'Garage Managed 2000'");
        
        String userName = JOptionPane.showInputDialog("Introduzca un nombre de usuario");
        String garageName = JOptionPane.showInputDialog("Introduzca el nombre de su garaje");
        
        if(userName == null || "".equals(garageName)){
            userName = "Sujeto de pruebas";
        }
        if(garageName == null || "".equals(garageName)){
            garageName = "Micael and Seijas";
        }
        
        Garage garage = new Garage();
        
        boolean modifier = false;
        do{
            int option = JOptionPane.showOptionDialog(null, "Bienvenido a '" + garageName + "', " + userName, garageName, JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Jugar", "Ajustar dificultad", "Salir"}, null);
            
            switch(option){
                
                case 0:
                    //Empezar
                    garage.startGame();
                    break;
                
                case 1:
                    //cofigurar
                    garage.configuration();
                    break;
                
                case 2:
                    //Salir
                    int option1 = JOptionPane.showOptionDialog(null, "Seguro que desea salir?", "Saliendo por la puerta de atrás", 
                            JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[] {"Salir", "Cancelar"}, null);
                    
                    switch(option1){
                        case 0:
                            //salir
                            modifier = true;
                            break;
                        
                        case 1:
                            //cancelar
                            break;
                        
                        default:
                            //cerrar
                            modifier = true;
                            break;
                    }
                    break;
                
                default:
                    //cerrar
                    modifier = true;
                    break;
            }
            
        }while(modifier == false);
        
        
    }
    
}
