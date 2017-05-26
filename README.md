# Game Of Earth
 - This Game Should run in Pixel or Nexus 6 .
 
# Creator
|Name|Duty|
|----|----|
|Kamontat Chantrachirathumrong 5810546552| `Database`, `Game algorithm`, `fully dressed use case`, `UML class diagram`  |
|Soraya Saenna 5810546056                | `Database`, `Game algorithm`, `fully dressed use case`, `UML class diagram`  |
|Thanawan Sean-in 5810545891             | `Main activity`, `Material UI`, `fully dressed use case`, `UML class diagram` |

# Design Pattern
We use Design Pattern
  - Observer Pattern —> [main activity](#view) (Observer), [GameLogic](#model) (Observer), [ResultDialog](#api) (Observer)
  - Null Object Pattern —> [Resource](#model) Object
  - Strategy pattern —> All game [algorithm](#model)
  - Singleton pattern —> [Database](#model), [Question Dialog](#api), [Result Dialog](#api)
  - Builder —> [Question](#model), [Resource](#model), [Dialog](#api)

# Design Principle
### We create this game along with `SOLID principle`

- Single Responsibility Principle
- Open/Closed Principle
- Liskov Substitution Principle
- Interface-Segregation Principle
- Dependency Inversion Principle And GRASP principles
- Protect Variation Principle
- Polymorphism Principle
- Pure Fabrication Principle
- Indirection Principle

# Files
1. Project description - [here](project_resource)
2. APK file - [here](production/release/GameOfEarth-1.0.0-beta(50)-release.apk)
3. Code association (JSON) - [here](codeiris/model_associate.json)

# Code Explanation

## API
1. [constants](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants)
    - [CityLevel](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants/CityLevel.java) - level of city depend on current population 
    - [DatabaseColumns](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants/DatabaseColumns.java) - all column inside database
    - [LightBulb](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants/LightBulb.java) - Enum of light open
    - [LogConstants](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants/LogConstants.java) - constants of log information
    - [TableName](app/src/main/java/com/softspec/finalproj/gameofearth/api/constants/TableName.java) - database table name
2. [database](app/src/main/java/com/softspec/finalproj/gameofearth/api/database)
    - [Creator](app/src/main/java/com/softspec/finalproj/gameofearth/api/database/Creator.java) - Creator to create data inside database (use creator [model](#model))
3. [data structure](app/src/main/java/com/softspec/finalproj/gameofearth/api/datastructure)
    - [Percent](app/src/main/java/com/softspec/finalproj/gameofearth/api/datastructure/Percent.java) - Percent data in program
    - [Progress](app/src/main/java/com/softspec/finalproj/gameofearth/api/datastructure/Progress.java) - Progress of create data in database
    - [Showable](app/src/main/java/com/softspec/finalproj/gameofearth/api/datastructure/Showable.java) - Interface of dialog
4. [management](app/src/main/java/com/softspec/finalproj/gameofearth/api/management)
    - [CityLoader](app/src/main/java/com/softspec/finalproj/gameofearth/api/management/CityLoader.java) - city api for change picture of city
    - [DatabaseManagement](app/src/main/java/com/softspec/finalproj/gameofearth/api/management/DatabaseManagement.java) - create and get randomly question
    - [ImageManagement](app/src/main/java/com/softspec/finalproj/gameofearth/api/management/ImageManagement.java) - image api of work with all image in program
    - [Leader](app/src/main/java/com/softspec/finalproj/gameofearth/api/management/Leader.java) - leader (3 person in bottom of game) management
5. [ui dialog](app/src/main/java/com/softspec/finalproj/gameofearth/api/uidialog)
    - [QuestionDialog](app/src/main/java/com/softspec/finalproj/gameofearth/api/uidialog/QuestionDialog.java) - show question if at time
    - [ResultDialog](app/src/main/java/com/softspec/finalproj/gameofearth/api/uidialog/ResultDialog.java) - show result of the question

## MODEL
1. [database](app/src/main/java/com/softspec/finalproj/gameofearth/model/database)
    - [Database](app/src/main/java/com/softspec/finalproj/gameofearth/model/database/Database.java) - Main database
    - [DatabaseQuery](app/src/main/java/com/softspec/finalproj/gameofearth/model/database/DatabaseQuery.java) - query of database
    - [DatabaseSavable](app/src/main/java/com/softspec/finalproj/gameofearth/model/database/DatabaseSavable.java) - interface of object that can save into database
2. [creator](app/src/main/java/com/softspec/finalproj/gameofearth/model/creator)
    - [Creator](app/src/main/java/com/softspec/finalproj/gameofearth/model/creator/Creator.java) - interface of data creator in database
3. [game](app/src/main/java/com/softspec/finalproj/gameofearth/model/game)
    - [GameLogic](app/src/main/java/com/softspec/finalproj/gameofearth/model/game/GameLogic.java) - all logic of the game
4. [question](app/src/main/java/com/softspec/finalproj/gameofearth/model/question)
    - [Question](app/src/main/java/com/softspec/finalproj/gameofearth/model/question/Question.java) - object of question that use inside this game
    - [QuestionCreator](app/src/main/java/com/softspec/finalproj/gameofearth/model/question/QuestionCreator.java) - creator of question to create question inside database
5. [resource](app/src/main/java/com/softspec/finalproj/gameofearth/model/resource)
    - [AcceptCreator](app/src/main/java/com/softspec/finalproj/gameofearth/model/resource/AcceptCreator.java) - creator accept resource (use when player accept the policy)
    - [DenyCreator](app/src/main/java/com/softspec/finalproj/gameofearth/model/resource/DenyCreator.java) - creator deny resource (use when player deny the policy)
    - [NullResource](app/src/main/java/com/softspec/finalproj/gameofearth/model/resource/NullResource.java) - null object of resource if question don't have result
    - [Resource](app/src/main/java/com/softspec/finalproj/gameofearth/model/resource/Resource.java) - object of resource that use inside this game
6. [strategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy)
    - [CityStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/CityStrategy.java) - city convert image strategy
    - [DefaultCityStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/DefaultCityStrategy.java) - default city conversion
    - [CO2Strategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/CO2Strategy.java) - co2 calculation strategy
    - [DefaultCO2Strategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/DefaultCO2Strategy.java) - default co2 calculation
    - [GameStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/GameStrategy.java) - game information strategy
    - [DefaultGameStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/DefaultGameStrategy.java) - default game information  
    - [PopulationStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/PopulationStrategy.java) - population calculation strategy
    - [DefaultPopulationStrategy](app/src/main/java/com/softspec/finalproj/gameofearth/model/strategy/DefaultPopulationStrategy.java) - default population calculation
    
## VIEW
1. [view](app/src/main/java/com/softspec/finalproj/gameofearth/view)
    - [FullScreenActivity](app/src/main/java/com/softspec/finalproj/gameofearth/view/FullScreenActivity.java) - since game should run fullscreen so this created to be super class of all game activity
    - [LoadedProgressActivity](app/src/main/java/com/softspec/finalproj/gameofearth/view/LoadedProgressActivity.java) - Loading progress for create database if not exist
    - [StartActivity](app/src/main/java/com/softspec/finalproj/gameofearth/view/StartActivity.java) - start page (contains start button)
    - [MainActivity](app/src/main/java/com/softspec/finalproj/gameofearth/view/MainActivity.java) - main page (game page)
    - [EndActivity](app/src/main/java/com/softspec/finalproj/gameofearth/view/EndActivity.java) - end page (contains highest score)

----------------------------------------------------------------------------------------