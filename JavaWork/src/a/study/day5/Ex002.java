package a.study.day5;

public class Ex002 {
	enum E{
		A {
			@Override
			public String mustImplement(String a) {
				return null;
			}
		},
		B("member value") {
			@Override
			public String mustImplement(String a) {
				return null;
			}
		};
		
	//enum은 class이다! 따라서 아래와 같이 class가 가지는 성격을 모두 가진다..
		//생성자를 가진다.
		E() {
		}
		E(String s) {
			this.s = s;
		}
		//맴버변수 또한 가질 수 있다.
		String s;
		
		//enum객체 안에서 반드시 구현 되어야 한다.
		//결국 이 또한 class의 특징이 그대로 나타나는 것.
		public abstract String mustImplement(String a);
	}
	
	public void a(){
		//check implementation
		Object o = new Object();
		o.equals("d");
		
		Integer i = new Integer(4);
		i.equals(3);
		
		String s = "s";
		s.equals("S");
		
		E.A.equals("e");
	}
}
