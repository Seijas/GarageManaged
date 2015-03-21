package a2.pkg0_garagemanage;


/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Ticket {
    
    Cars vehicle;
    double paid;
    float rate;
    double totalTime;
    
    public Ticket(){
    }
    public Ticket(Cars vehicle){
        this.vehicle = vehicle;
    }
    
    public void setRate(float rate){
        this.rate = rate;
    }
    public float getRate(){
        return rate;
    }
    
    public void setTotalTime(double totalTime){
        this.totalTime =  totalTime;
    }
    public double getTotalTime(){
        return totalTime;
    }
    
    public double getPaid(){
        return totalTime*rate;
    }
    
    @Override
    public String toString(){
        return "El vehiculo con matricula " + vehicle.getMatricula() + " abandona el garage pagando satisfactoriamente " + getPaid() + " por su estancia de " + vehicle.getTotalTime();
    }
    
    
    
    
    
    
    
    
}