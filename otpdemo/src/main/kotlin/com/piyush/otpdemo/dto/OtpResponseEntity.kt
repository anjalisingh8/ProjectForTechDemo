package com.piyush.otpdemo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class OtpResponseEntity<T>(
    @JsonProperty(value = "HttpResponseCode")
    var responseCode : String,
    @JsonProperty(value = "HttpResponseMessage")
    var responseMessage : String,
    @JsonProperty(value = "ApplicationResponse")
    var responseBody : T
)