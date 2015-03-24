package a2.pkg0_garagemanage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Methods {
    public static String[] readCars(){
        
        String fileCars = "src/files/cars";
        FileReader fr = null;
        
        try {
            fr = new FileReader(new File (fileCars));
            BufferedReader br = new BufferedReader(fr);
            
            String line ="";
            int counter = 0;
            int datum = Aleatory.number(0, Methods.countLines(fileCars));  //Generar numero entre uno y otro, debe quedar 0 y el numero de lineas del archivo a leer
            
            while(((line=br.readLine())!= null) && counter<=datum){
                String lineArray[] = line.split(". ");
                counter++;
                if(counter>datum){
                    return lineArray;
                }
            }
            return null;
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error;\nAlgo falló al intentar leer el fichero");
            return null;
        }finally{
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public static String[] readDailyTasks(){
        String fileDailyTasks = "src/files/dailyTasks";
        FileReader fr = null;
        
        try {
            fr = new FileReader(new File (fileDailyTasks));
            BufferedReader br = new BufferedReader(fr);
            
            int counter = 0;
            int datum = Aleatory.number(0, Methods.countLines(fileDailyTasks));
            String line ="";
            
            while(((line=br.readLine())!= null) && counter<=datum){
                
                String lineArray[] = line.split("---");
		
                counter++;
                if(counter>datum){
                    return lineArray;
                }
            }
            return null;
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error;\nAlgo falló al intentar leer el fichero");
            return null;
        }finally{ 
            try{                    
                if( null != fr ){   
                   fr.close();
                  
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public static boolean canEnter(Cars vehicle, String[] dailyTask){
        
        for(int counter=2; counter<dailyTask.length; counter++){
            String [] tasks = dailyTask[counter].split(",");
            for(int i=0; i<tasks.length; i++){
                if(vehicle.toCompare().contains(tasks[i])){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static int countLines(String nameFile){
        FileReader fr = null;
        try {
            fr = new FileReader(new File (nameFile));
            BufferedReader br = new BufferedReader(fr);
            int counter = 0;
            while(br.readLine()!= null){
                counter++;
            }
            return counter;
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error;\nAlgo falló al intentar leer el fichero");
            return 0;
        }finally{ 
            try{                    
                if( null != fr ){   
                   fr.close();
                  
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public static boolean isInteger(String number){
	try {
		Integer.parseInt(number);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static boolean isFloat(String number){
	try {
		Float.parseFloat(number);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    public static String formatText(String text){
        String[] phrase = text.split("-");
        
        for(int i=0; i<phrase.length; i++){
            if(i!=0){
                text = text + "\n" + phrase[i];
            }else{
                text = phrase[i];
            }
        }
        
        return text;
    }
    
    public static String[] adjustDificult(String dificulty, int defaultSize, float defaultRate, int minSize, int maxSize, float minRate, float maxRate){
        
        int sizeModified = defaultSize;
        float rateModified = defaultRate;
        
        boolean modifier = false;
        
        do{
            int reply = JOptionPane.showOptionDialog(null, dificulty + ": \nTamaño: " + sizeModified + "\nTarifa: " + rateModified + "€", dificulty, JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Confirmar", "Modificar parámetros", "volver"}, null);
            
            switch(reply){
                
                case 0:
                    //Confirm
                    modifier = true;
                    break;

                case 1:
                    //Modifi params
                    boolean modifierParams = false;
                    boolean accepted;
                    do{
                        int replyParams = JOptionPane.showOptionDialog(null, "Qué desea modificar \nTamaño: " + sizeModified + "\nTarifa: " + rateModified, dificulty, 
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Tamaño", "Tarifa", "Confirmar", "Cancelar"}, null);
                        switch(replyParams){

                            case 0:
                                //Tamaño
                                accepted = false;
                                do{
                                    String datum = JOptionPane.showInputDialog("El rango de tamaño para la dificultad " + dificulty + " es:\nTamaño mínimo: " + minSize + "\nTamaño máximo: " + maxSize);
                                    if(Methods.isInteger(datum)){
                                        sizeModified = Integer.parseInt(datum);
                                        if(sizeModified<=maxSize && sizeModified>=minSize){
                                            accepted = true;
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error;\nRecuerda que no se permite introducir valores fuera del rango permitido en esta dificultad");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Sólo se permiten números enteros");
                                    }
                                }while(accepted == false);
                                modifierParams = false;
                                break;

                            case 1:
                                //Tarifa
                                accepted = false;
                                do{
                                    String datum = JOptionPane.showInputDialog("El rango de tamaño para la dificultad " + dificulty + " es:\nTarifa mínima: " + minRate + "\nTarifa máxima: " + maxRate);
                                    if(Methods.isFloat(datum)){
                                        rateModified = Float.parseFloat(datum);
                                        if(rateModified<=maxRate && rateModified>=minRate){
                                            accepted = true;
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error;\nRecuerda que no se permite introducir valores fuera del rango permitido en esta dificultad");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Sólo se permiten valores numéricos");
                                    }
                                }while(accepted == false);
                                modifierParams = false;
                                break;

                            case 2:
                                //Confirmar
                                modifierParams = true;
                                modifier = true;
                                break;

                            case 3:
                                //cancelar
                                sizeModified = defaultSize;
                                rateModified = defaultRate;
                                
                                modifierParams = true;
                                modifier = false;
                                break;

                            default:
                                sizeModified = defaultSize;
                                rateModified = defaultRate;
                                
                                modifierParams = true;
                                modifier = false;
                                break;
                        }
                    }while(modifierParams == false);
                    break;

                case 2:
                    //Retuern
                    modifier = true;
                    break;

                default:
                    modifier = true;
                    break;

            }
        }while(modifier == false);
        
        String [] values = {String.valueOf(sizeModified), String.valueOf(rateModified)};
        return values;
    }
    
    public static float porcentage(int porcentage){
        return (float) (porcentage*0.01);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Utelinsilios copia y pega
    public static void readFile(ArrayList <Cars> cars, String fileCars, String delimiter){
        
        FileReader fr = null;
        
        try {
            fr = new FileReader(new File (fileCars));
            BufferedReader br = new BufferedReader(fr);
            
            String line ="";
            
            while((line=br.readLine())!= null){
                
                String lineArray[] = line.split(delimiter);
		
            }
            
        }catch(IOException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error;\nAlgo falló al intentar leer el fichero");
        }finally{
            try{                    
                if( null != fr ){   
                   fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public static void traslate(ArrayList <Cars> cars, String fileCars){
        
        PrintWriter fw = null;
        
        try{
            fw = new PrintWriter(fileCars);
            
            int i;
            for(i=0; i<cars.size(); i++){
                fw.println(cars.get(i).toPrint());
            }
            
        }catch(FileNotFoundException ex){
            Logger.getLogger(Methods.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            fw.close();
        }
        
    }
    
    
    
}
