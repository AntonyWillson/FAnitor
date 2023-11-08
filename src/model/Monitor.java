package model;

public abstract class Monitor {
	protected String brand;
	protected String name;
	protected int size;
	protected double weight;
	protected String type;
	
	public Monitor(String brand,String name, int size, double weight, String type) {
		super();
		this.brand = brand;
		this.name = name;
		this.size = size;
		this.weight = weight;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public abstract int Hitung();
	public abstract int basePrice();
	
}
