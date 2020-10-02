import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ui_copy extends JFrame {
    private JPanel mypanel;
    private JTextField srcPath;
    private JTextField dstPath;
    private JButton COPYButton;
    private JButton MOVEButton;
    private JLabel from;
    private JLabel to;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    ui_copy(){
        super("CopyByte");
        this.setContentPane(this.mypanel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400,200);
        COPYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String src = srcPath.getText();
                String dst = dstPath.getText();

                File fsrc = new File(src);
                File fdst = new File(dst);

                if(!fsrc.exists())
                {
                    JOptionPane.showMessageDialog(null, "no such location exists", "source path error", 0);
                }
                else if(!fdst.exists())
                {
                    JOptionPane.showMessageDialog(null,"no such location exists", "destination path error", 0 );
                }
                else
                {
                    copier cp = new copier(src,dst,false);
                }
            }
        });
        MOVEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String src = srcPath.getText();
                String dst = dstPath.getText();

                File fsrc = new File(src);
                File fdst = new File(dst);

                if(!fsrc.exists())
                {
                    JOptionPane.showMessageDialog(null, "no such location exists", "source path error", 0);
                }
                else if(!fdst.exists())
                {
                    JOptionPane.showMessageDialog(null,"no such location exists", "destination path error", 0 );
                }
                else
                {
                    //copier cp = new copier(src,dst,false);
                    System.out.println("nothing here ");
                }
            }
        });
    }

    public static void main(String[] args) {
        ui_copy ui = new ui_copy();
        //System.out.println(ui.getSize());
        ui.setVisible(true);
        ui.setVisible(false);
        System.out.println("main ends here");
    }
}
