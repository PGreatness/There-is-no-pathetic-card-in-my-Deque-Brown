public class DequeTester2{
  public static void main(String[] args) {
    QQKachoo<String> iscream = new QQKachoo<String>();

    System.out.println("-----Adding to front------");
    iscream.addFirst("Chocolate");
    System.out.println(iscream.peekFirst()); //Chocolate
    iscream.addFirst("Vanilla");
    System.out.println(iscream.peekFirst()); //Vanilla
    iscream.addFirst("Strawberry");
    System.out.println(iscream.peekFirst()); //Strawberry
    iscream.addFirst("Mint");
    System.out.println(iscream.peekFirst()); //Mint

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(iscream); //Mint Strawberry Vanilla Chocolate

    System.out.println("");

    System.out.println("-----Adding to end------");
    iscream.addLast("Pistachio");
    System.out.println(iscream.peekLast()); //Pistachio
    iscream.addLast("Coffee");
    System.out.println(iscream.peekLast()); //Coffee
    iscream.addLast("S'mores");
    System.out.println(iscream.peekLast()); //S'mores

    System.out.println("");

    System.out.println("------Current Deque------");
    System.out.println(iscream); //Mint Strawberry Vanilla Chocolate Pistachio Coffee S'mores
    System.out.println("");
  }





}
