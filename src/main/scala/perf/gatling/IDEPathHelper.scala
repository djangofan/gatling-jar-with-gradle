package perf.gatling

import java.nio.file.{Path, Paths}

object IDEPathHelper {

  val projectRootDir: String = Paths.get(".").toAbsolutePath.normalize.toString

  // .jar will be prepared with perf.gatling.conf in root of jar, not just under src/main/resources
  val gatlingConfUrl: String = projectRootDir + "/gatling.conf"

  val mavenSourcesDirectory = projectRootDir + "/src/test/scala"
  val mavenResourcesDirectory = projectRootDir + "/src/test/resources"
  val mavenTargetDirectory = projectRootDir + "/target"
  val mavenBinariesDirectory = mavenTargetDirectory + "/test-classes"

  val resourcesDirectory = mavenResourcesDirectory
  val simulationsDirectory = mavenSourcesDirectory + "/simulations"
  val dataDirectory = mavenResourcesDirectory + "/data"
  val resultsDirectory = mavenTargetDirectory + "/perf/gatling"

  val recorderConfigFile = mavenResourcesDirectory + "/recorder.conf"
  val recorderConfigFilePath: Path = Paths.get(recorderConfigFile)
  val recorderSimulationsDirectory = mavenSourcesDirectory + "/recorded"

  def main(args: Array[String]): Unit = {
    println(projectRootDir)
    println(gatlingConfUrl)
  }

}