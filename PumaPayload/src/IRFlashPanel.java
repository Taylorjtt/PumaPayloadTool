import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class IRFlashPanel extends JPanel
{
	JRadioButton power;
	JRadioButton flash;
	
	public IRFlashPanel()
	{
		super(new FlowLayout(FlowLayout.CENTER,20,10));
		setBorder(BorderFactory.createTitledBorder("Laser Flash Control"));
		power = new JRadioButton("Power On");
		flash = new JRadioButton("Flash On");
		this.add(power);
		this.add(flash);

	}
	
	public boolean getPower()
	{
		return power.isSelected();
	}
	public boolean getFlash()
	{
		return flash.isSelected();
	}
}
