package com.likaiyuan.fabric.clientrest.clientrest.Enrollment;

import org.hyperledger.fabric.sdk.Enrollment;

import java.io.Serializable;
import java.security.PrivateKey;

public class enrollment {

    //enrollm实现类
    public static class EnrollMentImpl implements Enrollment ,Serializable{
        private static final long serialVersionUID = -2784835212445309006L;
        private final PrivateKey privateKey;
        private final String certificate;
        public EnrollMentImpl(PrivateKey privateKey,String certificate){
            this.certificate=certificate;
            this.privateKey=privateKey;
        }

        @Override
        public PrivateKey getKey(){
            return privateKey;
        }

        @Override
        public String getCert(){
            return certificate;
        }

    }
}
