package org.geekwu.roudoudou;

public class Competence extends Entrainable {
	private static final long serialVersionUID = -2488662389931928082L;
	public final String name;

	Competence(int value, String name) {
		super(value);
		this.name = name;
	}

	@Override
	public int getNextStep() {
		// TODO Auto-generated method stub
		return 0;
	}

}
