package org.kilinochi.rqueue
package service

import service.RQBatcher.{DELAY_EXCHANGE_NAME, DELAY_HEADER, DELAY_QUEUE_NAME, NUM_ATTEMPT_HEADER, RETRY_BACKOFF}

import org.apache.commons.codec.binary.StringUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.amqp.core.MessageBuilder
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service

@Service
@Autowired
class RQProducer(private val rabbitTemplate: RabbitTemplate) {

  @Scheduled(fixedDelay = 15000)
  def sendMessage(): Unit = {
    rabbitTemplate.send(
      DELAY_EXCHANGE_NAME,
      DELAY_QUEUE_NAME,
      MessageBuilder
        .withBody(StringUtils.getBytesUtf8("Message"))
        .setHeader(DELAY_HEADER, 10 * RETRY_BACKOFF)
        .setHeader(NUM_ATTEMPT_HEADER, 10 + 1)
        .build()
    )
  }

}

object RQProducer {
  val logger: Logger = LoggerFactory.getLogger(classOf[RQProducer])
}
