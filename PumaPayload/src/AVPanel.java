import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Util.FLIGHT_MODE;

public class AVPanel extends JPanel
{
	JComboBox<FLIGHT_MODE> modeList;
	JRadioButton autoLand;
	public AVPanel()
	{
		super(new FlowLayout(FlowLayout.CENTER,20,10));
		setBorder(BorderFactory.createTitledBorder("AV Control"));
		modeList = new JComboBox<FLIGHT_MODE>(FLIGHT_MODE.values());
		autoLand = new JRadioButton("AutoLand");
		this.add(autoLand);
		this.add(modeList);
		this.setVisible(true);
	}
	
	public JComboBox<FLIGHT_MODE>getFlightModeList()
	{
		return modeList;
	}
	public boolean getAutoLand()
	{
		return autoLand.isSelected();
	}
}
