/**
 * 2주차 숙제 - 백준1920번 선형 검색으로 풀기 
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.08
 */
import java.util.Scanner;

public class HW{
  static int seqSearch(int arrA[], int n, int key){
    for(int i=0; i<n; i++) {
      if(arrA[i] == key)
        return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 배열 A
    System.out.print("배열 A의 원소 개수 n : ");
    int n = scanner.nextInt();
    System.out.printf("배열 A : ");
    int[] arrA = new int[n];
    for(int i=0; i<n; i++) {
      arrA[i] = scanner.nextInt();
    }

    // 찾을 값들의 배열 B
    System.out.print("배열 B의 원소 개수 n : ");
    int m= scanner.nextInt();
    System.out.printf("배열 B : ");
    int[] arrB = new int[m];
    for(int i=0; i<n; i++) {
      arrB[i] = scanner.nextInt();
    }

    // B의 원소가 A에 있는지 여부 출력
    for(int i=0; i<m; i++) {
      System.out.println(seqSearch(arrA, n, arrB[i]));
    }
  }
}
