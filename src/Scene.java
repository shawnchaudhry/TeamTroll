import java.awt.*;
import javax.swing.JPanel;
 
/** 
 * Interface for scenes.
 *
 * @author TeamTroll
 * @version 1.0
 */
public interface Scene {
 
    /**
     * Paints the components onto the screen.
     *
     * @param JPanel p The panel to contain the components.
     * @param Graphics g The graphics to the corresponding page. 
     */
    public void paint(JPanel p, Graphics g);
}