public class Animal {
    protected String name;
    private int order;

    public Animal(String n) {
        name = n;
    }

    public String name() {
       return name;
    }

    public void setOrder(int o) {
        order = o;
    }

    public int getOrder() {
         return order;
    }


//	public abstract String name();
	
    public boolean olderThan(Animal a) {
        return this.order < a.getOrder();
    }
}