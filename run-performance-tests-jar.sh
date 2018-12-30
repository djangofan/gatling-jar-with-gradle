#!/usr/bin/env bash
java -cp build/libs/performance-all.jar perf.gatling.Engine -s perf.gaatling.simulations.ComputerWorld
