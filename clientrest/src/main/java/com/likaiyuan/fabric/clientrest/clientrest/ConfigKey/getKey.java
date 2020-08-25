package com.likaiyuan.fabric.clientrest.clientrest.java.com.likaiyuan.fabric.clientrest.clientrest.ConfigKey;

import java.io.File;

import static java.lang.String.format;

public class getKey {

    //获取私钥文件
    public static File findFileSk(String directorys){
        File directory =new File(directorys);
        File[] matches=directory.listFiles((dir,name) -> name.endsWith("_sk"));

        if(null==matches){
            throw new RuntimeException(format("Matches returned null does %s directory exist?",directory.getAbsoluteFile().getName()));
        }
        if(matches.length!=1){
            throw new RuntimeException(format("Excepted in %s only 1 sk file but found %d",directory.getAbsoluteFile().getName(),matches.length));
        }
        return matches[0];
    }

}
