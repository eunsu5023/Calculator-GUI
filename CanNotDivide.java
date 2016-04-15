
public class CanNotDivide extends Exception {
		public CanNotDivide(){
			super("0으로 나눌 수 없습니다.");
		}
		public CanNotDivide(String message){
			super(message);
		}
}
