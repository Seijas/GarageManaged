package a2.pkg0_garagemanage;

/**
 * @version 2.0 Alfa
 * @author Micael Remi Pereira
 * @author Daniel Seijas
 */
public class Cars {
    
    String matricula, color, marca, modelo, tipo;
    int ocupCoche;
    double time;
    
    public Cars(){
        String carArray[] = Methods.readCars();
        
        this.matricula = Aleatory.enrollment();
        this.time = System.currentTimeMillis()/1000;
        
        this.marca = carArray[0];
        this.modelo = carArray[1];
        this.color = Aleatory.color(carArray[2]);
        this.tipo = carArray[3];
        this.ocupCoche = Aleatory.vehicle_occupancy(Integer.parseInt(carArray[4]));
        
    }
    
    public Cars(String matricula, String color, String marca, String modelo, String tipo, int ocupCoche, double time) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.ocupCoche = ocupCoche;
        this.time = time;
        this.tipo = tipo;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getOcupCoche() {
        return ocupCoche;
    }
    public void setOcupCoche(int ocupCoche) {
        this.ocupCoche = ocupCoche;
    }
    
    public double getTime(){
        return time;
    }
    public void setTime(double time){
        this.time = time;
    }
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vehículo " + tipo + " con matrícula: " + matricula + ", " + marca + ", " + modelo + " de color: " + color + ", y " + ocupCoche + " ocupantes";
    }
    
    public String toPrint(){
        return matricula + "¬" + marca + "¬" + modelo + "¬" + color + "¬" + tipo + "¬" + ocupCoche + "¬" + time;
    }
    
    public String toEntered(){
        return "El vehículo " + tipo + " con matrículla: " + matricula + "\ndesea entrar en el garaje" ;
    }
    public String toInfo(){
        return marca + " " + modelo + ", " + color + " con " + ocupCoche + " ocupantes \nmatrícula: " + matricula + "\ntipo: " + tipo;
    }
    
    public String toCompare(){
        return matricula + ", " + color + ", " + marca + ", " + modelo + ", " + ocupCoche + ", " + time + ", " + tipo + ", todos";
    }
}
