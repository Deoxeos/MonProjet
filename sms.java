import java.io.IOException;
import java.util.ArrayList;

public class sms {

	static ArrayList<String> papous = new ArrayList<String>();

	public static void main(String[] args) throws IOException {

		papous.add("papous");
		papous.add("papas");
		papous.add("à poux");
		papous.add("papis");
	//	papous.add("epoux");
		// papous.add("félé");

		rec("", 0);

		// gastonadeBinaire();
	}

	public static void rec(String choix, int caract) {
		if (caract == papous.size()) {
			System.out.println(choix);
		} else {
			
			System.out.println(!choix.contains(papous.get(caract)) + " " + choix + " " + papous.get(caract));

			if (!choix.contains(papous.get(caract))) {
				choix += papous.get(caract) + " ";
				caract++;
				System.out.println(caract);
				rec(choix, caract);
			}

		}

	}

	public static void gastonadeBinaire() {
		int cpt1 = 0;
		int cpt = (int) Math.pow(2, papous.size());

		for (int i = cpt; i > 0; i--) {
			String total = "";

			String tmpS = makebinary(i);

			for (int j = 0; j < tmpS.length(); j++) {
				char z = tmpS.charAt(j);
				if (z == '0') {
					total += "pas " + papous.get(j) + " ";
				} else {
					total += papous.get(j) + " ";
				}
			}
			System.out.println("\t\t" + total);
			cpt1++;
		}
		System.out.println(cpt1);
	}

	public static String makebinary(int cpt) {
		int mask = 1;
		String bin = "";

		for (int i = 0; i < papous.size(); i++, mask <<= 1) {
			char bit = (cpt & mask) != 0 ? '1' : '0';
			bin = bit + bin;
		}

		return bin;
	}
}
