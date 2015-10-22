package trioz.project.utility;

import org.springframework.ui.Model;

public class SessionCheck {

	public static boolean isUserExistsInSessionExists(Model model) {
		if (model.asMap().get("user") == null) {
			return false;
		}
		return true;
	}
}
