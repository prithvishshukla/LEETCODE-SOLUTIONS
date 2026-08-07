class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        for(int hour = 0; hour < 12; hour++) {
            for(int min = 0; min < 60; min++) {
                
                if(Integer.bitCount(hour) + Integer.bitCount(min) == turnedOn) {
                    result.add(hour + ":" + (min < 10 ? "0" + min : min));
                }
            }
        }
        
        return result;
    }
}