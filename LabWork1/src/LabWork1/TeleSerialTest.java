package LabWork1;

import Practice3.*;

public class TeleSerialTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeleSerial t1 = new TeleSerial("Aicarly", new Time(21, 30), new Time(0, 30), Days.MON);
		TeleSerial t2 = new TeleSerial("Sam and Cat", new Time(21, 25), new Time(0, 25), Days.MON);
		for(TeleSerial t : TeleSerial.teleSerials) {
			System.out.println(t);
		}
		System.out.println(TeleSerial.beOnTime(t1 ,Days.MON, new Time(21, 31)));
		

	}

}
