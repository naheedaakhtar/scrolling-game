# scrollinggame_java
Game Description:
This game is called Christmas Hunter. The goal is to collect as many presents and snowflakes as possible to increase
your points. The presents increase your special shots, which do more damage to the santa. You want to collect them. However, you want to avoid the grinch.
Once you collect 200 points, a villian will appear - santa. You want to reduce santa's hp to 0 while continuing to collect points
and you do this by pressing 'T' which will throw an ornament at the santa. The santa will move throughout the game. 

Custom features and mechanics:
The creation of a santa entity was needed to create the boss level. This required spawning, checking collisions, and moving 
the entity as I would any other entity. However, since the santa appears on the other end of the screen - this meant that I 
had to think of things backwards. For example, when I want the entities to be thrown - I want it to move towards the santa 
which meant that the way I move the thrown object is a different from how the other entities scroll across the screen.
 
 To create the special points, I created a counter that increased when you collide with a present
 then you are able to throw the special points as long as your collection of special throws is greater than 0.
 This involved creating a new Throwable (created interface) class that accomplishes this.

Win and Lose Conditions:
To win the game you need to achieve 300 points and reduce santa's hp to 0. This means you must keep collecting and throwing things
at the Santa until it dissapears from the screen. 
To lose the game it means the player hp is reduced to 0 before the win conditions are met. 

Image Sources:

Background Image:
https://www.istockphoto.com/illustrations/pixel-art-christmas

Avoid Entity (Grinch):
http://pixelartmaker.com/art/33d0f23b0552e9e

Get Entity (Tree):
https://www.freepik.com/premium-vector/pixel-art-christmas-tree-with-star-baubles-vector-icon-8bit-game-white-background_32924202.htm

Special Collection Entity (Present):
https://www.freepik.com/premium-vector/pixel-art-christmas-birthday-gift-red-gold-box-bit-game-item-white-background_11398536.htm

Special Ornament Throw (Heart):
https://www.seekpng.com/ipng/u2t4i1u2e6o0a9a9_sky-blue-heart-pixel-christmas-ornaments-pixel-art/

Regular Ornament Throw (Red Ornament):
https://shop11120.golbasiaydinkoleji.com/content?c=bola%20de%20navidad%20animada&id=40

Santa Entity:
https://pngtree.com/freepng/santa-claus-holding-a-gift-pixelated-design-with-commercial-elements_4036230.html

Player Entity:
https://www.shutterstock.com/image-vector/pixel-art-elf-plastic-parts-cute-1232926510
