package com.myolyn.payload;


import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

import Util.ByteArrayUtil;

public class GimabalCommand
{
	boolean lookingForward;
	boolean gimbalFree;
	boolean stowed;
	boolean provideVideo;
	
	public static String buildGimbalCommand(boolean lookingForward, boolean gimbalFree, boolean stowed, boolean provideVideo)
	{
		byte[] bytes = {0,0};
		//9
		bytes =  ByteArrayUtil.setBitInByteArray(bytes,9);
		//10
		bytes =  ByteArrayUtil.setBitInByteArray(bytes,10);
		
		if(!lookingForward)
		{
			//"7"
			bytes =  ByteArrayUtil.setBitInByteArray(bytes,7);
		}
		if(gimbalFree)
		{
			//"6"
			bytes =  ByteArrayUtil.setBitInByteArray(bytes,6);

		}
		if(provideVideo)
		{
			//"1"
			bytes =  ByteArrayUtil.setBitInByteArray(bytes,1);
		}
		if(!stowed)
		{
			//"0"
			bytes =  ByteArrayUtil.setBitInByteArray(bytes,0);
		}

		bytes = ByteArrayUtil.swapOrder(bytes);
		return DatatypeConverter.printHexBinary(bytes);
	}
	

	

	
}

