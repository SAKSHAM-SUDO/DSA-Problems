class MyHashMap {
    int size = (int)Math.pow(10, 6) + 1;
    int array[];
    
    public MyHashMap() {
        array = new int[size];
        Arrays.fill(array, -1);
    }
    
    public void put(int key, int value) {
        array[key] = value;
    }
    
    public int get(int key) {
        return array[key];
    }
    
    public void remove(int key) {
        array[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */