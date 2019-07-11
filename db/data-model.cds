namespace sap.crun.performance;

@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'SNGLRECOUT_INDEX', unique : false, order : #DESC, elementNames : ['TRANSID'] }  ]  
entity SNGLRECOUT {
  key TRANSID         : String(32) not null default '';
  key CONNID		  : String(32) not null default '';
  key CONNCOUNTER	  : Integer not null default 0;
  key CDATE 		  : Date not null;
  key CTIME 		  : Time not null;
  key SERVICEID 	  : String(36) not null default '';
  key CONNIDOUT 	  : String(32) not null default '';
  key CONNCOUNTERCOUT : Integer not null default 0;
  SID				  : String(40) not null default '';
  SYSTEMTYPE		  : String(10) not null default '';
  TYPE  			  : String(20) not null default '';
  NAME1 			  : String(150) not null default '';
  NAME2 			  : String(150) not null default '';
  USERNAME  		  : String(20) not null default '';
  TARGETINSTANCE	  : String(150) not null default '';
  CALLINGTIME		  : Decimal(31,6) not null default 0;
  SENTBYTES 		  : Decimal(31,6) not null default 0;
  RECEIVEDBYTES 	  : Decimal(31,6) not null default 0;
}  
  
@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'SNGLRECIN_INDEX', unique : false, order : #DESC, elementNames : ['TRANSID'] }  ]  
entity SNGLRECIN {
  key ID			  : UUID;
  TRANSID       	  : String(32) not null default '';
  CONNID			  : String(32);
  CONNCOUNTER		  : Integer not null default 0;
  CDATE 			  : DateTime not null;
  SERVICEID 		  : String(36);
  SID				  : String(40) not null default '';
  SYSTEMTYPE		  : String(10) not null default '';
  TYPE  			  : String(20) not null;
  NAME1 			  : String(1024);
  NAME2 			  : String(150);
  USERNAME  		  : String(20);
  SCLIENT  			  : String(3);
  INSTANCE  		  : String(100) not null default '';
  ROOTCTXID  		  : String(32);
  COMPONENTID  		  : String(32);
  ACTION  			  : String(40);
  PREVIOUSCOMPONENT   : String(32);
  RESPTIME			  : Decimal(31,6);
  MEMORY 			  : Decimal(31,6);
  CPUTIME 			  : Decimal(31,6);
  DBTIME			  : Decimal(31,6);
  WAITTIME 			  : Decimal(31,6);
  NETTIME 			  : Decimal(31,6);
  PARAMS  			  : String(255);
  MS				  : Integer not null default 0;
  USERTYPE  		  : String(1);
  CHAR1  			  : String(40);
  CHAR2  			  : String(100);
  NUM1 				  : Decimal(31,6);
  NUM2 			      : Decimal(31,6);
  NUM3				  : Decimal(31,6);
  BYTES_RCVD 		  : Decimal(31,6);
  BYTES_SENT 		  : Decimal(31,6);
}  


@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'AGGRECOUT_INDEX', unique : false, order : #DESC, elementNames : ['TYPE','NAME1'] }  ]  
entity AGGRECOUT {
  key TYPE            : String(3) not null default '';
  key NAME1 		  : String(150) not null default '';
  NAME2 			  : String(150) not null default '';
  USERNAME  		  : String(20) not null default '';
  CDATE 			  : Date not null;
  CTIME 			  : Time not null;
  SERVICEID 		  : String(36) not null default '';
  PREVIOUSCOMPONENT   : String(32) not null default '';
  INSTANCE  		  : String(40) not null default '';
  SCLIENT 		      : String(3) not null default '';
  TYPEOUT 		      : String(3) not null default '';
  NAME1OUT 		      : String(150) not null default '';
  SID 				  : String(8) not null default '';
  SYSTEMTYPE 		  : String(10) not null default '';
  USERNAMEOUT 		  : String(20) not null default '';
  TARGETINSTANCE 	  : String(40) not null default '';
  EXECUTION 		  : Decimal(31,6) not null default 0;
  CALLINGTIME 	      : Decimal(31,6) not null default 0;
  CALLINGTIMEMIN      : Decimal(31,6) not null default 0;
  CALLINGTIMEMAX 	  : Decimal(31,6) not null default 0;
  SENTBYTES 		  : Decimal(31,6) not null default 0;
  RECEIVEDBYTES 	  : Decimal(31,6) not null default 0;
}

@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'AGGRECIN_INDEX', unique : false, order : #DESC, elementNames : ['TYPE','NAME1'] }  ]  
entity AGGRECIN {
  key ID			  : UUID;
  TYPE                : String(3) not null;
  NAME1 		      : String(1024);
  NAME2 			  : String(150);
  USERNAME  		  : String(20);
  CDATE 			  : DateTime not null;
  SERVICEID 		  : String(36);
  PREVIOUSCOMPONENT   : String(32);
  INSTANCE  		  : String(40) not null default '';
  SCLIENT 		      : String(3);
  SID 				  : String(8) not null default '';
  SYSTEMTYPE 		  : String(10) not null default '';
  EXECUTION 		  : Decimal(31,6);
  RESPTIME 		      : Decimal(31,6);
  RESPTIMEMIN		  : Decimal(31,6);
  RESPTIMEMAX 		  : Decimal(31,6);
  MEMORY 		      : Decimal(31,6);
  CPUTIME			  : Decimal(31,6);
  CPUTIMEMIN 		  : Decimal(31,6);
  CPUTIMEMAX 	      : Decimal(31,6);
  DBTIME 		      : Decimal(31,6);
  DBTIMEMIN 		  : Decimal(31,6);
  DBTIMEMAX 		  : Decimal(31,6);
  WAITTIME			  : Decimal(31,6);
  WAITTIMEMIN 		  : Decimal(31,6);
  WAITTIMEMAX 		  : Decimal(31,6);
  NETTIME			  : Decimal(31,6);
  NETTIMEMIN 		  : Decimal(31,6);
  NETTIMEMAX 		  : Decimal(31,6);
  LENGTH			  : Integer;
  USERTYPE  		  : String(1);
  CHAR1  			  : String(40);
  CHAR2  			  : String(100);
  NUM1 				  : Decimal(31,6);
  NUM2 			      : Decimal(31,6);
  NUM3				  : Decimal(31,6);
  BYTES_RCVD 		  : Decimal(31,6);
  BYTES_SENT 		  : Decimal(31,6);
}

@cds.persistence.skip
entity STATUS_OVERVIEW(STARTTIMESTAMP : DateTime, ENDTIMESTAMP : DateTime) {
	key Type	: String(3);
	Count		: Integer;
}