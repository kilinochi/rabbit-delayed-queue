package org.kilinochi.rqueue
package configuration

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class RabbitMQConfiguration {

  @Autowired
  @Bean
  def simpleRabbitListenerContainerFactory(connectionFactory: ConnectionFactory) : SimpleRabbitListenerContainerFactory = {
    val factory = new SimpleRabbitListenerContainerFactory()
    factory.setConnectionFactory(connectionFactory)
    factory.setConcurrentConsumers(40)
    factory.setPrefetchCount(10)
    factory
  }
}
