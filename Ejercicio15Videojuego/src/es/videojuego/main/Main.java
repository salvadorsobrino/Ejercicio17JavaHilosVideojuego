package es.videojuego.main;

import java.util.ArrayList;
import java.util.List;

import es.videojuego.modelo.entidad.Curandero;
import es.videojuego.modelo.entidad.Espada;
import es.videojuego.modelo.entidad.Guerrero;
import es.videojuego.modelo.entidad.Hechizo;
import es.videojuego.modelo.entidad.Mago;
import es.videojuego.modelo.entidad.Personaje;
import es.videojuego.modelo.entidad.Rezo;
import es.videojuego.modelo.negocio.Batalla;
import es.videojuego.modelo.negocio.Fortaleza;

public class Main {
	public static void main(String[] args) {
		
		Fortaleza f = new Fortaleza();
		f.setNombre("Castillo de Bran");
		
		
		Mago mago = new Mago();
		mago.setInteligencia(10);
		mago.setNombre("Gandalf");
		mago.setVida(500);
		//le asignamos al personaje una fortaleza
		mago.setFortaleza(f);
		
		Hechizo bolaDeFuego = new Hechizo();
		bolaDeFuego.setDanioMinimo(10);
		bolaDeFuego.setDanioMaximo(20);
		bolaDeFuego.setPorcentajeCritico(20);
		bolaDeFuego.setPoderHechizo(10);
		
		//ahora viene la bidireccionalidad
		mago.setArma(bolaDeFuego);
		bolaDeFuego.setPersonaje(mago);
		
		Curandero cu = new Curandero();
		cu.setNombre("Saruman");
		cu.setSabiduria(10);
		cu.setVida(500);
		//le asignamos al personaje una fortaleza
		cu.setFortaleza(f);
		
		Rezo rezo = new Rezo();
		rezo.setDanioMaximo(20);
		rezo.setDanioMinimo(10);
		rezo.setPorcentajeCritico(20);
		rezo.setPoderCuracion(10);
		
		//ahora viene la bidireccionalidad
		cu.setArma(rezo);
		rezo.setPersonaje(cu);
		
		Guerrero guerrero = new Guerrero();
		guerrero.setFuerza(40);
		guerrero.setNombre("Rey Arturo");
		guerrero.setVida(500);
		//le asignamos al personaje una fortaleza
		guerrero.setFortaleza(f);
		
		Espada excalibur = new Espada();
		excalibur.setDanioMinimo(10);
		excalibur.setDanioMaximo(20);
		excalibur.setPorcentajeCritico(20);
		
		//ahora viene la bidireccionalidad
		guerrero.setArma(excalibur);
		excalibur.setPersonaje(guerrero);
		
		Guerrero jefe = new Guerrero();
		jefe.setFuerza(20);
		jefe.setNombre("Bran");
		jefe.setVida(1000);
		
		Espada excaliburOscura = new Espada();
		excaliburOscura.setDanioMinimo(10);
		excaliburOscura.setDanioMaximo(30);
		excaliburOscura.setPorcentajeCritico(25);
		
		//ahora viene la bidireccionalidad
		jefe.setArma(excaliburOscura);
		excaliburOscura.setPersonaje(jefe);
		
		//asignamos a la fortaleza el jefe
		f.setJefe(jefe);
		
		Thread t1 = new Thread(mago);
		Thread t2 = new Thread(cu);
		Thread t3 = new Thread(guerrero);
		
		mago = new Mago();
		mago.setInteligencia(20);
		mago.setNombre("Harry Potter");
		mago.setVida(500);
		//le asignamos al personaje una fortaleza
		mago.setFortaleza(f);
		
		Hechizo avadaKedavra = new Hechizo();
		bolaDeFuego.setDanioMinimo(10);
		bolaDeFuego.setDanioMaximo(30);
		bolaDeFuego.setPorcentajeCritico(20);
		bolaDeFuego.setPoderHechizo(10);
		
		//ahora viene la bidireccionalidad
		mago.setArma(avadaKedavra);
		avadaKedavra.setPersonaje(mago);
		
		Thread t4 = new Thread(mago);
		
		mago = new Mago();
		mago.setInteligencia(20);
		mago.setNombre("Lord Voldemort");
		mago.setVida(500);
		//le asignamos al personaje una fortaleza
		mago.setFortaleza(f);
		
		//ahora viene la bidireccionalidad
		mago.setArma(avadaKedavra);
		avadaKedavra.setPersonaje(mago);
		
		Thread t5 = new Thread(mago);
		
		
		List<Thread> listaPersonajes= new ArrayList<>();
		listaPersonajes.add(t1);
		listaPersonajes.add(t2);
		listaPersonajes.add(t3);
		listaPersonajes.add(t4);
		listaPersonajes.add(t5);

		
		//Utilizando LAMBDAS
		listaPersonajes.forEach(p -> {
			p.start();
		});

		
		/*Batalla batalla = new Batalla();
		batalla.setP1(mago);
		batalla.setP2(cu);
		
		Personaje pGanador = batalla.combatir();
		//pGanador.addNivel(1);
		System.out.println("El ganador de la arena es!!!!!: " + pGanador);*/
		
		
	}
}
