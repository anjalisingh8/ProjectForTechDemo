package com.piyush.otpdemo.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ServiceResponseEntity<T>(
    @JsonProperty(value = "ResponseCode")
    var responseCode : String,
    @JsonProperty(value = "ResponseMessage")
    var responseMessage : String,
    @JsonProperty(value = "ResponseBody")
    var responseBody : T
)