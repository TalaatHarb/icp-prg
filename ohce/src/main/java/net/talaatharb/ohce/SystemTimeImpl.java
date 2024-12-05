package net.talaatharb.ohce;

import java.time.LocalDateTime;

public class SystemTimeImpl implements SystemTime {

	@Override
	public int getHour() {
		return LocalDateTime.now().getHour();
	}

}
