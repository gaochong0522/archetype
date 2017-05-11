package test;

import Method.CustomXWPFDocument;
import archetype.common.gc.WordUtil;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 高崇 on 2017/5/8.
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("${name}", "huangqiqing");
        param.put("${major}", "信息管理与信息系统");
        param.put("${sex}", "男");
        param.put("${school}", "山东财经大学");
        param.put("${date}", new Date().toString());

        Map<String,Object> header = new HashMap<String, Object>();
        header.put("width", 100);
        header.put("height", 150);
        header.put("type", "jpg");
        header.put("content", WordUtil.inputStream2ByteArray(new FileInputStream("C:\\test\\baby.jpg"), true));
        param.put("${header}",header);

//        Map<String,Object> twocode = new HashMap<String, Object>();
//        twocode.put("width", 100);
//        twocode.put("height", 100);
//        twocode.put("type", "png");
////        twocode.put("content", ZxingEncoderHandler.getTwoCodeByteArray("测试二维码,huangqiqing", 100,100));
//        param.put("${twocode}",twocode);

        CustomXWPFDocument doc = WordUtil.generateWord(param, "C:\\test\\ideaplace\\archetype\\src\\main\\webapp\\abc\\1.docx");
        FileOutputStream fopts = new FileOutputStream("C:\\test\\2.docx");
        doc.write(fopts);
        fopts.close();
    }
}
