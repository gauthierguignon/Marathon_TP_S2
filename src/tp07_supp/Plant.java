package tp07_supp;

public abstract class Plant {

    protected int identity;
    protected double size;

    protected Plant(int identity, double size) {
        this.identity = identity;
        this.size = size;
    }
    
    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public double getSize() {
        return this.size;
    }
    
    public void setSize(double size) {
        this.size = size;
    }

    public String toString() {
        return "" + this.getClass().getSimpleName()+" ["+this.identity+","+this.size+"]";
    }

    public abstract double getPricePerUnit();

    public double getPrice() {
        return size * this.getPricePerUnit();
    }

    public abstract boolean isMature();


}
