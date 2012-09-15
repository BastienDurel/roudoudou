package org.geekwu.roudoudou;

public class Competence extends Entrainable {
	private static final long serialVersionUID = -2488662389931928082L;

	public final String name;

	Competence(int value, String name) {
		super(value);
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return " * " + name + ": " + value + " (" + xp + ")";
	}

	@Override
	public int getNextStep() {
		switch (value) {
		case -11:
		case -10:
		case -9:
			return 5;
		case -8:
		case -7:
		case -6:
		case -5:
			return 10;
		case -4:
		case -3:
		case -2:
		case -1:
			return 15;
		case 0:
		case 1:
		case 2:
		case 3:
			return 20;
		case 4:
		case 5:
			return 30;
		case 6:
		case 7:
			return 40;
		case 8:
		case 9:
			return 60;
		default:
			return 100;
		}
	}

	public static class List {
		public static String generale[] = { "Bricolage", "Chant", "Course", "Cuisine", "Danse",
				"Dessin", "Discretion", "Escalade", "Saut", "Séduction", "vigilance" };

		public static String corps_a_corps[] = { "Corps-à-corps", "Dague", "Épée à une main",
				"Épée à deux mains", "Hache à une main", "Hache à deux mains", "Masse à une main",
				"Masse à deux mains", "Fléau", "Arme d'hast", "Lance", "Bouclier" };

		public static String tir[] = { "Arbalète", "Arc", "Fronde", "Dague de jet", "Lance (lancer)", "Fouet" };

		public static String particuliere[] = { "Charpenterie", "Comédie", "Commerce", "Équitation",
				"Maçonnerie", "Musique", "Pickpocket", "Survie en cité", "Survie en extérieur",
				"Travestissement" };

		public static String survies[] = { "Survie en Désert", "Survie en Forêt", "Survie en Glaces",
				"Survie en Marais", "Survie en Montagne", "Survie en Sous-sol" };

		public static String specialisee[] = { "Acrobaties", "chirurgie", "Jeu", "Jonglerie",
				"Maroquinerie", "Métalurgie", "Natation", "Navigation", "Orfévrerie", "Serrurerie" };

		public static String connaissance[] = { "Alchimie", "Astrologie", "Botanique", "Écriture",
				"Légendes", "Médecine", "Zoologie" };

		public static String draconic[] = { "Oniros", "Hypnos", "Narcos", "thanatos" };
	}

	public static class Factory {
		public static Competence generale(String name) {
			return new Competence(-4, name);
		}

		public static Competence particuliere(String name) {
			return new Competence(-5, name);
		}

		public static Competence specialisee(String name) {
			return new Competence(-11, name);
		}

		public static Competence connaissance(String name) {
			return new Competence(-11, name);
		}

		public static Competence draconic(String name, boolean destroyer) {
			return new CompetenceDraconic(-11, name, destroyer);
		}

		public static Competence combat(String name) {
			return new Competence(-6, name);
		}

		public static Competence tir(String name) {
			return new Competence(-8, name);
		}
	}

	@Override
	Competence set(int value, int xp) {
		super.set(value, xp);
		return this;
	}

}
