name := "tweets-informer"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies += "org.apache.commons" % "commons-io" % "1.3.2"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.11"

libraryDependencies += "net.liftweb" %% "lift-json" % "3.4.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test

libraryDependencies += "org.twitter4j" % "twitter4j-core" % "4.0.4"

libraryDependencies += "com.typesafe" % "config" % "1.4.0"

libraryDependencies += "org.mockito" % "mockito-core" % "3.2.4"
