package fr.solinum.tondeusegazon;

public class Tondeuse {

	private int positionX;
	private int positionY;
	private int orientation;

	public int getPositionX() {
		return this.positionX;
	}

	public int getPositionY() {
		return this.positionY;
	}

	public int getOrientation() {
		return this.orientation;
	}

	public void deplacer(String positionInitial,String ordreMouvement) {
		
		char directionTendeuse;
		this.positionX=Character.getNumericValue(positionInitial.charAt(0));//test
		System.out.println(this.positionX);
		this.positionY=Character.getNumericValue(positionInitial.charAt(1));
		directionTendeuse=positionInitial.charAt(2);
		
		int i=0;
		char ordre;
		while (i < ordreMouvement.length()) {
			ordre=ordreMouvement.charAt(i);
			if(ordre!=' ') {
				if (directionTendeuse == 'n') {
					if (ordre == 'a') {
						this.positionY++;
					} else if (ordre == 'g') {
						directionTendeuse = 'w';
					} else if (ordre == 'd') {
						directionTendeuse = 'e';
					}
				} else if (directionTendeuse == 'e') {
					if (ordre == 'a') {
						this.positionX++;
					} else if (ordre == 'g') {
						directionTendeuse = 'n';
					} else if (ordre == 'd') {
						directionTendeuse = 's';
					}
				} else if (directionTendeuse == 's') {
					if (ordre == 'a') {
						this.positionY--;
					} else if (ordre == 'g') {
						directionTendeuse = 'e';
					} else if (ordre == 'd') {
						directionTendeuse = 'w';
					}
				} else if (directionTendeuse == 'w') {
					if (ordre == 'a') {
						this.positionX--;
					} else if (ordre == 'g') {
						directionTendeuse = 's';
					} else if (ordre == 'd') {
						directionTendeuse = 'n';
					}
				}	
			}
			i++;
		}
		String orientationAfficher="";
		if (directionTendeuse == 'n') {
			orientationAfficher = "Nord";
		} else if (directionTendeuse == 'e') {
			orientationAfficher = "Est";
		} else if (directionTendeuse == 's') {
			orientationAfficher = "Sud";
		} else if (directionTendeuse == 'o'){
			orientationAfficher = "Ouest";
		}
		System.out.println("La nouvelle position de la tondeuse est : X= " + this.positionX + ",Y= " + this.positionY
				+ " ,et l'orientation est : " + orientationAfficher);
	}
}
