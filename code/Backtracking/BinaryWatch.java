import java.util.*;
class BinaryWatch {

    static List<String> answer=new ArrayList<>();
    public static List<String> readBinaryWatch(int turnedOn) {
        int[] leds=new int[10];
        backTrack(0,0,turnedOn,leds);    
        return answer;
    }

    public static void backTrack(int index,int count,int turnedOn,int[] leds){
        if(turnedOn==count){
            int hour=0;
            int minute=0;
            for(int i=0;i<4;i++){
                if(leds[i]==1){
                    hour+=(1<<i);
                }
            }
            for(int i=4;i<10;i++){
                if(leds[i]==1){
                    minute+=(1<<(i-4));
                }
            }
            if (hour<=11 && minute<=59){
                String time=hour+":"+String.format("%02d",minute);
                answer.add(time);
            }
            return;
        }
        if(index==10) return;
        
        leds[index]=1;
        backTrack(index+1,count+1,turnedOn,leds);
        leds[index]=0;
        backTrack(index+1,count,turnedOn,leds);

    }
    public static void main(String[] args){
        int turnedOn=1;
        System.out.print(readBinaryWatch(turnedOn));
    }
}