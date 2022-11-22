import java.util.Scanner;
// IntStack는 같은 패키지 안에 있어서 따로 import하지 않음

public class IntStackTester {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("현재 데이터 수: " + s.size() + " / " + s.getCapacity());
			System.out.println("--------------------------------------------");
			System.out.println("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료");
			System.out.println("--------------------------------------------");
			int menu = scan.nextInt();
			if (menu == 0) return;
			switch (menu) {

				// 푸시
				case 1:
					System.out.print("데이터: ");
					int x = scan.nextInt();
					try {
						s.push(x);
					} catch (IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;

				// 팝
				case 2:
					try {
						x = s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				// 피크
				case 3:
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어 있습니다.");
					}
					break;

				// 덤프
				case 4:
					s.dump();
					break;
			}
		}
	}
}
