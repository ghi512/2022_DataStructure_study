/**
 * 이진 검색 프로그램
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.09
 */
import java.util.Scanner;

public class BinSearch {
  static int binSearch (int[] arr, int n, int key) {
    // 요솟수가 n개인 배열 arr에서 key와 같은 요소 이진 검색
    int pl = 0; // 검색 범위의 첫 인덱스
    int pr = n - 1; // 검색 범위의 끝 인덱스

    do { // 선행 반복문 -> 일단 먼저 검색 수행
      int pc = (pl + pr) / 2; // 검색 범위의 중앙 인덱스
      if (arr[pc] == key) // 검색 성공
        return pc;
      else if (arr[pc] < key)
        pl = pc + 1; // 검색 범위를 뒤쪽 절반으로 줄임
      else
        pr = pc - 1; // 검색 범위를 앞쪽 절반으로 줄임
    } while (pl <= pr); // 검색 범위가 더 이상 없는 경우 이진 검색 종료
    return -1; // 검색 실패
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 배열의 크기
    System.out.print("요솟수: ");
    int n = scanner.nextInt();

    // 배열의 크기만큼 int형 배열 생성
    int[] arr = new int[n];
    System.out.println("오름차 순으로 입력하세요.");
    System.out.print("arr[0]: ");
    arr[0] = scanner.nextInt();
    for(int i=1; i<n; i++) {
      do {
        System.out.print("arr[" + i + "]: ");
        arr[i] = scanner.nextInt();
      } while(arr[i] < arr[i-1]);
      // 오름차순이기 때문에, 배열의 이전 값이 이후 값보다 작으면 다시 입력
      // -> arr[0] 입력을 따로 받은 이유
    }

    // key값
    System.out.print("검색할 값: ");
    int key = scanner.nextInt();

    // 이진검색
    int index = binSearch(arr, n, key);
    if(index == -1)
      System.out.println(key + "는 배열에 없는 요소입니다.");
    else
      System.out.println(key + "는 arr[" + index +"]에 있습니다.");
    scanner.close();
  }
}
