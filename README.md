# Setup-Kafka
Setup Kafka locally

# Producer

<img width="764" alt="Screenshot 2024-11-28 at 11 32 34 PM" src="https://github.com/user-attachments/assets/57935570-7346-4242-bb4a-eadfda69c860">

# Consumer

<img width="994" alt="Screenshot 2024-11-28 at 11 32 15 PM" src="https://github.com/user-attachments/assets/ce04f2e6-e20b-4107-98b8-3d5da385d1d5">


To run these commands, open a **terminal** window on your macOS or Linux machine, then navigate to the directory where you downloaded the Kafka `tar.gz` file. For example:

1. **Open Terminal**: On macOS, you can open Terminal by going to `Applications > Utilities > Terminal`.

2. **Navigate to Download Location**: Go to the folder where Kafka was downloaded. If it was saved in your `Downloads` folder, type:

   ```bash
   cd ~/Downloads
   ```

3. **Extract Kafka**: Use the `tar` command to extract the Kafka archive. Replace `kafka_2.13-3.0.0.tgz` with the exact filename of the Kafka version you downloaded:

   ```bash
   tar -xzf kafka_2.13-3.0.0.tgz
   ```

4. **Navigate to the Kafka Directory**: Move into the extracted Kafka directory:

   ```bash
   cd kafka_2.13-3.0.0
   ```

You’re now in the Kafka directory and can proceed with the setup by running the commands for starting Zookeeper and Kafka.


After navigating to the Kafka directory and extracting it, follow these steps to complete the setup and get Kafka running locally. Remember, Kafka depends on **Zookeeper**, so we'll start Zookeeper first.

### Steps to Set Up and Run Kafka Locally

#### 1. **Start Zookeeper**

1. In the Kafka directory, start Zookeeper using the provided configuration file. Run the following command in your terminal:

   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   ```

   - **Explanation**: This command uses the `zookeeper.properties` configuration file located in the `config` directory. It launches Zookeeper, which Kafka needs for managing brokers and tracking cluster metadata.

2. Leave this terminal window open, as Zookeeper will continue to run while you work with Kafka.

#### 2. **Start Kafka Broker**

1. Open a **new terminal window** to keep Zookeeper running in the background.
2. In the new terminal window, navigate to the Kafka directory again (if you’re not already there).
3. Start Kafka using its configuration file:

   ```bash
   bin/kafka-server-start.sh config/server.properties
   ```

   - **Explanation**: This command starts the Kafka broker (or server), which will listen on `localhost:9092` by default. You should see messages in the terminal indicating that the broker has started successfully.

#### 3. **Create a Kafka Topic**

1. Open another **new terminal window**.
2. Navigate to the Kafka directory, if necessary.
3. Create a new topic in Kafka called `test-topic`:

   ```bash
   bin/kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
   ```

   - **Explanation**: This command creates a topic named `test-topic` with 1 partition and a replication factor of 1. The `--bootstrap-server` argument specifies the Kafka server address.

4. You should see a confirmation message that the topic was created successfully.

#### 4. **Send Messages to the Topic (Producer)**

1. Open a **new terminal window**.
2. In the Kafka directory, start a producer to send messages to the `test-topic`:

   ```bash
   bin/kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092
   ```

3. In this producer console, type messages and press **Enter** to send each one. Each message will be sent to the `test-topic` topic.

#### 5. **Read Messages from the Topic (Consumer)**

1. Open another **new terminal window**.
2. In the Kafka directory, start a consumer to read messages from `test-topic`:

   ```bash
   bin/kafka-console-consumer.sh --topic test-topic --bootstrap-server localhost:9092 --from-beginning
   ```

3. You should see the messages you typed in the producer console appear in the consumer console. This confirms that Kafka is successfully sending and receiving messages.

#### 6. **Stopping Kafka and Zookeeper**

To stop Kafka and Zookeeper, press `Ctrl + C` in each terminal window where they're running. Alternatively, you can use these commands in the Kafka directory:

```bash
# Stop Kafka
bin/kafka-server-stop.sh

# Stop Zookeeper
bin/zookeeper-server-stop.sh
```

### Summary of Commands

Here’s a quick list of all the commands in order:

```bash
# Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Start Kafka Broker
bin/kafka-server-start.sh config/server.properties

# Create a Kafka Topic
bin/kafka-topics.sh --create --topic test-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# Start a Producer
bin/kafka-console-producer.sh --topic test-topic --bootstrap-server localhost:9092

# Start a Consumer
bin/kafka-console-consumer.sh --topic test-topic --bootstrap-server localhost:9092 --from-beginning
```

By following these steps, you’ll have a local Kafka setup for testing and development purposes. Let me know if you need any further assistance!
