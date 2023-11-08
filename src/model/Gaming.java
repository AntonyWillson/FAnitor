package model;

public class Gaming extends Monitor {
	public int rate;
	
	public Gaming(String brand,String name, int size, double weight, String type, int rate) {
		super(brand,name, size, weight, type);
		this.rate = rate;
	}

	@Override
	public int Hitung() {
		return basePrice() + rate *10000 ;
	}

	@Override
	public int basePrice() {
		if (brand.equals("AOC")) {
			return  2500000;
		}else if (brand.equals("LG")) {
			return 2700000;
		}else if (brand.equals("ASUS")) {
			return 3000000;
		}
		return 0;
	}

}
