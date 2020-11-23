package com.xinput.unicloud.model.response.keypair;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 创建密钥对 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudCreateKeyPairResp extends UniResponse {

    /**
     * 密钥对ID
     */
    private String instanceId;

    /**
     * 名称
     */
    private String name;

    /**
     * 指纹
     */
    private String fingerPrint;

    /**
     * 区域
     */
    private String regionId;

    /**
     * 状态
     */
    private String status;

    /**
     * 公钥
     */
    private String publicKey;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 私钥
     */
    private String privateKey;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public void setFingerPrint(String fingerPrint) {
        this.fingerPrint = fingerPrint;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
