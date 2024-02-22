package resortInfo;

public class SkiAndSnowboardSchool {

    private int skiAndSnowboardSchoolID;

    private String instructorFullName ="";
    private String clientFullName="";
    private String lessonType="";
    private int lessonValidity;

    public int getSkiAndSnowboardSchoolID() {
        return skiAndSnowboardSchoolID;
    }

    public void setSkiAndSnowboardSchoolID(int skiAndSnowboardSchoolID) {
        this.skiAndSnowboardSchoolID = skiAndSnowboardSchoolID;
    }

    public String getInstructorFullName() {
        return instructorFullName;
    }

    public void setInstructorFullName(String instructorFullName) {
        this.instructorFullName = instructorFullName;
    }

    public String getClientFullName() {
        return clientFullName;
    }

    public void setClientFullName(String clientFullName) {
        this.clientFullName = clientFullName;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public int getLessonValidity() {
        return lessonValidity;
    }

    public void setLessonValidity(int lessonValidity) {
        this.lessonValidity = lessonValidity;
    }
}
