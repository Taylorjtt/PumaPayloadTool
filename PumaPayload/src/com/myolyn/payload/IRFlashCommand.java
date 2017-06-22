package com.myolyn.payload;

import javax.xml.bind.DatatypeConverter;

import Util.ByteArrayUtil;

public class IRFlashCommand
{
	public static String buildIRFlashCommand(boolean power, boolean flash)
	{
		byte[] bytes = {0,0};
		bytes = ByteArrayUtil.setBitInByteArray(bytes, 10);
		if(power)
		{
			bytes = ByteArrayUtil.setBitInByteArray(bytes, 0);
		}
		if(flash)
		{
			bytes = ByteArrayUtil.setBitInByteArray(bytes, 2);
		}
		bytes = ByteArrayUtil.swapOrder(bytes);
		return DatatypeConverter.printHexBinary(bytes);
	}
}
