package IOT.IOT;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MQTTTestePublish {

public static void main(String[] args) {
String topic = "Lampada";
String content = "Desliga";
int qos = 2;
String broker = "tcp://localhost:1883";
String clientId = "jow";
MemoryPersistence persistence = new
MemoryPersistence();
try {
MqttClient clientePublish = new MqttClient(broker, clientId, persistence);
MqttConnectOptions connOpts = new MqttConnectOptions();
connOpts.setCleanSession(true);
System.out.println("Conectando ao broker: " + broker);
clientePublish.connect(connOpts);
System.out.println("Conectado");
System.out.println("Publicando Mensagem: " + content);
MqttMessage message = new MqttMessage(content.getBytes());
message.setQos(qos);
clientePublish.publish(topic, message);
System.out.println("Message publicada");
clientePublish.disconnect();
System.out.println("Desconectado");
System.exit(0);

} catch (MqttException me) {
System.out.println("reason " + me.getReasonCode());
System.out.println("msg " + me.getMessage());
System.out.println("loc " + me.getLocalizedMessage());
System.out.println("cause " + me.getCause());
System.out.println("excep " + me);
me.printStackTrace();
}
}
}
