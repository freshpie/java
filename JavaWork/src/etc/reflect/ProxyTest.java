package etc.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		//동적 객체 생성...
		//proxy 패턴에서 다시 한번 정리 하자
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				if(methodName.equals("printProxyTest")){
					System.out.println("printProxyTest!!!!!!!!!!!");
				}else if(methodName.equals("printProxyTest2")){
					System.out.println("printProxyTest2@@@@@@@@@@");
				}
				return null;
			}
		};
		InvocationHandler handler2 = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				if(methodName.equals("printProxyTest")){
					System.out.println("프린트프록시테스트!!!!!!!!!!!");
				}else if(methodName.equals("printProxyTest2")){
					System.out.println("프린트프록시테스트2@@@@@@@@@@");
				}
				return null;
			}
		};
		
		ProxyTestInterface proxyTestInterface = 
				(ProxyTestInterface) Proxy.newProxyInstance(
						ProxyTestInterface.class.getClassLoader(),
						new Class<?>[] {ProxyTestInterface.class},
						//handler);
						handler2);
		
		proxyTestInterface.printProxyTest();
		proxyTestInterface.printProxyTest2();
	}
}
