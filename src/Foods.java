
public enum Foods {
	/* Foods */
	tacos,
	burgers,
	pizza,
	pasta,
	curry,
	BBQ,
	noodles,
	gyros,
	rice;

	private final String text;
	
	private Foods(){
		this.text = "";
	}
	
	private Foods(final String text){
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
