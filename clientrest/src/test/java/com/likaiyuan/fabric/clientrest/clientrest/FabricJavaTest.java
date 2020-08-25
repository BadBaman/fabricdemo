package com.likaiyuan.fabric.clientrest.clientrest;


import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.exception.TransactionException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;
import org.hyperledger.fabric_ca.sdk.exception.EnrollmentException;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.Security;

import static com.likaiyuan.fabric.clientrest.clientrest.FabricCa.FabricCa.getFabricUser4FabricCA;

/*
* @Author:likaiyuan
*
* */
public class FabricJavaTest {

    //设置加密方式
    static{
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

    }

    public static void main(String[] args) {
        try{
            //创建客户端代理
            HFClient hfClient=HFClient.createNewInstance();
            CryptoSuite cryptoSuite=CryptoSuite.Factory.getCryptoSuite();
            hfClient.setCryptoSuite(cryptoSuite);

            //设置用户
            //User user=getFabricUser4Local("user88","org1","Org1MSP");
            User user=getFabricUser4FabricCA("user88","org1","Org1MSP");
            hfClient.setUserContext(user);

            //创建通道的客户端代理
            Channel channel=hfClient.newChannel("mychannel");

            //创建orderer服务器客户端代理并加入到通道当中
            Orderer orderer=hfClient.newOrderer("orderer.example.com","grpc://192.168.205.1:8050");
            channel.addOrderer(orderer);

            //创建Peer服务器节点的客户端代理并加入到通道当中
            Peer peer=hfClient.newPeer("peer0.org1.example.com","grpc://192.168.205.1:7051");
            channel.addPeer(peer);

            //初始化通道
            channel.initialize();

            //获取IP地址为192.168.205.1的peer服务器的roberttestchannel112的相关信息，包括前面，区块链高度信息等
            BlockchainInfo blockchainInfo=channel.queryBlockchainInfo(peer);
            System.out.println("当前区块哈希为："+blockchainInfo.getCurrentBlockHash()+";当前区块高度为:"+blockchainInfo.getHeight()+";其他信息为:"+blockchainInfo.getBlockchainInfo());

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (CryptoException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (TransactionException e) {
            e.printStackTrace();
        } catch (ProposalException e) {
            e.printStackTrace();
        } catch (org.hyperledger.fabric_ca.sdk.exception.InvalidArgumentException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (EnrollmentException e) {
            e.printStackTrace();
        }
    }


}
