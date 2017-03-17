package TypeSignatures;

public class Types {

	private String nameType;

	private String inputType;

	private String outputType;

	private String body;

	public Types(String nameType, String inputType, String outputType) {

		this.nameType = nameType;
		this.inputType = inputType;
		this.outputType = outputType;
	}

	public Types(String bodyType) {

		String[] typeParts = bodyType.split(" ");
		this.nameType = typeParts[0];
		this.inputType = typeParts[2];
		this.outputType = typeParts[4];

	}

	/**
	 * public boolean evaluate(String x){
	 * 
	 * String[] parts = body.split(" -> ");
	 * 
	 * inputType = parts[0]; outputType = parts[1];
	 * 
	 * 
	 * String inputForNextFunction=null;
	 * 
	 * for (int i = 0; i < parts.length; i++) {
	 * 
	 * String current = parts[i];
	 * 
	 * if (inputForNextFunction == null || current.equals(inputForNextFunction))
	 * {
	 * 
	 * outputType = inputForNextFunction; }else{
	 * 
	 * return false; } }
	 * 
	 * 
	 * return true; }
	 **/

	public String toString() {

		return nameType + " :: " + inputType + " -> " + outputType;
	}

	public String getnameType() {

		return nameType;
	}

	public String getInputType() {

		return inputType;
	}

	public String getOutputType() {
		return outputType;

	}

}
