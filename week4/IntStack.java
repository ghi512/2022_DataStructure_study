
public class IntStack {
	private int max; // 스택 용량
	private int ptr; // 스택 포인터
	private int[] stk; // 스택 본체

	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	} // 스택이 비어있음

	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	} // 스택이 넘침

	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// 스택에 x를 푸시
	public int push(int x) throws OverflowIntStackException {
		if (ptr == max)	// 스택이 가득 참
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// 스택에서 데이터를 팝
	public int pop() throws EmptyIntStackException {
		if (ptr == 0)	// 스택이 비어 있음
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// 스택에서 데이터를 피크
	public int peek() throws EmptyIntStackException {
		if (ptr == 0)	// 스택이 비어 있음
			throw new EmptyIntStackException();
		return stk[ptr -1];
	}

	// 스택을 비움
	public void clear() {
		ptr = 0;
	}

	// 스택에서 x를 찾아 인덱스를 반환
	public int indexOf(int key) {
		for (int i = ptr - 1; i >= 0; i--) { // 꼭대기 쪽부터 선형 검색
			if (stk[i] == key)
				return i;		// 검색 성공
		}
		return -1;				// 검색 실패
	}

	// 스택의 용량을 반환
	public int getCapacity() {
		return max;
	}

	// 스택에 쌓여 있는 데이터 개수를 반환
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
