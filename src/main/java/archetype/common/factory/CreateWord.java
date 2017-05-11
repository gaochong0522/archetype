package archetype.common.factory;

import java.awt.Color;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import java.util.Date;

import sun.util.logging.resources.logging;

import com.lowagie.text.Cell;
import com.lowagie.text.DocumentException;

import com.lowagie.text.Document;

import com.lowagie.text.Element;

import com.lowagie.text.Font;

import com.lowagie.text.Image;

import com.lowagie.text.PageSize;

import com.lowagie.text.Paragraph;

import com.lowagie.text.Rectangle;

import com.lowagie.text.Table;

import com.lowagie.text.rtf.RtfWriter2;

import com.lowagie.text.rtf.style.RtfFont;

public class CreateWord {

	public static void main(String[] args) throws Exception {
		CreateWord cWord=new CreateWord();
		String targetImage = "http://api.map.baidu.com/staticimage/v2?ak=wjEn6346hlaKwHV2KhO4jw9xxtZpfc6N&mcode=333333&center=106.313874,39.014888&width=595&markers=106.313874,39.014888&markerStyles=l,A&height=300&zoom=11";
		   String savePath=""+"/"+"mapimg/";
		cWord.createword("1","2","make1", "money1",targetImage,savePath);
		
	}
		public void createword(String mapname,String username,String name, String imgName,String targetImage, String savePath){
		Rectangle rectPageSize = new Rectangle(PageSize.A4);

		rectPageSize = rectPageSize.rotate();
		//document document = new document(rectangle.rotate());

		Document doc = new Document(PageSize.A4.rotate());

		String  fileName=savePath+name+"_"+username+".doc";


		try {
			File saveDir = new File(savePath);  
            if(!saveDir.exists()){  
                saveDir.mkdir();  
            } 
			RtfWriter2.getInstance(doc, new FileOutputStream(fileName));

		doc.open();


		RtfFont titleFont = new RtfFont("仿宋_GB2312", 15, Font.BOLD,

				Color.BLACK);


		RtfFont contextFont = new RtfFont("仿宋_GB2312", 12, Font.NORMAL,

				Color.BLACK);

		GetImages getImages=new GetImages();
		
		   getImages.getImage(targetImage,savePath,imgName);
			Image png = Image.getInstance(savePath+File.separator+imgName+".jpg");   
//			(savePath+imgName+".jpg");
			doc.add(png); 


		String contextString = "注：图中A点为估价对象位置";
		String contextString1 = "估价对象"+(mapname.equals("0")?"":mapname)+"位置图";

		Paragraph context = new Paragraph(contextString);

		context.setAlignment(Element.ALIGN_LEFT);

		context.setFont(contextFont);

		context.setSpacingBefore(10);
		
		Paragraph context1 = new Paragraph(contextString1);
		
		context1.setAlignment(Element.ALIGN_CENTER);
		
		context1.setFont(titleFont);
		
		context1.setSpacingBefore(10);


		// context.setFirstLineIndent(20);

		doc.add(context);
		doc.add(context1);


	
		doc.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
