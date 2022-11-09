/**
 * 선형 검색 연습 프로그램
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.09
 */

import java.util.Scanner;

public class CodeEX {
  static int seqSearch (int a[], int n, int key){
    for(int i=0; i<n; i++) {
      if(a[i]==key)
        return i;
    }
    return -1;
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int size = 11;
    int[] arr = {19, 3, -5, 27, 80, 1, 38, 93, 82, 9, 408};

    while(true) {
      System.out.print("검색할 정수를 입력하세요 : ");
      int key = scanner.nextInt();
      int index = seqSearch(arr, size, key);
      if(index == -1) {
        System.out.printf("%d는 배열에 존재하지 않습니다.\n", key);
      }
      else {
        System.out.printf("%d는 %d번째에 존재합니다.\n", key, index+1);
        break;
      }
    }

  }
}
