import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class IRCameraPanel extends JPanel
{
	JRadioButton power;
	JRadioButton provideVideo;
	JRadioButton blackHot;
	JLabel zoomLabel;
	JSlider zoom;
	
	public IRCameraPanel()
	{
		super(new FlowLayout(FlowLayout.CENTER,20,10));
		setBorder(BorderFactory.createTitledBorder("IR Camera Control"));
		power = new JRadioButton("Power On");
		provideVideo = new JRadioButton("Provide Video");
		blackHot = new JRadioButton("Black Hot");
		zoomLabel = new JLabel("Zoom");
		zoom = new JSlider(0,100,0);
		this.add(power);
		this.add(provideVideo);
		this.add(blackHot);
		this.add(zoomLabel);
		this.add(zoom);
	}
	public boolean getBlackHot()
	{
		return blackHot.isSelected();
	}
	public boolean getPower()
	{
		return power.isSelected();
	}
	public boolean getProvideVideo()
	{
		return provideVideo.isSelected();
	}
	public double getZoomLevel()
	{
		return zoom.getValue();
	}
}
