import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        
        List<String>  wordList = new ArrayList<>();
        List<String> spoileList= new ArrayList<>();
        boolean[] spoilerIdx = new boolean[message.length()];
      
        
        for(int[] spoiler_range:spoiler_ranges){
           for(int i=spoiler_range[0]; i<=spoiler_range[1]; i++){
               spoilerIdx[i]=true;
           } 
        }
        
        message+=" ";
        
        //공백 만나면 word초기화
        //word 채우면서 스포일러 구간인지 체크
        String word = "";
        boolean isSpoiler = false;
        for(int i=0; i<message.length(); i++){
            if(message.charAt(i)==' ') {
                
                if(isSpoiler){
                    if(!wordList.contains(word) && !spoileList.contains(word)){
                        answer++;
                        spoileList.add(word);
                        //System.out.println(word);
                        //System.out.println(isSpoiler);
                    }
                    
                }
                else{
                    if(spoileList.contains(word)) spoileList.remove(word);
                    wordList.add(word);
                }

                word="";
                isSpoiler = false;
            }
            else {
                word+=message.charAt(i);
                if(spoilerIdx[i]) isSpoiler = true;
            }
            
        }
        
        
        //System.out.println(spoilerIdxList);

        return answer=spoileList.size();
    }
}