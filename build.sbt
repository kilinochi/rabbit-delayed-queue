name := "rabbit-delayed-queue"

version := "1.0"

scalaVersion := "2.13.4"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Xlint")

idePackagePrefix := Some("org.kilinochi.rqueue")

libraryDependencies ++= {
  Seq(
    "org.springframework.boot" % "spring-boot-starter-webflux" % "2.3.5.RELEASE",
    "org.springframework.boot" % "spring-boot-starter-amqp" % "2.3.5.RELEASE",
    "org.projectlombok" % "lombok" % "1.18.16",
    "org.slf4j" % "slf4j-api" % "1.7.30",
    "org.slf4j" % "slf4j-simple" % "1.7.30",
    "org.apache.commons" % "commons-lang3" % "3.11",
    "commons-codec" % "commons-codec" % "1.15"
  )
}

enablePlugins(JavaAppPackaging)

mainClass in Compile := Some("org.kilinochi.rqueue.RQApplication")