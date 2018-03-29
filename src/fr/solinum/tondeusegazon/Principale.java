package fr.solinum.tondeusegazon;

import java.io.BufferedReader;//<= pour lire les lignes
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;//prend des bytes et encode vers des caracteres
import java.util.IllegalFormatException;

public class Principale {
	public static void recupererDonnesFichier() throws IOException {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(new File("piloter.txt"));
			InputStreamReader fileReader = new InputStreamReader(fileInput);
			BufferedReader lineReader = new BufferedReader(fileReader);

			if (fileInput.available() == 0) {
				throw new NullPointerException("Le fichier est vide");
			}

			String fileLine = lineReader.readLine();
			while (fileLine.equals("")) {// test si les premiers lignes sont vide
				fileLine = lineReader.readLine();
			}
			int taillePositionPelouse = fileLine.length();
			if (taillePositionPelouse != 3) {
				throw new IllegalArgumentException("Saisie invalide");
			}

			int positionPelouseX = Character.getNumericValue(fileLine.charAt(0));
			int positionPelouseY = Character.getNumericValue(fileLine.charAt(2));

			Pelouse pelouse1 = new Pelouse(positionPelouseX, positionPelouseY);
			fileLine = lineReader.readLine();// sauter une ligne
			while(fileLine.equals("")){// test si la deuxieme ligne apres la position de pelouse est vide
				fileLine = lineReader.readLine();
			}
			Tondeuse tondeuse1 = new Tondeuse();

			String positionTondeuse = "";
			String mouvementTondeuse = "";
			while (fileLine != null) {// <= on est pas encore arriver a la fin de fichier
				
				int taillePositionTondeuse=fileLine.length();
				if(taillePositionTondeuse!=5) {
					throw new IllegalArgumentException("la position de tondeuse est invalide");
				}
				String positionTondeuseX = Character.toString(fileLine.charAt(0));
				String positionTondeuseY = Character.toString(fileLine.charAt(2));
				
				try {
					int	x=Integer.decode(positionTondeuseX);
					int y=Integer.decode(positionTondeuseY);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("La position doit etre un entier");
					break;
				}
				String orientationTondeuse = Character.toString(fileLine.charAt(4));
				positionTondeuse = positionTondeuseX + positionTondeuseY + orientationTondeuse;
				
				
				mouvementTondeuse = lineReader.readLine();
				
				tondeuse1.deplacer(positionTondeuse, mouvementTondeuse);

				fileLine = lineReader.readLine();
			}
		} catch (IOException ioE) {
			System.out.println("Impossible d'ouvrir le fichier");
		} finally {
			fileInput.close();
		}
	}

	public static void main(String args[]) {

		try {
			recupererDonnesFichier();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
