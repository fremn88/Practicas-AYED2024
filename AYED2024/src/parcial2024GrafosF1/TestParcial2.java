package parcial2024GrafosF1;

import tp5.ej1.GraphAdjList;

public class TestParcial2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				GraphAdjList<Recinto> grafo1 = new GraphAdjList<Recinto>();
				
				Recinto entrada = new Recinto(15,"entrada");
				Recinto cebras = new Recinto(10,"cebras");
				Recinto flamencos = new Recinto(10,"flamencos");
				Recinto tigres = new Recinto(10,"tigres");
				Recinto tortugas = new Recinto(10,"tortugas");
				Recinto pumas = new Recinto(10,"pumas");
				Recinto wallabies = new Recinto(30,"wallabies");
				Recinto murcielagos = new Recinto(20,"murcielagos");
				
				grafo1.createVertex(entrada);
				grafo1.createVertex(cebras);
				grafo1.createVertex(flamencos);
				grafo1.createVertex(tigres);
				grafo1.createVertex(tortugas);
				grafo1.createVertex(pumas);
				grafo1.createVertex(wallabies);
				grafo1.createVertex(murcielagos);

				grafo1.connect(grafo1.search(entrada), grafo1.search(cebras), 10);
				grafo1.connect(grafo1.search(entrada), grafo1.search(tigres), 15);
				grafo1.connect(grafo1.search(entrada), grafo1.search(murcielagos), 20);
				grafo1.connect(grafo1.search(entrada), grafo1.search(flamencos), 25);
				grafo1.connect(grafo1.search(cebras), grafo1.search(tigres), 8);
				grafo1.connect(grafo1.search(cebras), grafo1.search(tortugas), 5);
				grafo1.connect(grafo1.search(flamencos), grafo1.search(entrada), 25);
				grafo1.connect(grafo1.search(flamencos), grafo1.search(murcielagos), 25);
				grafo1.connect(grafo1.search(tigres), grafo1.search(entrada), 15);
				grafo1.connect(grafo1.search(tigres), grafo1.search(cebras), 8);
				grafo1.connect(grafo1.search(tortugas), grafo1.search(cebras), 5);
				grafo1.connect(grafo1.search(tortugas), grafo1.search(pumas), 15);
				grafo1.connect(grafo1.search(tortugas), grafo1.search(wallabies), 10);
				grafo1.connect(grafo1.search(wallabies), grafo1.search(tortugas), 10);
				grafo1.connect(grafo1.search(wallabies), grafo1.search(murcielagos), 10);
				grafo1.connect(grafo1.search(wallabies), grafo1.search(pumas), 2);
				grafo1.connect(grafo1.search(murcielagos), grafo1.search(wallabies), 10);
				grafo1.connect(grafo1.search(murcielagos), grafo1.search(flamencos), 25);
				grafo1.connect(grafo1.search(murcielagos), grafo1.search(entrada), 20);
				grafo1.connect(grafo1.search(pumas), grafo1.search(tortugas), 15);
				grafo1.connect(grafo1.search(pumas), grafo1.search(wallabies), 2);
				
				System.out.println(Parcial2.resolver(grafo1, 100));
	}

}
