
public enum Ethnicities {
	/* Ethnicities, and then some, by restaurant representation in Norman (popularity), with some not represented */
	Asian,
	Korean,
	Thai,
	Vietnamese,
	Chinese,
	Japanese,
	German,
	Indian,
	Mexican,
	Italian,
	American,
	Greek,
	Mediterranean,
	TexMex("Tex-Mex");

	private final String text;

	private Ethnicities(){
		this.text = "";
	}

	private Ethnicities(final String text){
		this.text = text;
	}

	private String getText(){
		return this.text;
	}

	@Override
	public String toString() {
		if (this.getText().equals(""))
			return this.name();
		else
			return text;
	}
}
