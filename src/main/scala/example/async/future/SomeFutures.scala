package example.async.future

import example.{MyApp, Task}

import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, ExecutionContext, Future}

object SomeFutures extends MyApp {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val tasks = Seq(
    Future(Task.sleep("sleep 1", 2 seconds)),
    Future(Task.sleep("sleep 2", 2 seconds)),
    Future(Task.sleep("sleep 3", 2 seconds))
  )

  Await.result(Future.sequence(tasks), Duration.Inf)
}
