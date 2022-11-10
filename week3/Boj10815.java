/**
 * 3주차 숙제 - 백준10815번 (https://www.acmicpc.net/problem/10815)
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.10
 */
import java.util.Scanner;

public class Boj10815 {
  static int binarySearch(int[] arr, int n, int key){
    int pl = 0;
    int pr = n-1;
    for(int i=0; i<n; i++) {
      do {
        int pc = (pr+pl)/2;
        if(arr[pc] == key)
          return pc;
        else if (arr[pc] < key)
          pl = pc+1;
        else
          pr = pc-1;
      }while (pl <= pr);
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 상근이의 숫자 카드 -> 범위 배열 (오름차순 입력)
    System.out.print("상근이의 숫자 카드 개수: ");
    int n = scanner.nextInt();
    System.out.println("상근이의 숫자 카드를 오름차순으로 입력하시오.");
    int[] cards = new int[n];
    System.out.print("1번째 카드: ");
    cards[0] = scanner.nextInt();
    for(int i=1; i<n; i++){
      do{
        System.out.printf("%d번째 카드: ", i+1);
        cards[i] = scanner.nextInt();
      } while (cards[i] < cards[i-1]);
    }

    // key값
    System.out.print("찾을 숫자의 개수: ");
    int m = scanner.nextInt();
    System.out.print("숫자 입력: ");
    int[] key = new int[m];
    for(int i=0; i<m; i++) {
      key[i] = scanner.nextInt();
    }

    // key값들을 상근이가 가지고 있는지 여부 출력
    // 0 - 가지고있지않음, 1 - 가지고있음
    for(int i=0; i<m; i++) {
      int index = binarySearch(cards, n, key[i]);
      if(index <0)
        System.out.print("0 ");
      else
        System.out.print("1 ");
    }

    scanner.close();
  }
}
