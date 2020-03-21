public class Researcher implements Comparable<Researcher> {
    //This class creates object that has three files.
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

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
