/*******************************************************************************
 * Copyright (c) 2008, 2013 IBM Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0
 * which is available at:
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *******************************************************************************/

package com.ibm.zurich.mqttsgw.messages;

import com.ibm.zurich.mqttsgw.client.ClientInterface;
import com.ibm.zurich.mqttsgw.messages.control.ControlMessage;
import com.ibm.zurich.mqttsgw.messages.mqtt.MqttMessage;
import com.ibm.zurich.mqttsgw.messages.mqtts.MqttsMessage;
import com.ibm.zurich.mqttsgw.utils.Address;


/**
 * This object represents an "internal" message that "wraps" a Mqtts, a Mqtt
 * or a Control message.It is generated by the BroketInterface, any ClientInterface, the TimerService
 * and the MsgHandler (GatewayMsgHandler or ClientMsgHandler) and then is added in Dispatcher's queue.
 * In the case of Mqtts message carries also the client interface in which
 * MsgHandler will respond in the future.In all cases carries the Address field in order to 
 * uniquely identify the ClientMsgHandler or GatewayMsgHandler.If this filed does not exist,
 * the encapsulated message (Mqtts, Mqtt or Control) is addressed to all MsgHandlers.
 * 
 * @see com.ibm.zurich.mqttsgw.core.Dispatcher
 * @see com.ibm.zurich.mqttsgw.core.MsgHandler
 * @see com.ibm.zurich.mqttsgw.core.ClientMsgHandler
 * @see com.ibm.zurich.mqttsgw.core.GatewayMsgHandler
 *  
 *
 */
public class Message {

	public static final int MQTTS_MSG = 1;
	public static final int MQTT_MSG = 2;
	public static final int CONTROL_MSG = 3;


	private final Address address;
	private int type;

	private MqttsMessage mqttsMessage = null;
	private MqttMessage mqttMessage = null;
	private ControlMessage controlMessage = null;

	private ClientInterface clientInterface = null; 


	public Message(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public MqttsMessage getMqttsMessage() {
		return mqttsMessage;
	}

	public void setMqttsMessage(MqttsMessage mqttsMessage) {
		this.mqttsMessage = mqttsMessage;
	}

	public MqttMessage getMqttMessage() {
		return mqttMessage;
	}

	public void setMqttMessage(MqttMessage mqttMessage) {
		this.mqttMessage = mqttMessage;
	}

	public ControlMessage getControlMessage() {
		return controlMessage;
	}

	public void setControlMessage(ControlMessage controlMessage) {
		this.controlMessage = controlMessage;
	}

	public ClientInterface getClientInterface() {
		return clientInterface;
	}

	public void setClientInterface(ClientInterface clientInterface) {
		this.clientInterface = clientInterface;
	};	
}