package perf.gatling

import io.gatling.recorder.GatlingRecorder
import io.gatling.recorder.config.RecorderPropertiesBuilder

object Recorder extends App {

	val props = new RecorderPropertiesBuilder()
		.simulationsFolder(IDEPathHelper.recorderSimulationsDirectory.toString)
		.simulationPackage("gatling")
		.resourcesFolder(IDEPathHelper.resourcesDirectory.toString)

	GatlingRecorder.fromMap(props.build, Some(IDEPathHelper.recorderConfigFilePath))
}
