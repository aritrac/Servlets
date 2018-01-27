import java.util.ArrayList;
import java.util.List;

public class Sample {
	public static void main(String[] args) {
		List<MyObj> list = new ArrayList<MyObj>();
		list.add(new MyObj("name1", 31));
		list.add(new MyObj("name1", 442));
		list.add(new MyObj("name2", 213));
		list.add(new MyObj("name1", 31));
		list.add(new MyObj("name2", 341));
		list.add(new MyObj("name3", 131));
	}
}

class MyObj{
	String name;
	int value;
	
	public MyObj(String name, int value){
		this.name = name;
		this.value = value;
	}
}