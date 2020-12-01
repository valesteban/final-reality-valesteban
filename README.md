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

Comenzando con la entrega parcial 3 de armar y atacar para ambos casos se ocupó double distpach, Primero para armar a 
los player se hizo que cada arma supiese a quien podía y a quien no podía armar, para el caso en donde un arma no podía 
armar a un personaje, este quedaba con una equippedWeapon = nunll. Continuando para el caso de atacar se creó el método 
attack que recibe a un ICharacter el cual sería al que se atacaria, dentro de este método se  puso el método de el 
ICharacer que sería atacado, este dependiendo de quien fuese el atacante tendría los métodos isAttackedbyEnemy o 
isAttackedByPlayer que ahí le quitaría la vida correspondiente, en caso de que ya no le quedasen vidas , esto no 
afectaría porque se quedaría constantemente con vida 0 , pero si el atacante no tenía vida no se llevaría a cabo el 
ataque, de la misma forma que si el atacante fuese un player y no estuviese armado, otro caso es que si se mata a un personaje 
su arma pasa a ser null .
Este método permite que tanto 
enemigos y player puedan atacarse entre ellos (enemigos con enemigos o enemigos 
con player o players con players).


Luego para la implementación del controller, este contiene una lista de los enemigos, los players y el inventario, los 
cuales comienzan vacíos y con métodos en el controller creamos tanto personajes como enemigos, los agregamos a las listas
correspondientes y luego agregamos a el controller como un listener de estos objetos. Como tenemos a todos los character
dentro de una lista que es una variable de la clase, el controller puede acceder todos los atributos de estos. Para el 
caso del inventario se crearon a la lista , cabe destacar que se asumió que entre player se pueden usar la misma arma, 
ya que no las usan al mismo tiempo. 
En cuanto a métodos para equipar a player  y atacar entre characters, esto se ocuparon casi directamente ya que ya estaban implementados 
en las clases correspondientes.

Para el caso en que hubiese un ganador se llevó a cabo un patrón de diseño observer, en este caso se notificaría al controller 
(por medio del handle) cuando un character se hubiese muerto, esto haria que se llevase a cabo el método del controller 
void isAttackedCharacter(ICharacter character) que recibe al character que murió, en este método se verifica si el muerto corresponde 
un player o un enemigo, dependiendo de esto se prosigue a chequear la lista correspondiente y si todos están muertos el parámetros 
winnerEnemy o winnerPlayer se cambia a true y tenemos un ganador, en caso contrario no se hace nada.

Finalmente para el caso de los turnos  creamos un método en el controller llamado turnsC(), este toma al primer elemento de
la BlockingQueue verifica si este character está dentro de la lista de enemigos o player , en caso de ser enemy se elige un numero al azar 
entre 0 y el porte de la lista de players y se ataca al que este en esa posición (en el caso de que fuese un player no hacemos nada aun por la entrega)
luego se saca a este character de la BlockingQueue y ocupamos el método de Icharacter waitTurn() aqui dependiendo si es enemy o player 
esperara un tiempo determinado para luego ser agregado a la BlockingQueue.

