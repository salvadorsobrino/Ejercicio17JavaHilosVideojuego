package es.videojuego.modelo.negocio;

import es.videojuego.modelo.entidad.Personaje;

public class Fortaleza {
	private String nombre;
	private Personaje jefe; //Jefe (pudiendo ser Mago,Guerrero o Hechizero)
	private Personaje campeon;
	


	/** Metodo synchronized que asegura el acceso unico al recurso en este caso "Personaje Jefe" al
	 * cual se le ir? restando vida 
	 * @param personaje le restar? vida al Personaje Jefe
	 */
	public synchronized void entrar(Personaje personaje) { 
		if (jefe.getVida()>0) {
			System.out.println(personaje.getNombre() +" entr? en la Fortaleza " + this.nombre +" y luchar? contra "+jefe.getNombre());
			Batalla batalla = new Batalla();
			batalla.setP1(jefe);
			batalla.setP2(personaje);
			Personaje pGanador = batalla.combatir();
			System.out.println(pGanador +" sali? victorioso");
			if(jefe.getVida()<=0) {
				campeon = pGanador;
			} else {
				System.out.println("?Qui?n podr? derrotar a "+jefe.getNombre()+"?");
			}
		} else {
			System.out.println(personaje.getNombre() + " aclama al victorioso "+campeon.getNombre());
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Personaje getJefe() {
		return jefe;
	}

	public void setJefe(Personaje jefe) {
		this.jefe = jefe;
	}

	public Personaje getCampeon() {
		return campeon;
	}

	public void setCampeon(Personaje campeon) {
		this.campeon = campeon;
	}
}
