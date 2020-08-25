package com.likaiyuan.fabric.clientrest.clientrest.config;

import java.io.File;

public class FabricConfig {
    public static final String ORG1_MSP = "Org1MSP";

    public static final String ORG1 = "org1";

    public static final String ORG2_MSP = "Org2MSP";

    public static final String ORG2 = "org2";

    public static final String ADMIN = "admin";

    public static final String ADMIN_PASSWORD = "adminpw";

    public static final String CHANNEL_CONFIG_PATH = "config/channel.tx";

    public static final String ORG1_USR_BASE_PATH = "crypto-config" + File.separator + "peerOrganizations" + File.separator
            + "org1.example.com" + File.separator + "users" + File.separator + "Admin@org1.example.com"
            + File.separator + "msp";

    public static final String ORG2_USR_BASE_PATH = "crypto-config" + File.separator + "peerOrganizations" + File.separator
            + "org2.example.com" + File.separator + "users" + File.separator + "Admin@org2.example.com"
            + File.separator + "msp";

    public static final String ORG1_USR_ADMIN_PK = ORG1_USR_BASE_PATH + File.separator + "keystore";
    public static final String ORG1_USR_ADMIN_CERT = ORG1_USR_BASE_PATH + File.separator + "admincerts";

    public static final String ORG2_USR_ADMIN_PK = ORG2_USR_BASE_PATH + File.separator + "keystore";
    public static final String ORG2_USR_ADMIN_CERT = ORG2_USR_BASE_PATH + File.separator + "admincerts";

    public static final String CA_ORG1_URL = "http://10.10.127.51:7054";

    public static final String CA_ORG2_URL = "http://10.10.127.51:8054";

    public static final String ORDERER_URL = "grpc://10.10.127.51:7050";
    public static final String ORDERER_NAME = "orderer.example.com";

    public static final String ORDERER2_NAME = "orderer2.example.com";
    public static final String ORDERER2_URL = "grpc://10.10.127.51:7050";

    public static final String ORDERER3_NAME = "orderer3.example.com";
    public static final String ORDERER3_URL = "grpc://10.10.127.51:7050";

    public static final String ORDERER4_NAME = "orderer4.example.com";
    public static final String ORDERER4_URL = "grpc://10.10.127.51:7050";

    public static final String ORDERER5_NAME = "orderer5.example.com";
    public static final String ORDERER5_URL = "grpc://10.10.127.51:7050";



    public static final String CHANNEL_NAME = "mychannel";


    public static final String ORG1_PEER_0 = "peer0.org1.example.com";

    public static final String ORG1_PEER_0_URL = "grpc://10.10.127.51:7051";

    public static final String ORG1_PEER_1 = "peer1.org1.example.com";

    public static final String ORG1_PEER_1_URL = "grpc://10.10.127.51:8051";

    public static final String ORG2_PEER_0 = "peer0.org2.example.com";

    public static final String ORG2_PEER_0_URL = "grpc://10.10.127.51:9051";

    public static final String ORG2_PEER_1 = "peer1.org2.example.com";

    public static final String ORG2_PEER_1_URL = "grpc://10.10.127.51:10051";


    public static final String CHAINCODE_ROOT_DIR = "chaincode";


    public static final String CHAINCODE_1_NAME = "fabcar";

    public static final String CHAINCODE_1_PATH = "github.com/fabcar";

    public static final String CHAINCODE_1_VERSION = "1";

}
