package com.myolyn.payload;
import javax.xml.bind.DatatypeConverter;

import Util.FLIGHT_MODE;
import Util.XModemCRC;
public class HRAVStateCommand
{
	public static String buildHRAVStateCommand(FLIGHT_MODE flightMode, boolean autoLand)
	{
		String header = "FF003431008C";
		String mode = String.format("%02X", flightMode.ordinal() & 0xFF);
		String autoLandString;
		
		if(autoLand)
		{
			autoLandString = "01";
		}
		else
		{
			autoLandString = "00";
		}
					   
		               
		String data = "0011003A1A9303110048FFFBFFF600010315D91DF76CD6B00168A616013A002803E1001900004990";
		String wholeCommand = header + autoLandString + mode + data;
		byte[] bytes = DatatypeConverter.parseHexBinary(wholeCommand);
		String CRC = XModemCRC.calculateCRC(bytes);
		wholeCommand = "2121"+wholeCommand+CRC;
		return wholeCommand;
		
	}
}
