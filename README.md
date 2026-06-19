# Orb Mover

### Reposition the minimap orbs within the orb parent widget using coordinates

![Orb Mover demo](https://github.com/user-attachments/assets/c5907d71-1e43-42be-b520-34206ecd8032)

| **Settings**    | **Description**                                           |
|-----------------|-----------------------------------------------------------|
| Custom position | Enables the custom position to the orb.                   |
| Horizontal      | The horizontal position. Increased value moves orb right. |
| Vertical        | The vertical position. Increased value moves orb up.      |

| **Supported orbs** | 
|--------------------|
| Hitpoints          |
| Prayer             |
| Run energy         |
| Special attacks    |
| Store              |
| Activity Adviser   |
| Wiki               |
| World map          |
| XP drops           |


## Features


- Reposition each minimap orb independently.
- Per-element enable toggle.
- Horizontal and vertical position set via coordinates.
- Disabling an element (or the whole plugin) returns it to its original position.
- Supported across all three game client layouts. 

## How to use


1. Expand the section for the orb you want to move.
2. Tick Custom position to take control of that element.
3. Adjust the horizontal and vertical positions until satisfied.

## Note


- Positions are relative to the orb parent widget and therefore bounded by it.
- Switching between game client layouts may require re-adjustments.
- The vertical coordinates are inverted for a more intuitive user experience.
- coordinates (0, 0) corresponds to the bottom left corner of the orb parent widget and may be moved up and right from there.
