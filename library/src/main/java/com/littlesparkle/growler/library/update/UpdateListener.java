package com.littlesparkle.growler.library.update;

public interface UpdateListener {
    void onUpdateAvailable(UpdatePackageInfo info);

    void onNoUpdate();
}
