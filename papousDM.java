import java.io.IOException;
import java.util.ArrayList;

public class papousDM {
	static ArrayList<String> tabPapous = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		tabPapous.add("papous");
		tabPapous.add("papas");
		tabPapous.add("à poux");
		tabPapous.add("papis");

		System.out.println("Affichage de la solution itérative : ");
		solutionIterative();

		System.out.println();

		System.out.println("Affichage de la solution récursive : ");
		solutionRecursive("", 0);

	}

	public static void solutionRecursive(String choix, int caract) {
		if (caract == tabPapous.size()) {
			System.out.println(choix.trim());
		} else {
			solutionRecursive(choix + " " + tabPapous.get(caract), caract + 1);
			solutionRecursive(choix + " pas " + tabPapous.get(caract), caract + 1);
		}
	}

	public static void solutionIterative() {
		int cpt = (int) Math.pow(2, tabPapous.size());

		for (int i = cpt; i > 0; i--) {
			String phrase = "";
			String bitValue = makebinary(i);

			for (int j = 0; j < bitValue.length(); j++) {
				char z = bitValue.charAt(j);
				if (z == '0') {
					phrase += "pas " + tabPapous.get(j) + " ";
				} else {
					phrase += tabPapous.get(j) + " ";
				}
			}
			System.out.println(phrase);
		}
	}

	public static String makebinary(int cpt) {
		int mask = 1;
		String bin = "";

		for (int i = 0; i < tabPapous.size(); i++, mask <<= 1) {
			char bit = (cpt & mask) != 0 ? '1' : '0';
			bin = bit + bin;
		}

		return bin;
	}
}
