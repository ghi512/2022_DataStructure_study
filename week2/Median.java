/**
 * 세 정수의 중앙값 구하기 프로그램
 * @author : Minji Kim
 * @email : ghi512@naver.com
 * @date : 2022.11.08
 */

import java.util.Scanner;

public class Median {
  static int med3(int a, int b, int c) {
    if(a>=b) {
      if(b>=c) {
        return b;
      }
      else if(a>=c) {
        return c;
      }
      else {
        return a;
      }
    }
    else {
      if(a>=c) {
        return a;
      }
      else if (b>=c) {
        return c;
      }
      else {
        return b;
      }
    }
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("세 정수를 입력하세요.");
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    int med = med3(a, b, c);
    System.out.printf("%d, %d, %d의 중앙값은 %d 입니다.\n", a, b, c, med);
  }
}
