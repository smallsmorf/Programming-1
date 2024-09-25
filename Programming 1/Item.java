public class Item {
    private String name;
    private double unitCost;
    private double unitPrice;
    private int stock;

    public Item(String name, double unitCost, double unitPrice, int stock) {
        
        this.name = name;
        this.unitCost = unitCost;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    // Getters and setters can be added here if required

    public String getName() {
        return name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void validateItem() throws InvalidItemException {
        if (name.length() > 10) {
            throw new InvalidItemException("Check items.txt, remove all invalid names and restart the program: " + name);
        }
        if (unitCost < 0 || unitCost > 1000) {
            throw new InvalidItemException("Check items.txt, remove all invalid unit costs and restart the program: " + name + " " + unitCost);
        }
        if (unitPrice < 0 || unitPrice > 1000) {
            throw new InvalidItemException("Check items.txt, remove all invalid unit prices and restart the program: " + name + " " + unitPrice);
        }
        if (stock < 0 || stock > 1000) {
            throw new InvalidItemException("Check items.txt, remove all invalid stock values and restart the program: " + name + " " + stock);
        }
    }
}
