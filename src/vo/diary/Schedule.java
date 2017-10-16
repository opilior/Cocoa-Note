package vo.diary;

import java.util.Arrays;
import java.util.Date;

public class Schedule extends Diary {
	private String title;
	private String content;
	private String[] groupMemberID;
	private Date startDate;
	private Date endDate;
	
	public Schedule() {
		super();
	}
	public Schedule(String title, String content, String[] groupMemberID, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.content = content;
		this.groupMemberID = groupMemberID;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getGroupMemberID() {
		return groupMemberID;
	}
	public void setGroupMemberID(String[] groupMemberID) {
		this.groupMemberID = groupMemberID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Schedule [title=" + title + ", content=" + content + ", groupMemberID=" + Arrays.toString(groupMemberID)
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
	
}