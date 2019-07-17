sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageToast"
], function (Controller, MessageToast) {
	"use strict";

	return Controller.extend("app.controller.App", {
		
		onOpenDialog : function () {
			//this.getOwnerComponent().openHelloDialog();
		},
		
		onNew1: function() {  //create new Order, through Odata
		   //create new record
		   
		   
		   var oTable = this.getView().byId("table1");
		   var oModel = this.getView().getModel();
		   
		   var sPathSource = "SNGLRECOUT(TRANSID='05FF88E921FAF1A58111005056032F99',CONNID='D866BD70886F11E9B765E87D0A4CC092',CONNCOUNTER=1,CDATE=datetime'2019-06-07T00%3A00%3A00',SERVICEID='FA163E4CC4F01EE699A8E03865ABBC52',CONNIDOUT='B8FF88E931CBF1788111005056032F99',CONNCOUNTERCOUT=2)";
		   var oSourceRow = oTable.getBinding("rows").oModel.oData[sPathSource];
		   var newId = (oTable.getBinding("rows").getLength() + 1).toString();
		   //console.log(oSourceRow.TRANSID);

		   var leng = oTable.getSelectedIndices().length;
		   if(leng === 1) { 
		   	
		   	var oNow = new Date();

		   	   var oEntry = {
		   	   	  "TRANSID": oSourceRow.CONNID.substring(0,29) + newId, 
				  "CONNID": oSourceRow.CONNID,
				  "CONNCOUNTER": oSourceRow.CONNCOUNTER,
				  //"CDATE": oSourceRow.CDATE,
				  //"CTIME": oSourceRow.CTIME,
				  "CDATE": oNow,
				  //"CTIME": "12:12:12",
				  "SERVICEID": oSourceRow.SERVICEID,
				  "CONNIDOUT": oSourceRow.CONNIDOUT,
				  "CONNCOUNTERCOUT": oSourceRow.CONNCOUNTERCOUT,
				  "SID": oSourceRow.SID,
				  "SYSTEMTYPE": oSourceRow.SYSTEMTYPE,
				  "TYPE": oSourceRow.TYPE,
				  "NAME1": oSourceRow.NAME1,
				  "NAME2": oSourceRow.NAME2,
				  "USERNAME": "I027712",
				  "TARGETINSTANCE": oSourceRow.TARGETINSTANCE,
				  "CALLINGTIME": oSourceRow.CALLINGTIME,
				  "SENTBYTES": oSourceRow.SENTBYTES,
				  "RECEIVEDBYTES": oSourceRow.RECEIVEDBYTES
				  };
				  /*var oNow = new Date();  //.now();
				  oEntry.ID = "d" + oNow.getFullYear().toString() + 
				  oNow.getMonth().toString() +  oNow.getDate().toString() + 
				  "-" + oNow.getHours() + "e3-" + oNow.getMinutes().toString() + oNow.getSeconds().toString() + "-b642-0ed5f89f718b";
				  */
				  
				  oModel.create("/SNGLRECOUT", oEntry, {
				  	method: "POST",
				  	success: function(data) {
				  		console.log(data);
				  		},
				  	error: function(e) {
				  		console.log(e);
				  	}
				  });
				  
				  this.getView().getModel().refresh();
		    } else {
		    	MessageToast.show("plz select only one row");
		    }
		   	
		},

		onDelete1 : function (oEvent) {
			//var nametoShow = this.oView.getModel().oData.recipient.name;
			//MessageToast.show(nametoShow);
			var oTable = this.getView().byId("table1");
			var oModel = this.getView().getModel();
			var leng = oTable.getSelectedIndices().length;
			for(var i=0; i<leng; i++ ) {
				var idx = oTable.getSelectedIndices()[i];
				
				var transId = oTable.getRows()[idx].getCells()[0].getText();
				var connId = oTable.getRows()[idx].getCells()[1].getText();
				var connCounter = oTable.getRows()[idx].getCells()[2].getText();
				
				var oCDATE = new Date(oTable.getRows()[idx].getCells()[3].getText());  //.now();
				var strCDATE = oCDATE.toISOString().split('T')[0]+ "T00%3A00%3A00";
				
				//var cTime = oTable.getRows()[idx].getCells()[4].getText();
				var srvId = oTable.getRows()[idx].getCells()[5].getText();
				
				var connIdOut = oTable.getRows()[idx].getCells()[6].getText();
				var connCounterOut = oTable.getRows()[idx].getCells()[7].getText();
				
				

				var sPath = "/SNGLRECOUT(TRANSID='" 
				     + transId 
				     + "',CONNID='"
				     + connId 
				     + "',CONNCOUNTER="
				     + connCounter
				     + ",CDATE=datetime'"
				     + strCDATE
				     + "',SERVICEID='"
				     + srvId
				     + "',CONNIDOUT='"
				     + connIdOut
				     + "',CONNCOUNTERCOUT="
				     + connCounterOut
				     + ")" ;
				     
				 //console.log(sPath);    
				
				oModel.remove(sPath, 
				{
				   success: function(data) {
				   		console.log(data);
				   	},
				   	error: function(ex) {
				   		console.log(ex);
				   }
				});
			}
			
			oModel.refresh();
			oTable.setSelectedIndex(-1);
		},
		
		
		onUpdate1: function (oEvent) {
			var oTable = this.getView().byId("table1");
			var oModel = this.getView().getModel();
			var leng = oTable.getSelectedIndices().length;
			if(leng === 1) {
				var idx = oTable.getSelectedIndex();

				var transId = oTable.getRows()[idx].getCells()[0].getText();
				var connId = oTable.getRows()[idx].getCells()[1].getText();
				var connCounter = oTable.getRows()[idx].getCells()[2].getText();
				
				var oCDATE = new Date(oTable.getRows()[idx].getCells()[3].getText());  //.now();
				var strCDATE = oCDATE.toISOString().split('T')[0]+ "T00%3A00%3A00";
				
				//var cTime = oTable.getRows()[idx].getCells()[4].getText();
				var srvId = oTable.getRows()[idx].getCells()[5].getText();
				
				var connIdOut = oTable.getRows()[idx].getCells()[6].getText();
				var connCounterOut = oTable.getRows()[idx].getCells()[7].getText();
				
				var sPath = "/SNGLRECOUT(TRANSID='" 
				     + transId 
				     + "',CONNID='"
				     + connId 
				     + "',CONNCOUNTER="
				     + connCounter
				     + ",CDATE=datetime'"
				     + strCDATE
				     + "',SERVICEID='"
				     + srvId
				     + "',CONNIDOUT='"
				     + connIdOut
				     + "',CONNCOUNTERCOUT="
				     + connCounterOut
				     + ")" ;
				     
			
			var oEntry = {};
			//var oNow = new Date();  //.now();
			
		    oEntry.NAME1 = "X-Name1";
		    oEntry.NAME2 = "X-Name2";
		    
		   
			oModel.update(sPath,  oEntry, 
				    {   
				    	method: "POST",
				    	success: function(data) {
				    		console.log(data);
				    	},
				    	error: function(ex) {
				    		console.log(ex);
				    	}
				});
			} else {
				MessageToast.show("Select only one row");
			}
			oModel.refresh();
			
		}
	});

});
