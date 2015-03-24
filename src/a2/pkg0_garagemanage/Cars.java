





/////////////////////hay un par de cosas que no pillo
/////////////////////param time
/////////////////////to print, tocompare




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
    
    /**
     *Constructor por defecto
     *default constructor
     */
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
    
    /**
     *Constructor con parametros
     *param constructor
     * @param matricula tipo string de cada coche
     * @param color tipo string de cada coche
     * @param marca tipo string de cada coche
     * @param modelo tipo string de cada coche
     * @param tipo tipo string de cada coche
     * @param ocupCoche tipo string ocupacion max del coche
     * @param time 
     */
    public Cars(String matricula, String color, String marca, String modelo, String tipo, int ocupCoche, double time) {
        this.matricula = matricula;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.ocupCoche = ocupCoche;
        this.time = time;
        this.tipo = tipo;
    }
    
    /**
     *
     * @return
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     *
     * @param matricula
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     *
     * @return
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     *
     * @return
     */
    public String getModelo() {
        return modelo;
    }

    /**
     *
     * @param modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return
     */
    public int getOcupCoche() {
        return ocupCoche;
    }

    /**
     *
     * @param ocupCoche
     */
    public void setOcupCoche(int ocupCoche) {
        this.ocupCoche = ocupCoche;
    }
    
    /**
     *
     * @return
     */
    public double getTime(){
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(double time){
        this.time = time;
    }
    
    /**
     *
     * @return
     */
    public String getTipo(){
        return tipo;
    }

    /**
     *
     * @param tipo
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * string de parametros del coche por defecto
     * default string car param
     * @return
     */
    @Override
    public String toString() {
        return "Vehículo " + tipo + " con matrícula: " + matricula + ", " + marca + ", " + modelo + " de color: " + color + ", y " + ocupCoche + " ocupantes";
    }
    
    /**
     *
     * @return
     */
    public String toPrint(){
        return matricula + "¬" + marca + "¬" + modelo + "¬" + color + "¬" + tipo + "¬" + ocupCoche + "¬" + time;
    }
    
    /**
     * string de info de coches que entran al garage
     * info string entered cars
     * @return
     */
    public String toEntered(){
        return "El vehículo " + tipo + " con matrículla: " + matricula + "\ndesea entrar en el garaje" ;
    }

    /**
     * string de informacion completa de cada coche generado
     * complet info string of generated car
     * @return
     */
    public String toInfo(){
        return marca + " " + modelo + ", " + color + " con " + ocupCoche + " ocupantes \nmatrícula: " + matricula + "\ntipo: " + tipo;
    }
    
    /**
     *
     * @return
     */
    public String toCompare(){
        return matricula + ", " + color + ", " + marca + ", " + modelo + ", " + ocupCoche + ", " + time + ", " + tipo + ", todos";
    }
}
