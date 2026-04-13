import java.util.*;

class Solution {
    
    static String[] answer;
    static HashMap<String, String> users;
    static int idx = 0;
        
    public String[] solution(String[] record) {
        
        users = new HashMap<>();
        int cnt = 0;
        
        for (String s : record) {
            
            String[] part = s.split("\\s+");
            
            String a = part[0];
            
            if (!a.equals("Change")) {
                cnt++;
                
                if (a.equals("Enter")) {
                    String id = part[1];
                    String name = part[2];
                
                    users.put(id, name);
                }
            }
            else {
                String id = part[1];
                String name = part[2];
                
                users.put(id, name);
            }   
        }
        
        answer = new String[cnt];
        
        for (String s : record) {
            
            String[] part = s.split("\\s+");
            
            String a = part[0];
            String id = part[1];
            
            if (a.equals("Change")) continue;
            
            message(id, a);
            
        }
        
        return answer;
        
    }
    
    public static void message(String id, String a) {
        
        if (a.equals("Enter")) {
            String an = users.get(id) + "님이 들어왔습니다.";
            answer[idx++] = an;
        } 
        else if (a.equals("Leave")) {
            String an = users.get(id) + "님이 나갔습니다.";
            answer[idx++] = an;
        }
        
    }
    
}