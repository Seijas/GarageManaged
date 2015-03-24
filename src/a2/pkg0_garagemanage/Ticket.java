package a2.pkg0_garagemanage;


/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Ticket {
    
    Cars vehicle;
    float paid;
    float rate;
    double totalTime;
    
    public Ticket(){
    }
    public Ticket(Cars vehicle){
        this.vehicle = vehicle;
        totalTime = vehicle.getTotalTime();
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
    
    public double getPaid(float rate){
        this.rate = rate;
        return totalTime*rate;
    }
    
    @Override
    public String toString(){
        return "El vehiculo con matricula " + vehicle.getMatricula() + " abandona el garage pagando satisfactoriamente " + getPaid(rate) + " por su estancia de " + vehicle.getTotalTime();
    }
    
    
    
    
    
    
    
    
}