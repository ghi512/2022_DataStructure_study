/**
 * Boj2161.java : 백준 2161번 - 직접 만든 큐 사용하여 풀리
 * @autor : Minji Kim
 * @email : 32200588@dankook.ac.kr
 * @date : 2022.11.29
 */
import java.util.Scanner;
class QueueInt {
  private int[] que; // 큐용 배열 (링버퍼)
  private int capacity; // 큐 용량
  private int front; // 맨 앞(front)의 요소 커서
  private int rear; // 맨 뒤(rear)의 요소 커서
  private int num; // 현재 데이터 개수

  // 실행 시 예외 : 큐가 비어있음
  public class EmptyIntQueueException extends RuntimeException {
    public EmptyIntQueueException() {}
  }

  // 실행 시 예외 : 큐가 가득 참
  public class OverflowIntQueueException extends RuntimeException{
    public OverflowIntQueueException() {}
  }

  // 생성자
  public QueueInt(int maxlen) {
    num = front = rear = 0;
    capacity = maxlen;
    try {
      que = new int[capacity]; // 큐 본체용 배열 생성
    }catch (OutOfMemoryError e) { // 생성할 수 없는 경우
      capacity = 0;
    }
  }

  // 큐에 x를 인큐
  public int enque(int x) throws OverflowIntQueueException {
    if(num >= capacity) // 현재 데이터의 개수가 최대 용량을 넘기면 예외 발생
      throw new OverflowIntQueueException();
    que[rear++] = x; // rear에 데이터 x를 넣고, rear 값 ++
    num++; // 현재 데이터 개수 +1
    if(rear == capacity) // rear의 위치가 큐 배열의 끝을 가리키면 배열의 첫 인덱스인 0으로 변경
      rear=0;
    return x; // 인큐한 데이터 x를 리턴
  }

  // 큐에서 데이터를 디큐
  public int deque() throws EmptyIntQueueException {
    if(num <= 0)
      throw new EmptyIntQueueException();
    int x = que[front++]; // front에 있는 데이터를 빼서 x에 넣고, front 값 ++
    num--; // 현재 데이터 개수 -1
    if(front == capacity)
      front=0;
    return x;
  }

  // 큐에서 데이터를 피크
  public int peek() throws EmptyIntQueueException {
    if (num <= 0) // 빈 큐일때
      throw new EmptyIntQueueException();
    return que[front];
  }

  // 큐를 비움
  public void clear() {
    num = front = rear = 0;
  }

  // 큐에서 x 검색 -> 인덱스 반환
  public int indexOf(int x) {
    for(int i=0; i<num; i++) {
      int idx = (i + front) % capacity;
      if(que[idx] == x) // 검색 성공
        return idx;
    }
    return -1; // 검색 실페
  }

  // 큐의 최대 용량을 반환
  public int getCapacity() {
    return capacity;
  }
  // 큐에 쌓여 있는 데이터 개수를 반환
  public int size() {
    return num;
  }
  // 큐가 비어 있는지 확인
  public boolean isEmpty() {
    return num <= 0;
  }
  // 큐가 가득 찼는지 확인
  public boolean isFull() {
    return num >= capacity;
  }
  // 큐 안의 모든 데이터 출력
  public void dump() {
    if(num <= 0) {
      System.out.println("큐가 비어있습니다.");
    }
    else {
      for(int i=0; i<num; i++) {
        int idx = (i + front) % capacity;
        System.out.println(que[idx] + " ");
      }
      System.out.println();
    }
  }
}

public class Boj2161 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int capacity = scanner.nextInt();
    QueueInt myQue = new QueueInt(capacity); // 입력받은 수만큼 큐 생성
    int[] discard = new int[capacity-1]; // 버린 카드를 저장할 배열 생성

    // 1~capacity 순으로 큐 채우기
    for(int i=0; i<capacity; i++) {
      myQue.enque(i+1);
    }

    // 큐에 데이터가 하나 남을 때까지 반복
    int k=0;
    while(myQue.size() > 1) {
      // 제일 위 카드를 버린다
      discard[k] = myQue.deque();
      k++;
      // 버리고 남은 카드 중 제일 위 카드를 더미의 맨 아래에 넣는다.
      int temp = myQue.deque();
      myQue.enque(temp);
    }

    // 버린 카드들을 순서대로 출력하고, 마지막에 남은 카드를 출력한다.
    for(int i=0; i<capacity-1; i++) {
      System.out.print(discard[i] + " ");
    }
    myQue.dump();
    scanner.close();
  }
}
