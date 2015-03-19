package a2.pkg0_garagemanage;

import java.util.Random;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Aleatory {
    
    public static String enrollment(){
        Random rnd = new Random();
        
        String number = String.valueOf(rnd.nextInt(9999));
        
        while(number.length() < 4){
            number = "0" + number;
        }
        
        char [] first = {'A', 'B', 'C', 'D', 'F', 'G', 'H', 'J'}; //no vale 'R' //8
        char [] letter = {'T', 'K', 'W', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B',
            'N', 'J', 'Z', 'S', 'V', 'H', 'L', 'C', 'R'}; //20
        
        char two = ' ';
        char three = ' ';
        char one = first[rnd.nextInt(8)];
        if (one == 'A'){
            two = letter[rnd.nextInt(19)];
        }else{
            two = letter[rnd.nextInt(20)];
            three = letter[rnd.nextInt(20)];
        }
        return String.valueOf(number) + '-' + one + two + three;
    }
    
    public static int number(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max-min)+min;
    }
    
    public static String color(String colors){
        Random rnd = new Random();
        String colorArray[] = colors.split("-");
        return colorArray[rnd.nextInt(colorArray.length)];
    }
    
    public static int vehicle_occupancy(int data){
        Random rnd = new Random();
        return (rnd.nextInt(data)+1);
    }
    
    
    
    
}
