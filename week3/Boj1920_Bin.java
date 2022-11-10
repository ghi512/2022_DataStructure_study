/**
 * 3주차 숙제 - 백준1920번 이진 검색으로 풀기 (https://www.acmicpc.net/problem/1920)
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.10
 */
import java.util.Scanner;

public class Boj1920_Bin {
  static int binSearch(int[] arr, int n, int key) {
    int pl = 0; // 찾으려는 배열의 가장 왼쪽 인덱스
    int pr = n-1; // 찾으려는 배열의 가장 오른쪽 인덱스
    do {
      int pc = (pl+pr)/2; // 검색 범위의 중앙 인덱스
      if(arr[pc] == key) // 검색 성공
        return pc;
      else if (arr[pc] < key)  // 중앙 값이 키값보다 작으므로 왼쪽 범위 버리기
        pl = pc + 1;
      else // 중앙 값이 키값보다 크므로 오른쪽 범위 버리기
        pr = pc -1;
    } while(pl <= pr); // 검색 범위 있으면 계속 검색
    return -1; // 검색 실패
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 배열 A -> 오름차 순으로 입력되어야 함
    System.out.print("배열A의 요솟수 : ");
    int n = scanner.nextInt(); // 배열A의 요솟수 n
    System.out.println("배열A의 원소를 오름차순으로 입력하세요.");
    int[] arrA = new int[n];
    System.out.print("arrA[0] : ");
    arrA[0] = scanner.nextInt();
    for(int i=1; i<n; i++) {
      do {
        System.out.printf("arrA[%d] : ", i);
        arrA[i] = scanner.nextInt();
      } while(arrA[i] < arrA[i-1]); // i번째 원소가 i-1번째 원소보다 작으면 다시 입력받음
    }

    // 배열 B -> 찾고싶은 key 값들의 배열
    System.out.print("배열B의 요솟수 : ");
    int m = scanner.nextInt();
    System.out.print("배열 B : ");
    int[] arrB = new int[m];
    for(int i=0; i<m; i++) {
      arrB[i] = scanner.nextInt();
    }
    
    // B의 원소가 A에 있는지 여부 출력 -> 이진 탐색
    for(int i=0; i<m; i++) {
      int index = binSearch(arrA, n, arrB[i]);
      if(index >= 0)
        System.out.println(1);
      else
        System.out.println(0);
    }

    scanner.close();
  }
}
