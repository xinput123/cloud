package com.xinput.cloud.domain;

import javax.validation.constraints.NotEmpty;

/**
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @date 2020-11-17 15:15
 */
public class CloudConfig {

    @NotEmpty(message = "[accessKey] 不能为空")
    private String accessKey;

    @NotEmpty(message = "[secretKey] 不能为空")
    private String secretKey;

    public CloudConfig() {
    }

    public CloudConfig(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
