module frogger {
	exports frogger;
	exports frogger.constant;
	exports frogger.controller;
	exports frogger.model.actor.staticActor;
	exports frogger.model;
	exports frogger.view;
	exports frogger.service;
	exports frogger.model.actor.movableActor;
	exports frogger.model.actor;
	opens frogger.controller to javafx.fxml;

	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires transitive javafx.fxml;
	requires transitive javafx.graphics;
	requires transitive javafx.media;
}