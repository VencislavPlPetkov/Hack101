package PandaSocialNetwork;

public class Panda {

	private String name;

	private String email;

	private String gender;

	public Panda(String name, String email, String gender) {

		this.name = name;
		if (isEmailValid(email)) {

			this.email = email;
		} else {

			throw new IllegalArgumentException("This is NOT valid email!");
		}

		this.gender = gender;
	}

	private boolean isEmailValid(String email) {

		return email.matches("\\S+@\\S+\\.\\S+") && email.length() >= 5;
	}

	public String getName() {

		return name;
	}

	public String getEmail() {

		return email;
	}

	public String getGender() {

		return gender;
	}

	public boolean isMale() {

		return this.getGender() == "male";
	}

	public boolean isFemale() {

		return this.getGender() == "female";
	}

	public boolean equals(Panda otherPanda) {

		return (name.equals(otherPanda.name) && email.equals(otherPanda.email) && gender.equals(otherPanda.gender));
	}

	public String toString() {

		String result = "";

		result += "Name: " + name + "\n";

		result += "Email: " + email + "\n";

		result += "Gender: " + this.getGender() + "\n";

		return result;

	}

}