package prototype;
/**
 * 
 * @author Jiyang Tao
 * @andrewID jiangt
 * @date Jan 20, 2016
 * 
 * Class People implements the abstract, which extends by class Student.
 */
public abstract class People {
	private String name;
	
//	public People(String name) {
//		this.setName(name);
//	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}