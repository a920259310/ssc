package com.springboot.zcssc.utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.net.URL;

public class ImgUtil {
    /**
     * 验证码识别
     * @param imgUri   验证码流
     * @return
     */
    public static String getCodeByImg(String imgUri) {
        ITesseract instance = new Tesseract();//调用Tesseract
        URL url = ClassLoader.getSystemClassLoader().getResource("tessdata");//获得Tesseract的文字库
        String tesspath = url.getPath().substring(1);
        instance.setDatapath(tesspath);//进行读取，默认是英文，如果要使用中文包，加上instance.setLanguage("chi_sim"); 
        String result = null;
        try {
            File file = new File(imgUri);
            result = instance.doOCR(file);
        } catch (TesseractException e1) {
            e1.printStackTrace();
        }

        System.out.println("验证码替换前result:"+result);
        result = result.replaceAll("[^a-z^A-Z^0-9]", "");//替换大小写及数字
        result = result.replaceAll("[^\\d]", "");
        System.out.println("验证码替换后result:"+result);
        return result;
    }
}
