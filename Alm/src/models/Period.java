package models;

import enums.AttestationSeason;
import java.io.Serializable;

public class Period implements Serializable, Comparable<Period> {
	private int year;
	private AttestationSeason season;

	public Period() {}

	public Period(int year, AttestationSeason season) {
		this.year = year;
		this.season = season;
	}
	
	public int getYear() {
		return year;
	}

	public AttestationSeason getSeason() {
		return season;
	}

	@Override
	public int compareTo(Period o) {
		if(year == o.year) {
			if(season == o.season) {
				return 0;
			}
			return (season == AttestationSeason.SPRING && o.season == AttestationSeason.FALL) ? 1 : -1;
		}
		return (year > o.year) ? 1 : -1;
	}

	@Override
	public String toString() {
		return year + " " + season;
	}
}