Hacer una batalla en una fortaleza de unos personajes (magos, guerreros, etc) contra un jefe final.

Cada personaje sera un hilo que irá a atacar al jefe a la fortaleza. Solo un personaje podra entrar 
a la vez a la fortaleza a atacar al jefe, ambos se atacaran hasta que muera el personaje o 
muera el jefe. El jefe es especialmente duro por lo que costará matarle. 
En caso de que el personaje muera, el siguiente personaje entrara en la fortaleza 
para intentar derrotarle.

En caso de que el jefe muera, el campeon sera vitoreado y aclamado por su publico y el 
resto de los personajes que queden por combatir ya no podran hacerlo.

Para la implementacion se pedira que se lancen los hilos personajes a la vez y que entren en 
la fortaleza a matar al jefe final, pero solamente uno podrá entrar en la fortaleza al mismo 
tiempo, por lo que se debe sincronizar el objeto fortaleza para que solo un personaje 
pueda entrar a la vez.

NOTAS:
Se ha modificado el codigo para que el turno vaya aumentando.
Se ha modificado el método estaMuerto de tal manera que si la vida del personaje es <= 0 se muestre 0 (más estético)
Se ha utilizando LAMBDAS para recorrer el Array