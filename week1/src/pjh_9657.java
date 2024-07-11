//백준 #9657/s3
//dp ??
import java.util.*;

class Player{
    public int Take(){//가져가는 돌 개수
        Random random = new Random();
        int num_stones=random.nextInt(3)+1;//1,2,3 중 무작위 값 생성
        if(num_stones==2)
            return 4;
        return num_stones;//임의 정수 반환
    }
};

class GameStart{
    int CurrentStones;
    Player SK=new Player();
    Player CY=new Player();
    public GameStart(int TotalStones){
        CurrentStones=TotalStones;
    }
    int Judge(){
        if(CurrentStones==4||CurrentStones==3||CurrentStones==1){ // 여기 CurrentStones==1 추가
            //다음 차례의 Player1 1개 또는 3개 또는 4개를 한 번에 가져가면서
            //다음 차례의 Player1 승리, 이전 차례의 Player2 패배
            return -1;
        }
        else if(CurrentStones==2){
            //다음 차례의 Player1 1개 가져가고(1,3,4개만 가져가니까)
            //그 다음 차례의 Player2 1개 가져가면서 승리
            return 1;
        }
        //아직 승부가 결정나지 않음
        return 0;
    }
    public String Play(){
        while(CurrentStones>=1){
            int temp;
            temp=SK.Take();
            CurrentStones-=temp;
            System.out.println("상근이가 가져간 돌의 수 : "+temp+"\nCurrent Stones: "+CurrentStones);
            if(Judge()==-1)
                return "CY";
            else if(Judge()==1)
                return "SK";
            //상근이 모든 돌을 가져간 경우 게임 종료
            if(CurrentStones<=0) // 여기 if CurrentStones<=0 조건문 추가
                return "SK";
            temp=CY.Take();
            CurrentStones-=temp;
            System.out.println("창영이가 가져간 돌의 수 : "+temp+"\nCurrent Stones: "+CurrentStones);
            if(Judge()==-1)
                return "SK";
            else if(Judge()==1)
                return "CY";
        }
        return null;
    }
}
public class pjh_9657 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stones = sc.nextInt();
        GameStart game = new GameStart(stones);
        String winner = game.Play();
        System.out.println(winner);
    }
}

/*
 int n = sc.nextInt();

    stone[1] = 1; // SK
    stone[2] = 0; // CY
    stone[3] = 1; // SK
    stone[4] = 1; // SK

   for (i = 5; i < 1001; i++){
      if (stone[i - 1] + stone[i - 3] + stone[i - 4] == 3)
            // the person who took the stone right before was "SK"
         stone[i] = 0; // the winner is "CY"
      else
         stone[i] = 1; // otherwise the winner is "SK"
   }

   if (stone[n] == 1)
      sysout("SK");
   else
      sysout("CY");
 */