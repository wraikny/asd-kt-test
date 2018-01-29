package wraiknyapp

fun isMac(): Boolean {
    return System.getProperty("os.name").toLowerCase().startsWith("mac")
}

fun isWindows(): Boolean {
    return System.getProperty("os.name").toLowerCase().startsWith("windows")
}

fun main(args: Array<String>) {
    val path = System.getProperty("user.dir")
    when {
        isMac() -> System.load(path + "/libAltseed_core.dylib")
        isWindows() -> System.load(path + "/Altseed_core.dll")
        else -> println("Unexpected OS: " + System.getProperty("os.name"))
    }

    asd.Engine.Initialize("Test", 640, 480, asd.EngineOption())

    while(asd.Engine.DoEvents()) {
        asd.Engine.Update()
    }
    asd.Engine.Terminate()

}