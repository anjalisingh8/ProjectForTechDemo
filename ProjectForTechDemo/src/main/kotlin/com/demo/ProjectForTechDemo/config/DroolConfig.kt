package com.demo.ProjectForTechDemo.config

import com.demo.ProjectForTechDemo.entity.User
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.kie.api.KieServices
import org.kie.api.builder.KieFileSystem
import org.kie.api.event.rule.AfterMatchFiredEvent
import org.kie.api.event.rule.BeforeMatchFiredEvent
import org.kie.api.event.rule.DefaultAgendaEventListener
import org.kie.api.io.ResourceType
import org.kie.api.runtime.KieContainer
import org.kie.api.runtime.KieSession
import org.kie.internal.io.ResourceFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.util.StopWatch
import java.io.IOException


@Configuration
class DroolConfig {

    private val logger : Logger = LogManager.getLogger(User::class)

    private val kieServices = KieServices.Factory.get()

    @Throws(IOException::class)
    private fun getKieFileSystem(): KieFileSystem {

        val kieFileSystem = kieServices.newKieFileSystem()
        logger.info("File Path")
//      kieFileSystem.write(ResourceFactory.newClassPathResource("Rules/Rule.drl",getClass()), org.kie.api.io.ResourceType.CHANGE_SET)
//        val kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder()
//        kBuilder.add(ResourceFactory.newClassPathResource("changeset.xml",getClass() ),org.kie.api.io.ResourceType.CHANGE_SET)
//        val kbuilderConf = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration(null, classLoader)
//
//        val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(kbuilderConf)
//        kbuilder.add( ResourceFactory.newFileResource( "/project/myrules.drl" ), ResourceType.DRL);


        return kieFileSystem
    }

    @Bean
    @Throws(IOException::class)
    fun getKieContainer(): KieContainer {
        println("Container created")
        getKieRepository()
        logger.info("File loaded")
        val kb = kieServices.newKieBuilder(getKieFileSystem())
        kb.buildAll()
        val kieModule = kb.kieModule
        return kieServices.newKieContainer(kieModule.releaseId)
    }

    private fun getKieRepository() {
        val kieRepository = kieServices.repository
        kieRepository.addKieModule { kieRepository.defaultReleaseId }
    }

    @Bean
    @Throws(IOException::class)
    fun getKieSession(): KieSession? {
        println("session created")
        logger.info("Session")

        val kieSession: KieSession = getKieContainer().newKieSession()

        val stopWatch = StopWatch()
        kieSession.addEventListener(object : DefaultAgendaEventListener() {
            override fun beforeMatchFired(event: BeforeMatchFiredEvent?) {
                super.beforeMatchFired(event)
                println("Before match fired.........")
                println("Timer started")
                stopWatch.start()
            }
        })

        kieSession.addEventListener(object : DefaultAgendaEventListener() {
            override fun afterMatchFired(event: AfterMatchFiredEvent) {
                super.afterMatchFired(event)
                println(event.match.rule.name)
                println("Rule Match found")
                stopWatch.stop()
                print("time...." + stopWatch.getTotalTimeMillis().toString() + "ms")
            }
        })
        return getKieContainer().newKieSession()
    }

}