package fr.solinum.tondeusegazon;

public class Tondeuse {

	private int positionX;
	private int positionY;
	private char orientation;

	public Tondeuse(int positionX, int positionY, char orientation) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.orientation = orientation;
	}

	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public char getOrientation() {
		return this.orientation;
	}

	public void deplacer(String mouvement) {

		char nouvelleOrientation = this.orientation;

		int i = 0;

		while (i < mouvement.length()) {
			if (nouvelleOrientation == 'n') {
				if (mouvement.charAt(i) == 'a') {
					this.positionY++;
				} else if (mouvement.charAt(i) == 'g') {
					nouvelleOrientation = 'w';
				} else if (mouvement.charAt(i) == 'd') {
					nouvelleOrientation = 'e';
				}
			} else if (nouvelleOrientation == 'e') {
				if (mouvement.charAt(i) == 'a') {
					this.positionX++;
				} else if (mouvement.charAt(i) == 'g') {
					nouvelleOrientation = 'n';
				} else if (mouvement.charAt(i) == 'd') {
					nouvelleOrientation = 's';
				}
			} else if (nouvelleOrientation == 's') {
				if (mouvement.charAt(i) == 'a') {
					this.positionY--;
				} else if (mouvement.charAt(i) == 'g') {
					nouvelleOrientation = 'e';
				} else if (mouvement.charAt(i) == 'd') {
					nouvelleOrientation = 'w';
				}
			} else if (nouvelleOrientation == 'w') {
				if (mouvement.charAt(i) == 'a') {
					this.positionX--;
				} else if (mouvement.charAt(i) == 'g') {
					nouvelleOrientation = 's';
				} else if (mouvement.charAt(i) == 'd') {
					nouvelleOrientation = 'n';
				}
			}
			i++;
		}
		String orientationAfficher;
		if (nouvelleOrientation == 'n') {
			orientationAfficher = "Nord";
		} else if (nouvelleOrientation == 'e') {
			orientationAfficher = "Est";
		} else if (nouvelleOrientation == 's') {
			orientationAfficher = "Sud";
		} else {
			orientationAfficher = "Ouest";
		}
		System.out.println("La nouvelle position de la tondeuse est : X= " + this.positionX + ",Y= " + this.positionY
				+ " ,et l'orientation est : " + orientationAfficher);
	}
}
