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
		   
		   var sPathSource = "AGGRECIN(1l)";
		   var oSourceRow = oTable.getBinding("rows").oModel.oData[sPathSource];
		   var newId = oTable.getBinding("rows").getLength() + 1;

		   var leng = oTable.getSelectedIndices().length;
		   if(leng === 1) { 
		   	
		   	var oNow = new Date();

		   	   var oEntry = {
		   	   	  "ID": newId.toString(), 
				  "TYPE": "M_A",
				  "USERNAME": "Xinlei",
				  "INSERTED_AT": oNow,
				  "INSTANCE": oSourceRow.INSTANCE,
				  "SID": oSourceRow.SID,
				  "SYSTEMTYPE": oSourceRow.SYSTEMTYPE,

				  "NAME1": oSourceRow.NAME1,
				  "NAME2": oSourceRow.NAME2,

				  "EXECUTION": oSourceRow.EXECUTION,
				  "RESPTIME": oSourceRow.RESPTIME,
				  "RESPTIMEMIN": oSourceRow.RESPTIMEMIN,
				  "RESPTIMEMAX": oSourceRow.RESPTIMEMAX,
				  "MEMORY": oSourceRow.MEMORY,
				  "CPUTIME": oSourceRow.CPUTIME,
				  "CPUTIMEMIN": oSourceRow.CPUTIMEMIN,
				  "CPUTIMEMAX": oSourceRow.CPUTIMEMAX,
				  "DBTIME": oSourceRow.DBTIME,
				  "DBTIMEMIN": oSourceRow.DBTIMEMIN,
				  "DBTIMEMAX": oSourceRow.DBTIMEMAX,
				  "WAITTIME": oSourceRow.WAITTIME,
				  "WAITTIMEMIN": oSourceRow.WAITTIMEMIN,
				  "WAITTIMEMAX": oSourceRow.WAITTIMEMAX,
				  "NETTIME": oSourceRow.NETTIME,
				  "NETTIMEMIN": oSourceRow.NETTIMEMIN,
				  "NETTIMEMAX": oSourceRow.NETTIMEMAX,
				  "LENGTH": oSourceRow.LENGTH,
				  "USERTYPE": oSourceRow.USERTYPE,
				  "CHAR1": oSourceRow.CHAR1,
				  "CHAR2": oSourceRow.CHAR2,
				  "NUM1": oSourceRow.NUM1,
				  "NUM2": oSourceRow.NUM2,
				  "NUM3": oSourceRow.NUM3,
				  "BYTES_RCVD": oSourceRow.BYTES_RCVD,
				  "BYTES_SENT": oSourceRow.BYTES_SENT
				  };
				  
				  
				  oModel.create("/AGGRECIN", oEntry, {
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
				
				var sId = oTable.getRows()[idx].getCells()[0].getText();
				
				var sPath = "/AGGRECIN("  + sId + "l)";

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

				var sId = oTable.getRows()[idx].getCells()[0].getText();
				
				var sPath = "/AGGRECIN("  + sId + "l)";
			
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
