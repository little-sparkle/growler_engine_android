package com.littlesparkle.growler.library.update;

/**
 * Created by dell on 2016/7/14.
 */
public class UpdateRequestInfo {


    /**
     * platform : string
     * identification : string
     * version_name : string
     * version_code : int
     */

    private String platform;
    private String identification;
    private String version_name;
    private int version_code;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getVersion_name() {
        return version_name;
    }

    public void setVersion_name(String version_name) {
        this.version_name = version_name;
    }

    public int getVersion_code() {
        return version_code;
    }

    public void setVersion_code(int version_code) {
        this.version_code = version_code;
    }
}
