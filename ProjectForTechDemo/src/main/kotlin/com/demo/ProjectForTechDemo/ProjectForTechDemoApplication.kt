package com.demo.ProjectForTechDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProjectForTechDemoApplication

fun main(args: Array<String>) {
	print("Hi")
	runApplication<ProjectForTechDemoApplication>(*args)
}
