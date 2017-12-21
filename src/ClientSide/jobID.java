package ClientSide;

public class jobID {
	private int JobID = 0;
	private String message = "";

	public jobID(int id, String datapassed) {
		JobID = id;
		message = datapassed;
	}

	public int getJobID() {
		return JobID;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "jobID [JobID=" + JobID + ", message=" + message + "]";
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
