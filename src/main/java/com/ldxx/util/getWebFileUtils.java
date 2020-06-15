package com.ldxx.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class getWebFileUtils {

    public static String getWebFile(){
        String jar_parent="";
        try {
            jar_parent = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();
            jar_parent+= File.separator+"LQTProject_file"+File.separator;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jar_parent;
    }
}
