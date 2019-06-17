package sap.crun.performance.api.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@IdClass(CompositeSnglRecOutKey.class)
@Table(name = "SAP_CRUN_PERFORMANCE_SNGLRECOUT")
public class SnglRecOut implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank 
	@Column(name = "TRANSID")
	private String transId;
	
	@Id
	@NotBlank
	@Column(name = "CONNID")
	private String connId;
	
	@Id
	@NotBlank
	@Column(name = "CONNCOUNTER")
	private int connCounter;
	
	@Id
	@NotBlank
	@Column(name = "CDATE")
	private String cDate;

	@Id
	@NotBlank
	@Column(name = "CTIME")
	private String cTime;
	
	@Id
	@NotBlank
	@Column(name = "SERVICEID")
	private String serviceId;
	
	@Id
	@NotBlank
	@Column(name = "CONNIDOUT")
	private String connIdOut;
	
	@Id
	@NotBlank
	@Column(name = "CONNCOUNTERCOUT")
	private int connCounterOut;
	
	@Column(name = "SID")
	@NotBlank
	private String sId;
	
	@Column(name = "SYSTEMTYPE")
	@NotBlank
	private String systemType;
	
	@Column(name = "TYPE")
	@NotBlank
	private String type;

	@Column(name = "NAME1")
	@NotBlank
	private String name1;
	
	@Column(name = "NAME2")
	@NotBlank
	private String name2;
	
	@Column(name = "USERNAME")
	@NotBlank
	private String userName;
	
	@Column(name = "TARGETINSTANCE")
	@NotBlank
	private String targetInstance;
	
	@Column(name = "CALLINGTIME")
	@NotBlank
	private float callingTime;
	
	@Column(name = "SENTBYTES")
	@NotBlank
	private float sendBypes;
	
	@Column(name = "RECEIVEDBYTES")
	@NotBlank
	private float receivedBypes;

	public String getTransId() {
		return transId;
	}

	
	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getConnId() {
		return connId;
	}

	public void setConnId(String connId) {
		this.connId = connId;
	}

	public int getConnCounter() {
		return connCounter;
	}

	public void setConnCounter(int connCounter) {
		this.connCounter = connCounter;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getConnIdOut() {
		return connIdOut;
	}

	public void setConnIdOut(String connIdOut) {
		this.connIdOut = connIdOut;
	}

	public int getConnCounterOut() {
		return connCounterOut;
	}

	public void setConnCounterOut(int connCounterOut) {
		this.connCounterOut = connCounterOut;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTargetInstance() {
		return targetInstance;
	}

	public void setTargetInstance(String targetInstance) {
		this.targetInstance = targetInstance;
	}

	public float getCallingTime() {
		return callingTime;
	}

	public void setCallingTime(float callingTime) {
		this.callingTime = callingTime;
	}

	public float getSendBypes() {
		return sendBypes;
	}

	public void setSendBypes(float sendBypes) {
		this.sendBypes = sendBypes;
	}

	public float getReceivedBypes() {
		return receivedBypes;
	}

	public void setReceivedBypes(float receivedBypes) {
		this.receivedBypes = receivedBypes;
	}


}

