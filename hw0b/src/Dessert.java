public class Dessert {
    public int flavor;
    public int price;
    public static int numDesserts = 0;
    
    Dessert(int f, int p) {
        this.flavor = f;
        this.price = p;
        numDesserts++;
    }

    public void printDessert() {
        System.out.printf("%d %d %d", this.flavor, this.price, numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
