package com.likaiyuan.fabric.clientrest.clientrest.Bean;

import org.hyperledger.fabric.sdk.Enrollment;
import org.hyperledger.fabric.sdk.User;

import java.io.Serializable;
import java.util.Set;

public class myuser {

    //Fabric user实现类
    public static final class FabricUsersImpl implements User, Serializable{
        private String name;
        private Set<String> roles;
        private String account;
        private String affiliation;
        private String organization;
        private String enrollmentSecret;
        Enrollment enrollment =null;
        private String KeyValStoreName;

        public FabricUsersImpl(String name, String org){
            this.name=name;
            this.organization=org;
        }

        @Override
        public String getName(){
            return this.name;
        }

        @Override
        public Set<String> getRoles(){
            return roles;
        }

        public void setRoles(Set<String> roles){
            this.roles=roles;
        }

        @Override
        public String getAccount(){
            return this.account;
        }

        public void setAccount(String account){
            this.account=account;
        }

        @Override
        public String getAffiliation(){
            return this.affiliation;
        }

        public void setAffiliation(String affiliation){
            this.affiliation=affiliation;
        }

        @Override
        public Enrollment getEnrollment(){
            return this.enrollment;
        }

        public boolean isEnrolled(){
            return this.enrollment !=null;
        }

        public String getEnrollmentSecret(){
            return enrollmentSecret;
        }

        public void setEnrollmentSecret(String enrollmentSecret){
            this.enrollmentSecret=enrollmentSecret;
        }

        public void setEnrollment(Enrollment enrollment){
            this.enrollment=enrollment;
        }

        @Override
        public String getMspId(){
            return mspId;
        }

        String mspId;

        public void setMspId(String mspID){
            this.mspId=mspID;
        }





    }


}
