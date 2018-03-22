package example

import com.typesafe.scalalogging.LazyLogging
import example.Utils.timeLog

import scala.concurrent.duration.Duration

object Task extends LazyLogging {

  def sleep(name: String, duration: Duration): Unit = timeLog(name) {
    Thread.sleep(duration.toMillis)
  }

  def cpu(name: String, complexity: Int): Unit = timeLog(name) {
    // NOTE: on my laptop, complexity=100 takes ~1.5s
    Utils.cpuIntensiveComputation(complexity)
  }
}
