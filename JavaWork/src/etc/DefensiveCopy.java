package etc;

public class DefensiveCopy {
	public static void main(String[] args) {
		//전제로 DataManager는 불변객체로 사용되길 원하거나, 외부(client)가 내부 정보를 변경하지 못하게 사용하고 싶다
		//아래 NonDefensiveCopy에서는 Day class(참조타입)를 사용하여 내부 Day객체를 변경하거나, int[] values의 값을 변경하려는 시도를 하고 있고,
		//그 시도가 성공(방어하지 못함)하는 것을 보여주고 있다.
		//개발자가 의도한 바는 call by value로서의 동작을 의도 했으나 call by reference 처럼 동작한 것이다.
		//DataManager class를 보면 Day객체 던, int[] values던 해당 객체를 직접 던지거나 직접 접근하는 구조로 되어 있다(일반적..)
		//하지만 DefensiveDataManager class를 보면 항상 새로운 객체를 생성하여 반환하거나, 항상 새로운 객체를 할당하여
		//Day class(참조타입) 와의 연결을 끊으므로서 Day class(참조타입)를 이용하여 내부 Day 객체를 변경하지 못하게 하고 있다.
		System.out.println("NonDefensiveCopy------------------------------------");
		DataManager manager1 = new DataManager(new int[] { 1, 2 }, new Day(10));
		System.out.println("날짜 : " + manager1.getDay().getDay());
		System.out.println("점수 : " + manager1.getValues()[0]);

		manager1.getDay().setDay(20);
		manager1.getValues()[0] = 100;
		System.out.println("날짜 : " + manager1.getDay().getDay());
		System.out.println("점수 : " + manager1.getValues()[0]);
		
		System.out.println("DefensiveCopy---------------------------------------");
		DefensiveDataManager manager2 = new DefensiveDataManager(new int[] { 1, 2 }, new Day(10));
		System.out.println("날짜 : " + manager2.getDay().getDay());
		System.out.println("점수 : " + manager2.getValues()[0]);

		manager2.getDay().setDay(20);
		manager2.getValues()[0] = 100;
		System.out.println("날짜 : " + manager2.getDay().getDay());
		System.out.println("점수 : " + manager2.getValues()[0]);
	}
}
class DataManager {
	int[] values;
	Day day;

	public DataManager(int[] values, Day day) {
		this.values = values;
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	public int[] getValues() {
		return values;
	}
}
class DefensiveDataManager {
	int[] values;
	Day day;

	public DefensiveDataManager(int[] values, Day day) {
		this.values = new int[values.length];
		System.arraycopy(values, 0, this.values, 0, values.length);

		this.day = new Day(day.getDay());
	}

	public Day getDay() {
		return new Day(day.getDay());
	}

	public int[] getValues() {
		return values.clone();
	}
}
class Day {	//참조 타입...
	int day;

	public Day(int day) {
		this.day = day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDay() {
		return day;
	}
}