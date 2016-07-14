package com.littlesparkle.growler.library.update;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by dell on 2016/7/14.
 */
public interface UpdateService {

    //    请求更新
    @POST("/ota/update")
    Observable otaUpdate(@Body UpdatePackageInfo updatePackageInfo);

}
