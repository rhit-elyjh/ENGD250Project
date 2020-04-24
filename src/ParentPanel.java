/*
 * @author Jonathan Ely.
 */

import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class ParentPanel extends JPanel{
	private GroupLayout layout = new GroupLayout(this);
	private MainFrame frame;
	private HashMap<String, JComponent> componentMap = new HashMap<String, JComponent>();
	private int panelScale = 50;
	
	public ParentPanel(MainFrame frame) {
		this.setLayout(layout);
		this.frame = frame;
		setupComponents();
		setupListeners();
		setupLayout();
	}
	
	public GroupLayout getLayout() {
		return this.layout;
	}
	
	public void addComponent(String string, JComponent component) {
		this.componentMap.put(string, component);
	}
	
	public JComponent returnComponent(String string) {
		if(this.componentMap.containsKey(string)) {
			return this.componentMap.get(string);
		}
		else {
			System.out.println("Warning in ParentPanel: Component '" + string + "' does not exist within componentMap of " + Thread.currentThread().getStackTrace()[2].getClassName());
			return null;
		}
	}
	
	public int getPanelScale() {
		return panelScale;
	}
	
	public void setPanelScale(int scale) {
		this.panelScale = scale;
	}
	
	public MainFrame getFrame() {
		return this.frame;
	}
	
	public abstract void setupComponents();
	
	public abstract void setupLayout();
	
	public abstract void setupListeners();
}
