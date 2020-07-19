package androidstack.wanandroid.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * 重要知识：retrofit + gson
 * Created on 2020/7/19 09:54
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 */
object ApiServiceManager {
    private val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder().callTimeout(5, TimeUnit.SECONDS).build())
        .baseUrl("https://www.wanandroid.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create<ApiService>()
}