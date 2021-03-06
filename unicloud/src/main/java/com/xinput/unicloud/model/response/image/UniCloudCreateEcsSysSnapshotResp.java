package com.xinput.unicloud.model.response.image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xinput.cloud.util.StringUtils;
import com.xinput.unicloud.model.response.UniResponse;

/**
 * 创建系统盘快照 响应值
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-20 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniCloudCreateEcsSysSnapshotResp extends UniResponse {

    /**
     * 快照ID
     */
    private String snapshotId;

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    @Override
    public boolean isSuccess() {
        if (StringUtils.isNotEmpty(snapshotId)) {
            return true;
        }
        return false;
    }
}
