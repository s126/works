package hello.s126.until;

import java.util.Calendar;
import java.util.Date;

public class CommonUtil {
	public static int calAge(Date birth) {
		Calendar cal = Calendar.getInstance();
	  	int now = cal.get(Calendar.YEAR);
	  	cal.setTime(birth);
	  	return now - cal.get(Calendar.YEAR);
	}
}
