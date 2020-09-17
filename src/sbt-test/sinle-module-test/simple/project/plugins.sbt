//{
//  val pluginVersion = System.getProperty("plugin.version")
//  if (pluginVersion == null) {
//    throw new RuntimeException(
//      """|The system property 'plugin.version' is not defined.
//         |Specify this property using the scriptedLaunchOpts -D.""".stripMargin)
//  } else {
//    addSbtPlugin("com.github.aaabramov" % "sbt-dsl-plugin" % "0.1-SNAPSHOT")
//  }
//}

addSbtPlugin("com.github.aaabramov" % "sbt-dsl-plugin" % "0.1-SNAPSHOT")
