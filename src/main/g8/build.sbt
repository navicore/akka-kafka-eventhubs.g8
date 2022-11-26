name := "$name;format="Camel"$"

fork := true
javaOptions in test ++= Seq(
  "-Xms512M", "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

ensimeScalaVersion in ThisBuild := "$scalaVersion$"
scalaVersion := "$scalaVersion$"
val akkaVersion = "$akkaVersion$"

libraryDependencies ++= Seq(
    "ch.qos.logback" % "logback-classic" % "1.4.5",
    "com.typesafe" % "config" % "1.2.1",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,

    "org.json4s" %% "json4s-native" % "3.5.3",
    "com.github.nscala-time" %% "nscala-time" % "2.32.0",

    "com.microsoft.azure" %% "azure-eventhubs-reactive" % "0.5.0",

    "com.microsoft.azure" % "azure-eventhubs" % "0.15.1",
    "com.typesafe.akka" %% "akka-stream-kafka" % "0.17",

    "org.scalatest" %% "scalatest" % "3.0.1" % "test"
  )

dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor"  % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

mainClass in assembly := Some("$package$.Main")
assemblyJarName in assembly := "$name;format="Camel"$.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

