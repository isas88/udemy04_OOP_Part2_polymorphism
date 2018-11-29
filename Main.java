/* a parent class reference is used to refer a child class object
 * 
 * objects created with datatype as parent class can access only methods common to parent and child class 
 * that object cannot access methods present only in child class
 * but that object can access method present in parent class and not in child class 
 *  
 * 
 */

package udemy04_OOP_Part2_polymorphism;

public class Main {
	
	public static void main(String[] args) {

		Car car2 = new HondaCivic();
		HondaCivic car3 = new HondaCivic();
		car3.testmethod();
		((HondaCivic) car2).testmethod();
		System.out.println("our change :");
		car2.testmethod();
		car3.testmethod2();
		
		System.out.println("before for loop");
		
		for (int i=1;i<=3;i++) {
			
			Car car1 = getcarmethod(i);
			car1.printcardetails();
			car1.accelerate(50);
			System.out.println(car1.getName() +": accelerated to 50");
			car1.brake(10);
			System.out.println(car1.getName() +": brake applied - 10");
			car1.accelerate(-10);
			System.out.println(car1.getName() +": accelerated to -10");
			System.out.println(car1.getName() +": car speed is :" +car1.getCarspeed());
			//car1.printcardetails();
		}
		System.out.println("Test Starts Here");
		Main obj = new Main();
		obj.test();
	}
	
	public void test () {
		//Car a = new HondaCivic();
		Car a = getcarmethod(2);
		a.printcardetails();		
	}
	
	public static Car getcarmethod(int i) {
		
			switch (i){
			
			case 1:
				return new DodgeCharger();
			
			case 2:
				return new HondaCivic();
				
			case 3:
				return new Car(8,"Hellcat","Red");
			
			default:
				return null;
			}
	}
}

//end of class

class Car {

	private boolean engine;
	private int cylilnders;
	private String name;
	private String color;
	private int carspeed;
	
	public Car(int cylinders, String name, String color) {
		this.cylilnders = cylinders;
		this.name = name;
		this.color = color;
		this.engine = true;
	}

	public int getCylilnders() {
		return cylilnders;
	}

	public String getName() {
		return name;
	}

	public void startengine() {
		//this.engine = true;
		System.out.println("Engine Started :" +this.engine);
	}
	
	public void accelerate(int speed) {
		this.carspeed = this.carspeed + speed;
		
	}

	public void brake(int brake) {
		this.carspeed -= brake;
		
	}

	public String getColor() {
		return color;
	}
	
	public void printcardetails() {
	
		System.out.println("******Printed from Car Class ->*********");
		System.out.println("This is a " +this.getName() +" with " +this.getCylilnders() 
		+" cylinders" +", color: " +this.getColor());
	}

	
	public int getCarspeed() {
		return carspeed;
	}
	public void testmethod() {
		System.out.println("car test method");
	}
}

//end of class
	
class DodgeCharger extends Car {
	
	public DodgeCharger() {
		super(6, "Dodge", "Billet");
	}

	public void printcardetails() {
		System.out.println("This is a " +this.getName() +" with " +this.getCylilnders() 
		+" cylinders" +", color: " +this.getColor());
	}
}


class HondaCivic extends Car {
	
	public HondaCivic() {
		super(4, "Honda", "Black");
	}
	
	public void testmethod() {
		System.out.println("Test Method");
	}
	
	public void testmethod2() {
		System.out.println("Test Method2");
	}
	
}


















