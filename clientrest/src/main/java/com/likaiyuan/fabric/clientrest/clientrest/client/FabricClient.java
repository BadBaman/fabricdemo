package com.likaiyuan.fabric.clientrest.clientrest.client;

import com.likaiyuan.fabric.clientrest.clientrest.Bean.FabricUser;
import org.hyperledger.fabric.sdk.*;
import org.hyperledger.fabric.sdk.exception.CryptoException;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;
import org.hyperledger.fabric.sdk.exception.ProposalException;
import org.hyperledger.fabric.sdk.security.CryptoSuite;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricClient {

    private HFClient instance;

    public HFClient getInstance(){return instance;}


    /*
     * @likaiyuan
     * 本方法用于建立Fabric客户端
     * 并赋予密钥和用户上下文信息
     * */
    public FabricClient(FabricUser context) throws CryptoException, InvalidArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        CryptoSuite cryptoSuite = CryptoSuite.Factory.getCryptoSuite();
        // setup the client
        instance = HFClient.createNewInstance();
        instance.setCryptoSuite(cryptoSuite);
        //instance.setUserContext(context);
    }

    /*
     * 调用另一个类
     * 实现创建通道客户端
     * */

    public ChannelClient createChannelClient(String name) throws InvalidArgumentException {
        Channel channel = instance.newChannel(name);
        ChannelClient client = new ChannelClient(name, channel, this);
        return client;
    }

    /*
     *
     * 实现调用智能合约
     * */
    /*public Collection<ProposalResponse> deployChainCode(String chainCodeName, String chaincodePath, String codepath,
                                                        String language, String version, Collection<Peer> peers)
            throws InvalidArgumentException, IOException, ProposalException {
        LifecycleInstallChaincodeRequest request = instance.newLifecycleInstallChaincodeRequest();
        ChaincodeID.Builder chaincodeIDBuilder = ChaincodeID.newBuilder().setName(chainCodeName).setVersion(version)
                .setPath(chaincodePath);
        ChaincodeID chaincodeID = chaincodeIDBuilder.build();
        Logger.getLogger(FabricClient.class.getName()).log(Level.INFO,
                "Deploying chaincode " + chainCodeName + " using Fabric client " + instance.getUserContext().getMspId()
                        + " " + instance.getUserContext().getName());
        request.setChaincodeID(chaincodeID);
        request.setUserContext(instance.getUserContext());
        request.setChaincodeSourceLocation(new File(codepath));
        request.setChaincodeVersion(version);
        Collection<ProposalResponse> responses = instance.sendInstallProposal(request, peers);
        return responses;
    }*/

}