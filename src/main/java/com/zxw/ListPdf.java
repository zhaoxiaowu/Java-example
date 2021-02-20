package com.zxw;

import java.io.File;

/**
 * @author: wuhongyun
 * @date: 2021/2/20
 */
public class ListPdf {
    public static final String FILE_NAME = "D:\\PDF\\pdf\\web\\";
    public static final String LINK_PREFIX = "https://tostringcc.gitee.io/pdf/web/viewer.html?file=";

    public static void main(String[] args) {
        String path = FILE_NAME;
        listPdf(path);
    }

    static void listPdf(String path) {
        File dir = new File(path);
        File[] subFiles = dir.listFiles(); //获取D盘下所有的文件和文件夹对象
        for (File subFile : subFiles) {
            if (subFile.isFile() && subFile.getName().endsWith(".pdf")) {
                String result = subFile.toString().replace(FILE_NAME, "");
                String link = LINK_PREFIX + result;
                //生成markdown 语法 []() 无法跳转到新页面
                //System.out.println(" - [" + subFile.getName().replace(".pdf", "") + "](" + link + ")");
                //<a href="http://write.blog.csdn.net/postlist" target="_blank">跳到自己博客列表</a>
                System.out.println("- <a href=\"" + link + "\" target=\"_blank\">" + subFile.getName().replace(".pdf", "") + "</a>");
                System.out.println("");
            } else if (subFile.isDirectory()) {
                listPdf(subFile.toString());
            }
        }
    }
}
