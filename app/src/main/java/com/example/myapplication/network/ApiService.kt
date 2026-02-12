package com.example.myapplication.network

import com.example.myapplication.model.SignInRequest
import com.example.myapplication.model.SignInResponse
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

object ApiService {

    fun signIn(request: SignInRequest): SignInResponse {
        val url = URL("https://api.tfl.com/login")
        val connection = url.openConnection() as HttpURLConnection

        try {
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val json = JSONObject()
            json.put("customerId", request.customerId)
            json.put("password", request.password)

            val writer = OutputStreamWriter(connection.outputStream)
            writer.write(json.toString())
            writer.flush()
            writer.close()

            val responseCode = connection.responseCode

            val reader = BufferedReader(
                InputStreamReader(
                    if (responseCode in 200..299)
                        connection.inputStream
                    else
                        connection.errorStream
                )
            )

            val responseText = reader.readText()
            reader.close()

            val responseJson = JSONObject(responseText)

            return SignInResponse(
                success = responseJson.optBoolean("success"),
                token = responseJson.optString("token"),
                message = responseJson.optString("message")
            )

        } finally {
            connection.disconnect()
        }
    }
}
