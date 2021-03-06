package com.xinput.cloud.domain.req;

import com.xinput.cloud.consts.CloudConsts;

/**
 * 创建云主机
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 19:34
 */
public class RunEcsReq {

    /**
     * 类型：String
     * 描述：区域Id {@link com.xinput.cloud.consts.CloudConsts.Region}
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private CloudConsts.Region region;

    /**
     * 类型：String
     * 描述：硬盘实例ID
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String azoneId;

    /**
     * 类型：String
     * 描述：计费方式
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.PayTypeEnum #UniCloud}
     */
    private CloudConsts.PayTypeEnum payType;

    /**
     * 类型：int
     * 描述：购买租期(月)
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private int period;

    /**
     * 类型：string
     * 描述：版本号
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String vmSpecificationCode;

    /**
     * 类型：string
     * 描述：系统盘规格
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String sysDiskSpecificationCode;

    /**
     * 类型：string
     * 描述：系统盘大小(G)
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private int sysDiskSize;

    /**
     * 类型：string
     * 描述：镜像ID
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String imageId;

    /**
     * 类型：string
     * 描述：镜像规格族,详见枚举说明
     * 适用云: {@link com.xinput.cloud.consts.CloudConsts.CloudEnum #UniCloud}
     */
    private String imageSpecificationClassCode;

    /**
     * 类型：string
     * 描述：使用的vpc
     */
    private String vpcId;

    /**
     * 类型：string
     * 描述：绑定的安全组
     */
    private String securityGroupId;

    /**
     * 类型：string
     * 描述：EIP规格
     */
    private String bandWidthSpecificationCode;

    /**
     * 类型：string
     * 描述：EIP带宽
     */
    private int bandWidthSize;

    /**
     * 类型：string
     * 描述：云主机初始密码
     */
    private String password;

    /**
     * 类型：string
     * 描述：密钥对ID
     */
    private String keyPair;

    /**
     * 类型：string
     * 描述：实例名称(字母开头，包含字母数字，2到15个字符)
     */
    private String instanceName;

    /**
     * 类型：string
     * 描述：虚机hostName，不指定是使用instanceName
     */
    private String hostName;

    /**
     * 类型：string
     * 描述：虚机描述
     */
    private String description;

    /**
     * 类型：int
     * 描述：购买数量
     */
    private int baseQuantity;

    /**
     * 类型：string
     * 描述：主网卡所在子网ID
     */
    private String masterEniSubNetId;

    /**
     * 类型：string
     * 描述：主网卡名称
     */
    private String masterEniName;

    /**
     * 类型：string
     * 描述：辅助网卡所在子网ID
     */
    private String secondaryEniSubNetId;

    /**
     * 类型：string
     * 描述：辅助网卡名称
     */
    private String secondaryEniName;

    /**
     * 类型：string
     * 描述：初始化脚本
     */
    private String initialShell;

    public CloudConsts.Region getRegion() {
        return region;
    }

    public void setRegion(CloudConsts.Region region) {
        this.region = region;
    }

    public String getAzoneId() {
        return azoneId;
    }

    public void setAzoneId(String azoneId) {
        this.azoneId = azoneId;
    }

    public CloudConsts.PayTypeEnum getPayType() {
        return payType;
    }

    public void setPayType(CloudConsts.PayTypeEnum payType) {
        this.payType = payType;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getVmSpecificationCode() {
        return vmSpecificationCode;
    }

    public void setVmSpecificationCode(String vmSpecificationCode) {
        this.vmSpecificationCode = vmSpecificationCode;
    }

    public String getSysDiskSpecificationCode() {
        return sysDiskSpecificationCode;
    }

    public void setSysDiskSpecificationCode(String sysDiskSpecificationCode) {
        this.sysDiskSpecificationCode = sysDiskSpecificationCode;
    }

    public int getSysDiskSize() {
        return sysDiskSize;
    }

    public void setSysDiskSize(int sysDiskSize) {
        this.sysDiskSize = sysDiskSize;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageSpecificationClassCode() {
        return imageSpecificationClassCode;
    }

    public void setImageSpecificationClassCode(String imageSpecificationClassCode) {
        this.imageSpecificationClassCode = imageSpecificationClassCode;
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId;
    }

    public String getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public String getBandWidthSpecificationCode() {
        return bandWidthSpecificationCode;
    }

    public void setBandWidthSpecificationCode(String bandWidthSpecificationCode) {
        this.bandWidthSpecificationCode = bandWidthSpecificationCode;
    }

    public int getBandWidthSize() {
        return bandWidthSize;
    }

    public void setBandWidthSize(int bandWidthSize) {
        this.bandWidthSize = bandWidthSize;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyPair() {
        return keyPair;
    }

    public void setKeyPair(String keyPair) {
        this.keyPair = keyPair;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBaseQuantity() {
        return baseQuantity;
    }

    public void setBaseQuantity(int baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    public String getMasterEniSubNetId() {
        return masterEniSubNetId;
    }

    public void setMasterEniSubNetId(String masterEniSubNetId) {
        this.masterEniSubNetId = masterEniSubNetId;
    }

    public String getMasterEniName() {
        return masterEniName;
    }

    public void setMasterEniName(String masterEniName) {
        this.masterEniName = masterEniName;
    }

    public String getSecondaryEniSubNetId() {
        return secondaryEniSubNetId;
    }

    public void setSecondaryEniSubNetId(String secondaryEniSubNetId) {
        this.secondaryEniSubNetId = secondaryEniSubNetId;
    }

    public String getSecondaryEniName() {
        return secondaryEniName;
    }

    public void setSecondaryEniName(String secondaryEniName) {
        this.secondaryEniName = secondaryEniName;
    }

    public String getInitialShell() {
        return initialShell;
    }

    public void setInitialShell(String initialShell) {
        this.initialShell = initialShell;
    }
}
