package styling.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import styling.CodeEvaluator;

public class StylingListener implements ActionListener {
	
	MainFrame frame;
	
	public StylingListener(MainFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String repositorio = frame.repositorio.getText();
		String path = null;
		
		if (repositorio != null) {
			repositorio = repositorio.trim();
			
			if (repositorio.length() > 0) {
				
				if (repositorio.indexOf("http") != -1) {
					path = downloadRepository(repositorio);
				} else {
					path = repositorio;
				}
			}
			
			new ResultFrame(CodeEvaluator.evaluate(path));
		}
	}
	
	private String downloadRepository(String repositorio) {
		
		return GitDownloader.download(repositorio);
	}
}
