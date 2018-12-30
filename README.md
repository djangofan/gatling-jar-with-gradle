# Gatling with Gradle, Taurus, Docker, AND Jenkins

In the context of a Gradle build, this code demonstrates how to automate the performance tests of a RESTful Web Service by executing a .jar Gatling performance test archive in a dockerized Taurus test harness.

## How This Works

Trying not to tie the performance test execution and test harness to the build.  This way the user can choose to build the .jar differently and/or execute the .jar with a different test harness with simple config changes to this example project.

1. Gatling performance test project built into a runnable .jar file
2. Taurus test harness that runs the .jar file

## How to install 

Clone this repository:

```
$ git clone https://github.com/djangofan/gatling-with-gradle-taurus-and-docker.git
```

#### Build with **gradle**:

```
$ cd gatling-with-gradle-taurus-and-docker
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


##  How to run demo test load in the Taurus harness

Run this bash script to start the dockerized aurus test harness:
```
$ ./startTaurus.sh
```

## Other Info As Inspiration

https://www.blazemeter.com/blog/how-integrate-docker-jenkins

https://wiki.jenkins.io/display/JENKINS/Gatling+Plugin


