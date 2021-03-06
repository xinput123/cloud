package com.xinput.unicloud.model.response.keypair;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 获取密钥对列表 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDescribeKeyPairResp extends UniResponse {

    private int size;

    private int totalCount;

    private int totalPages;

    private int page;

    @JsonProperty(value = "list")
    private List<DescribeKeyPair> describeKeyPairs;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<DescribeKeyPair> getDescribeKeyPairs() {
        return describeKeyPairs;
    }

    public void setDescribeKeyPairs(List<DescribeKeyPair> describeKeyPairs) {
        this.describeKeyPairs = describeKeyPairs;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DescribeKeyPair {

        /**
         * 公钥
         */
        private String publicKey;

        /**
         * 指纹
         */
        private String fingerPrint;

        /**
         * 创建时间,单位毫秒
         */
        private Long createTime;

        /**
         * 状态
         */
        private String status;

        /**
         * 名称
         */
        private String name;

        /**
         * 密钥对ID
         */
        private String instanceId;

        /**
         * 地区ID
         */
        private String regionId;

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String publicKey) {
            this.publicKey = publicKey;
        }

        public String getFingerPrint() {
            return fingerPrint;
        }

        public void setFingerPrint(String fingerPrint) {
            this.fingerPrint = fingerPrint;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInstanceId() {
            return instanceId;
        }

        public void setInstanceId(String instanceId) {
            this.instanceId = instanceId;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
