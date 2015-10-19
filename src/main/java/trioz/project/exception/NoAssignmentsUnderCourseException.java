package trioz.project.exception;

public class NoAssignmentsUnderCourseException extends RuntimeException{
	private String assignmentId;
	private String message = "Assignment Not found for this Id";
	
	public NoAssignmentsUnderCourseException(){}
	
	public NoAssignmentsUnderCourseException(String id,String message){
		this.assignmentId = id;
		if(message !=null) this.message = message;
	}
	
	public String getFullMessage(){
		return (message + assignmentId);
	}
	
	@Override
	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}
}
