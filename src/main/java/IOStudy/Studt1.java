package IOStudy;

import java.io.*;

/**
 * Created by 高崇 on 2017/5/5.
 */
public class Studt1 {
    public static void main(String[] args) {
        File file =  new File ("C:\\test\\test\\like1.txt");
        File file1 =  new File ("C:\\test\\test\\like.txt");
        if (!file1.exists()){
            file.mkdir();
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            int c ;
            while ((c = bis.read())!=-1){
                bos.write(c);
                bos.flush();
            }
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createFile(){
        File file =  new File("C:\\test\\test");
        File file1 =  new File(file,"\\makedir");
        File file2 = new File(file,"like.txt");
//        file1.mkdir();
        if (file.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void copyFile(){
        File file = new File("C:\\test\\test\\like.txt");
        File file1 = new File("C:\\test\\test\\file.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            byte[] bytes =  new byte[8*1024];
            int b = 0;
            try {
                while ((b = fileInputStream.read(bytes,0,bytes.length))!=-1) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.flush();
                }
                fileOutputStream.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
