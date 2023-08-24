package hashTable;

public class Main {


    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
        myHashTable.set("Hello", 10);
        myHashTable.set("Hey", 12);
        myHashTable.set("Hola", 13);
        myHashTable.set("Arigato", 11);
        System.out.println(myHashTable.get("Hola"));
        System.out.println(myHashTable.get("as"));
        myHashTable.printTable();
        System.out.println(myHashTable.keys());
    }
}
