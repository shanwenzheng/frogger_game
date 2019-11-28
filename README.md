# <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574904535284&di=813c323d940e990abd930b9162c49178&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201802%2F06%2F20180206082802_nmqet.thumb.700_0.jpg" alt="frog logo" width="50"/> Frogger

> This is a Frogger game project written in JavaFX.<br>

## Refactor Log

#### ① Model Refactor

* Rmove `setOnKeyPressed` && `setOnKeyReleased` and add `handleKeyPressed` && `handleKeyReleased` method
* Create `Map` Abstract class
* Create `SimpleMode` `NormalMode` `HardMode` class abstract from `Map` Class as game Level
* Solve Digit Bug
* Split `Actor` class into `StaticActor` and `MovableActor`
* Split Model classes to inherit from different actor
* Refactor `WetTurtle` class
* Refactor `Turtle` class
* Refactor `Obstacle` class
* Refactor `Log` class
* Refactor `End` class
* Refactor `BackgroundImage` class
* Refactor `Animal` Class

* Uniform `Turtle` Class
* Uniform `Obstacle` Class
* Uniform `Log` Class
* Delete `BackgroundImage` Class

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
