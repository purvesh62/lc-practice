package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class HashTable {
    private Node[] hashMap;

    private int size = 8;

    public HashTable() {
        hashMap = new Node[size];
    }


    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            // Calculate the HASH
            hash = (hash + asciiValue * 23) % hashMap.length;
        }
        return hash;
    }


    public void set(String key, int value) {
        int hashKey = hash(key);
        Node newNode = new Node(key, value);

        if (hashMap[hashKey] == null) {
            hashMap[hashKey] = newNode;
        } else {
            Node temp = hashMap[hashKey];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key) {
        int hashValue = hash(key);
        if (hashMap != null && hashMap[hashValue] != null) {
            Node temp = hashMap[hashValue];
            while (temp != null) {
                if (Objects.equals(temp.key, key)) {
                    return temp.value;
                } else {
                    temp = temp.next;
                }
            }
        }
        return 0;
    }


    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Node temp = hashMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allKeys;
    }

    public void printTable() {
        for (int i = 0; i < hashMap.length; i++) {
            System.out.println(i + ":");
            Node temp = hashMap[i];
            while (temp != null) {
                System.out.println("{ " + temp.key + " : " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
}
