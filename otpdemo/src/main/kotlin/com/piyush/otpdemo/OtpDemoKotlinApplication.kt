package com.piyush.otpdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.data.mongodb.core.MongoTemplate as MongoTemplate


@SpringBootApplication
@EnableMongoRepositories("com.piyush.otpdemo.repository")
class OtpDemoKotlinApplication

fun main(args: Array<String>) {
	runApplication<OtpDemoKotlinApplication>(*args)
}
//
//@Bean
//@Throws(Exception::class)
//fun mongoTemplate(): MongoTemplate? {
//
//}

