/**
 * 이진 검색 프로그램 - 자바 표준 라이브러리 사용
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.09
 */
import java.util.Arrays;
import java.util.Scanner;

public class BinSearchLib {
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
    for (int i = 1; i < n; i++) {
      do {
        System.out.print("arr[" + i + "]: ");
        arr[i] = scanner.nextInt();
      } while (arr[i] < arr[i - 1]);
      // 오름차순이기 때문에, 배열의 이전 값이 이후 값보다 작으면 다시 입력
      // -> arr[0] 입력을 따로 받은 이유
    }

    // key값
    System.out.print("검색할 값: ");
    int key = scanner.nextInt();

    // 이진검색
    int index = Arrays.binarySearch(arr, key);
    // 배열에 값이 존재하지 않으면 존재해야할 인덱스 return
    if (index < 0) {
      System.out.println("값이 배열에 존재하지 않습니다.");
      int idx = -index - 1;
      // 값이 존재하지 않으면 -> 그 값이 있어야 할 위치를 x라 할 때,
      // return -x-1
      // -7 = -6-1 -> 값이 있어야할 위치 : 6
      System.out.println(key + "는 " + idx + "번째 인덱스에 있어야 합니다.");
    } else
      System.out.println(key + "는 arr[" + index + "]에 있습니다.");
    scanner.close();
  }
}
