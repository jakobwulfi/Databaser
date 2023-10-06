import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JAVAexamples {

	/**
	 * @param args
	 */
	static Connection minConnection;
	static Statement stmt;
	static BufferedReader inLine;

	public static void opgaveA() {
	try {
		// Indlæser søgestreng
		System.out.println("Indtast karakter");
		String karakter = inLine.readLine();
		System.out.println("Indtast administrator bedømmelse. Skriv NULL hvis ingen bedømmelse.");
		String bedømmelse = inLine.readLine();
		System.out.println("Indtast studerende ID.");
		String studID = inLine.readLine();
		System.out.println("Indtast forsøgsnummer.");
		String forsøgsnummer = inLine.readLine();
		System.out.println("Indtast id for eksamensafvikling.");
		String afviklingID = inLine.readLine();
		// Laver sql-sætning og får den udført
		String sql = "insert into eksamensforsøg values(" + karakter + "," + bedømmelse + "," + forsøgsnummer + "," + studID +
						"," + afviklingID + ")";
		System.out.println("SQL-streng er "+ sql);
		stmt.executeQuery(sql);
		// insert into eksamensforsøg values (0, NULL, 1, 2, 101);
		// pæn lukning
 		if (!minConnection.isClosed()) {
			System.out.println("Eksamensforsøg oprettet.");
			 minConnection.close();
		}
		}
	catch (SQLException e) {
		switch (e.getErrorCode())
		// fejl-kode 547 svarer til en foreign key fejl
		{ case 547 : {if (e.getMessage().contains("studerendeID"))
			System.out.println("Den studerende findes ikke");
		else if (e.getMessage().contains("eksamensafviklingID"))
			System.out.println("Eksamensafvikling er ikke oprettet");
		else
			System.out.println("ukendt fremmednøglefejl");
			break;
		}
		// primary key er auto generated
		};
	}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void opgaveB() {
		try {
			// Indlæser søgestreng
			// -- (eksamensafviklingID, startdato, slutdato, fk_eksamenID)
			System.out.println("Indtast ID for ny eksamensafvikling");
			String afviklingID = inLine.readLine();
			System.out.println("Indtast startdato for afvikling (YYYY-MM-DD).");
			String startDato = inLine.readLine();
			System.out.println("Indtast slutdato for afvikling (YYYY-MM-DD).");
			String slutDato = inLine.readLine();
			System.out.println("Indtast ID for eksamen.");
			String eksamenID = inLine.readLine();
			// Laver sql-sætning og får den udført
			String sql = "insert into eksamensafvikling values(" + afviklingID + "," +"'"+ startDato+"'"+ "," +"'"+ slutDato+"'" +
					"," + eksamenID +")";
			System.out.println("SQL-streng er "+ sql);
			stmt.executeQuery(sql);
			// insert into eksamensforsøg values (0, NULL, 1, 2, 101);
			// pæn lukning
			if (!minConnection.isClosed()) {
				System.out.println("Eksamensforsøg oprettet.");
				minConnection.close();
			}
		}
		catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{ case 547 : {if (e.getMessage().contains("eksamenID"))
				System.out.println("Eksamen findes ikke");
			else
				System.out.println("ukendt fremmednøglefejl");
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
				case 2627: {System.out.println("ID er allerede anvendt til en anden afvikling.");
					break;
				}
			};
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void opgaveC() {
		try {
			// Indlæser søgestreng
			System.out.println("Indtast navn på eksamen (fx PRO2)");
			String navn = inLine.readLine();
			System.out.println("Indtast termin for eksamen (fx vinter2022). Brug ikke mellemrum.");
			String termin = inLine.readLine();
			System.out.println("Indtast ID for afvikling");
			String afviklingID = inLine.readLine();
			// Laver sql-sætning og får den udført
			String sql = "select s.navn, s.studerendeID, ef.karakter " +
					"from studerende s " +
					"join eksamensforsøg ef on ef.fk_studerendeID = s.studerendeID " +
					"join eksamensafvikling ea on ea.eksamensafviklingID = ef.fk_eksamensafviklingID " +
					"join eksamen e on e.eksamenID = ea.fk_eksamenID " +
					"where e.navn = ("+"'" + navn +"'"+ ") and e.termin = ("+"'"+termin+"'"+") " +
					"and ea.eksamensafviklingID = ("+"'" + afviklingID +"'"+ ")" +
					"order by s.navn;";
			System.out.println("SQL-streng er "+ sql);
			ResultSet res=stmt.executeQuery(sql);
			//gennemløber svaret
			while (res.next()) {
				System.out.println(res.getString(1) + "    " + res.getString(2) + "    " +
						res.getString(3));
			}
			// pæn lukning
			if (!minConnection.isClosed()) {
				minConnection.close();
			}
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			inLine = new BufferedReader(new InputStreamReader(System.in));
			//generel opsætning
			//via native driver
			String server="JAKOBWOLFB\\SQLEXPRESS"; //virker måske hos dig
			                                       //virker det ikke - prøv kun med localhost
			String dbnavn="karakterregistreringssystem";            //virker måske hos dig
			String login="sa";                     //skal ikke ændres
			String password="jakobwolf1234";            //skal ændres
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			minConnection = DriverManager.getConnection("jdbc:sqlserver://"+server+";databaseName="+dbnavn+
					";user=" + login + ";password=" + password + ";");
			//minConnection = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=torben07;");
			stmt = minConnection.createStatement();
			//Indlæsning og kald af den rigtige metode
			System.out.println("Indtast  "); 
			System.out.println("a for opgave a");
			System.out.println("b for opgave b");
			System.out.println("c for opgave c");
			String in=inLine.readLine();
			switch (in)
			{case "a"  : {opgaveA();break;}
				case "b"  : {opgaveB();break;}
				case "c"  : {opgaveC();break;}
			default : System.out.println("ukendt indtastning");
			} 
		}
		catch (Exception e) {
			System.out.println("fejl:  "+e.getMessage());
		}
	}
	

}

