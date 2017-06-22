import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class PayloadControlPanel extends JFrame
{
	GimbalPanel gimbalPanel;
	ColorCameraPanel ccPanel;
	IRCameraPanel irCamPanel;
	IRFlashPanel irFlashPanel;
	AVPanel avPanel;
	
	public  PayloadControlPanel()
	{
		super();
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		gimbalPanel = new GimbalPanel();
		ccPanel = new ColorCameraPanel();
		irCamPanel = new IRCameraPanel();
		irFlashPanel = new IRFlashPanel();
		avPanel = new AVPanel();
		this.add(avPanel);
		this.add(gimbalPanel);
		this.add(ccPanel);
		this.add(irCamPanel);
		this.add(irFlashPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public AVPanel getAvPanel()
	{
		return avPanel;
	}
	public GimbalPanel getGimbalPanel()
	{
		return gimbalPanel;
	}
	public ColorCameraPanel getColorCamerapanel()
	{
		return ccPanel;
	}
	public IRCameraPanel getIRCameraPanel()
	{
		return irCamPanel;
	}
	public IRFlashPanel getIRFlashPanel()
	{
		return irFlashPanel; 
	}
}
