import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class sms {

	static ArrayList<String> papous = new ArrayList<String>();
	static int bruh = 1;
	static File f1 = new File("res.txt");
	static PrintWriter p1;
	static Stream<String> content;

	public static void main(String[] args) throws IOException {
		p1 = new PrintWriter(f1);
		papous.add("papous");
		papous.add("papas");
		papous.add("à poux");
		papous.add("papis");
		papous.add("epoux");
		papous.add("félé");

		rec("", 0);

		gastonadeBinaire();

		content = Files.lines(Paths.get("res.txt"), StandardCharsets.ISO_8859_1);
		List<String> p = content.filter(x -> x.equals(x)).collect(Collectors.toList());

		//System.out.println(p.size());
		int issou = 0; 
		for (String q : p) {
			for (String r : p) {
				if (q.equals(r))
					issou++; 
			}
		}
	
		if(issou == (int) (Math.pow(2, papous.size()) * 2) ) System.out.println("yop");
	}

	public static void rec(String choix, int caract) {
		if (caract == papous.size()) {

			p1.write(choix + "\n");
			p1.flush();
			bruh++;

		} else {

			rec(choix + " " + papous.get(caract), caract + 1);
			rec(choix + " pas " + papous.get(caract), caract + 1);

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
			// System.out.println("\t\t" + total);
			p1.write(total + "\n");
			p1.flush();

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
