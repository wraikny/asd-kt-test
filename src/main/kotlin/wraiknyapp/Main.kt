package wraiknyapp

class Shikaku : asd.GeometryObject2D() {init {
    val size = asd.Vector2DF(100f, 100f)
    val rect = asd.RectangleShape()
    // It goes well when using
    // asd.RectF(asd.Vector2DF.DivideByScalar(size, -2.0f), size)
    rect.drawingArea = asd.RectF(-size.X/2.0f, -size.Y/2.0f, size.X, size.Y)

    this.shape = rect
    this.position = asd.Vector2DF.DivideByScalar(asd.Engine.getWindowSize().To2DF(), 2.0f)
    this.color = asd.Color(255, 255, 255)

    // Error
    // val tmp = asd.Vector2DF(1.0f, 1.0f) / 1.0f
}
}

fun main(args: Array<String>) {
    val isMac = System.getProperty("os.name").toLowerCase().startsWith("mac")
    val isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows")

    val path = System.getProperty("user.dir")

    when {
        isMac -> System.load(path + "/libAltseed_core.dylib")
        isWindows -> System.load(path + "/Altseed_core.dll")
        else -> println("Unexpected OS: " + System.getProperty("os.name"))
    }

    asd.Engine.Initialize("Test", 640, 480, asd.EngineOption())

    val rect = Shikaku()
    asd.Engine.AddObject2D(rect)

    while(asd.Engine.DoEvents()) {
        asd.Engine.Update()
    }
    asd.Engine.Terminate()
}