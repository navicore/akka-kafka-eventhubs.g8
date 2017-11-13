[![Build Status](https://travis-ci.org/navicore/akka-kafka-eventhubs.g8.svg?branch=master)](https://travis-ci.org/navicore/akka-kafka-eventhubs.g8)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ce59808726964769b0a135aa8ad1bbb5)](https://www.codacy.com/app/navicore/akka-kafka-eventhubs.g8?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=navicore/akka-kafka-eventhubs.g8&amp;utm_campaign=Badge_Grade)

A [g8] Template for an Akka Streams App that Reads from Kafka and Writes to Azure Eventhubs
---

## PREREQ

  * sbt >= 13.16

## USAGE

G8 will prompt you for details like your project name and package name.

In a terminal shell, enter:

```console
sbt new navicore/akka-kafka-eventhubs.g8 
```

`cd` into the resulting directory and `sbt run`

See generated the README.md for how to build and configure the output project.


## DEVELOPING

While changing the template, test using something like:

```console
sbt new file:///Users/navicore/git/navicore/akka-kafka-eventhubs.g8
```

[g8]: http://www.foundweekends.org/giter8/

