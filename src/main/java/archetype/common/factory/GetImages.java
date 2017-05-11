package archetype.common.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class GetImages {
 
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        GetImages getImages = new GetImages();
//        String targetImage = "http://api.map.baidu.com/staticimage/v2?ak=wjEn6346hlaKwHV2KhO4jw9xxtZpfc6N&mcode=333333&center=106.313874,39.014888&width=800&markers=106.313874,39.014888&markerStyles=l,A&height=500&zoom=11";
//        String savePath=PathKit.getWebRootPath()+"/"+"/mapimg";
//        getImages.getImage(targetImage,savePath,"test3");
    }
     
    public void getImage(String targetImage,String savePath,String filename){
        URL url = null;
        FileOutputStream outfile = null;
        InputStream infile = null;
        URLConnection con = null;
        byte [] buffer = null;
        try {
            url = new URL(targetImage);
            //文件保存位置  
            File saveDir = new File(savePath);  
            if(!saveDir.exists()){  
                saveDir.mkdir();  
            } 
            outfile = new FileOutputStream(saveDir+File.separator+filename+".jpg", false);
            con = url.openConnection();
            infile = con.getInputStream();
            buffer = new byte[1024];
            int j = 0;
            
            while( (j = infile.read(buffer)) != -1 )
            {
            	outfile.write(buffer,0,j);
            }
      
            if (outfile != null)
            {
            	outfile.close();
            }
            
            
//            if(infile.available()>0 == false){
//             continue;
//            }else{
//				Thread.sleep(200);
//            }
//            count = infile.read(buffer);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//            while(infile.read(buffer, 0, 1024) != -1){
//                outfile.write(buffer);
//            }
            //infile.read(buffer, 0, fileLenght);
            //outfile.write(buffer, 0, fileLenght);
            System.out.println("image save ok");
            infile.close();
            outfile.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        	
    }
}