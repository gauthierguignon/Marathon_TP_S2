package tp04;

public class Person {
    
    private static int counter = 0;
    private final int ID;
    private String forename;
    private String name; 

    public Person (String forename, String name) {
        this.ID = counter ++;
        this.forename = forename;
        this.name = name;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getForename() {
        return forename;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return "" + this.ID + " : " + this.forename + " " + this.name;
    }

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        if(this.ID == other.ID) return true;
        return false;
    }






}
