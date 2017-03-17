package TypeSignatures;

import java.util.ArrayList;
import java.util.Stack;

public class TypeCompositionManager {

	ArrayList<Types> funcs = new ArrayList<>();

	public void add(Types t) {

		funcs.add(t);
	}

	public Types findByName(String nameType) {

		Types result = null;

		for (int i = 0; i < funcs.size(); i++) {

			Types currentFunc = funcs.get(i);
			if (currentFunc.getnameType().equals(nameType)) {

				result = currentFunc;
			}
		}

		return result;
	}
}
