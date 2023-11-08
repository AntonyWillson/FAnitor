package model;

public class Designer extends Monitor{
	public double color;

	public Designer(String brand,String name, int size, double weight, String type, double color) {
		super(brand,name, size, weight, type);
		this.color = color;
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

	@Override
	public int Hitung() {
		
	return (int) (basePrice() + (2 - color) * 1000000);
 
	}

	
}
