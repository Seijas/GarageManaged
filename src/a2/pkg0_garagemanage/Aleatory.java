package a2.pkg0_garagemanage;

import java.util.Random;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Aleatory {
    
    /**
     * Metodo de generacion aleatoria de matriculas de coches
     * aleatory generation method of enrollments
     * @return generated enrollment
     */
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
    
    /**
     * Metodo de generacion aleatoria de numero entero
     * aleatory generation method of integer number
     * @param min rango minimo a introducir
     * @param max rango maximo a introducir
     * @return aleatory number entre min y max
     */
    public static int number(int min, int max){
        Random rnd = new Random();
        return rnd.nextInt(max-min)+min;
    }
    
    /**
     * Metodo de generacion aleatorio de colores
     * aleatory generation method of colors
     * @param colors lista de colores 
     * @return aleatory color of the list of colors
     */
    public static String color(String colors){
        Random rnd = new Random();
        String colorArray[] = colors.split("-");
        return colorArray[rnd.nextInt(colorArray.length)];
    }
    
    /**
     *Metodo de generacion aleatoria de un numero de ocupacion de un vehiculo
     * aleatory generation method of vehicle occupancy 
     * @param data dato de ocupacion del vehiculo
     * @return aleatory integer numbre of occupancy
     */
    public static int vehicle_occupancy(int data){
        Random rnd = new Random();
        return (rnd.nextInt(data)+1);
    }
    
    
    
    
}
