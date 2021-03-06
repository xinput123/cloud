package com.xinput.unicloud.model.response.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.unicloud.model.response.UniResponse;

import java.util.List;

/**
 * 查看私有镜像列表 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudDescribeImageResp extends UniResponse {

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 请求size
     */
    private Integer pageSize;

    /**
     * 请求page
     */
    private Integer pageNumber;

    private List<Image> images;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Image {

        /**
         * 操作系统
         */
        private String ostype;

        /**
         * 大小
         */
        private Integer size;

        /**
         * 创建时间，单位毫秒
         */
        private Long creationTime;

        /**
         * 状态
         */
        private String status;

        /**
         * 地区ID
         */
        private String regionId;

        private DataImageInfo dataImageInfo;

        /**
         * 可用区ID
         */
        private String zoneId;

        /**
         * 镜像名
         */
        private String imageName;

        /**
         * 操作系统版本
         */
        private String operatingSystem;

        /**
         * 镜像ID
         */
        private String imageId;

        public String getOstype() {
            return ostype;
        }

        public void setOstype(String ostype) {
            this.ostype = ostype;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public long getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(long creationTime) {
            this.creationTime = creationTime;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getRegionId() {
            return regionId;
        }

        public void setRegionId(String regionId) {
            this.regionId = regionId;
        }

        public DataImageInfo getDataImageInfo() {
            return dataImageInfo;
        }

        public void setDataImageInfo(DataImageInfo dataImageInfo) {
            this.dataImageInfo = dataImageInfo;
        }

        public String getZoneId() {
            return zoneId;
        }

        public void setZoneId(String zoneId) {
            this.zoneId = zoneId;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getOperatingSystem() {
            return operatingSystem;
        }

        public void setOperatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

        /**
         * 数据盘镜像信息
         */
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DataImageInfo {
        }
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
