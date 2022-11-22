public class CharStack {
  private int max; // 스택의 용량
  private int ptr; // 스택 포인터
  private char[] stk; // 스택의 본체

  public class EmptyInStackException extends RuntimeException { // 스택이 비어있을 경우 에러 발생
    public EmptyInStackException() {}
  }
  public class OverflowIntStackException extends RuntimeException{ // 스택이 꽉 착을 때 에러 발생 -> 넘침
    public OverflowIntStackException() {}
  }
  public CharStack(int capacity) { // 생성자. 매개변수로 스택의 용량을 줌
    ptr = 0; // 스택 포인터는 스택의 바닥을 가리키고 있음
    max = capacity;
    try {
      stk = new char[max];
    } catch (OutOfMemoryError e) {
      max = 0;
    }
  }

  // 스택에 x를 push
  public char push(char x) throws OverflowIntStackException {
    if (ptr >= max) // 스택이 가득차있으면
      throw new OverflowIntStackException();
    return stk[ptr++] = x;
  }

  // 스택에서 데이터를 pop -> 데이터를 꺼내서 버림
  public char pop() throws EmptyInStackException {
    if(ptr <= 0) // 스택이 빈 경우 pop할 데이터가 없으므로
      throw new EmptyInStackException();
    return stk[ptr--];
  }

  // 스택에서 데이터를 peak -> 데이터를 꺼내서 확인
  public char peak() throws EmptyInStackException{
    if(ptr <= 0) {
      throw new EmptyInStackException();
    }
    return stk[ptr -1];
  }

  // 스택을 비움
  public void clear() {
    ptr = 0;
  }

  // 스택에서 x를 찾아 인덱스 반환
  public int indexOf(int key) {
    for(int i=ptr-1; i>=0; i--) { // 꼭대기부터 선형 검색
      if(stk[i] == key) // 검색 성공
        return i;
    }
    return -1; // 검색 실패
  }

  // 스택의 용량을 반환
  public int getCapacity() { // max는 private한 변수이므로 max값을 얻기 위한 함수 이용
    return max;
  }

  // 스택에 쌓여있는 데이터 개수 반환
  public int size() {
    return ptr;
  }

  // 스택이 비어 있는가?
  public boolean isEmpty() {
    return ptr <= 0;
  }

  // 스택이 가득 찼는가?
  public boolean isFull() {
    return ptr >= max;
  }

  // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
  public void dump() {
    if (ptr <= 0) {
      System.out.println("스택이 비어있습니다.");
    }
    else {
      for (int i = 0; i < ptr; i++) {
        System.out.println(stk[i]);
      }
      System.out.println();
    }
  }
}


