# sbt-dsl-plugin

Provides you opinionated sbt DSL to bu truly human readable
This plugin requires sbt 1.0.0+

## Usage

Which one is better? Decide yourself.

#### Classic SBT

```sbt
name := "root-project-name"
organization := "com.example.sbt"
scalaVersion := "2.12.12"
version := "0.0.1"

lazy val global = project
  .in(file("."))
  .aggregate(
    common,
    module1,
    module2
  )

lazy val common = project
  .settings(
    name := "common",
    libraryDependencies ++= "org.scalatest" %% "scalatest" % "3.2.2" % Test
  )

lazy val module1 = project
  .settings(
    name := "module1"
  )
  .dependsOn(
    common
  )

lazy val module2 = project
  .settings(
    name := "module2"
  )
  .dependsOn(
    common
  )
```

#### DSL

```sbt
lazy val baseSettings = BaseSettings(
  version = Version("0.0.1"),
  scalaVer = `2.12.12`,
  organization = Organization("com.example.sbt"),
  commonSettings = Seq(
    "org.scalatest" %% "scalatest" % "3.2.2" % Test
  )
)

lazy val common = create a module named "common" withConfig(

) from baseSettings

lazy val module1 = create a module named "module1" withConfig(
  dependsOn = Seq(common)
) from baseSettings

lazy val module2 = create a module named "module2" withConfig(
  dependsOn = Seq(common)
) from baseSettings

lazy val module2 = create root "root-project-name" containing(
  common,
  module1,
  module2
) from baseSettings

```

### Testing

Run `test` for regular unit tests.

Run `scripted` for [sbt script tests](http://www.scala-sbt.org/1.x/docs/Testing-sbt-plugins.html).

### Publishing

1. publish your source to GitHub
2. [create a bintray account](https://bintray.com/signup/index) and [set up bintray credentials](https://github.com/sbt/sbt-bintray#publishing)
3. create a bintray repository `sbt-plugins` 
4. update your bintray publishing settings in `build.sbt`
5. `sbt publish`
6. [request inclusion in sbt-plugin-releases](https://bintray.com/sbt/sbt-plugin-releases)
7. [Add your plugin to the community plugins list](https://github.com/sbt/website#attention-plugin-authors)
8. [Claim your project an Scaladex](https://github.com/scalacenter/scaladex-contrib#claim-your-project)
