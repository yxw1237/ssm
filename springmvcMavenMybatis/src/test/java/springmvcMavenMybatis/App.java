package springmvcMavenMybatis;


import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class App {
	public static void main(String[] args)
	{
		Properties props = new Properties();
    	
		props.put("bootstrap.servers", "192.168.1.25:32780");
		props.put("group.id", "admin");
		props.put("auto.offset.reset", "earliest");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    	
		@SuppressWarnings("resource")
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		
		consumer.subscribe(Arrays.asList("TEST_IMS_COLLECTOR_ALERT"));
    	
		while(true)
		{
			ConsumerRecords<String, String> records = consumer.poll(100);
			
			for(ConsumerRecord<String, String> record : records)
			{
				//if(record.key().equals("D121230004"))
				//{
					//String s = String.format("offset = %d, key = %s, value = %s \r\n", record.offset(), record.key(), record.value());
				JSONObject js =JSONObject.parseObject(record.value());
				JSONArray ja = JSONArray.parseArray(js.getString("alertList"));
				for(int i=0;i<ja.size();i++){
					String time = ja.getJSONObject(i).getString("reportTime");
					String err = ja.getJSONObject(i).getString("errorID");
					String jibie = ja.getJSONObject(i).getString("severity");
					System.out.println(time+"....."+err+"....."+jibie+"===="+Integer.toHexString(Integer.parseInt(err)));
				}
					//System.out.println(s);
				//}
			}
    	}
	}

}
