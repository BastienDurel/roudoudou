package org.geekwu.roudoudou;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Personnage implements Serializable {
	private static final long serialVersionUID = -8251393170024570395L;

	String name;

	int beaute = 10;

	boolean vrai_revant = true;

	Caracteristique taille = new Caracteristique(15);

	Caracteristique apparence = new Caracteristique(15);

	Caracteristique constitution = new Caracteristique(15);

	Caracteristique force = new Caracteristique(15);

	Caracteristique agilite = new Caracteristique(15);

	Caracteristique dexterite = new Caracteristique(15);

	Caracteristique vue = new Caracteristique(14);

	Caracteristique ouie = new Caracteristique(8);

	Caracteristique odorat_gout = new Caracteristique(8);

	Caracteristique volonte = new Caracteristique(8);

	Caracteristique intellect = new Caracteristique(8);

	Caracteristique empathie = new Caracteristique(8);

	Caracteristique reve = new Caracteristique(8);

	Caracteristique chance = new Caracteristique(8);

	Personnage(String name) {
		this.name = name;
	}

	List<Competence> competences = new Vector<Competence>();
	List<Sort> sorts = new Vector<Sort>();

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("org.geekwu.roudoudou.Personnage [" + name + "] beauté "
				+ beaute);
		if (vrai_revant == false)
			b.append(" Haut-rêvant");

		b.append(System.lineSeparator() + " * Caractéristiques:");
		b.append(System.lineSeparator() + " * Taille: " + taille.value);
		b.append(System.lineSeparator() + " * Apparence: " + apparence.value);
		b.append(System.lineSeparator() + " * Constitution: " + constitution.value);
		b.append(System.lineSeparator() + " * Force: " + force.value);
		b.append(System.lineSeparator() + " * Agilité: " + agilite.value);
		b.append(System.lineSeparator() + " * Dextérité: " + dexterite.value);
		b.append(System.lineSeparator() + " * Vue: " + vue.value);
		b.append(System.lineSeparator() + " * Ouïe: " + ouie.value);
		b.append(System.lineSeparator() + " * Odorat-Goût: " + odorat_gout.value);
		b.append(System.lineSeparator() + " * Volonté: " + volonte.value);
		b.append(System.lineSeparator() + " * Empathie: " + empathie.value);
		b.append(System.lineSeparator() + " * Intellect: " + intellect.value);
		b.append(System.lineSeparator() + " * Rêve: " + reve.value);
		b.append(System.lineSeparator() + " * Chance: " + chance.value);

		if (!competences.isEmpty()) {
			b.append(System.lineSeparator() + "Compétences:");
			Iterator<Competence> i = competences.iterator();
			while (i.hasNext()) {
				b.append(System.lineSeparator() + i.next());
			}
		}
		return b.toString();
	}

	public void save(File destination) throws IOException {
		FileOutputStream fos = new FileOutputStream(destination);
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(this);
		out.close();
	}

	public static Personnage fromFile(File source) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(source);
		ObjectInputStream in = new ObjectInputStream(fis);
		Personnage newPersonnage = (Personnage) in.readObject();
		in.close();
		return newPersonnage;
	}

	public int getMelee() {
		return (force.value + agilite.value) / 2;
	}

	public int getTir() {
		return (dexterite.value + vue.value) / 2;
	}

	public int getLancer() {
		return (getTir() + force.value) / 2;
	}

	public int getDerobee() {
		return ((21 - taille.value) + agilite.value) / 2;
	}

	/**
	 * Calcule le nombre de points de caractéristique du perso (utile à la
	 * création)
	 * 
	 * @return points de caractéristique
	 */
	public int getCaracsPoints() {
		return taille.value + apparence.value + constitution.value + force.value + agilite.value
				+ dexterite.value + vue.value + ouie.value + odorat_gout.value + volonte.value
				+ empathie.value + intellect.value + reve.value + chance.value + Math.max(0, beaute - 10);
	}

	/**
	 * @return Les points de vie du personnage
	 */
	public int getVie() {
		return Math.round((float) (taille.value + constitution.value) / 2f);
	}

	/**
	 * @return L'endurance du personnage
	 */
	public int getEndurance() {
		return Math.max(taille.value + constitution.value, getVie() + volonte.value);
	}

	/**
	 * @return Le seuil de constitution du personnage
	 */
	public int getSeuilConstitution() {
		if (constitution.value < 9)
			return 2;
		if (constitution.value < 12)
			return 3;
		if (constitution.value < 15)
			return 4;
		return 5;
	}

	/**
	 * @return Les points de sustantation nécessaires au personnage
	 */
	public int getSust() {
		if (constitution.value < 10)
			return 2;
		if (constitution.value < 14)
			return 3;
		return 4;
	}

	/**
	 * @return Le +Dom personnel du personnage
	 */
	public int getPlusdom() {
		if (constitution.value < 8)
			return -1;
		if (constitution.value < 12)
			return 0;
		if (constitution.value < 14)
			return 1;
		return 2;
	}

	/**
	 * @return L'encombrement du personnage
	 */
	public float getEncombrement() {
		return (taille.value + force.value) / 2;
	}

	/**
	 * @return
	 */
	public String getCaracTextCompressed() {
		return "Nom: " + name + " Beauté: " + beaute + System.lineSeparator() + "Taille: "
				+ taille.value + " Apparence: " + apparence.value + " Constitution: "
				+ constitution.value + " Force: " + force.value + " Agilité: " + agilite.value
				+ " Dextérité: " + dexterite.value + " Vue: " + vue.value + " Ouïe: " + ouie.value
				+ " Odorat-Goût: " + odorat_gout.value + " Volonté: " + volonte.value + " Empathie: "
				+ empathie.value + " Intellect: " + intellect.value + " Rêve: " + reve.value
				+ " Chance: " + chance.value;
	}

	public boolean isVraiRevant() {
		return vrai_revant;
	}

	public void setVraiRevant(boolean vrai_revant) {
		this.vrai_revant = vrai_revant;
	}
	
	public Competence getSurvie() {
		Competence _survie = Competence.Factory.particuliere(Competence.List.special.SURVIE);
		if (competences.contains(_survie)) {
			return competences.get(competences.indexOf(_survie));
		}
		return null;
	}
}
