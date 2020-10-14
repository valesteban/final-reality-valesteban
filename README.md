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

En cuanto al diseño de la jerarquía para las armas se creó una clase diferente para cada tipo diferente de arma, las cuales heredan de una clase abstracta AbstractWeapon la cual contiene todos los métodos que comparten, esta implementa una interface IWeapon, esto con el fin de al momento de crear y ocupar  los test y/o métodos  y  quisiésemos referirnos a algo común entre todas las armas. En este mismo contexto la única clase con variables y métodos nuevos fue la clase Staff a la debido a su mayor especialización.

Continuando con la jerarquía para los jugadores y enemigos se comenzó con una interfaz implementada por la clase abstracta AbstracCharacter la cual contiene todo aquello que tanto los enemigos como los personajes comparten para luego seguir con dos subclases; La primera Enemy -con más métodos y variables e implementación de métodos abstractos- y la segunda AbstractPlayer la cual consiste en una clase abstracta que además implementa una interfaz , esta clase contiene variables específicas de todos los player y sus métodos compartidos la cual finalmente tendría como subclases todos los diferentes tipos de player a excepción de los players con magia para los cuales se creó una subclase mas para sus variables y geters.  Se creó la interfaz ya que el conjunto de players serian ocupados en su conjunto para métodos como en el caso de los test o al momento de equiparlos con armas.


Para la entrega 1 se dio por hecho que en el futuro tendremos que implementar de diferente manera el método equip() perteneciente a la clase abstracta AbstractPlayer,  es por esto que se creó en especifico un aclase abstracta la cual no contiene métodos abstractos. también se dejó la variable type de tanto weapons como de characters con el pensamiento de que en el futuro se ocuparan (no son ocupadas). 

En cuanto a los test comenzando con las armas,  no se creó una jerarquía y se fue probando cada clase independientemente, Por otro lado para los test de los character se probaron también de forma independiente los constructores de cada clase y los métodos de las clases probados con algunos objetos (no todos).
