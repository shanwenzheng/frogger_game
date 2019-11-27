# <img src="https://www.google.com/imgres?imgurl=http%3A%2F%2Fstatic.shenyou.tv%2F20180127%2Fc51e3ad4b5c85d5cb00e56c36a5852bc.png-watermark&imgrefurl=https%3A%2F%2Fwww.shenyou.cn%2Farticle%2F317102.html&docid=Mm_L1rG1wdaI2M&tbnid=EpPK5xLODVDG6M%3A&vet=10ahUKEwi4w8jcuIvmAhVK6RoKHTrbAM4QMwguKAIwAg..i&w=446&h=432&hl=en-GB&bih=794&biw=1474&q=%E6%97%85%E8%A1%8C%20%E9%9D%92%E8%9B%99&ved=0ahUKEwi4w8jcuIvmAhVK6RoKHTrbAM4QMwguKAIwAg&iact=mrc&uact=8" alt="frog logo" width="50"/> Frogger

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
