package com.nttdata.mvn;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Taller práctico Maven. Añadir dependencia y usarla. Crear documentación.
 *
 */
public class App {
	
	/**
	 * Método principal.
	 */
	public static void main(String[] args) {
		// Carteles establecidos para mostrar.
		String welcome = "Bienvenido.";
		String look = "Se va a mostrar un array de números:";
		String off = "¿Qué número quieres quitar?";
		String delete = "El número elegido para eliminar es: ";
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int n;

		// Comienzo de lo mostrado por consola al ejecutar.
		System.out.println(welcome);
		System.out.println(look);
		System.out.println();

		// Recorre array de números ya inicializado.
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}

		System.out.println("\n");

		// Recoge información de teclado e
		// invoca al método validate para comprobar que
		// sea un número en el rango indicado.
		do {
			System.out.println(off);
			Scanner read = new Scanner(System.in);
			n = read.nextInt();
			System.out.println();
		} while (validate(n));

		// Elimina el elemento recogido por teclado
		// y lo muestra. Usa la librería commons lang.
		array = ArrayUtils.removeElement(array, n);
		System.out.println(Arrays.toString(array));
	}

	/**
	 * Comprueba el rango de los números mostrados.
	 */
	public static boolean validate(int n) {
		// Usa la librería commons lang.
		try {
			Validate.isTrue(n < 0 || n > 9);
			return true;
		} catch (IllegalArgumentException iae) {
			iae.getMessage();
			return false;
		}
	}
}
