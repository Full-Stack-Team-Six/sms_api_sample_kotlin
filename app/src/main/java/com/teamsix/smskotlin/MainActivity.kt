package com.teamsix.smskotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity:AppCompatActivity() {

    //Initialize Variables
    private lateinit var button: Button
    private var phone = ""
    private var name = ""
    private var apiKey = ""
    private var url = " https://portal.fullstackteamsix.com/api/v1/send/index.php"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Enter the number of the recipients
         phone = "255743368863"
         name = "Hello World"

        //Paste your API key here
         apiKey = "0813-asdasdasd-sdf2e3bfa5sdfsdfsdf129c-sdfsdfsd12684f1"


        //Initialize the button
        button = findViewById(R.id.btn_send_message)

        //Set the button on click listener
        button.setOnClickListener {

            //When the button is clicked execute the method below
            sendMessage()
        }
    }



    //Method to Send Message
    private fun sendMessage() {


        val textView = findViewById<TextView>(R.id.tv_response)
        textView.text = "Sending ..."


        // Instantiate the RequestQueue.
        val queue : RequestQueue = Volley.newRequestQueue(this)

        // Request a string response from the provided URL.
        val stringRequest = object:StringRequest(Method.POST, url,
            Response.Listener { response ->

                textView.text = "Server response:$response";

                // TODO: Check the response if your message has been sent.
                Log.d("server", response)


            }, Response.ErrorListener { error ->

                textView.text = "Error:$error";
                // TODO: Handle error
                Log.d("server", error.toString())

            }) {

            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["phone"] = phone
                params["message"] = name
                params["key"] = apiKey
                return params
            }
        }
        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}

