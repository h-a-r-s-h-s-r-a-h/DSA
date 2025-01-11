package Code.Hash.Project02;

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
        private HashNode next;

        public HashNode(Integer key) {
            this.key = key;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Hash Function
    private int getBucketIndex(Integer key) {
        return Math.abs(key) % noOfBuckets;
    }

    public boolean add(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        // Check if the key already exists
        while (head != null) {
            if (head.key.equals(key)) {
                return false; // Key already exists, no duplicate allowed
            }
            head = head.next;
        }

        // Add the key to the hash table
        size++;
        HashNode newNode = new HashNode(key);
        newNode.next = buckets[bucketIndex];
        buckets[bucketIndex] = newNode;
        return true;
    }

    public boolean contains(Integer key) {
        if (key == null) {
            throw new IllegalArgumentException("Key is null!");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return true; // Key found
            }
            head = head.next;
        }
        return false; // Key not found
    }

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!add(nums[i])) {
                return true; // Duplicate found
            }
        }
        return false; // No duplicates
    }


    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        // Test containsDuplicate method
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Contains duplicates (nums1): " + hashTable.containsDuplicate(nums1)); // Output: false

        int[] nums2 = {1, 2, 3, 4, 1};
        System.out.println("Contains duplicates (nums2): " + hashTable.containsDuplicate(nums2)); // Output: true

        // Test add and contains methods
        hashTable.add(10);
        hashTable.add(20);
        System.out.println("Contains 10: " + hashTable.contains(10)); // Output: true
        System.out.println("Contains 30: " + hashTable.contains(30)); // Output: false
        System.out.println("HashTable size: " + hashTable.size()); // Output: 2
    }
}
