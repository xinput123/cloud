package com.xinput.unicloud.model.reqeust.image;

import com.xinput.cloud.exception.ParamException;
import com.xinput.unicloud.consts.UniCloudConsts;
import com.xinput.unicloud.model.reqeust.UniRequest;

/**
 * 查看私有镜像列表 参数
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 23:31
 */
public class UniCloudDescribeImageReq extends UniRequest {

    /**
     * 类型：int
     * 必选：否
     * 描述：页码
     */
    private Integer page;

    /**
     * 类型：int
     * 必选：否
     * 描述：页面容量
     */
    private Integer size;

    /**
     * 类型：String
     * 必选：否
     * 描述：镜像名筛选
     */
    private String imageName;

    /**
     * 类型：String
     * 必选：否
     * 描述：镜像状态筛选
     */
    private String status;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void checkConstraints() throws ParamException {
        this.setAction(UniCloudConsts.Action.DESCRIBE_IMAGE.getAction());
        this.checkField();

        if (this.page == null || this.page < 1) {
            this.page = 1;
        }
        if (this.size == null || this.size < 1) {
            this.size = 10;
        }
    }

}
