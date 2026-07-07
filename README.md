# Legends of the Arena

A turn-based fantasy combat game written in Java that demonstrates object-oriented programming principles through strategic battles, unique character abilities, consumable items, enemy AI, and game state management.

---

## Overview

**Legends of the Arena** is an enhanced version of a class project originally designed to practice Abstract Data Types (ADTs) and object-oriented programming. The project expands the original game with new playable characters, enemies, items, combat mechanics, a scoring system, and a multi-round battle structure.

Players choose a hero and fight through two rounds of combat against randomly selected enemies while managing health, abilities, and consumable items.

---

## Features

### Heroes

* **Wizard**

  * Basic Attack
  * Heal Spell
  * Undo Spell (reverts the previous game state)
  * Mana Burst (sacrifices health to deal double damage)
  * Item usage

* **Knight**

  * Basic Attack
  * Block (reduces incoming damage)
  * Shield Bash (damages and stuns the enemy)
  * Charge Attack (stores power for a stronger attack next turn)
  * Item usage

### Enemies

* **Dragon**

  * High health and powerful attacks
  * More aggressive attack patterns as health decreases

* **Skeleton**

  * Lower health than the Dragon
  * Fast attacks and life-draining abilities

### Item System

* Heal Potion
* Strength Potion (3× damage for three turns)
* Weakness Potion (reduces enemy damage for three turns)

### Additional Gameplay

* Two-round battle system
* Random enemy order
* Random potion rewards
* Undo functionality using a stack-based game state system
* Turn-based combat
* Final score based on battle performance

---

## Object-Oriented Concepts Used

This project was designed to reinforce several core Java and software engineering concepts, including:

* Inheritance
* Polymorphism
* Abstract classes
* Interfaces
* Encapsulation
* Composition
* ADTs (Stack)
* Basic enemy AI
* Game state management

---

## Project Structure

```text
src/
│
├── AIControlledEnhanced.java
├── CombatEntityEnhanced.java
├── DragonEnhanced.java
├── GameStackEnhanced.java
├── GameStateEnhanced.java
├── HealPotion.java
├── Item.java
├── Knight.java
├── MyDriver.java
├── PlayerControlledEnhanced.java
├── Skeleton.java
├── StrengthPotion.java
├── WeaknessPotion.java
└── WizardEnhanced.java
```

---

## How to Run

1. Clone this repository.
2. Compile all Java source files.
3. Run `MyDriver.java`.
4. Follow the prompts to select your hero and battle your opponents.

---

## Gameplay

1. Select either the Wizard or Knight.
2. Receive a random potion.
3. Battle the first randomly selected enemy.
4. If victorious, receive another potion and continue into the second battle.
5. Defeat both enemies to earn the highest possible score.

---

## Future Improvements

Possible future additions include:

* Graphical interface using Java Swing or JavaFX
* More heroes and enemy types
* Inventory system with multiple items
* Equipment and armor
* Save/load functionality
* Difficulty settings
* Better enemy AI
* Experience and leveling system
* Multiplayer support

---

## What I Learned

This project strengthened my understanding of object-oriented programming by requiring multiple interacting classes, interfaces, inheritance hierarchies, and abstract classes. It also provided experience implementing gameplay mechanics such as status effects, temporary buffs, game state management using stacks, and turn-based combat logic.

---


