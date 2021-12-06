public class Car {
    //Field - Properties

    private int xCoord;
    private int yCoord;
    private int speed;
    private String name;

    public Owner owner = null;

    //Constructor
    // A special kind of method that is run when the object is created
    // It cannot return anything

    public Car(int xCoord, int yCoord, int speed, String name) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.speed = speed;
        this.name = name;

        if (this.speed < 0)
                this.speed = 0;
    }

    public Car(int xCoord, int yCoord){
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public Car(){
        xCoord = 0;
        yCoord = 0;
        speed = 0;
        name = "";
    }

    //Methods - Behaviors
    public void speedUp(){
        speed++;
    }

    // Overloading Methods
    // Methods with the same name but difference signature
    // Overloaded methods can refer to each other
    public void speedUp(int amount){
        speed += amount;
    }

    public void slowDown(){
        speed--;
        if(speed < 0){
            speed = 0;
        }
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public String toString(){
        return name + ": \nX: " + xCoord + "\nY: " + yCoord + "\nSpeed: " + speed;
   }

}
