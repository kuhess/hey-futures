package example.sync

import example.{MyApp, Task}

import scala.concurrent.duration.DurationInt

object Basic extends MyApp {
  Task.sleep("sleep 1", 2 seconds)
  Task.sleep("sleep 2", 2 seconds)
  Task.sleep("sleep 3", 2 seconds)
}
