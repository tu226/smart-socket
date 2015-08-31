package net.vinote.smart.socket.protocol.p2p.message;

import java.net.ProtocolException;

/**
 * @author Seer
 * @version RemoteInterfaceMessageReq.java, v 0.1 2015年8月24日 上午9:35:07 Seer Exp.
 */
public class RemoteInterfaceMessageReq extends BaseMessage {

	/** 接口唯一标识 */
	private String uniqueId;

	/** 接口名称 */
	private String interfaceClass;

	/** 调用方法 */
	private String method;

	/** 参数类型字符串 */
	private String[] paramClassList;

	/** 入参 */
	private Object[] params;

	@Override
	protected void encodeBody() throws ProtocolException {
		writeString(uniqueId);
		writeString(interfaceClass);
		writeString(method);
		writeObjectByProtobuf(paramClassList);
		writeObjectByProtobuf(params);
	}

	@Override
	protected void decodeBody() {
		uniqueId = readString();
		interfaceClass = readString();
		method = readString();
		paramClassList = readObjectByProtobuf();
		params = readObjectByProtobuf();
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getInterfaceClass() {
		return interfaceClass;
	}

	public void setInterfaceClass(String interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object... params) {
		this.params = params;
	}

	public String[] getParamClassList() {
		return paramClassList;
	}

	public void setParamClassList(String... paramClassList) {
		this.paramClassList = paramClassList;
	}

	@Override
	public int getMessageType() {
		return MessageType.REMOTE_INTERFACE_MESSAGE_REQ;
	}

}
