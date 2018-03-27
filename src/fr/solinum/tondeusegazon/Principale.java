package fr.solinum.tondeusegazon;

import java.io.BufferedReader;//<= pour lire les lignes
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;//prend des bytes et encode vers des caracteres

public class Principale {

	public static void recupererDonnesFichier() {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(new File("piloter.txt"));
			InputStreamReader fileReader = new InputStreamReader(fileInput);// <= on a lui dit qu'on va lire ce fichier
			BufferedReader lineReader = new BufferedReader(fileReader);
			String fileLine = lineReader.readLine();

			int positionPelouseX = Character.getNumericValue(fileLine.charAt(0));
			int positionPelouseY = Character.getNumericValue(fileLine.charAt(2));

			Pelouse pelouse1 = new Pelouse(positionPelouseX, positionPelouseY);
			Tondeuse tondeuse1 = new Tondeuse();
			String positionTondeuse = "";
			String mouvementTondeuse = "";
			while (fileLine != null) {// <= on est pas encore arriver a la fin de fichier
				fileLine = lineReader.readLine();// sauter une ligne
				String positionTondeuseX = Character.toString(fileLine.charAt(0));
				String positionTondeuseY = Character.toString(fileLine.charAt(2));
				String orientationTondeuse = Character.toString(fileLine.charAt(4));
				positionTondeuse = positionTondeuseX + positionTondeuseY + orientationTondeuse;
				//System.out.println(positionTondeuse);
				fileLine = lineReader.readLine();
				if (fileLine != null) {
					mouvementTondeuse = lineReader.readLine();
				}
				tondeuse1.deplacer(positionTondeuse, mouvementTondeuse);
			}
		}catch (IOException ioE) {
			System.out.println("Impossible d'ouvrir le fichier");
			}
	}

	public static void main(String args[]) {

		recupererDonnesFichier();
	}
}
