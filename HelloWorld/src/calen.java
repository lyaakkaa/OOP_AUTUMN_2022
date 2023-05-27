 import java.util.*;
 
public class calen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int selectedYear = 2022;
		int selectMonth = 8;  // September
		
		Calendar calendar = new GregorianCalendar();
		int cDay = calendar.get(Calendar.DATE);
		int cMon = calendar.get(Calendar.MONTH);
		int cYear = calendar.get(Calendar.YEAR);
		
		GregorianCalendar Gcalendar = new GregorianCalendar( selectedYear, selectMonth, 1);
		int days = Gcalendar.getActualMaximum(Calendar.DATE);
		int start = Gcalendar.get(Calendar.DAY_OF_WEEK);
		
		Gcalendar = new GregorianCalendar( selectedYear, selectMonth, days);
		int totalWeeks = Gcalendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
		int cnt = 1;
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		
		for(int i = 1; i <= totalWeeks; i++) {
			System.out.println();
			
			for(int j = 1; j <= 7; j++) {
				if(cnt < start || cnt - start + 1 > 31) {
					System.out.print("   ");
					
				}
				else {
					
				}
			}
		}
		
		
		
		
		
		
		
	}

}
