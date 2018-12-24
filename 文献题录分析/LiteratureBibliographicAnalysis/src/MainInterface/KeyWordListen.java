package MainInterface;

import java.awt.event.*;
import KeywordQuery.WordFrequencyQuery;

public class KeyWordListen implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		WordFrequencyQuery.main(null);
	}
}