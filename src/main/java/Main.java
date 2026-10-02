public class Main {

    public static void main(String[] args) {

        CircularLinkedList<Integer> list = new CircularLinkedList<>();

        System.out.println("Adding items:");

        list.addItem(10);
        list.addItem(20);
        list.addItem(30);
        list.addItem(20);

        System.out.print("List: ");
        list.showList();

        System.out.print("Reverse: ");
        list.showReverseList();


        System.out.println("\nFinding items:");

        System.out.println("Find 10: " + list.find(10));
        System.out.println("Find 20: " + list.find(20));
        System.out.println("Find 50: " + list.find(50));


        System.out.println("\nRemoving items:");

        System.out.println("Remove 20: " + list.remove(20));

        System.out.print("List after removing first 20: ");
        list.showList();

        System.out.print("Reverse: ");
        list.showReverseList();


        System.out.println("\nRemove 10: " + list.remove(10));

        System.out.print("List after removing 10: ");
        list.showList();


        System.out.println("\nRemove 50: " + list.remove(50));

        System.out.print("List after trying to remove 50: ");
        list.showList();


        System.out.println("\nRemoving remaining items");

        System.out.println("Remove 30: " + list.remove(30));
        System.out.println("Remove 20: " + list.remove(20));

        System.out.print("List should now be empty: ");
        list.showList();

        System.out.print("Reverse empty list: ");
        list.showReverseList();


        System.out.println("\nTesting empty list");

        System.out.println("Find 10 in empty list: " + list.find(10));
        System.out.println("Remove 10 from empty list: " + list.remove(10));
    }
}
