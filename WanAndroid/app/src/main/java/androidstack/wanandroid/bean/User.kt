package androidstack.wanandroid.bean


/**
 * 重要知识：kotlin data class
 * Created on 2020/7/19 10:04
 * @author zhangchaozhou
 * @email 13760289294@139.com
 * @wechat 13760289294
 *
 */
//{
//    "data": {
//        "admin": false,
//        "chapterTops": [],
//        "coinCount": 0,
//        "collectIds": [],
//        "email": "",
//        "icon": "",
//        "id": 71064,
//        "nickname": "chaozhouzhang",
//        "password": "",
//        "publicName": "chaozhouzhang",
//        "token": "",
//        "type": 0,
//        "username": "chaozhouzhang"
//    },
//    "errorCode": 0,
//    "errorMsg": ""
//}
data class User(
    val username:String,
    val nickname:String,
    val publicName:String,
    val token:String,
    val id:Long
)