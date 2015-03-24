package a2.pkg0_garagemanage;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Garage {
    ArrayList <Cars> cars = new ArrayList();
    ArrayList <Ticket> ticket = new ArrayList();
    
    private int size;
    private float rate;
    private int places_available = size-cars.size();
    
    public Garage(){
        this.size = 100;
        this.rate = (float) 0.75;
    }
    public Garage(int size, float rate, int places_available){
        this.size = size;
        this.rate = rate;
        this.places_available = places_available;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    public void setRate(float rate){
        this.rate = rate;
    }
    public void setPlaces(int places){
        this.places_available = places;
    }
    
    public int getSize(){
        return size;
    }
    public float getRate(){
        return rate;
    }
    public int getPlaces(){
        return places_available;
    }
    
    
    public void configuration(){
        
        String[] values;
        
        String dificulty = (String) JOptionPane.showInputDialog(null, "Elija una dificultad", "Dificultad", 
                JOptionPane.YES_NO_OPTION, null, new Object[] {"Fácil", "Difícil", "Veterano"}, "Difícil");
                    
        switch(dificulty){
            case "Fácil":
                values= Methods.adjustDificult(dificulty, 50, 1, 10, 65, (float) 0.86, (float) 1.15);
                //String dificulty, int defaultSize, float defaultRate, int minSize, int maxSize, float minRate, float maxRate
                this.size = Integer.parseInt(values[0]);
                this.rate = Float.parseFloat(values[1]);
                break;
            
            case "Difícil":
                values= Methods.adjustDificult(dificulty, 100, (float) 0.75, 65, 175, (float) 0.66, (float) 0.86);
                
                this.size = Integer.parseInt(values[0]);
                this.rate = Float.parseFloat(values[1]);
                break;
            
            case "Veterano":
                values= Methods.adjustDificult(dificulty, 200, (float) 0.55, 175, 500, (float) 0.10, (float) 0.66);
                
                this.size = Integer.parseInt(values[0]);
                this.rate = Float.parseFloat(values[1]);
                break;
                
            default:
                break;
        }
    }

    
    public void startGame(){
        
        int fail;
        double start_time;
        boolean stop = false;
        boolean brokeTime = true;
        boolean modifier = false;
        
        do{
            start_time = (System.currentTimeMillis()/1000);
                        
            //leer desde fichero tarea diaria
            String dailyTask[] = Methods.readDailyTasks();
            
            JOptionPane.showMessageDialog(null, Methods.formatText(dailyTask[1]));
            fail = 0;
            
            do{
                this.take_out_car();
                
                //generacion de coches
                Cars vehicle = new Cars();
                
                int counter = 2;
                boolean canEnter = Methods.canEnter(vehicle, dailyTask);
                //entrada de coches mientras tiempo
                do{
                    int optionUser = JOptionPane.showOptionDialog(null, vehicle.toEntered(), vehicle.getMatricula(), JOptionPane.YES_NO_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Permitir entrada", "Denegar entrada", "Más información", "Datos del Garage", "Salir"}, null);
                    
                    switch(optionUser){
                        
                        case 0:
                            //admitir vehiculo
                            if(canEnter == false){
                                fail++;
                                System.out.println("El vehiculo no deberia haber entrado");
                            }
                            if(cars.size()>=this.size){
                                JOptionPane.showMessageDialog(null, "El vehículo pasa la barrera, da varias vueltas al garage \ny comprueba que no hay ni una sola plaza "
                                        + "de aparcamiento sin ocupar, \nvuelve hacia su garita y toma represalias contra usted. \nSu jefe tendrá en cuenta este descuido");
                                fail++;
                            }else{
                                cars.add(vehicle);
                            }
                            
                            modifier = true;
                            break;
                        
                        case 1:
                            //rechazar vehiculo
                            if(cars.size()<(this.size/2) && 10<Aleatory.number(0, 15)){
                                JOptionPane.showMessageDialog(null, "El vehiculo se disponia a entrar, pero le deniegas la entrada, \nte mira con cara amenazadora y te pregunta por qué. 'El garage está vacio' afirma");
                                fail++;
                            }
                            if(canEnter){
                                System.out.println("El coche podia entrar");
                            }
                            modifier = true;
                            break;
                        
                        case 2:
                            JOptionPane.showMessageDialog(null, vehicle.toInfo());
                            modifier = false;
                            break;
                        
                        case 3:
                            //datos del garage
                            JOptionPane.showMessageDialog(null, "El garaje cuenta con un total de " + size + " plazas, de las cuales esta ocupadas " + cars.size());
                            break;
                        
                        case 44: //de momento igual que por defecto
                            //salir
                            break;
                        
                        default:
                            JOptionPane.showMessageDialog(null, "Misión abortada \nAbandonas tu puesto de trabajo y los clientes saltan la barrera sin pagar, \nel jefe se da cuenta de la situación y te despide");
                            brokeTime = false;
                            modifier = true;
                            stop = true;
                            break;
                    }
                }while(modifier==false);
                
            }while(((start_time+60) > (System.currentTimeMillis()/1000)) && (brokeTime));
            
            //calculo de beneficios
            JOptionPane.showMessageDialog(null, "Hoy los vehiculos que han salido del garaje han pagado un total de: " 
                    + this.recopilateTickets() + "€");
            
            //continuar o salir??
            
        }while(stop == false);
        //se guard todo o no se gurda nada
        
        //guardar partida o no
        
        //borrado arraylist
        cars.clear();
    }
    
    public void take_out_car(){
        
        int occupancy = cars.size();
        if(occupancy <= size*Methods.porcentage(15)){
            return;
        }
        
        if(occupancy <= size*Methods.porcentage(70)){
            byte number_of_car = (byte) Aleatory.number(0, 50);
            if(number_of_car <= 35){
                return;
            }
            Cars carOne = cars.remove(Aleatory.number(0, occupancy));
            carOne.setTotalTime();
            
            ticket.add(new Ticket(carOne));
            return;
        }
        
        Cars carTwo = cars.remove(Aleatory.number(0, occupancy));
        carTwo.setTotalTime();
        
        ticket.add(new Ticket(carTwo));
    }
    
    public float recopilateTickets(){
        float totalPaied = 0;
        
        for(int i=0; i<ticket.size(); i++){
            totalPaied = totalPaied + ticket.get(i).getPaid();
        }
        
        return totalPaied;
    }
    
    
    
}