namespace sap.crun.performance;

@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'SNGLRECOUT_INDEX', unique : false, order : #DESC, elementNames : ['TRANSID'] }  ]  
entity SNGLRECOUT {
  key TRANSID         : String(32) not null default '';
  key CONNID		  : String(32) not null default '';
  key CONNCOUNTER	  : Integer not null default 0;
  key CDATE 		  : String(8) not null default '';
  key CTIME 		  : String(8) not null default '';
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
  key TRANSID         : String(32) not null default '';
  key CONNID		  : String(32) not null default '';
  key CONNCOUNTER	  : Integer not null default 0;
  key CDATE 		  : String(8) not null default '';
  key CTIME 		  : String(8) not null default '';
  key SERVICEID 	  : String(36) not null default '';
  SID				  : String(40) not null default '';
  SYSTEMTYPE		  : String(10) not null default '';
  TYPE  			  : String(20) not null default '';
  NAME1 			  : String(150) not null default '';
  NAME2 			  : String(150) not null default '';
  USERNAME  		  : String(20) not null default '';
  SCLIENT  			  : String(3) not null default '';
  INSTANCE  		  : String(100) not null default '';
  ROOTCTXID  		  : String(32) not null default '';
  COMPONENTID  		  : String(32) not null default '';
  ACTION  			  : String(40) not null default '';
  PREVIOUSCOMPONENT   : String(32) not null default '';
  RESPTIME			  : Decimal(31,6) not null default 0;
  MEMORY 			  : Decimal(31,6) not null default 0;
  CPUTIME 			  : Decimal(31,6) not null default 0;
  DBTIME			  : Decimal(31,6) not null default 0;
  WAITTIME 			  : Decimal(31,6) not null default 0;
  NETTIME 			  : Decimal(31,6) not null default 0;
  PARAMS  			  : String(255) not null default '';
  MS				  : Integer not null default 0;
  RATING			  : Integer not null default 0;
  USERTYPE  		  : String(1) not null default '';
  CHAR1  			  : String(40) not null default '';
  CHAR2  			  : String(100) not null default '';
  NUM1 				  : Decimal(31,6) not null default 0;
  NUM2 			      : Decimal(31,6) not null default 0;
  NUM3				  : Decimal(31,6) not null default 0;
  BYTES_RCVD 		  : Decimal(31,6) not null default 0;
  BYTES_SENT 		  : Decimal(31,6) not null default 0;
}  


@Catalog.tableType: #COLUMN 
@Catalog.index: [ { name : 'AGGRECOUT_INDEX', unique : false, order : #DESC, elementNames : ['TYPE','NAME1'] }  ]  
entity AGGRECOUT {
  key TYPE            : String(3) not null default '';
  key NAME1 		  : String(150) not null default '';
  NAME2 			  : String(150) not null default '';
  USERNAME  		  : String(20) not null default '';
  CDATE 			  : String(8) not null default '';
  CTIME 			  : String(8) not null default '';
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
  key TYPE            : String(3) not null default '';
  key NAME1 		  : String(150) not null default '';
  NAME2 			  : String(150) not null default '';
  USERNAME  		  : String(20) not null default '';
  CDATE 			  : String(8) not null default '';
  CTIME 			  : String(8) not null default '';
  SERVICEID 		  : String(36) not null default '';
  PREVIOUSCOMPONENT   : String(32) not null default '';
  INSTANCE  		  : String(40) not null default '';
  SCLIENT 		      : String(3) not null default '';
  SID 				  : String(8) not null default '';
  SYSTEMTYPE 		  : String(10) not null default '';
  EXECUTION 		  : Decimal(31,6) not null default 0;
  RESPTIME 		      : Decimal(31,6) not null default 0;
  RESPTIMEMIN		  : Decimal(31,6) not null default 0;
  RESPTIMEMAX 		  : Decimal(31,6) not null default 0;
  MEMORY 		      : Decimal(31,6) not null default 0;
  CPUTIME			  : Decimal(31,6) not null default 0;
  CPUTIMEMIN 		  : Decimal(31,6) not null default 0;
  CPUTIMEMAX 	      : Decimal(31,6) not null default 0;
  DBTIME 		      : Decimal(31,6) not null default 0;
  DBTIMEMIN 		  : Decimal(31,6) not null default 0;
  DBTIMEMAX 		  : Decimal(31,6) not null default 0;
  WAITTIME			  : Decimal(31,6) not null default 0;
  WAITTIMEMIN 		  : Decimal(31,6) not null default 0;
  WAITTIMEMAX 		  : Decimal(31,6) not null default 0;
  NETTIME			  : Decimal(31,6) not null default 0;
  NETTIMEMIN 		  : Decimal(31,6) not null default 0;
  NETTIMEMAX 		  : Decimal(31,6) not null default 0;
  LENGTH			  : Integer not null default 0;
  CHAR1  			  : String(40) not null default '';
  CHAR2  			  : String(100) not null default '';
  NUM1 				  : Decimal(31,6) not null default 0;
  NUM2 			      : Decimal(31,6) not null default 0;
  NUM3				  : Decimal(31,6) not null default 0;
  USERTYPE  		  : String(1) not null default '';
  BYTES_RCVD 		  : Decimal(31,6) not null default 0;
  BYTES_SENT 		  : Decimal(31,6) not null default 0;
}

entity Books {
  key ID : Integer;
  title  : String;
  stock  : Integer;
}
