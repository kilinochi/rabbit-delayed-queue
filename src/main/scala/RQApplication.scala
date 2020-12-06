package org.kilinochi.rqueue

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

object RQApplication {
  def main(args: Array[String]): Unit = SpringApplication.run(classOf[RQApplication], args :_ *)
}

@SpringBootApplication
@EnableScheduling
class RQApplication {}
