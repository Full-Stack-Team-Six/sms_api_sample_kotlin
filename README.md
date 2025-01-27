# SMS Kotlin API - Version 1.0

This is the official **Kotlin SMS API** sample provided by [Full Stack Team Six](https://fullstackteamsix.com/) to makes it easy for developers to integrate our API in their code.

Jump To:
* [Getting Started](#Getting-Started)
* [Quick Examples](#Quick-Examples)
* [Getting Help](#Getting-Help)
* [Features](#Features) 
* [More Resources](#Resources) 

## Getting Started

1. **Create an Account** – Before you begin, you need to
   sign up and register your SENDER name.
 

## Quick Examples

### Sending an SMS

```kotlin
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
```

## Getting Help

Please use these community resources for getting help. We use the GitHub issues for tracking bugs and feature requests and have limited bandwidth to address them.
For general issues regarding the SMS services and their limitations, you may also take a look at the [Documentation](https://fullstackteamsix.com/docs).


### Opening Issues

If you encounter a bug with our `API` we would like to hear about it. You can contact us through [here](https://fullstackteamsix.com/contacts.html).

## Features

* Send Automated SMS via API
 
## Reach out on social media

* [Twitter](www.twitter.com/fullstackteam6) – Follow us on Twitter 
* [Facebook](https://web.facebook.com/fullstackteamsix/) – Follow us on Facebook 
* [Instagram](https://www.instagram.com/full_stack_team_six/) – Follow us on Instagram 
* [LinkedIn](https://www.linkedin.com/company/full-stack-team-six) – Follow us on LinkedIn 
