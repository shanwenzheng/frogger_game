# <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574904535284&di=813c323d940e990abd930b9162c49178&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201802%2F06%2F20180206082802_nmqet.thumb.700_0.jpg" alt="frog logo" width="50"/> Frogger

> This is a Frogger game project written in JavaFX and maintain as well as extend the [existing code](https://github.com/hirish99/Frogger-Arcade-Game).<br>

## Directory

- [Screenshots](#screenshots)
- [Version Requirement](#version-requirement)
- [Compiling & Running](#compiling-running)
- [File Structure](#file-structure)
- [Maintaining Work](#maintaining-work)
- [Extending Work](#extending-work)
- [About](#about)

## Screenshots
# <img src="https://i.loli.net/2019/12/13/jm21GspU8bVodKI.jpg" alt="home" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/RSMoI6D5krLCYGn.png" alt="select" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/jxhnQbFu4UTGCz6.png" alt="instruction" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/FXpIEanmbYfHDhi.png" alt="normal" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/5Z9GOdlXYS8xaTy.png" alt="hard" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/QFHLhxAifo24TRZ.png" alt="simple" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/tuRyPqZwgUNEe2L.png" alt="victory" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/Z1as6RHJlzjQ54w.png" alt="defeat" width="350" height="400"/>  <img src="https://i.loli.net/2019/12/13/h2G7BTs3YvWJZ81.jpg" alt="popup" width="350" height="400"/>

## Version Requirement
> Compatible with:
>
> - Java 10 or higher
> - JavaFX 10 or higher
> - Maven

## Compiling & Running

You can launch this application either by running as normal `JavaFX application` or using `maven` to build this project.

For example, in Eclipse, Click <kbd>Run</kbd> -> <kbd>Run As</kbd> -> <kbd>Java Application</kbd> || <kbd>Maven build</kbd>

## File Structure

```
src
└── main
|   ├── java
|   |   └── frogger
|   |       ├── constant
|   |       ├── controller
|   |       ├── model
|   |       ├── service
|   |       └── Main.java
|   └── resources
|       └── frogger
|           ├── css
|           ├── image
|           ├── scoreFile
|           ├── music
|           └── view
|── test
    ├── java
    |   └── frogger
    |       ├── constant
    |       ├── controller
    |       ├── model
    |       └── service
    └── resources
        └── frogger
            └── file
```

## Maintaining Work

### Breaking up large classes in a meaningful way 

For example, breaking the original `Main` class into `GameController` class and `GameView` class. Moreover, the `GameController` class can be split into `ActAnimation` class, `MusicPlayer` class, `ScoreBoardUpdater` class, etc.

### Breaking up large methods in a meaningful way

For example, instead of adding all object in one function in `GameView` class, I use seperate method such as `drawObstacle()` or `drawLog()` to accomplish the same thing.

### Improving Encapsulation

Making all public field into `private` and create `getter` and `setter` method to access these fields

### Splitting Animal Class

Instead of checking frog whether touch other actors, in my refactor, I create method `checkTouch()` for each actor to check whether they touch frog. And if ture, then call the `GameController` to handle such consequences.

For example, in `Log` class, if `getIntersectingObjects(Frog.class).size() >= 1`, then will call `GameController.INSTANCE.handleLogTurtleTouched(this);` which call `move` method in frog to move with log.

### Splitting Actor Class

Break up the `Actor` class to `MovableActor` and `StaticActor` and only `MovableActor` have the move and act method.

### Add design patterns

* MVC (Controller + View + Model)
* Singleton (`MusicPlayer`, `ScoreListReader`, etc)
* Factory (`ScoreBaseFactory`, `MapFactory`)
* Observer

### Refactor inner method of class

Almost every class's intrinsic function has been recreated (Redcue if statement, extract common method, etc.)

### Using Constant Java Class

`FileName`, `GameLevel`, `NormalMode`... Every time you want to change the image path or speed of one actor, only need to do is open these class and change the corresponding value.

### Organising files in a meaningful way

Deatils in [File Structure](#file-structure)

### Add meaningful JavaDocs

Deatils in [docs folder](https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/tree/master/doc)


</br>

## Extending Work

### GameLevel

A new level can be easily added by creating a new class under `/src/main/java/frogger/constant` which contain the constant of `SPEED` and `POSITION`

##### Step 1: create constant java class:

An example of part of `NormalMode.java` defining the game property in normal level.

```java
	
	public static final double SPEED_OF_LONG_TRUCK = 1
	public static final double SPEED_OF_LONG_LOG = -1;
	public static final double SPEED_OF_TURTLE = -1;
	
	public static final HashMap<Integer, Integer> POS_OF_LONG_TRUCK = new HashMap<Integer, Integer>(){{
		put(0,540);
		put(500,540);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_LONG_LOG = new HashMap<Integer, Integer>(){{
		put(0,276);
		put(400,276);
	}};
	
	public static final HashMap<Integer, Integer> POS_OF_TURTLE = new HashMap<Integer, Integer>(){{
		put(500,376);
		put(300,376);
	}};
```
##### step 2: Using MapReader to create Map

`MapReader` class receives the gameLevel and read the corresponding constant class to generate appropriate `Map`.

An example of usage MapReader:

```java
    Class levelConst = Class.forName("frogger.constant." + gameLevel);
    double speed = levelConst.getField("SPEED_OF_" + actor_string).get(null);
    HashMap<Integer, Integer> position = levelConst.getField("POS_OF_" + actorStr).get(null);

    for(Integer xPos : position.keySet()){
        map.getActors().add(new Actor(ImageLink, ImageSize, xPos, position.get(xPos), speed));
    }
```

##### step 3: Using MapFactory to get Map and return to gameView

`MapFactory` pass the gamelevel to `MapReader` and get the map from it. Then return the map to `GameView` who add it to background.

```java
    if(MapType.equals("NormalMode")){
        mapReader = new MapReader("NormalMode");
    }

    mapReader.createMap();
    return mapReader.getMap();
```

Done! A new Level and new map is created.

### StartScreen

A home page contains three buttons, `start button` switch to select page, `instruction button` open the instruction stage and `exit button` exit the application

### SelectScreen

A select page ask players to select `gameLevel` and enter `nickname`. The nickname cannot be null and max length is 12.

### gameScreen

In addition to the original function, I add three button: `restart, instruction and home`. Moreover, I also add the `life` system and when life runs out, the game end. Finally, the `pop up` stage, appearing at the end of each round, showing the scores from each round, highest at the top.

### highScoreList

This appears when ending game. If lose, play the lose music and show the defeat image. If win, play the victory music and show the victory image. In addition, this show a `permanent high score list` stored in file. Finally, `three button: restart, home, exit` plays corresponding function.

### popupScreen

This appears when frog lose its life and shows the scores from each round, highest at the top.

<br>

## About

### Requirements:

Click [here](https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/blob/master/COMP2013%20Coursework02%202019%20TaskDescription%20v07.pdf) to know requirements.

### Class Diagram:

<img src="https://i.loli.net/2019/12/13/gCfPQMstuiqZ6N1.png" alt="class diagram"/> 

### Video illustration:

Click [here](https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/blob/master/Shan_Wenzheng.mp4) to download the video documentation about game running and illustration of refactor and addition works.

### ChangeLog:

Click [here](https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/blob/master/CHANGELOG.md) to know the changelog and version information.

### Credits:

All music & images are derived from internet and free to use for non-commercial use.

### License:

This project use [MIT license](https://projects.cs.nott.ac.uk/scyws1/g52swm_cw2_scyws1/blob/master/LICENSE).