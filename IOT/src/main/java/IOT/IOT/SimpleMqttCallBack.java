package IOT.IOT;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleMqttCallBack implements MqttCallback {
String message;
public void connectionLost(Throwable throwable) {

System.out.println("Conexao com MQTT broker perdida!");

}
public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
message = new String(mqttMessage.getPayload());

System.out.println("Menssagem recebida" + " para " + topic + " :\t"+ message );

}
public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
}
public String getMessage(){
return message;
}
}
