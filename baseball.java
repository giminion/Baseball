import java.util.*;
import java.io.*;

public class baseball {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);  // 스캐너
        Random random = new Random(System.currentTimeMillis()); // 랜덤 객체 생성

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int answer[] = new int[3];  // 정답인 세자리 숫자를 차례대로 담을 배열 answer 선언

        while(true){
            answer[0] = random.nextInt(9);
            answer[1] = random.nextInt(9);
            answer[2] = random.nextInt(9);

            if((answer[0]!=answer[1])&&(answer[1]!=answer[2])&&(answer[0]!=answer[2])){
                break;   // 세 수가 모두 다르면 break
            }
        }

        int count = 1; // 도전 횟수

        while (true) {
            System.out.print(count + "번째 시도 : ");
            String input = sc.next();  // String으로 세자리 숫자를 입력받아 input에 저장

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < 3; i++) {
                int num = input.charAt(i) - '0'; // input의 각 자리를 정수 형태로 num에 저장

                if (num == answer[i]) {
                    strike++;  // 슷지와 위치가 일치하면 strike 카운트
                } else if (num == answer[0] || num == answer[1] || num == answer[2]) {
                    ball++;  // 위치는 일치하지 않지만 숫자는 존재한다면 ball 카운트
                }
            }

            if (strike == 3) {  // 세자리를 모두 맞히면 종료
                System.out.println("3S");
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            if ((ball == 0 && strike == 0) || (ball != 0 && strike != 0)) {
                System.out.println(ball + "B" + strike + "S");
            } else if (strike == 0) {
                System.out.println(ball + "B");
            } else if (ball == 0) {
                System.out.println(strike + "S");
            }

            count++;  // 끝나지 않았다면 도전 횟수 카운트
        }

    }
}

