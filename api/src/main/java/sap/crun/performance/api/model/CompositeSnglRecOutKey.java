package sap.crun.performance.api.model;

import java.io.Serializable;

public class CompositeSnglRecOutKey implements Serializable {
	private String transId;
	private String connId;
	private int connCounter;
	private String cDate;
	private String cTime;
	private String serviceId;
	private String connIdOut;
	private int connCounterOut;
}
