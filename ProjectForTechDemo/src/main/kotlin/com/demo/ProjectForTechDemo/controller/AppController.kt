package com.demo.ProjectForTechDemo.controller

import com.demo.ProjectForTechDemo.entity.User
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.kie.api.runtime.KieSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1")
class AppController {
    private val logger: Logger = LogManager.getLogger(User::class)

    @Autowired
    private val session: KieSession ?= null

    @GetMapping
    fun home():String{
        return "Welcome to the home Page";
    }

    @PostMapping("/transfer")
    fun walletTransfer(@RequestBody user: User?): User? {
        logger.info("Info Method")
        session?.insert(user)
        logger.info(user)
        session?.fireAllRules()
//        val rulesChrono: AgendaEventListener = RulesChronoChartRecorder().withMaxThreshold(500.0).schedule()
//        session!!.addEventListener(rulesChrono)
//        val sb = StringBuilder()
//        rulesChrono.getPerfStat().values()
//            .forEach1 { s ->
//                sb.append(
//                    format(
//                        "%n%s - min: %.2f avg: %.2f max: %.2f activations: %d",
//                        s.getDomain(),
//                        s.getMinTimeMs(),
//                        s.getAvgTimeMs(),
//                        s.getMaxTimeMs(),
//                        s.getLeapsCount()
//                    )
//                )
//            }
//        println(sb.toString())
        return user
    }
}

