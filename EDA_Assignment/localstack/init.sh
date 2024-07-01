#!/bin/sh

# Create SNS topic
awslocal sns create-topic --name appointment

# Create SQS queues
awslocal sqs create-queue --queue-name emailQueue
awslocal sqs create-queue --queue-name smsQueue
awslocal sqs create-queue --queue-name entityQueue

# Subscribe SQS queues to SNS topic
awslocal sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:appointment --protocol sqs --notification-endpoint http://localhost:4566/000000000000/emailQueue
awslocal sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:appointment --protocol sqs --notification-endpoint http://localhost:4566/000000000000/smsQueue
awslocal sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:appointment --protocol sqs --notification-endpoint http://localhost:4566/000000000000/entityQueue
