package com.littlesparkle.growler.library.update;

public class UpdatePackageInfo {
    private String update_log;
    private String version;
    private int version_i;
    private int size;
    private boolean isForce;
    private String url;
    private String md5;

    public UpdatePackageInfo() {
    }

    public String getUpdateLog() {
        return update_log;
    }

    public String getVersion() {
        return version;
    }

    public int getVersionI() {
        return version_i;
    }

    public int getSize() {
        return size;
    }

    public boolean isForce() {
        return isForce;
    }

    public String getUrl() {
        return url;
    }

    public String getMd5() {
        return md5;
    }

    @Override
    public String toString() {
        return "UpdatePackageInfo{" +
                "update_log='" + update_log + '\'' +
                ", version='" + version + '\'' +
                ", version_i=" + version_i +
                ", size=" + size +
                ", isForce=" + isForce +
                ", url='" + url + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
