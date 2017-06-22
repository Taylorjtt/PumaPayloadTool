package com.myolyn.payload;

import javax.xml.bind.DatatypeConverter;

import Util.XModemCRC;

public class PanAndTiltCommand
{
	public static String buildPanAndTiltCommand(int pan, int tilt)
	{
		String header = "FF000A06";
		String panString = String.format("%02X", pan & 0xFF);
		String tiltString = String.format("%02X", tilt & 0xFF);
		String wholeCommand = header+panString+tiltString;
		byte[] bytes = DatatypeConverter.parseHexBinary(wholeCommand);
		String CRC = XModemCRC.calculateCRC(bytes);
		wholeCommand = "2121"+wholeCommand+CRC;
		
		return wholeCommand;
	}
}
