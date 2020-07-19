package androidstack.wanandroid

import android.os.Bundle
import android.widget.Toast
import androidstack.wanandroid.viewmodel.LoadState
import androidstack.wanandroid.viewmodel.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * 重要知识：Activity+ViewModel+LiveData
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        GlobalScope.launch {
            delay(1000L)
            println("Hello,World!")
        }

        //获取ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //对加载状态进行动态观察
        viewModel.loadState.observe(this, Observer {
            when (it) {
                is LoadState.Success -> btn_login.isEnabled = true
                is LoadState.Fail -> {
                    btn_login.isEnabled = true
                    Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                }
                is LoadState.Loading -> {
                    btn_login.isEnabled = false
                }
            }

        })

        //对User数据进行观察
        viewModel.user.observe(this, Observer {
            //展示登录结果
            if (it.errorCode == 0) {
                Toast.makeText(this, it.data?.nickname, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, it.errorMsg, Toast.LENGTH_SHORT).show()
            }
        })

        //点击登录按钮登录
        btn_login.setOnClickListener {
            viewModel.login("chaozhouzhang", "123456")
        }
    }
}