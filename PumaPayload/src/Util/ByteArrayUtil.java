package Util;

public class ByteArrayUtil
{
	public static byte setBitInByte(byte b,int pos)
	{
		return (byte) (b | (1<<pos));
	}
	public static byte[] swapOrder(byte[] b)
	{
		byte temp = b[0];
		b[0] = b[1];
		b[1] = temp;
		return b;
	}
	public static byte[] setBitInByteArray(byte[] bytes, int index)
	{
		if(index < 8)
		{
			bytes[0] = setBitInByte(bytes[0],index);
		}
		else if (index < 16)
		{
			bytes[1] = setBitInByte(bytes[1],index - 8);
		}
		return bytes;
		
	}
}
