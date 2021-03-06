package informatique

import general.Arete
import general.Graphe
import general.Sommet

class Noed extends Sommet {
  
	def this(x: String, y: String) {
		this()
		this.x=x;
		this.y=y;
		System.out.println("Creation lien ok")
	}
  
	def this(graphe: Reseau, x: String, y: String) {
		this()
		this.graphe = graphe
		this.x = x
		this.y = y
	}

	@Override override def addAretes(arete: Arete) {
		if (arete.isInstanceOf[Lien]) {
			ensembleAretes.add(arete)
			System.out.println("ajout du lien ok")
		}
		else {
			System.err.println("L'arrete n'est pas isntance de Lien")
		}
	}

	@Override override def addAretes(arete: Arete, sommet: Sommet) {
		if (arete.isInstanceOf[Lien] && sommet.isInstanceOf[Noed]) {
			if (graphe != null && graphe == sommet.graphe) {
				System.out.println("vérification des graphes ok dans addArretes")
				if ((arete.sommet1 != this && arete.sommet2 != sommet) && ((arete.sommet1 != sommet && arete.sommet2 != this))) {
					arete.removeFromSommets
					arete.sommet1 = this
					if (sommet != null) {
						arete.sommet2 = sommet
					}
					ensembleAretes.add(arete)
				}
				else {
					System.out.println("L'arete se trouve déjà entre les deux sommets")
				}
			}
			else {
				System.out.println("Veuillez vérifier le graphe de l'arete et des sommets")
			}
    }
    else {
      System.out.println("Problème d'instance dans addarete(arrete,sommet) dans Atome")
    }
  }
	
	@Override override def setGraphe(graphe: Graphe) {
		if(graphe.isInstanceOf[Reseau]){
			this.graphe = graphe;
		}
		else
		{
			System.err.println("Graphe n'est pas instance de Molecule");
		}
	}
}