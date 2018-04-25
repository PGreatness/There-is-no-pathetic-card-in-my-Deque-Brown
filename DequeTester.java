public class DequeTester {

    public static void main(String[] args) {
	QQKachoo<String> farm = new QQKachoo<String>();

	System.out.println("-----Adding to front------");
	farm.addFirst("Cabbage");
	System.out.println("Peeking Front: " + farm.peekFirst()); //Cabbage
	farm.addFirst("Kale");
	System.out.println("Peeking Front: " + farm.peekFirst()); //Kale
	farm.addFirst("Broccoli");
	System.out.println("Peeking Front: " + farm.peekFirst()); //Broccoli
	farm.addFirst("Brussels sprouts");
	System.out.println("Peeking Front: " + farm.peekFirst()); //Brussels sprouts
	farm.addFirst("Carrots");
	farm.addFirst("Corn");
	System.out.println("Peeking Front: " + farm.peekFirst()); //Corn

	System.out.println("");

	System.out.println("------Current Deque------");
	System.out.println(farm); // END: Cabbage Kale Broccoli Brussels sprouts Carrots Corn :FRONT

	System.out.println("");

	System.out.println("-----Adding to end------");
	farm.addLast("CabbageLeaf");
	System.out.println("Peeking Last: " + farm.peekLast()); //CabbageLeaf
	farm.addLast("Head o'Cabbage");
	System.out.println("Peeking Last: " + farm.peekLast()); //Head o'Cabbage
	farm.addLast("CabbageCore");
	System.out.println("Peeking Last: " + farm.peekLast()); //CabbageCore

	System.out.println("");

	System.out.println("------Current Deque------");
	System.out.println(farm); //END: CabbageCore Head o'Cabbage CabbageLeaf Cabbage Kale Broccoli Brussels sprouts :FRONT

	System.out.println("");

	System.out.println("-----Removing from front-----");
	farm.removeFirst(); //Brussels sprouts dies
	System.out.println("Now Front is: " + farm.peekFirst()); //Broccoli

	System.out.println("");

	System.out.println("------Current Deque------");
	System.out.println(farm); //END: CabbageCore Head o'Cabbage CabbageLeaf Cabbage Kale Broccoli :FRONT

	System.out.println("");

	System.out.println("-----Removing from end-----");
	farm.removeLast(); //CabbageCore dies
	System.out.println("Now Back is: " + farm.peekLast()); //Head o'Cabbage

	System.out.println("");

	System.out.println("------Current Deque------");
	System.out.println(farm); //END: Head o'Cabbage CabbageLeaf Cabbage Kale Broccoli :FRONT

	System.out.println("");

	System.out.println("------REMOVING EVERYTHING------");
	farm.removeFirst();
	System.out.println("REMOVING FIRST");
	System.out.println(farm);
	farm.removeLast();
	System.out.println("REMOVING LAST");
	System.out.println(farm);
	farm.removeFirst();
	System.out.println("REMOVING FIRST");
	System.out.println(farm);
	farm.removeLast();
	System.out.println("REMOVING LAST");
	System.out.println(farm);
	farm.removeFirst();
	System.out.println("REMOVING FIRST");
	System.out.println(farm);
	System.out.println("Empty now?: "+farm.isEmpty()); //true
    }
}
