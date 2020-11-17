import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();
		if(command == "Load a roster")
		{
			Boolean amStupid = true;
			//This is where we handle menu actions?
		}
	}
}
