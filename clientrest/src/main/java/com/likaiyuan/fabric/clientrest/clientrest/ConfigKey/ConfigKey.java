package com.likaiyuan.fabric.clientrest.clientrest.ConfigKey;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.security.PrivateKey;
import java.security.Security;

public class ConfigKey {

    static{
        Security.addProvider(new BouncyCastleProvider());

    }
    //从配置文件中获取私钥
    public static PrivateKey getPrivateKeyFromBytes(byte[] data) throws IOException {

        final Reader pemReader=new StringReader(new String(data));
        final PrivateKeyInfo pemPair;
        PEMParser pemParser=new PEMParser(pemReader);
        pemPair=(PrivateKeyInfo)pemParser.readObject();
        PrivateKey privateKey=new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME).getPrivateKey(pemPair);
        return privateKey;
    }

}
