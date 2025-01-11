package Code.Hash.Project01;

public class HashTable {
    private HashNode[] buckets;
    private int noOfBuckets;
    private int size;

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.noOfBuckets = capacity;
        buckets = new HashNode[noOfBuckets];
        this.size = 0;
    }

    private class HashNode {
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Modular Function or Hash Function
    private int getBucketIndex(Integer key) {
        return key % noOfBuckets;
    }

    public void put(Integer key, String value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or Value is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.next = head;
        buckets[bucketIndex] = node;
    }

    public String get(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public String remove(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null !!!");
        }
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (previous != null) {
            previous.next = head.next;
        } else {
            buckets[bucketIndex] = head.next;
        }
        return head.value;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        // Adding to hash
        table.put(105, "Billi");
        table.put(21, "Aarushu");
        table.put(31, "Bewakoof");

        // Updating
        System.out.println("Size before updating :- " + table.size());
        table.put(21, "KaliBilli");
        System.out.println("Size after updating :- " + table.size());

        // Extracting value from key
        System.out.println("Value at key 21 :- " + table.get(21));

        // Deleting
        System.out.println("Size before deleting :- " + table.size());
        System.out.println("deleting.. :- " + table.remove(31));
        System.out.println("Size after deleting :- " + table.size());

    }
}
