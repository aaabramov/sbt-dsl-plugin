lazy val baseSettings = BaseSettings(
  version = Version("0.1.1"),
  scalaVer = `2.12.12`,
  organization = Organization("com.github.aaabramov.test")
)

lazy val server = create a module named "server" withConfig(

) from baseSettings

lazy val client = create a module named "client" withConfig(

) from baseSettings

lazy val service = create root "service" containing(
  server,
  client
) from baseSettings
