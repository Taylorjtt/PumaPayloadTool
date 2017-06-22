
import java.util.Timer;
import java.util.TimerTask;

import com.yoctopuce.YoctoAPI.YAPI;
import com.yoctopuce.YoctoAPI.YAPI_Exception;
import com.yoctopuce.YoctoAPI.YSerialPort;
import com.myolyn.payload.*;
import Util.FLIGHT_MODE;
public class PumaPayloadMain
{

	public static void main(String[] args)
	{
		YSerialPort serialPort = YSerialPort.FindSerialPort("RS232MK1-89EB4.serialPort");
		// TODO Auto-generated method stub
		try
		{
			YAPI.RegisterHub("127.0.0.1");
		} catch (YAPI_Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PayloadControlPanel controlPanel = new PayloadControlPanel();
		
		TimerTask PayloadBandwidthLimit = new TimerTask()
		{
			
			@Override
			public void run()
			{
				try
				{
					
					serialPort.writeHex("2121FF000918088BE440");
				} catch (YAPI_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		TimerTask KLVStream = new TimerTask()
		{
			
			@Override
			public void run()
			{
				try
				{
					
					serialPort.writeHex("2121FF00C01702060E2B34010101010F000000000000007C2323312E0000D5CC008400100017FFF8012F0389FFE30009FFF6FFF0FFFE0004FDAF00000000002503E10019F94C2323370B840000000028BD23233A13030000000000000000000000003DF32323FE23CD2F9F0581000002700000000000000000000017290000000400000004E0D48290");
				} catch (YAPI_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		TimerTask HRAVCommand = new TimerTask()
		{
			
			@Override
			public void run()
			{
				try
				{
					
					String hrAv = HRAVStateCommand.buildHRAVStateCommand((FLIGHT_MODE) controlPanel.getAvPanel().getFlightModeList().getSelectedItem(),
							controlPanel.getAvPanel().getAutoLand());
					System.out.println(hrAv);
					serialPort.writeHex(hrAv);
				} catch (YAPI_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		TimerTask panAndTiltControl = new TimerTask()
		{
			
			@Override
			public void run()
			{
				try
				{
					String panAndTiltCMD = PanAndTiltCommand.buildPanAndTiltCommand(controlPanel.getGimbalPanel().getPan(), controlPanel.getGimbalPanel().getTilt());
					serialPort.writeHex(panAndTiltCMD);
				} catch (YAPI_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		TimerTask controlCommand = new TimerTask()
		{
			
			@Override
			public void run()
			{
				try
				{

					String gimbalCommand = GimabalCommand.buildGimbalCommand(controlPanel.getGimbalPanel().getLookingForward()
							, controlPanel.getGimbalPanel().getGimbalFree(), !controlPanel.getGimbalPanel().getUnstowed()
							, true);
					System.out.println(gimbalCommand);
					String ccCommand = ColorCameraCommand.buildColorCameraCommand(controlPanel.getColorCamerapanel().getPower(), 
							controlPanel.getColorCamerapanel().getProvideVideo(), controlPanel.getColorCamerapanel().getFiltered(),
							controlPanel.getColorCamerapanel().getZoomLevel());
					String IRCamCommand = IRCameraCommand.buildIRCameraCommand(controlPanel.getIRCameraPanel().getPower()
							, controlPanel.getIRCameraPanel().getProvideVideo(), controlPanel.getIRCameraPanel().getBlackHot(),
							controlPanel.getIRCameraPanel().getZoomLevel());
					String irflashCommand = IRFlashCommand.buildIRFlashCommand(controlPanel.getIRFlashPanel().getPower(),
							controlPanel.getIRFlashPanel().getFlash());
					String wholeCommand = PayloadCommandBuilder.buildPayloadCommand(gimbalCommand,ccCommand,IRCamCommand,irflashCommand);
					serialPort.writeHex(wholeCommand);
					//System.out.println(wholeCommand);
				} catch (YAPI_Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		new Timer().scheduleAtFixedRate(KLVStream, 5000, 100);
		new Timer().scheduleAtFixedRate(PayloadBandwidthLimit, 5000, 1000);
		new Timer().scheduleAtFixedRate(controlCommand, 5000, 500);
		new Timer().scheduleAtFixedRate(panAndTiltControl, 5000, 100);
		new Timer().scheduleAtFixedRate(HRAVCommand, 5000, 20);

	}

}
