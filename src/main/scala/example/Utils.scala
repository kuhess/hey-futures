package example

import java.security.MessageDigest
import java.time.{Clock, Duration}

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm
import com.typesafe.scalalogging.LazyLogging

import scala.util.Random

object Utils extends LazyLogging {
  def timeLog(name: String)(body: => Any): Unit = {
    logger.info(s"$name - start")
    body
    logger.info(s"$name - end")
  }

  def cpuIntensiveComputation(n: Int = 100): Unit = (1 to n) foreach { _ =>
    val md = MessageDigest.getInstance("SHA-512")
    md.update(randomBytes(10000))
    md.digest(randomBytes(1000000))
  }

  private def randomBytes(size: Int): Array[Byte] = {
    val bytes = new Array[Byte](size)
    Random.nextBytes(bytes)
    bytes
  }
}


trait MyApp extends App with LazyLogging {

  override def main(args: Array[String]): Unit = {
    logger.info("starting application")
    val startInstant = Clock.systemUTC().instant()
    super.main(args)
    val finishInstant = Clock.systemUTC().instant()
    val duration = Duration.between(startInstant, finishInstant)
    logger.info(s"finishing application after $duration")
  }
}
