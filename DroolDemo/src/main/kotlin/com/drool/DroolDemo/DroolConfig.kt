package com.drool.DroolDemo

import org.springframework.context.annotation.Configuration

@Configuration
class DroolConfig {

    fun getKieSession(filepath: String) : KieSession? {

        val kieServices = KieServices.Factory.get()

        val kieFileSystem = kieServices.newKieFileSystem()



        val file = Paths.get(filepath).toFile()



        //Show (debug) xls in drl format

        file.inputStream().use {

            val sc = SpreadsheetCompiler()

            println(sc.compile(it, InputType.XLS))

        }



        var kieSession: KieSession? = null



        file.inputStream().use {

            read from inputStream//

            kieFileSystem.write(

                "src/main/resources/rules.xls",

                kieServices.resources.newInputStreamResource(it)

            )

            val kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll()



            //rule file describing the contents of the check

            val results = kieBuilder.results

            if (results.hasMessages(Message.Level.ERROR)) {

                println(results.toString())

                throw IllegalStateException(a problem with the description of the ">>> rules file There you. " )

            }



            kieSession = kieServices

                .newKieContainer(kieServices.repository.defaultReleaseId)

                .newKieSession()

        }



        return kieSession
    }



}