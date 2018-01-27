import java.util.ArrayList;

public class Test {

public static ArrayList<Integer> lengths(ArrayList<String> strings) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (String item : strings) {
            list.add(item.length());
        }
        return list;
    }

public static void main(String[] args) {

ArrayList<String> list = new ArrayList<String>();

        list.add("Dog");
        list.add("Elephant");
        list.add("Aligator");
        list.add("Parrot");

        ArrayList<Integer> stringLenghts = lengths(list);
        System.out.println(stringLenghts);

    }
}