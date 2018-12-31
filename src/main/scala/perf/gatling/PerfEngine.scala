package perf.gatling

import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.app.Gatling
import io.gatling.core.config.{GatlingConfiguration, GatlingPropertiesBuilder}
import org.slf4j.LoggerFactory

object PerfEngine extends App {

        val LOG_LEVEL = sys.env.getOrElse("LOG_LEVEL", "WARN")

        val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]

        if (LOG_LEVEL.equals(Level.TRACE)) {
            context.getLogger("io.perf.gatling.http.engine.response").setLevel(Level.valueOf(LOG_LEVEL))
        } else if (LOG_LEVEL.equals(Level.DEBUG)) {
            context.getLogger("io.perf.gatling.http.engine.response").setLevel(Level.valueOf("DEBUG"))
        } else {
            context.getLogger("io.perf.gatling.http").setLevel(Level.valueOf("INFO"))
        }

        val testConfiguration = GatlingConfiguration.load()

        val testDescription = testConfiguration.config.getString("perf.gatling.core.runDescription")
        val simulationClass = testConfiguration.config.getString("perf.gatling.core.simulationClass")
        val simulationDir = testConfiguration.config.getString("perf.gatling.core.directory.simulations")
        val resourcesDir = testConfiguration.config.getString("perf.gatling.core.directory.resources")
        val resultsDir = testConfiguration.config.getString("perf.gatling.core.directory.results")
        val binariesDir = testConfiguration.config.getString("perf.gatling.core.directory.binaries")

        val props = new GatlingPropertiesBuilder
        props.simulationsDirectory(simulationDir)
            .simulationClass(simulationClass)
            .resourcesDirectory(resourcesDir)
            .resultsDirectory(resultsDir)
            .binariesDirectory(binariesDir)
            .runDescription(testDescription)

        println("\n####### CONFIGURATION ########")
        println("Description:          " + testDescription)
        println("Simulation directory: " + simulationDir)
        println("Simulation class:     " + simulationClass)
        println("Resources directory:  " + resourcesDir)
        println("Results directory:    " + resultsDir)
        println("Binaries directory:   " + binariesDir)
        println("##############################\n")

        Gatling.fromMap(props.build)

}
