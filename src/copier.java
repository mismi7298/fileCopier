import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



class copier extends JFrame implements Runnable
{

    private JLabel from;
    private JLabel to;
    private JPanel srcPath;
    private JLabel dstPath;
    private JLabel size;
    private JLabel precent;
    private JPanel objPanel;

    private String src, dst;
    private boolean delete;
    Thread thread;
    copier(String src, String dst , boolean delete)
    {
        super("CopyByte");
        this.setContentPane(this.objPanel);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(300,200);
        this.src=src;
        this.dst=dst;
        this.delete=delete;

        this.thread = new Thread(this);
        //thread.setDaemon(false);
        thread.start();
    }
    public void run()
    {
        try {
            this.setVisible(true);
            //this.thread.sleep(10000);
            copy(src, dst, delete);
            System.out.println("now i am going to die");
            //this.thread.setDaemon(true);
            //System.exit(0);
            throw new Exception("done");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null ,e, "errors", JOptionPane.ERROR_MESSAGE);
        }

    }
    private  void copy(String src, String dst, boolean delete) throws Exception
    {
        File file = new File(src);
        if(! file.exists())
        {
            throw new Exception() ;
        }
        if(file.isFile()) {

            fileCopy(file.getPath() , dst+"/"+ file.getName());

            if(delete)
                file.delete();

            return ;
        }

        File[] files = file.listFiles();

        dst = dst + "/" + file.getName(); ;

        File dstFile = new File(dst);

        if(! dstFile.mkdir())
        {
            System.out.println("folder creation failed : " + dst);
            //return ;
        }


        for(File f: files){
            if(f.isDirectory())
            {
                copy(f.getPath(), dst, delete);
            }
            else
            {
                fileCopy(f.getPath(), dst+ "/"+ f.getName());
            }
            if(delete)
                f.delete();
        }

        if(delete)
            file.delete();


    }


    private  void fileCopy(String fn1, String fn2) throws Exception
    {
        //src file, trgt file

            //open fn1 for reading in binary mode, file must exist or an execption would raise.
            FileInputStream fin = new FileInputStream(fn1);

            //open fn3 for writing in binary mode, file will be created or overwritten.
            FileOutputStream fout = new FileOutputStream(fn2);

            //copy
            int n, cnt = 0;
            byte arr[] = new byte[1024];

            while((n = fin.read(arr))!= -1)
            {
                fout.write(arr, 0, n);
                cnt++;
            }

            fout.flush();
            //close the streams
            fout.close();
            fin.close();

    }
}