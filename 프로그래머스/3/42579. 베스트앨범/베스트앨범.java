import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> streaming = new HashMap<>();
        HashMap<String, List<int[]>> songs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            
            streaming.put(genres[i], streaming.getOrDefault(genres[i], 0) + plays[i]);
            
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new int[] {i, plays[i]});
            
        }
        
        
        // 처음부터 streaming.keySet() 넣어서 배열 만드는 것
        List<String> genreList = new ArrayList<>(streaming.keySet());
        
        // 내림차순 정렬
        genreList.sort((g1, g2) -> streaming.get(g2) - streaming.get(g1));
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String genre : genreList) {
            
            List<int[]> songList = songs.get(genre);
            
            songList.sort((s1, s2) -> {
                
                if (s1[1] == s2[1]) {
                    return s1[0] - s2[0];
                }
                else return s2[1] - s1[1];
                
            });
            
            for(int i = 0; i < Math.min(2, songList.size()); i++) {
                
                answer.add(songList.get(i)[0]);
                
            }
            
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
        
    }
}