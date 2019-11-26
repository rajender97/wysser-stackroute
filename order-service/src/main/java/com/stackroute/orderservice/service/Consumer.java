package com.stackroute.orderservice.service;

import com.google.gson.Gson;
import com.stackroute.orderservice.domain.TimeSlot;
import com.stackroute.orderservice.repository.ConsumerRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Consumer {
    @Autowired
    private ConsumerRepository consumerRepository;

    private KafkaConsumer<String, String> kafkaConsumer;

    public Consumer(String topicName, Properties consumerProperties) {

        kafkaConsumer = new KafkaConsumer<>(consumerProperties);
        kafkaConsumer.subscribe(Arrays.asList(topicName));
    }

    /**
     * This function will start a single worker thread per topic.
     * After creating the consumer object, we subscribed to a list of Kafka topics, in the constructor.
     * For this example, the list consists of only one topic. But you can give it a try with multiple topics.
     */
    public void runSingleWorker() {

        /*
         * We will start an infinite while loop, inside which we'll be listening to
         * new messages in each topic that we've subscribed to.
         */
        while(true) {

            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);

            for (ConsumerRecord<String, String> record : records) {

                /*
                Whenever there's a new message in the Kafka topic, we'll get the message in this loop, as
                the record object.
                 */

                /*
                Getting the message as a string from the record object.
                 */
                String message = record.value();

                /*
                Logging the received message to the console.
                 */
                System.out.println("Received message: " + message);

                /*
                If you remember, we sent 10 messages to this topic as plain strings.
                10 other messages were serialized JSON objects. Now we'll deserialize them here.
                But since we can't make out which message is a serialized JSON object and which isn't,
                we'll try to deserialize all of them.
                So, obviously, we'll get an exception for the first 10 messages we receive.
                We'll just log the errors and not worry about them.
                 */
                try {
                    Gson gson = new Gson();
                    TimeSlot timeSlot = gson.fromJson(message, TimeSlot.class);
                    System.out.println(timeSlot.toString());
                    //JSONObject receivedJsonObject = new JSONObject(message);

                    /*
                    To make sure we successfully deserialized the message to a JSON object, we'll
                    log the index of JSON object.
                     */
                    //System.out.println("Index of deserialized JSON object: " + receivedJsonObject.getInt("index"));
                    //this.consumerRepository.deleteAll();
                    this.consumerRepository.save(timeSlot);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                /*
                Once we finish processing a Kafka message, we have to commit the offset so that
                we don't end up consuming the same message endlessly. By default, the consumer object takes
                care of this. But to demonstrate how it can be done, we have turned this default behaviour off,
                instead, we're going to manually commit the offsets.
                The code for this is below. It's pretty much self explanatory.
                 */
                {
                    Map<TopicPartition, OffsetAndMetadata> commitMessage = new HashMap<>();

                    commitMessage.put(new TopicPartition(record.topic(), record.partition()),
                            new OffsetAndMetadata(record.offset() + 1));

                    kafkaConsumer.commitSync(commitMessage);

                    System.out.println("Offset committed to Kafka.");
                }
            }
        }
    }
}
