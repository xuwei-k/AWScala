package awscala.sqs

case class Queue(url: String) {

  def messages()(implicit sqs: SQS): collection.Seq[Message] = sqs.receiveMessage(this)

  def add(messages: String*)(implicit sqs: SQS) = sqs.sendMessages(this, messages)
  def addAll(messages: collection.Seq[String])(implicit sqs: SQS) = sqs.sendMessages(this, messages)

  def remove(messages: Message*)(implicit sqs: SQS) = sqs.deleteMessages(messages)
  def removeAll(messages: collection.Seq[Message])(implicit sqs: SQS) = sqs.deleteMessages(messages)

  def destroy()(implicit sqs: SQS) = sqs.deleteQueue(this)

}

