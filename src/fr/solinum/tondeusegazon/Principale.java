package fr.solinum.tondeusegazon;

import java.io.BufferedReader;//<= pour lire les lignes
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;//prend des bytes et encode vers des caracteres
import java.util.IllegalFormatException;

public class Principale {

	public static boolean isInteger(char caracter) {
		String caracterToString = Character.toString(caracter);
		try {
			Integer.parseInt(caracterToString);
			return true;
		} catch (IllegalFormatException e) {
			return false;
		}
	}

	public static void recupererDonnesFichier() throws IOException {
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(new File("piloter.txt"));
			InputStreamReader fileReader = new InputStreamReader(fileInput);// <= on a lui dit qu'on va lire ce fichier
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
			Tondeuse tondeuse1 = new Tondeuse();

			String positionTondeuse = "";
			String mouvementTondeuse = "";
			while (fileLine != null) {// <= on est pas encore arriver a la fin de fichier
				String positionTondeuseX = Character.toString(fileLine.charAt(0));
				String positionTondeuseY = Character.toString(fileLine.charAt(2));
				String orientationTondeuse = Character.toString(fileLine.charAt(4));
				positionTondeuse = positionTondeuseX + positionTondeuseY + orientationTondeuse;

				if (fileLine != null) {
					mouvementTondeuse = lineReader.readLine();
				}
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
