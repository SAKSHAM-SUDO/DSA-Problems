class MyCalendar {

    HashMap<Integer, Integer> map;
    public MyCalendar()
    {
        map = new HashMap<>();
    }
    
    public boolean book(int start, int end)
    {
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int s = entry.getKey();
            int e = entry.getValue();
            
            if(s < end && start < e)
                return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */