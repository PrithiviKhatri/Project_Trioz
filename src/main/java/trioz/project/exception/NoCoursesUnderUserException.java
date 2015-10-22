package trioz.project.exception;

public class NoCoursesUnderUserException extends RuntimeException {
	private String userName;
	private String message = "Courses  Not found for User";

	public NoCoursesUnderUserException() {
	}

	public NoCoursesUnderUserException(String userName, String message) {
		this.userName = userName;
		if (message != null)
			this.message = message;
	}

	public String getFullMessage() {
		return (message + "  ::  " + userName);
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

}
