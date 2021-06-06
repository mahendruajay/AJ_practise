package pattern_based.searching_sorting.ik.part1_presort_transfrom;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.



Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:

Input: intervals = [[7,10],[2,4]]
Output: true

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

	public static void main(String[] args) {

		MeetingRooms meetingRooms = new MeetingRooms();

		int[][] input1 = {{0, 30}, {5, 10}, {15, 20}};
		System.out.println("Can attend all meeting with Input1: " + meetingRooms.canAttendMeetings(input1));

		int[][] input2 = {{7, 10}, {2, 4}};
		System.out.println("Can attend all meeting with Input1: " + meetingRooms.canAttendMeetings(input2));
	}

	public boolean canAttendMeetings(int[][] intervals) {

		List<Meeting> meetings = new ArrayList<>();
		for (int[] interval : intervals) {
			meetings.add(new Meeting(interval[0], interval[1]));
		}

		meetings.sort(new MeetingStartTimeComparator());

		for (int i = 1; i < meetings.size(); i++) {
			if (meetings.get(i).startTime < meetings.get(i - 1).endTime) {
				return false;
			}
		}

		return true;

	}

	public class Meeting {
		Integer startTime;
		Integer endTime;

		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	class MeetingStartTimeComparator implements Comparator<Meeting> {

		public int compare(Meeting meeting1, Meeting meeting2) {
			return meeting1.startTime.compareTo(meeting2.startTime);
		}
	}
}
