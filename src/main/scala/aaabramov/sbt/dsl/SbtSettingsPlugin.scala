package aaabramov.sbt.dsl

import aaabramov.sbt.dsl.ModuleDSL.{CreateWord, NamedWord}
import sbt._

object SbtSettingsPlugin extends AutoPlugin {

  object autoImport {

    val create: CreateWord.type = ModuleDSL.create

    val module: NamedWord.type = ModuleDSL.module

    lazy val `2.12.12` = ScalaVer("2.12.10")
    lazy val `2.13.3` = ScalaVer("2.13.3")

    val Version: Entities.Version.type = Entities.Version
    val Organization: Entities.Organization.type = Entities.Organization
    val ScalaVer: Entities.ScalaVer.type = Entities.ScalaVer
    val BaseSettings: Entities.BaseSettings.type = Entities.BaseSettings

  }

  override def trigger = allRequirements

}
