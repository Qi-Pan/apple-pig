package test1;

public class Test1 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Address address = new Address("ºÏ·Ê","Â®Ñô");
		Student stu1 = new Student("Tom",24,address);
		Student stu2 = (Student)stu1.clone();
		System.out.println(stu1==stu2);
		System.out.println(stu1.address.city==stu2.address.city);
		System.out.println(stu1.address.street==stu2.address.street);
	}

}
class Student implements Cloneable{
	String name;
	int age;
	Address address;
	public Student(String name,int age,Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
		
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student stu = (Student)super.clone();
		stu.name = new String(stu.name);
		stu.address = (Address)this.address.clone();
		return stu;
	}
	
}
class Address implements Cloneable{
	String city;
	String street;
	public Address(String city, String street) {
		this.city = city;
		this.street = street;
	}
	public Address(Address address) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Address address = (Address)super.clone();
		address.city = new String(address.city);
		address.street = new String(address.street);
		return address;
	}
	
	
}
