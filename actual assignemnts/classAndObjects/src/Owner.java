public class Owner {

    private String name;

    public static int idGenerator = 0; // ALL OBJECTS OF THIS CLASS WILL SHARE THIS FIELD

    private int id; // Not shared accross all Owners

    public Owner(String name){
        this.name = name;
        this.id = idGenerator;
        idGenerator++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getAngry() {
        System.out.println("I don't like my car!!!! WHERE IS MANAGER");
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}
