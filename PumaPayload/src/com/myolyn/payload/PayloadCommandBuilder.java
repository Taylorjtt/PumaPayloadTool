package com.myolyn.payload;
import Util.XModemCRC;
import javax.xml.bind.DatatypeConverter;

public class PayloadCommandBuilder
{
	
	public static String buildPayloadCommand(String GimbalCommand,String ColorCameraCommand, String IRCamCommand,String flashCommand)
	{
		String header = "FF00130104";
		String wholeCommand = header+GimbalCommand+ColorCameraCommand+IRCamCommand+flashCommand;
		byte[] bytes = DatatypeConverter.parseHexBinary(wholeCommand);
		String CRC = XModemCRC.calculateCRC(bytes);
		wholeCommand = "2121"+wholeCommand+CRC;
		return wholeCommand;
	}
}
