package aaabramov.sbt.dsl

import sbt.Keys.{libraryDependencies, _}
import sbt._

object ModuleDSL {

  import Entities._

  def create: CreateWord.type = CreateWord

  def module: NamedWord.type = NamedWord

  case object CreateWord {

    def root(projectName: String): RootWord = RootWord(projectName)

    def a(dummy: NamedWord.type): NamedWord.type = NamedWord

  }

  case class RootWord(projectName: String) {

    def containing(projects: ProjectReference*): ContainingWord =
      ContainingWord(projectName, projects)

  }

  case class ContainingWord(projectName: String, projects: Seq[ProjectReference]) {

    def from(base: BaseSettings): Project =
      Project(projectName, file("."))
        .aggregate(projects: _*)
        .settings(base.commonSettings: _*)
  }

  case class ProjectWord(project: Project) {

    def from(base: BaseSettings): Project =
      project
        .settings(
          organization := base.organization.value,
          version := base.version.value,
          scalaVersion := base.scalaVer.value
        )
        .settings(base.commonSettings: _*)
  }

  object NamedWord {
    def named(name: String): ModuleWord = ModuleWord(name)
  }

  case class ModuleWord(name: String) {

    def withConfig(
                    dependsOn: Seq[ClasspathDep[ProjectReference]] = Nil,
                    compileLibs: Seq[ModuleID] = Nil,
                    providedLibs: Seq[ModuleID] = Nil,
                    testLibs: Seq[ModuleID] = Nil,
                    plugins: Seq[Plugins] = Nil,
                    additionalSettings: Seq[Def.SettingsDefinition] = Nil,
                    root: String = name
                  ): ProjectWord =
      ProjectWord(
        Project(name, file(root))
          .dependsOn(dependsOn: _*)
          .settings(
            libraryDependencies ++= compileLibs,
            libraryDependencies ++= providedLibs.map(_ % Provided),
            libraryDependencies ++= testLibs.map(_ % Test)
          )
          .settings(additionalSettings: _*)
          .enablePlugins(plugins: _*)
      )

  }

}
