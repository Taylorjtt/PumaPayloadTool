import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class GimbalPanel extends JPanel
{
	JRadioButton lookingForward;
	JRadioButton gimbalFree;
	JRadioButton unstowed;
	JLabel panLabel;
	JSlider pan;
	JLabel tiltLabel;
	JSlider tilt;
	
	public GimbalPanel()
	{
		super(new FlowLayout(FlowLayout.CENTER,20,10));
		setBorder(BorderFactory.createTitledBorder("Gimbal Control"));
		lookingForward  = new JRadioButton("Looking Forward", false);
		gimbalFree  = new JRadioButton("Gimbal Free", false);
		unstowed  = new JRadioButton("Unstowed", false);
		panLabel = new JLabel("Pan");
		pan = new JSlider(-127,127);
		tiltLabel = new JLabel("Tilt");
		tilt = new JSlider(-127,127);
		this.add(panLabel);
		this.add(pan);

		this.add(tiltLabel);
		this.add(tilt);
		this.add(lookingForward);
		this.add(gimbalFree);
		this.add(unstowed);
		this.setVisible(true);
	}
	
	public short getPan()
	{
		return (short) pan.getValue();
		
	}
	public short getTilt()
	{
		return (short) tilt.getValue();
		
	}
	public boolean getLookingForward()
	{
		return lookingForward.isSelected();
	}
	public boolean getGimbalFree()
	{
		return gimbalFree.isSelected();
	}
	public boolean getUnstowed()
	{
		return unstowed.isSelected();
	}
}
