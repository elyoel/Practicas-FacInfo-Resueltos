package tp5.ejercicio4;

import tp5.listaAdy.*;

import java.util.ArrayList;
import java.util.List;

import tp5.*;

public class VisitaOsloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<String> bicisenda = new AdjListGraph<>();
		
		// Creación de los vértices
		Vertex<String> holmenkollen = bicisenda.createVertex("Holmenkollen");
		Vertex<String> parqueVigeland = bicisenda.createVertex("Parque Vigeland");
		Vertex<String> galeriaNacional = bicisenda.createVertex("Galería Nacional");
		Vertex<String> parqueBotanico = bicisenda.createVertex("Parque Botanico");
		Vertex<String> museoMunch = bicisenda.createVertex("Museo Munch");
		Vertex<String> folkMuseum = bicisenda.createVertex("FolkMuseum");
		Vertex<String> palacioReal = bicisenda.createVertex("Palacio Real");
		Vertex<String> ayuntamiento = bicisenda.createVertex("Ayuntamiento");
		Vertex<String> akkerBrigge = bicisenda.createVertex("Akker Brigge");
		Vertex<String> museoFram = bicisenda.createVertex("Museo Fram");
		Vertex<String> museoBarcoPolar = bicisenda.createVertex("Museo del Barco Polar");
		Vertex<String> museoVikingo = bicisenda.createVertex("Museo Vikingo");
		Vertex<String> elTigre = bicisenda.createVertex("El Tigre");
		Vertex<String> laOpera = bicisenda.createVertex("La Opera");
		Vertex<String> fortalezaAkershus = bicisenda.createVertex("Fortaleza Akershus");

		// Conexiones (Aristas) con sus respectivos pesos en minutos
		// Conexiones Bidireccionales (No dirigido) con pesos en minutos

		// Holmenkollen - Parque Vigeland
		bicisenda.connect(holmenkollen, parqueVigeland, 30);
		bicisenda.connect(parqueVigeland, holmenkollen, 30);

		// Parque Vigeland - Galería Nacional
		bicisenda.connect(parqueVigeland, galeriaNacional, 10);
		bicisenda.connect(galeriaNacional, parqueVigeland, 10);

		// Parque Vigeland - FolkMuseum
		bicisenda.connect(parqueVigeland, folkMuseum, 20);
		bicisenda.connect(folkMuseum, parqueVigeland, 20);

		// Galería Nacional - Parque Botánico
		bicisenda.connect(galeriaNacional, parqueBotanico, 15);
		bicisenda.connect(parqueBotanico, galeriaNacional, 15);

		// Parque Botánico - Ayuntamiento
		bicisenda.connect(parqueBotanico, ayuntamiento, 10);
		bicisenda.connect(ayuntamiento, parqueBotanico, 10);

		// Parque Botánico - Museo Munch
		bicisenda.connect(parqueBotanico, museoMunch, 1);
		bicisenda.connect(museoMunch, parqueBotanico, 1);

		// Ayuntamiento - Palacio Real
		bicisenda.connect(ayuntamiento, palacioReal, 5);
		bicisenda.connect(palacioReal, ayuntamiento, 5);

		// Ayuntamiento - Akker Brigge
		bicisenda.connect(ayuntamiento, akkerBrigge, 20);
		bicisenda.connect(akkerBrigge, ayuntamiento, 20);

		// Ayuntamiento - El Tigre
		bicisenda.connect(ayuntamiento, elTigre, 15);
		bicisenda.connect(elTigre, ayuntamiento, 15);

		// Palacio Real - FolkMuseum
		bicisenda.connect(palacioReal, folkMuseum, 5);
		bicisenda.connect(folkMuseum, palacioReal, 5);

		// FolkMuseum - Akker Brigge
		bicisenda.connect(folkMuseum, akkerBrigge, 30);
		bicisenda.connect(akkerBrigge, folkMuseum, 30);

		// FolkMuseum - Museo Fram
		bicisenda.connect(folkMuseum, museoFram, 5);
		bicisenda.connect(museoFram, folkMuseum, 5);

		// Museo Fram - Museo del Barco Polar
		bicisenda.connect(museoFram, museoBarcoPolar, 5);
		bicisenda.connect(museoBarcoPolar, museoFram, 5);

		// Museo del Barco Polar - Museo Vikingo
		bicisenda.connect(museoBarcoPolar, museoVikingo, 5);
		bicisenda.connect(museoVikingo, museoBarcoPolar, 5);

		// Museo Vikingo - Akker Brigge
		bicisenda.connect(museoVikingo, akkerBrigge, 30);
		bicisenda.connect(akkerBrigge, museoVikingo, 30);

		// Museo Munch - El Tigre
		bicisenda.connect(museoMunch, elTigre, 15);
		bicisenda.connect(elTigre, museoMunch, 15);

		// El Tigre - La Opera
		bicisenda.connect(elTigre, laOpera, 5);
		bicisenda.connect(laOpera, elTigre, 5);

		// La Opera - Fortaleza Akershus
		bicisenda.connect(laOpera, fortalezaAkershus, 10);
		bicisenda.connect(fortalezaAkershus, laOpera, 10);
		List<String> caminoProhibidos = new ArrayList<>();
		//caminoProhibidos.add("Akker Brigge");
		//caminoProhibidos.add("Palacio Real");
		caminoProhibidos.add("Parque Botanico");
		caminoProhibidos.add("FolkMuseum");
		System.out.println(VisitaOslo.paseoEnBici(bicisenda, "Museo Vikingo", 120, caminoProhibidos));
	}

}
