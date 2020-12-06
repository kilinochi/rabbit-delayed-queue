package org.kilinochi.rqueue
package service

abstract class RQBatcher {

}

protected object RQBatcher {
  val DELAY_QUEUE_NAME = "delayed.queue"
  val DELAY_EXCHANGE_NAME = "delayed.exchange"
  val DELAY_HEADER = "x-delay"
  val NUM_ATTEMPT_HEADER = "x-num-attempt"
  val RETRY_BACKOFF = 5000
}
