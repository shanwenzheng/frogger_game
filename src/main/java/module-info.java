module frogger {
	exports frogger;
	exports frogger.constant;
	exports frogger.controller;
	exports frogger.model.actor.staticActor;
	exports frogger.model;
	exports frogger.view;
	exports frogger.util;
	exports frogger.model.actor.movableActor;
	exports frogger.model.actor;

	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	requires transitive javafx.media;
	requires transitive javafx.fxml;
}