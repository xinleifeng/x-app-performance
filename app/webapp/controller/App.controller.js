sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageToast"
], function (Controller, MessageToast) {
	"use strict";

	return Controller.extend("app.controller.App", {
		
		onOpenDialog : function () {
			//this.getOwnerComponent().openHelloDialog();
		},
		
		onNewOrder: function() {  //create new Order, through Odata
		   //create new record
		   var oModel = this.getView().getModel();
		   var oEntry = {};
		   var oNow = new Date();  //.now();
		   oEntry.ID = "d" + oNow.getFullYear().toString() + 
		                    oNow.getMonth().toString() +  oNow.getDate().toString() + 
		                    "-" + oNow.getHours() + "e3-" + oNow.getMinutes().toString() + oNow.getSeconds().toString() + "-b642-0ed5f89f718b";
		   oEntry.buyer = "Buyer XX";
		   oEntry.amount = 9;
		   oEntry.book_ID = 20;
		   oEntry.date =  oNow;
		   

		   /*
		   	    	<!--
	    	<d:ID>46263108-0fe3-11e8-b642-0ed5f89f718b</d:ID>
	    	<d:buyer>Buyer 1</d:buyer>
	    	<d:date>2018-02-01T00:00:00Z</d:date>
	    	<d:amount>1000</d:amount>
	    	<d:book_ID>2</d:book_ID>
	     --> */

		   
		   oModel.create("/Orders", oEntry, {
		   	method: "POST",
		   	success: function(data) {
		   		console.log(data);
		   	},
		   	error: function(e) {
		   		console.log(e);
		   	}
		   });
		   this.getView().getModel().refresh();
		},

		onDelete1 : function (oEvent) {
			//var nametoShow = this.oView.getModel().oData.recipient.name;
			//MessageToast.show(nametoShow);
			var oTable = this.getView().byId("table1");
			var oModel = this.getView().getModel();
			var leng = oTable.getSelectedIndices().length;
			for(var i=0; i<leng; i++ ) {
				var idx = oTable.getSelectedIndices()[i];
				var orderId = oTable.getRows()[idx].getCells()[0].getText();
				oModel.remove("/SNGLRECOUT(guid'" + orderId  + "')", 
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
		onUpdate: function (oEvent) {
			
			var oTable = this.getView().byId("table1");
			var oModel = this.getView().getModel();
			var leng = oTable.getSelectedIndices().length;
			if(leng === 1) {
				var idx = oTable.getSelectedIndex();
				var orderId = oTable.getRows()[idx].getCells()[0].getText();
			}
				
			/*
			var oEntry = {};
				var oNow = new Date();  //.now();
			
		        oEntry.buyer = "Buyer Update";
		        oEntry.amount = 9;
		        oEntry.book_ID = oNow.getDay() + 1;
		        oEntry.date =  oNow;
		   
		   
				oModel.update("/Orders(guid'" + orderId  + "')",  oEntry, 
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
			*/
		}
	});

});
