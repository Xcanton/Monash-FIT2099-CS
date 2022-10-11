# FIT2099 Assignment (Semester 2 - 2022) - Pokemon!

## XX_LabYYTeamZZ
*
*
*

Link to contribution logs spreadsheet: https://docs.google.com/spreadsheets/d/11aeIKppbeZUSxP_gKiK_iaR93w-Cf8F0TI1SMyKmes0/edit?usp=sharing

## Design Rationale

_Please write your design rationale below (along with UML diagram pictures)..._

REQ1:
All spawning grounds will extend the abstract class spawning ground which follows the DRY principle and allows the system to be modified in the future without changing existing code which follows the open-closed principle

REQ2:
This diagram represents an object oriented system which represents a rougelike game. It makes sense that the classes Charmander, Squirtle and Bulbasaur inherit the abstract class actor as they share similar attributes and so should be inherited. Furthermore, they will use enumeration to represent their individual typings. To simulate their intrinsic and special attacks, the class Intrinsic Weapon will simulate their instrinsic attacks while their special attacks may be simulated by the class WeaponItem.  

REQ3:
Main role:  
The main purpose of the **ConsumeAction** class is to provide the player with the ability to consume certain items. When an item is consumed, it will call the `addCapabilities()` method and the `addAffection()` method implemented from the **Magical** interface (which is further explained below). This allows any new capabilities and buffs to be applied appropriately to the player based on the item they consume. At the end of consumption, the item is removed from inventory.

Design Rationale:  
The ConsumeAction requires several attributes that have already been implemented via the Action class which determined the Action class to be a suitable parent class when designing the ConsumeAction class. Additionally, since the ConsumeAction class is an action and generally maintains the “meaning” of the parent class’s behaviour (being a performable action), the extension from the Action class adheres to good design principles, in particular with LSP (Liskov Substitution Principle).

Main role:  
The main purpose of the Magical interface implemented by candy and pokefruit which both extend the Items class, is to distinguish items that can be consumed and provide affection from regular Items that do not. The interface provides methods such as addAffection() which apply effects from the item once consumed.

The implementation of this interface follows the open-closed principle of the SOLID principles where the implementation of new consumable items that possess effects require no modification of the Item class or interface. This is due to the fact that the addAffection() method can be overridden when implementing the new Class to comply with the desired affects.

REQ4:
The UML diagram represents the affection system of the game. Each instance of Squirtle, Charmander and Bulbasaur will have an affection attribute while the game will have only 1 instance of the Affection Manager which is a class that is used to manage affection interactions such as decreasing or increasing affection.  

REQ5:
This diagram represents the system of time, the dependencies between time and items and terrain
change its propert at different times.
