package example.async.future

import example.{MyApp, Task}

import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, ExecutionContext, Future}

object ALotOfBlockingFutures extends MyApp {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val tasks = (1 to 20).map(i => Future {
    Task.sleep(f"sleep $i%02d", 2 seconds)
  })

  Await.result(Future.sequence(tasks), Duration.Inf)
}
