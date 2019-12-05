# ChangeLog

All notable chanegs to the project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [0.7.1] - 2019-12-04

### Added

- Create `FileName` constant class to store file URLs. In this way, every time we want to change the URL of file, only to do is changing the constant in `FileName` thus to increase maintainability.

## [0.7.0] - 2019-12-04

### Changed

- Finalize `ScoreListController` class to read the scoreList from file and show in the ScoreList page

## [0.6.2] - 2019-12-04

### Added

- Add `scoreListReader` class to read socreList from file
- Add `scoreListWriter` class to write current score into file

## [0.6.1] - 2019-12-03

### Added

- Add `highScoreList.fxml` to show the select page
- Add `highScoreListConrtoller` Controller to hanlde the initialize event and button event in ScoreList page

## [0.6.0] - 2019-12-03

### Added

- Add `instruction.fxml` to show the select page
- Add `instructionConrtoller` Controller to hanlde the button event in instruction page
- Add three button: HomePageButton, InstructionButton, RestartButton

### Changed

- Complete handleInstructionButton Clicked method in `StartScreenController` class
- Complete hanldeButton Clicked method in `GameController` class to realize restart, show instruction and back to home page function

## [0.5.0] - 2019-12-02

### Added

- Add `select.fxml` to show the select page
- Add `select` Controller to hanlde the button event and input event in select page

### Changed

- Refactor `MusicPlayer` class to contain startScreenMediaPlayer, selectMediaPlayer, gameMediaPlayer, loseMediaPlayer, winMediaPlayer to play different music depend on the page.

## [0.4.0] - 2019-12-01

### Added

- Add `SceneSwitch` Instance class to handle the change of stage scene
- Add `startScreen.fxml` to show the home page
- Add `startScreen` Controller to hanlde the button event in startScreen

## [0.3.1] - 2019-11-30

### Added

- Create `NormalMode` `SimpleMode` `HardMode` constant class to store the speed of each actor and position of each actor
- Create `MapReader` class to read from the gameLevel constant class and generate corresponding map layout.
- Create `MapFactory` class to read from input about the gameLevel String and call `MapReader` class to generate corresponding map and return this map to `GameView` class to show the scene.
- Add highScore scoreBoard in gameView to display the highest score of the current play
- Create `Life` Class and set life count operation in controller

## [0.3.0] - 2019-11-29

### Removed

- Remove all unused import class

### Changed

- Improve encapsulation by using private and setter and getter function

## [0.2.3] - 2019-11-29

### Removed

- Remove timer in GameController about detectEnd and updateScore

## [0.2.2] - 2019-11-29

### Changed

- Create checkTouch in `MovableActor` class as an abstract method
- Create hanlde function in `GameController` to listen the event happen in view then call releated method to response to these events
- `Turtle` check if intersect with animal and call function in GameController to let animal move with turtle
- `WetTurtle` check if intersect with animal and call function in GameController to let animal move with turtle or water death
- `Log` check if intersect with animal and call function in GameController to let animal move with Log
- `Obstacle` check if intersect with animal and call function in GameController to let animal car death
- `Frog` check if intersect with end and call function in GameController to hanlde endGame Condition
- `Frog` check if intersect with pool and call function in GameController to hanlde water death
- Using above could spilt the large function in `Frog` class and make each actor class to detect whether intersect with other

## [0.2.1] - 2019-11-29

### Changed

- Refactor `ScoreBoardUpdater` Class into Singleton Pattern
- Refactor `ActAnimation` Class into Singleton Pattern

## [0.2.0] - 2019-11-28

### Changed

- Uniform each actor class. (e.g Create the log abstract class for long-log, medium-log, short-log). (However, this is removed in version 0.3.0)

## [0.1.0] - 2019-11-27

### Changed

- Rename `Animal` class into `Frog` class
- Refactor `Frog` class by spliting the long act function into serveal small function to handle each event happens.

## [0.0.3] - 2019-11-26

### Fixed

- Fix the `digit` class bug that the hundreds place will not change when reducing. (Example: 160 - 50 = 110, and 110 - 50 = 160). Instead of adding new digit to origin place each time. Create a digit arrayList and each time replace the image of each digit.

### Changed

- Split `Actor` class into `StaticActor` class and `MovableActor` class. Extract the common method in each abstract class to imporve maintenance.
- Refactor specific actor class (`Wetturtle`, `Turtle`, `Log`, `Obstacle`, `End`, `Digit`) to reduce the code base and match the principle of single responsibility

### Removed

- Remove the `BackgroundImage` class and add `game.css` file to implement the function of adding background image.

## [0.0.2] - 2019-11-26

### Added

- Add `MusicPlayer` Class and set it to Singleton Pattern
- Add `ScoreBoardUpdater` Class to update Score 
- Add `ActAnimation` Class to make all actor operate act method

### Removed
- Remove `MyStage` Class and use `MusicPlayer` Class to replace it functions.
- Remove `World` Class and the eventListener for scene changed has to be replaced with eventHandler and call the method in gameController which calling method in animal to handle keymove.

## [0.0.1] - 2019-11-26

### Changed

- Build the normal JavaFX frogger game to Maven Project
- Split the `GameView` (Add all the imageView to background) from Main Class
- Split the `GameControoler` (The action about operating timer) from Main Class
- Refactor the package layout to match the MVC pattern(Controller, Model, Service, View)

[0.0.1]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.0.1
[0.0.2]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.0.2
[0.0.3]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.0.3
[0.1.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.1.0
[0.2.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.2.0
[0.2.1]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.2.1
[0.2.2]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.2.2
[0.2.3]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.2.3
[0.3.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.3.0
[0.3.1]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.3.1
[0.4.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.4.0
[0.5.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.5.0
[0.6.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.6.0
[0.6.1]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.6.1
[0.6.2]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.6.2
[0.7.0]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.7.0
[0.7.1]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/-/tags/v0.7.1
[Unreleased]: https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/compare/v0.0.1...master#