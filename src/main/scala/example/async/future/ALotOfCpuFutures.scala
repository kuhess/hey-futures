package example.async.future

import example.{MyApp, Task}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}

object ALotOfCpuFutures extends MyApp {
  implicit val ec: ExecutionContext = ExecutionContext.global

  val tasks = (1 to 20).map(i => Future {
    Task.cpu(f"cpu $i%02d", 100)
  })

  Await.result(Future.sequence(tasks), Duration.Inf)
}
