public class Researcher {
    //This class creates object that has three files.
    private String name;
    private String city;
    private int postalCode;
    public Researcher() {
        name = "";
        postalCode = 0;
        city = "";
    }
    
    public int compareTo(Researcher o) {
        // This only allow the object to compare with name field
        return name.compareTo(o.name);
    }

}
