package example

import java.util.concurrent._

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext

object ExecutionContextUtils extends LazyLogging {

  def single: ExecutionContext = {
    val executor = Executors.newSingleThreadExecutor()
    logger.info("creating SingleThreadExecutor")
    ExecutionContext.fromExecutorService(executor)
  }

  def fixedPool(size: Int): ExecutionContext = {
    val executor = Executors.newFixedThreadPool(size).asInstanceOf[ThreadPoolExecutor]
    logger.info(s"creating FixedThreadPoolExecutor: corePoolSize=${executor.getCorePoolSize} maxPoolSize=${executor.getMaximumPoolSize}")
    ExecutionContext.fromExecutorService(executor)
  }

  def workStealingPool(parallelism: Int): ExecutionContext = {
    val executor = Executors.newWorkStealingPool(parallelism).asInstanceOf[ForkJoinPool]
    logger.info(s"creating ForkJoinPool: parallelism=${executor.getParallelism}")
    ExecutionContext.fromExecutorService(executor)
  }
}
