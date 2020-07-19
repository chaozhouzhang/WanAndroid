package androidstack.wanandroid.viewmodel

/**
 * 重要知识：密封类
 */
sealed class LoadState(val msg: String) {
    class Loading(msg: String = "") : LoadState(msg)
    class Success(msg: String = "") : LoadState(msg)
    class Fail(msg: String) : LoadState(msg)
}