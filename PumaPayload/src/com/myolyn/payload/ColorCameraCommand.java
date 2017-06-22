package com.myolyn.payload;
import javax.xml.bind.DatatypeConverter;

import Util.ByteArrayUtil;
public class ColorCameraCommand
{

	public static String buildColorCameraCommand(boolean power,boolean provideVideo,boolean filtered,double zoomPercent)
	{
		byte[] bytes = {0,0};
		bytes = ByteArrayUtil.setBitInByteArray(bytes, 8);
		bytes = ByteArrayUtil.setBitInByteArray(bytes, 3);
		if(power)
		{
			bytes = ByteArrayUtil.setBitInByteArray(bytes, 0);
		}
		if(provideVideo)
		{
			bytes = ByteArrayUtil.setBitInByteArray(bytes, 1);
		}
		if(filtered)
		{
			bytes = ByteArrayUtil.setBitInByteArray(bytes, 2);
		}
		
		int zoom = (int) ((zoomPercent*255)/100);
		bytes = ByteArrayUtil.swapOrder(bytes);
		String commandString = DatatypeConverter.printHexBinary(bytes);
		String zoomString = String.format("%02X", zoom);
		return commandString + zoomString;
	}
}
