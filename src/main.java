

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class main {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        System.out.println("enter the path of folder/file to be copied");
        String src= scan.next();  //"C:/Users/mismi7298/Desktop/Interviews_Top_Questions_Topics_SystemDesign_Notes";

        System.out.println("enter the location of the folder/file to be copied at");
        String dst = scan.next();//"C:/Users/mismi7298/Desktop/toBeC";

        copy(src , dst);

    }

    private static void copy(String src, String dst)
    {
        File file = new File(src);
        File[] files = file.listFiles();

        //String parFolder = file.getParentFile.getName();
        dst = dst + "/" + file.getName(); ;

        System.out.println(src);
        System.out.println(dst);

        File dstFile = new File(dst);

        if(! dstFile.mkdir())
        {
            System.out.println("folder creation failed : " + dst);
            //return ;
        }


        for(File f: files){
            //System.out.println( f.getPath());
            //System.out.println(dst+"/"+f.getName());
            if(f.isDirectory())
            {
                copy(f.getPath(), dst);
            }
            else
            {
                fileCopy(f.getPath(), dst+ "/"+ f.getName());
            }
        }
    }

    private static void fileCopy(String fn1, String fn2)
    {
        try
        {
            //String fn1 = args[0];//src file
            //String fn2 = args[1];//trgt file

            //open fn1 for reading in binary mode, file must exist or an execption would raise.
            FileInputStream fin = new FileInputStream(fn1);

            //open fn3 for writing in binary mode, file will be created or overwritten.
            FileOutputStream fout = new FileOutputStream(fn2);

            //copy
            int n, cnt = 0;
            byte arr[] = new byte[1024];

            //while((n = fin.read())!= -1)
            //{
            //  fout.write(n);
            //  cnt++;
            //}

            while((n = fin.read(arr))!= -1)
            {
                fout.write(arr, 0, n);
                cnt++;
            }

            fout.flush();

            //close the streams
            fout.close();
            fin.close();

            //System.out.printf("File Copied in %d cycles", cnt);
        }
        catch(Exception ex)
        {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}