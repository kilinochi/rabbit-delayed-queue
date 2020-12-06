1. docker build --tag=x25/rmq-delayed-message-exchange .
2. docker run -d --name rmq -p 5672:5672 -p 15672:15672 x25/rmq-delayed-message-exchange
