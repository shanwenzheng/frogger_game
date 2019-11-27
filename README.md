# <img src="http://b-ssl.duitang.com/uploads/item/201801/25/20180125131358_tVkML.thumb.1000_0.jpeg" alt="frog logo" width="50"/> Frogger

> This is a Frogger game project written in JavaFX.<br>

## Refactor Log

#### ① Model Refactor

* Rmove `setOnKeyPressed` && `setOnKeyReleased` and add `handleKeyPressed` && `handleKeyReleased` method
* Create `Map` Abstract class
* Create `SimpleMode` `NormalMode` `HardMode` class abstract from `Map` Class as game Level

#### ② View Refactor

* Split `gameView` from main class
* Remove `MyStage` class (Change to `MusicPlayer` class)
* Remove Actor acts related code from World (change to `Animation` class)
* Remove `World` class (The function is implemented in `gameController`)

#### ③ Util Refactor

* Create `MusicPlayer` class
* Create `Animation` class for Actor acts
* Create `ScoreBoardUpdater` class
* Change `MusicPlayer` to singleton pattern
* Create `MapLoader` class to load view
* Create `MapFactory` class to generate view

#### ④ Controller Refactor

* Split `gameController` from main class
* Split functoin in `gameController` to match single responsiblity
* Rename Timer to EndDetecter to match single responsibility
* Move scene eventHandler into `gameController`
