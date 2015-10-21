package trioz.project.exception;

public class NoUsersExistsException extends RuntimeException{
	private String message = "No users exist in Database!!!!";

	public NoUsersExistsException() {
	}

	public NoUsersExistsException(String message) {
		if (message != null)
			this.message = message;
	}

	public String getFullMessage() {
		return (message + "  ::  " + message);
	}

	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

}
