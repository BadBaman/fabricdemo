package com.likaiyuan.fabric.clientrest.clientrest.Cryptogen;

import com.likaiyuan.fabric.clientrest.clientrest.Bean.myuser;
import org.apache.commons.io.IOUtils;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.PrivateKey;

import static com.likaiyuan.fabric.clientrest.clientrest.ConfigKey.ConfigKey.getPrivateKeyFromBytes;

public class Cryptogen {

    //根据cryptogen模块生成的账号创建Fabric账号
    public static User getFabricUser4Local(String username, String org, String orgId) throws IOException {

        myuser.FabricUsersImpl user= new myuser.FabricUsersImpl(username,org);
        user.setMspId(orgId);
        String certificate =new String(IOUtils.toByteArray(String.valueOf(new File(String.valueOf(new File("/home/go/src/github.com/hyperledger/fabric/fabric-samples/first-network/crypto-config/peerOrganizations/example.com/users/Admin@example.com/msp/signcerts/Admin@example.com-cert.pem"))))),"UTF-8");
        File privatekeyfile =new File("/home/go/src/github.com/hyperledger/fabric/fabric-samples/first-network/crypto-config/peerOrganizations/org1.example.com/users/Admin@org1.example.com/msp/signcerts/Admin@org1.example.com-cert.pem");
        PrivateKey privateKey =getPrivateKeyFromBytes(IOUtils.toByteArray(new FileInputStream(privatekeyfile)));

        EnrollMentImpl enrollment= new EnrollMentImpl(privateKey,certificate);
        user.setEnrollment(enrollment);
        return user;
    }

    //enrollm实现类
    static class EnrollMentImpl implements Enrollment , Serializable {
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
