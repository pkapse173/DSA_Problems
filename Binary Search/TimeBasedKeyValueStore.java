public class TimeBasedKeyValueStore {

        private Map<String, List<Pair<Integer, String>>> map;
    
        public TimeMap() {
            map = new HashMap<>();
        }
    
        public void set(String key, String value, int timestamp) {
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair<>(timestamp, value));
        }
    
        public String get(String key, int timestamp) {
            List<Pair<Integer, String>> list = map.get(key);
            if (list == null) {
                return "";
            }
            int left = 0, right = list.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (list.get(mid).getKey() <= timestamp) {
                    if (mid == list.size() - 1 || list.get(mid + 1).getKey() > timestamp) {
                        return list.get(mid).getValue();
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            }
            return "";
        }
    
    }
    
    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
    

