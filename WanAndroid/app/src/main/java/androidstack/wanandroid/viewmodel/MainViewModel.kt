package androidstack.wanandroid.viewmodel

import androidstack.wanandroid.api.ApiServiceManager
import androidstack.wanandroid.bean.BaseResponse
import androidstack.wanandroid.bean.User
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.async

/**
 * 重要知识：ViewModel + 协程 + LiveData
 */
class MainViewModel : ViewModel() {

    val user = MutableLiveData<BaseResponse<User>>()
    val loadState = MutableLiveData<LoadState>()


    fun login(username: String, password: String) {
        launch({
            loadState.value = LoadState.Loading()
            val result = async { ApiServiceManager.apiService.loginForm(username,password) }
            user.value = result.await()
            loadState.value = LoadState.Success()
        }, {
            loadState.value =
                LoadState.Fail(it.message ?: "登录失败")
        })
    }

}