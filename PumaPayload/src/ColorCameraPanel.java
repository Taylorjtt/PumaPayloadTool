import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class ColorCameraPanel extends JPanel
{
	JRadioButton power;
	JRadioButton provideVideo;
	JRadioButton filtered;
	JLabel zoomLabel;
	JSlider zoom;
	
	public ColorCameraPanel()
	{
		super(new FlowLayout(FlowLayout.CENTER,20,10));
		setBorder(BorderFactory.createTitledBorder("Color Camera Control"));
		power = new JRadioButton("Power On");
		provideVideo = new JRadioButton("Provide Video");
		filtered = new JRadioButton("Filtered");
		zoomLabel = new JLabel("Zoom");
		zoom = new JSlider(0,100,0);
		this.add(power);
		this.add(provideVideo);
		this.add(filtered);
		this.add(zoomLabel);
		this.add(zoom);
	}
	public boolean getPower()
	{
		return power.isSelected();
	}
	public boolean getProvideVideo()
	{
		return provideVideo.isSelected();
	}
	public boolean getFiltered()
	{
		return filtered.isSelected();
	}
	public double getZoomLevel()
	{
		return zoom.getValue();
	}
}
