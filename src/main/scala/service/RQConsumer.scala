package org.kilinochi.rqueue
package service

import service.RQBatcher.{DELAY_EXCHANGE_NAME, DELAY_QUEUE_NAME}
import service.RQConsumer.logger

import org.apache.commons.codec.binary.StringUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.amqp.rabbit.annotation.{Exchange, Queue, QueueBinding, RabbitListener}
import org.springframework.messaging.Message
import org.springframework.stereotype.Service

@Service
class RQConsumer extends RQBatcher {

  @RabbitListener(bindings =
    Array(
      new QueueBinding {
        override def value(): Queue = new Queue(value = DELAY_QUEUE_NAME)

        override def exchange(): Exchange = new Exchange {
          override def value(): String = DELAY_EXCHANGE_NAME
          override def delayed(): String = "true"
        }
        override def key(): Array[String] = Array(DELAY_QUEUE_NAME)
      }
    )
  )
  def receiveMessage(message: Message[Array[Byte]]): Unit = {
    val msg = StringUtils.newStringUtf8(message.getPayload).intern()
    logger.info("Received message = {}", msg)
  }
}

object RQConsumer {
  val logger: Logger = LoggerFactory.getLogger(classOf[RQConsumer])
}
