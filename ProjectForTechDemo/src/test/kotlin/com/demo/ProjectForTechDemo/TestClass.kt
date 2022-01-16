package com.demo.ProjectForTechDemo

import org.droolsassert.DroolsAssert
import org.droolsassert.DroolsSession
import org.droolsassert.TestRules
import org.junit.Test
import org.junit.jupiter.api.extension.RegisterExtension
import java.util.*


@DroolsSession("classpath:/org/droolsassert/Rules/Rule.drl")
class TestClass {

    @RegisterExtension
    var drools: DroolsAssert? = DroolsAssert()

    @Test
    @TestRules(expected = ["sleep method", "more than 200"])
    fun testRulesChronoListener() {
        for (i in 1..50) drools!!.insertAndFire(randomFunction(i))
        drools!!.printPerformanceStatistic()
    }

    fun randomFunction(i: Int): Int {
        return Random().nextInt(i) * 10
    }
}