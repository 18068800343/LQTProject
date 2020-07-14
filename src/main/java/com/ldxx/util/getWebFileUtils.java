package com.ldxx.util;

import org.springframework.boot.system.ApplicationHome;

import java.io.File;

public class getWebFileUtils {

    public String getWebFile(){
        String jar_parent="";
        try {
            ApplicationHome h = new ApplicationHome(getClass());
            File jarF = h.getSource();
            System.out.println(jarF.getParentFile().toString());
            jar_parent =jarF.getParentFile().toString();
            /*jar_parent = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();*/
            jar_parent+= File.separator+"LQTProject_file"+File.separator;
            System.out.println(jar_parent);

        } catch (/*FileNotFound*/Exception e) {
            e.printStackTrace();
        }
        return jar_parent;
    }
}
