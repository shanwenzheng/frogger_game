# <img src="http://b-ssl.duitang.com/uploads/item/201801/25/20180125131358_tVkML.thumb.1000_0.jpeg" alt="frog logo" width="50"/> Frogger

> This is a Frogger game project written in JavaFX.<br>

## Refactor Log

#### ① Model Refactor

#### ② View Refactor

* Split `gameView` from main class
* Remove `MyStage` class
* Remove Actor acts related code from World

#### ③ Util Refactor

* Create `MusicPlayer` class
* Create `Animation` class for Actor acts
* Create `ScoreBoardUpdater` class

#### ④ Controller Refactor

* Split `gameController` from main class
