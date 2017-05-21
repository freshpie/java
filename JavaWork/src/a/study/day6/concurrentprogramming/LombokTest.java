package a.study.day6.concurrentprogramming;

public class LombokTest {
	public static void main(String[] arg){
		UserVo user = new UserVo("leeehan","333",40584049);
	
		user.setTel(234);
		user.getUserAge();
	}
}
