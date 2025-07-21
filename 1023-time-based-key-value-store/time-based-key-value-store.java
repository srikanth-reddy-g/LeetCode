class Node {
    int timeKey;
    String value;

    public Node(int timeKey, String value) {
        this.timeKey = timeKey;
        this.value = value;
    }

    public int getTimeKey() {
        return this.timeKey;
    }

    public String getValue() {
        return this.value;
    }
}

class TimeMap {

    Map<String, List<Node>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new ArrayList<Node>());
        timeMap.get(key).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key))
            return "";
        int low = 0;
        int high = timeMap.get(key).size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (timeMap.get(key).get(mid).getTimeKey() > timestamp) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high < 0 ? "" : timeMap.get(key).get(high).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

//                   Map
//             key   ->     List<Node>
//             foo   ->   [[1,bar],[4,bar2]]
//                            [1,4,5,6,8,9,12] // get the lower bound