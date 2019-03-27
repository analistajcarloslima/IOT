package IOT.IOT;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

public class MQTTTesteSubscribe {

public static void main(String[] args) {
String topic = "Lampada";
String broker = "tcp://localhost:1883";
String clientId = "ControladorLampada";
try {

MqttClient clienteSubscribe = new MqttClient(broker, clientId);
clienteSubscribe.setCallback( new SimpleMqttCallBack() );
System.out.println("Conectando ao broker: " + broker);
clienteSubscribe.connect();
System.out.println("Conectado");
clienteSubscribe.subscribe(topic);
} catch (MqttException me) {
System.out.println("reason " +
me.getReasonCode());
System.out.println("msg " +
me.getMessage());
System.out.println("loc " +
me.getLocalizedMessage());
System.out.println("cause " +
me.getCause());
System.out.println("excep " + me);
me.printStackTrace();
}
}
}
