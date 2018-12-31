package perf.gatling

import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import org.slf4j.LoggerFactory

object Engine extends App {

  val LOG_LEVEL = sys.env.getOrElse("LOG_LEVEL", "WARN")

  val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]

  if (LOG_LEVEL.equals(Level.TRACE)) {
  	context.getLogger("io.perf.gatling.http.engine.response").setLevel(Level.valueOf(LOG_LEVEL))
  } else if (LOG_LEVEL.equals(Level.DEBUG)) {
  	context.getLogger("io.perf.gatling.http.engine.response").setLevel(Level.valueOf("DEBUG"))
  } else {
  	context.getLogger("io.perf.gatling.http").setLevel(Level.valueOf("INFO"))
  }

  // GatlingPropertiesBuilder works only with Gatling 3.0.0 or higher
  val props = new GatlingPropertiesBuilder
  props.simulationClass("perf.gatling.simulations.ComputerWorld")
      .resourcesDirectory(IDEPathHelper.resourcesDirectory.toString)
      .resultsDirectory(IDEPathHelper.resultsDirectory.toString)
      .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)

  Gatling.fromMap(props.build)
  
}
