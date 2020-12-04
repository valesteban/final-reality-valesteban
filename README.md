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
attack que recibe a un ICharacter el cual sería al que se atacaría, dentro de este método se  puso el método de el 
characer que sería atacado, este dependiendo de quien fuese el atacante tendría los métodos isAttackedbyEnemy o 
isAttackedByPlayer que ahí le quitaría la vida correspondiente, en caso de que ya no le quedasen vidas , esto no 
afectaría porque se quedaría constantemente con vida 0 , pero si el atacante no tenía vida no se llevaría a cabo el 
ataque, de la misma forma que si el atacante fuese un player y no estuviese armado, otro caso es que si se mata a un personaje 
su arma pasa a ser null además de que un personajes sin vida (es decir muerto) no se le podría armas una arma.
El método attack permite que tanto enemigos y player puedan atacarse entre ellos (enemigos con enemigos o enemigos 
con player o players con players).

Luego para la implementación del controller, este contiene una lista de los enemigos, los players y el inventario, un handler, y dos variables que nos 
 permitirán consultar si alguien ganó (winnerPlayer y winnerEnemy) . En cuanto a las listas de enemigos y players estas comienzan 
 vacíos y con métodos en el controller creamos tanto personajes como enemigos, los agregamos a las listas
correspondientes y luego agregamos a el controller como un listener de estos objetos (realmente un handler). Como tenemos a todos los character
dentro de una lista que es una variable de la clase, el controller puede acceder todos los atributos de estos. Para el 
caso del inventario se creó una lista que al igual que la de player y enemigos parte vacía, y a medida que creamos objetos se van
 agregando a este inventario, cabe destacar que se asumió que el usuario no tratara de armar a  dos pllayer con una misma
arma. 
En cuanto a métodos para equipar a player  y atacar entre characters, esto se ocuparon casi directamente ya que ya estaban implementados 
en las clases correspondientes.

Para el caso en que hubiese un ganador se llevó a cabo un patrón de diseño observer, en este caso se notificaría al controller 
(por medio del handle) cuando un character se hubiese muerto, esto haría que se llevase a cabo el método del controller 
void isAttackedCharacter(ICharacter character) que recibe al character que murió, en este método se verifica si el muerto corresponde 
un player o un enemigo, dependiendo de esto se prosigue a chequear la lista correspondiente y si todos están muertos el parámetros 
winnerEnemy o winnerPlayer se cambia a true y tenemos un ganador, en caso contrario no se hace nada.

Finalmente para el caso de los turnos se crearon diferentes métodos para simular los pasos descritos en la sección 2.2 de la descripcion del proyecto
donde un primer método public void firstCharacterQueue() tomaría el primer elemento de la cola, luego verificaría si este character pertenece a la lista de 
player o a la de enemy, en caso de ser player no se haría nada (aun no debemos implementar la interacción con el usuario), pero en caso de ser enemigo
nos llevaría a un nuevo método   public void enemyTurn(ICharacter character) el cual elegiría un numero random entre 0 y el largo de la lista players 
para luego atacar a uno de los players. Luego tendríamos el método public void pullOutCharacter() que sacaría al primer character de la cola de turnos y 
luego el método public void timerCharacter(ICharacter character) que haría que este character espero el tiempo correspondiente para luego volver a ser 
agregado a la cola de turnos. Estos métodos no se juntaron ya que se dijo que en esta entrega se debían implementar cada uno de estos pasos independiente.

Otro punto importante a mencionar es que debido a la cantidad de creación de personajes muy parecido entre ellos al igual que armas, se pensaría en aplicar factory.
además en cuanto al handler se creó una interfaz pensando que un futuro se pondrían crear más handles en caso de que muriesen.
