package com.likaiyuan.fabric.clientrest.clientrest.FabricCa;

import com.likaiyuan.fabric.clientrest.clientrest.Bean.myuser;
import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.HFCAClient;
import org.hyperledger.fabric_ca.sdk.exception.EnrollmentException;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;

public class FabricCa {

    //通过Fabric CA获取Fabric账号
    public static User getFabricUser4FabricCA(String username, String org, String orgId) throws IllegalAccessException, InvocationTargetException, InvalidArgumentException, InstantiationException, NoSuchMethodException, CryptoException, ClassNotFoundException, MalformedURLException, EnrollmentException, org.hyperledger.fabric_ca.sdk.exception.InvalidArgumentException {

        myuser.FabricUsersImpl user=new myuser.FabricUsersImpl(username,org);
        user.setMspId(orgId);
        CryptoSuite cryptoSuite=CryptoSuite.Factory.getCryptoSuite();
        HFCAClient hfcaClient= HFCAClient.createNewInstance("http://192.168.205.1:7054",null);
        hfcaClient.setCryptoSuite(cryptoSuite);
        Enrollment enrollment=hfcaClient.enroll("user88","peer2wd");
        user.setEnrollment(enrollment);
        return user;
    }
}
