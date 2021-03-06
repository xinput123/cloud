package com.xinput.cloud.consts;

import com.xinput.cloud.util.StringUtils;

public final class CloudConsts {

    /**
     * 区域
     */
    public enum Region {
        // 紫光云unicloud
        UNICLOUD_XN1_CQ("cdfe62b9-953b-4f1b-998b-3d932cdfdb54", "西南1-重庆"),
        UNICLOUD_HB1_TJ("a717c4d1-223a-40d3-81a5-8f2a21718635", "华北1-天津"),
        UNICLOUD_HB1_BJ3("HB1-BJMYB", "华北2-北京3");

        private String regionId;
        private String desc;

        Region(String regionId, String desc) {
            this.regionId = regionId;
            this.desc = desc;
        }

        public String getRegionId() {
            return regionId;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 云种类
     */
    public enum CloudEnum {
        UNICLOUD("unicloud", "紫光云");

        private String cloud;

        private String desc;

        CloudEnum(String cloud, String desc) {
            this.cloud = cloud;
            this.desc = desc;
        }

        public String getCloud() {
            return cloud;
        }

        public String getDesc() {
            return desc;
        }
    }

    /**
     * 主机规格编码
     */
    public enum VmSpecificationCode {
        UNICLOUD_S1_MEDIUM_4("s1.medium.4", "通用型 1核4GB"),
        UNICLOUD_S1_LARGE_4("s1.large.4", "通用型 2核8GB"),
        UNICLOUD_S1_XLARGE_4("s1.xlarge.4", "通用型 4核16GB"),
        UNICLOUD_S1_2XLARGE_4("s1.2xlarge.4", "通用型 8核32GB"),
        UNICLOUD_S1_3XLARGE_4("s1.3xlarge.4", "通用型 12核48GB"),
        UNICLOUD_S1_4XLARGE_4("s1.4xlarge.4", "通用型 16核64GB"),
        UNICLOUD_S1_6XLARGE_4("s1.6xlarge.4", "通用型 24核96GB"),
        UNICLOUD_C1_MEDIUM_2("c1.medium.2", "计算型 1核2GB"),
        UNICLOUD_C1_LARGE_2("c1.large.2", "计算型 2核4GB"),
        UNICLOUD_C1_XLARGE_2("c1.xlarge.2", "计算型 4核8GB"),
        UNICLOUD_C1_2XLARGE_2("c1.2xlarge.2", "计算型 8核16GB"),
        UNICLOUD_C1_3XLARGE_2("c1.3xlarge.2", "计算型 12核24GB"),
        UNICLOUD_C1_4XLARGE_2("c1.4xlarge.2", "计算型 16核32GB"),
        UNICLOUD_C1_6XLARGE_2("c1.6xlarge.2", "计算型 24核48GB"),
        UNICLOUD_M1_MEDIUM_8("m1.medium.8", "内存型 1核8GB"),
        UNICLOUD_M1_LARGE_8("m1.large.8", "内存型 2核16GB"),
        UNICLOUD_M1_XLARGE_8("m1.xlarge.8", "内存型 4核32GB"),
        UNICLOUD_M1_2XLARGE_8("m1.2xlarge.8", "内存型 8核64GB"),
        UNICLOUD_M1_3XLARGE_8("m1.3xlarge.8", "内存型 12核96GB"),
        UNICLOUD_M1_4XLARGE_8("m1.4xlarge.8", "内存型 16核128GB"),
        UNICLOUD_M1_6XLARGE_8("m1.6xlarge.8", "内存型 24核192GB"),
        UNICLOUD_H1_LARGE_4("h1.large.4", "高主频通用型 2核8GB"),
        UNICLOUD_H1_XLARGE_4("h1.xlarge.4", "高主频通用型 4核16GB"),
        UNICLOUD_H1_2XLARGE_4("h1.2xlarge.4", "高主频通用型 8核32GB"),
        UNICLOUD_H1_4XLARGE_4("h1.4xlarge.4", "高主频通用型 16核64GB"),
        UNICLOUD_H1_LARGE_2("h1.large.2", "高主频计算型 2核4GB"),
        UNICLOUD_H1_XLARGE_2("h1.xlarge.2", "高主频计算型 4核8GB"),
        UNICLOUD_H1_2XLARGE_2("h1.2xlarge.2", "高主频计算型 8核16GB"),
        UNICLOUD_H1_4XLARGE_2("h1.4xlarge.2", "高主频计算型 16核32GB"),
        UNICLOUD_L1_XLARGE_4("l1.xlarge.4", "本地型 4核16G"),
        UNICLOUD_L1_2XLARGE_4("l1.2xlarge.4", "本地型 8核32GB"),
        UNICLOUD_L1_4XLARGE_4("l1.4xlarge.4", "本地型 16核64GB"),
        UNICLOUD_L1_6XLARGE_4("l1.6xlarge.4", "本地型 24核96GB"),
        UNICLOUD_P1_2XLARGE_8("p1.2xlarge.8", "计算型 8核64GB 1*NVIDIA V100"),
        UNICLOUD_P1_4XLARGE_8("p1.4xlarge.8", "计算型 16核128GB 2*NVIDIA V100");

        private String code;
        private String desc;

        VmSpecificationCode(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }

        public static VmSpecificationCode getVmSpecificationCode(String code) {
            for (VmSpecificationCode vmSpecificationCode : VmSpecificationCode.values()) {
                if (StringUtils.equalsIgnoreCase(vmSpecificationCode.getCode(), code)) {
                    return vmSpecificationCode;
                }
            }

            return null;
        }
    }

    /**
     * 计费方式
     */
    public enum PayTypeEnum {
        UNICLOUD_YEAR_MONTH("YEAR_MONTH", "紫光云计费方式:包年包月"),
        UNICLOUD_CHARGING_HOURS("CHARGING_HOURS", "紫光云计费方式:按小时实时付费"),
        UNICLOUD_DAY_MONTH("DAY_MONTH", "紫光云计费方式:按日月结");
        private String payType;
        private String desc;

        PayTypeEnum(String payType, String desc) {
            this.payType = payType;
            this.desc = desc;
        }

        public String getPayType() {
            return payType;
        }

        public String getDesc() {
            return desc;
        }
    }
}
