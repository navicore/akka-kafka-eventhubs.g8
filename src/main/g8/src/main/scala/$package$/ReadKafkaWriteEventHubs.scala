package $package$

import akka.Done
import akka.kafka.scaladsl.Consumer
import akka.kafka.{ConsumerMessage, Subscriptions}
import akka.stream.scaladsl.Sink
import com.microsoft.azure.reactiveeventhubs.ResumeOnError._
import com.typesafe.scalalogging.LazyLogging
import $package$.streams.eventhubs.EhPublish

import scala.concurrent.Future

object ReadKafkaWriteEventHubs extends LazyLogging with Conf {

  def apply(): Future[Done] = {
    Consumer
      .committableSource(consumerSettings, Subscriptions.topics(topic))
      .mapAsync(parallelism) {
        EhPublish()
      }
      .mapAsync(parallelism) {
        (msg: ConsumerMessage.CommittableMessage[Array[Byte], String]) =>
          msg.committableOffset.commitScaladsl()
      }
      .runWith(Sink.ignore)
  }
}
