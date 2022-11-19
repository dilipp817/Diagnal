package com.demo.diagnal

import android.content.Context
import okio.Utf8
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class Utils {
    companion object {
        fun getJsonFromAssets(context: Context, fileName: String): String? {
            val jsonString: String = try {
                val inputStream: InputStream = context.assets.open(fileName)
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                String(buffer, charset("UTF-8"))
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}