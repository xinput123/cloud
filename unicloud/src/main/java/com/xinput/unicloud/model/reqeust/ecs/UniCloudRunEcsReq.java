package com.xinput.unicloud.model.reqeust.ecs;

import com.xinput.cloud.consts.CloudConsts;
import com.xinput.cloud.domain.req.RunEcsReq;
import com.xinput.cloud.exception.ParamException;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-19 19:36
 */
public class UniCloudRunEcsReq extends UniRequest {

    /**
     * 类型：String
     * 必选：是
     * 描述：硬盘实例ID
     */
    @NotEmpty(message = "字段 [azoneId] 不能为空")
    private String azoneId;

    /**
     * 类型：String
     * 必选：是
     * 描述：计费方式
     */
    @NotEmpty(message = "字段 [payType] 不能为空")
    private String payType;

    /**
     * 类型：int
     * 必选：是
     * 描述：购买租期(月)
     * 如果 payType 的值是 CHARGING_HOURS，则 period 的值固定为1
     */
    private Integer period;

    /**
     * 类型：string
     * 必选：是
     * 描述：版本号 见{@link com.xinput.cloud.consts.CloudConsts.VmSpecificationCode} 以 UNICLOUD_ 开头
     */
    @NotEmpty(message = "字段 [vmSpecificationCode] 不能为空")
    private String vmSpecificationCode;

    /**
     * 类型：string
     * 必选：是
     * 描述：系统盘规格
     */
    @NotEmpty(message = "字段 [sysDiskSpecificationCode] 不能为空")
    private String sysDiskSpecificationCode;

    /**
     * 类型：string
     * 必选：是
     * 描述：系统盘大小(G)
     */
    @NotNull(message = "字段 [sysDiskSize] ")
    private Integer sysDiskSize;

    /**
     * 类型：string
     * 必选：是
     * 描述：镜像ID
     */
    @NotEmpty(message = "字段 [imageId] 不能为空")
    private String imageId;

    /**
     * 类型：string
     * 必选：是
     * 描述：镜像规格族,详见枚举说明
     */
    @NotEmpty(message = "字段 [imageSpecificationClassCode] 不能为空")
    private String imageSpecificationClassCode;

    /**
     * 类型：string
     * 必选：否
     * 描述：使用的vpc
     */
    @NotEmpty(message = "字段 [vpcId] 不能为空")
    private String vpcId;

    /**
     * 类型：string
     * 必选：否
     * 描述：绑定的安全组
     */
    @NotEmpty(message = "字段 [securityGroupId] 不能为空")
    private String securityGroupId;

    /**
     * 类型：string
     * 必选：否
     * 描述：EIP规格
     */
    private String bandWidthSpecificationCode;

    /**
     * 类型：string
     * 必选：否
     * 描述：EIP带宽
     */
    private int bandWidthSize;

    /**
     * 类型：string
     * 必选：否
     * 描述：云主机初始密码
     */
    private String password;

    /**
     * 类型：string
     * 必选：否
     * 描述：密钥对ID
     */
    private String keyPair;

    /**
     * 类型：string
     * 必选：是
     * 描述：实例名称(字母开头，包含字母数字，2到15个字符)
     */
    @NotEmpty(message = "字段 [instanceName] 不能为空")
    @Size(min = 2, max = 15, message = "字段 [instanceName] 字母开头，包含字母数字，2到15个字符")
    private String instanceName;

    /**
     * 类型：string
     * 必选：否
     * 描述：虚机hostName，不指定是使用instanceName
     */
    private String hostName;

    /**
     * 类型：string
     * 必选：否
     * 描述：虚机描述
     */
    private String description;

    /**
     * 类型：int
     * 必选：是
     * 描述：购买数量
     */
    @NotNull(message = "字段 [baseQuantity] 值不能为空")
    private Integer baseQuantity;

    /**
     * 类型：string
     * 必选：否
     * 描述：主网卡所在子网ID
     */
    private String masterEniSubNetId;

    /**
     * 类型：string
     * 必选：否
     * 描述：主网卡名称
     */
    private String masterEniName;

    /**
     * 类型：string
     * 必选：否
     * 描述：辅助网卡所在子网ID
     */
    private String secondaryEniSubNetId;

    /**
     * 类型：string
     * 必选：否
     * 描述：辅助网卡名称
     */
    private String secondaryEniName;

    /**
     * 类型：string
     * 必选：否
     * 描述：初始化脚本
     */
    private String initialShell;

    /**
     * 类型：List<DataDisk>
     * 必选：否
     */
    private List<DataDisk> DataDisks;

    public String getAzoneId() {
        return azoneId;
    }

    public void setAzoneId(String azoneId) {
        this.azoneId = azoneId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
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

    public Integer getSysDiskSize() {
        return sysDiskSize;
    }

    public void setSysDiskSize(Integer sysDiskSize) {
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

    public Integer getBaseQuantity() {
        return baseQuantity;
    }

    public void setBaseQuantity(Integer baseQuantity) {
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

    public List<DataDisk> getDataDisks() {
        return DataDisks;
    }

    public void setDataDisks(List<DataDisk> dataDisks) {
        DataDisks = dataDisks;
    }

    @Override
    public void checkConstraints() throws ParamException {
        if (StringUtils.isAllEmpty(this.keyPair, this.password)) {
            throw new ParamException("字段 [keyPair]或[password] 不能都为空.");
        }

        if (!StringUtils.equalsIgnoreCase(UniCloudConsts.Action.RUN_ECS.getAction(), this.getAction())) {
            this.setAction(UniCloudConsts.Action.RUN_ECS.getAction());
        }

        this.checkField();
    }

    public UniCloudRunEcsReq(RunEcsReq runEcsReq) {
        super.setAction(UniCloudConsts.Action.RUN_ECS.getAction());
        if (runEcsReq.getRegion() != null) {
            super.setRegionId(runEcsReq.getRegion().getRegionId());
        }
        this.azoneId = runEcsReq.getAzoneId();

        if (runEcsReq.getPayType() != null) {
            this.payType = runEcsReq.getPayType().getPayType();
        }
        if (CloudConsts.PayTypeEnum.UNICLOUD_CHARGING_HOURS == runEcsReq.getPayType()) {
            this.period = 1;
        } else {
            this.period = runEcsReq.getPeriod();
        }

        this.vmSpecificationCode = runEcsReq.getVmSpecificationCode();
        this.sysDiskSpecificationCode = runEcsReq.getSysDiskSpecificationCode();
        this.sysDiskSize = runEcsReq.getSysDiskSize();
        this.imageId = runEcsReq.getImageId();
        this.imageSpecificationClassCode = runEcsReq.getImageSpecificationClassCode();
        this.vpcId = runEcsReq.getVpcId();
        this.securityGroupId = runEcsReq.getSecurityGroupId();
        this.bandWidthSpecificationCode = runEcsReq.getBandWidthSpecificationCode();
        this.bandWidthSize = runEcsReq.getBandWidthSize();
        this.password = runEcsReq.getPassword();
        this.keyPair = runEcsReq.getKeyPair();
        this.instanceName = runEcsReq.getInstanceName();
        this.hostName = runEcsReq.getHostName();
        this.description = runEcsReq.getDescription();
        this.baseQuantity = runEcsReq.getBaseQuantity();
        this.masterEniSubNetId = runEcsReq.getMasterEniSubNetId();
        this.masterEniName = runEcsReq.getMasterEniName();
        this.secondaryEniSubNetId = runEcsReq.getSecondaryEniSubNetId();
        this.secondaryEniName = runEcsReq.getSecondaryEniName();
        this.initialShell = runEcsReq.getInitialShell();
    }

    public static class DataDisk {

        /**
         * 类型：string
         * 必选：是
         * 描述：数据盘规格
         */
        private String dataDiskSpecificationCode;

        /**
         * 类型：int
         * 必选：是
         * 描述：数据盘大小
         */
        private int dataDiskSize;

        /**
         * 类型：string
         * 必选：否
         * 描述：如使用整机镜像，需指定源镜像下属的数据盘镜像ID
         */
        private String templateId;

        public String getDataDiskSpecificationCode() {
            return dataDiskSpecificationCode;
        }

        public void setDataDiskSpecificationCode(String dataDiskSpecificationCode) {
            this.dataDiskSpecificationCode = dataDiskSpecificationCode;
        }

        public int getDataDiskSize() {
            return dataDiskSize;
        }

        public void setDataDiskSize(int dataDiskSize) {
            this.dataDiskSize = dataDiskSize;
        }

        public String getTemplateId() {
            return templateId;
        }

        public void setTemplateId(String templateId) {
            this.templateId = templateId;
        }
    }
}
