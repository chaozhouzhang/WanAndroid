package androidstack.wanandroid.api

import androidstack.wanandroid.bean.BaseResponse
import androidstack.wanandroid.bean.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 重要知识：retrofit + http
 * Created on 2020/7/19 09:53
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
interface ApiService {

    @FormUrlEncoded
    @POST("user/login")
    suspend fun loginForm(@Field("username")  username: String,@Field("password")  password: String): BaseResponse<User>

    @POST("user/login")
    suspend fun loginQuery(@Query("username")  username: String, @Query("password")  password: String): BaseResponse<User>
}