package se.standout.robert.helpers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DateHelper {
	private final Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat sdf;

	public DateHelper() {
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		this.sdf = new SimpleDateFormat("yyyy-MM-dd");
	}

	public List<String> getDatesOfCurrentWeek() {
		List<String> dates = new ArrayList<>();

		for(int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
			calendar.set(Calendar.DAY_OF_WEEK, i);
			dates.add(sdf.format(calendar.getTime()));
		}

		return dates;
	}
}
