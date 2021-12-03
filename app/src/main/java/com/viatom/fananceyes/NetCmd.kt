package com.viatom.fananceyes

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.util.*

object NetCmd {

    //新浪财经有现成的接口，可以获取最近二十天的每5分钟股票数据

    //datalen最多1023
    fun sina(symbol: String):String{
        return sina(symbol,5,5,1023)
    }

    fun sina(symbol:String,scale:Int,mean:Int,dataLen:Int):String{
        return "http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=${symbol}&scale=${scale}&ma=${mean}&datalen=${dataLen}"
    }

    private val client = OkHttpClient();
    @Throws(IOException::class)
    fun getFinance(sy: String): String? {
        val url= sina(sy)
        val request: Request = Request.Builder()
            .addHeader("Content-Type", "application/json; charset=UTF-8")
            .url(url)
            .build()
        client.newCall(request)
            .execute()
            .use { response ->
                return response.body?.string()
            }
    }
}