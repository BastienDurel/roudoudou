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

	Caracteristique taille = new Caracteristique(8);

	Caracteristique apparence = new Caracteristique(8);

	Caracteristique constitution = new Caracteristique(8);

	Caracteristique force = new Caracteristique(8);

	Caracteristique agilite = new Caracteristique(8);

	Caracteristique dexterite = new Caracteristique(8);

	Caracteristique vue = new Caracteristique(8);

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

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("org.geekwu.roudoudou.Personnage [" + name + "] beauté "
				+ beaute);
		if (vrai_revant == false) b.append(" Haut-rêvant");
		
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
}
