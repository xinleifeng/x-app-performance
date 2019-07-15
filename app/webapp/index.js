sap.ui.require([
	"sap/m/Shell",
	"sap/m/App",
	"sap/m/Page",
	"sap/ui/core/ComponentContainer"
], function(
	Shell, App, Page, ComponentContainer) {
	"use strict";

	sap.ui.getCore().attachInit(function() {
		new Shell ({
			app : new App ({
				pages : [
					new Page({
						title : "TEST",
						enableScrolling : true,
						content : [
							new ComponentContainer({
								name : "app",
								settings : {
									id : "app"
								}
							})
						]
					})
				]
			})
		}).placeAt("content");
	});
});