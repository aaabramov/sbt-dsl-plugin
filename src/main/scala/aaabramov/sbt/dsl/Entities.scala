package aaabramov.sbt.dsl

import sbt.Def

object Entities {

  case class Version(value: String)

  object Version {
    def apply(version: String): Version = new Version(version)

    def snapshot(version: String): Version = new Version(s"$version-SNAPSHOT")

    def release(version: String): Version = apply(version)
  }

  class Organization(val value: String)

  object Organization {
    def apply(organization: String): Organization = new Organization(organization)
  }

  case class ScalaVer(value: String)

  object ScalaVer {
    def apply(scalaVer: String): ScalaVer = new ScalaVer(scalaVer)
  }

  case class BaseSettings(
                           version: Entities.Version,
                           scalaVer: Entities.ScalaVer,
                           organization: Entities.Organization,
                           commonSettings: Seq[Def.SettingsDefinition] = Nil
                         )

}
