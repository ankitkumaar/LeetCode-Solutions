class MyHashMap 
{
    // Declare an array globally
    int[] data;
    public MyHashMap() 
    {
        // Initialize data[key] to -1
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    
    public void put(int key, int value) 
    {
        // Add value to data[key]
        data[key] = value;
    }
    
    public int get(int key) 
    {
        // Return value stored in data[key]
        return data[key];
    }
    
    public void remove(int key) 
    {
        // Initialize data[key] to -1
        // showing that no value exists at data[key]
        data[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */