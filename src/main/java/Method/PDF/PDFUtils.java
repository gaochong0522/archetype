package Method.PDF;


import java.io.*;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * Created by gc on 2017/6/27.
 */
public class PDFUtils {
    public static void makeWork(String name){
        File pdfFile = new File(name);
        PDDocument document = null;
        try
        {
            // 方式一：
            /**
             InputStream input = null;
             input = new FileInputStream( pdfFile );
             //加载 pdf 文档
             PDFParser parser = new PDFParser(new RandomAccessBuffer(input));
             parser.parse();
             document = parser.getPDDocument();
             **/

            // 方式二：
            document=PDDocument.load(pdfFile);

            // 获取页码
            int pages = document.getNumberOfPages();

            // 读文本内容
            PDFTextStripper stripper=new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(pages);
            String content = stripper.getText(document);
           File b =new File("c:\\test\\test\\b.txt");
           if (!b.exists()){
               b.createNewFile();
           }
            FileWriter fileWriter = new FileWriter(b);
            fileWriter.write(content);
            fileWriter.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}
