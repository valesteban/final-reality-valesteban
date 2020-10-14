Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

**The rest of the documentation is left for the users of this template to complete**

En cuanto al diseno de la jerarquia para las armas se creó una clase diferente para cada tipo diferente de arma, las cuales heredan de una clase abtracta AbstractWeapon la cual contiene todos los metodos que comparten, esta implementa una interface IWeapon, esto con el fin de al momento de crear y ocupar  los test y/o metodos  y  quisiesemos referirnos a algo comun entre todas las armas. En este mismo contexto la unica clase con variables y metodos nuevos fue la clase Staff a la debido a su mayor especialización.

Continuando con la jerarquia para los jugadores y enemigos se comenzo con una interfas implementada por la clase abstracta AbstracCharacter la cual contine todo aquello que tanto los enemigos como los personajes comparten para luego seguir con dos subclases; La primera Enemy -con mas metodos y variables e implementacion de metodos abstractos- y la segunda AbstractPlayer la cual consiste en una clase abstracta que ademas implementa una interfas , esta clase contiene variables especificas de todos los player y sus metodos compartidos la cual finalmente tendria como subclases todos los diferentes tipos de player a excepcion de los players con magia para los cuales se creo un asubclase mas para sus variables y geters.  Se creó la interfas ya que el conjunto de players serian ocupados en su conjunto para metodos como en el caso de los test o al momento de equiparlos con armas.


Para la entrega 1 se dió por hecho que en el futuro tendremos que implementar de diferente manera el metodo equip() perteneciente a la clase abtracta AbstractPlayer,  es por esto que se creó en especifico un aclase abstracta la cual no contiene metodos abstractos. Tambien se dejó la variable type de tanto weapons como de characters con el pensamiento de que en el futuro se ocuparan (no son ocupadas). 

En cuanto  a los test comenzando con las armas,  no se creó una jerarquia y se fue probando cada clase independientemente, Por otro lado para los test de los character se probaron tambien de forma independiente los constructores de cada clase y los metodos de las clases probados con algunos objetos (no todos).
