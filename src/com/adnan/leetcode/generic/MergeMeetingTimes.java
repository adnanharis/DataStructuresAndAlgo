/**
 https://www.interviewcake.com/question/java/merging-ranges?course=fc1&section=array-and-string-manipulation
 */
public class MergeMeetingTimes {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        List<Meeting> meetings = new ArrayList<>(5);
        meetings.add(new Meeting(0, 1));
        meetings.add(new Meeting(3, 5));
        meetings.add(new Meeting(4, 8));
        meetings.add(new Meeting(10, 12));
        meetings.add(new Meeting(9, 10));

        List<Meeting> mergedMeetings = merge(meetings);
        print(mergedMeetings);
    }

    private static List<Meeting> merge(List<Meeting> meetings) {
        // Sort based on the start time
        Collections.sort(meetings, new Comparator<Meeting>() {
            public int compare(Meeting a, Meeting b) {
                return a.getStartTime() - b.getStartTime();
            }
        });

        List<Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(new Meeting(0, 0));

        Iterator<Meeting> it = meetings.iterator();
        while(it.hasNext()) {
            Meeting m = it.next();
            Meeting mm = mergedMeetings.get(mergedMeetings.size() - 1);
            if (m.getStartTime() <= mm.getEndTime()
                    && m.getEndTime() > mm.getEndTime()) {
                mm.setEndTime(m.getEndTime());
            } else {
                mergedMeetings.add(m);
            }
        }

        // print(meetings);
        // System.out.println();
        // print(mergedMeetings);
        return mergedMeetings;
    }

    private static void print(List<Meeting> meetings) {
        Iterator<Meeting> it = meetings.iterator();
        while(it.hasNext()) {
            Meeting m = it.next();
            System.out.print(m.getStartTime() + " " + m.getEndTime() + "\n");
        }
    }
}

class Meeting {
    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}