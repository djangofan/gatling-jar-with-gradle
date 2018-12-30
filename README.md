# Gatling as a executable JAR with Gradle

In the context of a Gradle build, this code demonstrates how to automate the performance tests of a RESTful Web Service 
by executing a .jar Gatling performance test archive.

## How This Works

This project does not tie the performance test execution and test harness to the build itself.  This way the user can 
choose to execute the .jar any way they like.

1. We build the Gatling performance test project built into a runnable .jar file
2. Trying to support execution of the .jar from Jenkins, or a test harness such as Taurus or Blazemeter.

## How to install 

Clone this repository:

```
$ git clone https://github.com/djangofan/gatling-jar-with-gradle.git
```

#### Build with **gradle**:

```
$ cd gatling-jar-with-gradle
$ ./gradlew shadowJar
```

##  How to run demo test load standalone

Start the test load with:
```
$ ./gradlew runPerformanceJar
```

Or run them directly, without Gradle, as an executable .jar

```
$ ./run-performance-tests-jar.sh
```


## Other Info As Inspiration

https://www.blazemeter.com/blog/how-integrate-docker-jenkins

https://wiki.jenkins.io/display/JENKINS/Gatling+Plugin

