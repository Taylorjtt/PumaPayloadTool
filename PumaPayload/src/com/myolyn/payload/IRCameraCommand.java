package com.myolyn.payload;

import javax.xml.bind.DatatypeConverter;

import Util.ByteArrayUtil;

public class IRCameraCommand
{
	public static String buildIRCameraCommand(boolean power,boolean provideVideo,boolean blackHot,double zoomPercent)
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
		if(blackHot)
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
