package com.nttdata.nttdatatallermvn.sql;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Taller práctico JDBC. 
 * Conexión con la base de datos y mostrar algunos datos.
 *
 */

public class App {

	//Variable para crear la conexión con el método privado.
	private static Connection connect = null;

	/**
	 * Clase principal. 
	 */
	public static void main(String[] args) {
		try {
			// Llamada al método que establece la conexión.
			Connection conn = ConnectionDB();

			String query = "select * from nttdata_mysql_soccer_player";

			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			// Bucle que va recorriendo cada posición para mostrar los datos.
			while (rs.next()) {
				System.out.println("Número jugador: " + rs.getString("id_soccer_player"));
				System.out.println("Nombre: " + rs.getString("name"));
				System.out.println("Fecha de nacimiento: " + rs.getString("birth_date"));
				System.out.println("Posición principal: " + rs.getString("first_rol"));
				System.out.println("Posición secundaria: " + rs.getString("second_rol"));
				System.out.println("Equipo: " + rs.getString("id_soccer_team"));
				System.out.println("-----------------------------------------------------");
			}

			// Cierra conexión con la base de datos.
			st.close();
			rs.close();
			conn.close();

			System.out.println();
			System.out.println("Se ha cerrado la conexión con la Base de Datos.");
		} catch (Exception ex) {
			System.out.println("Error. No es posible conectar con la Base de Datos.");
			ex.printStackTrace();
		}
	}

	/**
	 * Método privado que establece la conexión con la base de datos.
	 */
	private static Connection ConnectionDB() {
		try {
			String url = "jdbc:mysql://localhost:3306/nttdata_jdbc_ex?characterEncoding=UTF-8";
			connect = DriverManager.getConnection(url, "root", "rootroot");
			System.out.println("Conexión con la base de datos establecida.");
			System.out.println();
		} catch (SQLException ex) {
			System.out.println("Error en la conexión de la base de datos.");
			ex.printStackTrace();
		}
		return connect;
	}
}
