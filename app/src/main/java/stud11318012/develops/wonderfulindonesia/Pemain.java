package stud11318012.develops.wonderfulindonesia;

import android.os.Parcel;
import android.os.Parcelable;

public class Pemain implements Parcelable {

    private String namaPemain;
    private String nationality;
    private String position;
    private String career;
    private int appearances;
    private int goalCount;
    private int imgResource;

    public String getNamaPemain() {
        return namaPemain;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getPosition() {

        return position;
    }

    public void setPosition(String position) {

        this.position = position;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getAppearances() {
        return appearances;
    }

    public void setAppearances(int appearances) {
        this.appearances = appearances;
    }

    public int getGoalCount() {

        return goalCount;
    }

    public void setGoalCount(int goalCount) {

        this.goalCount = goalCount;
    }

    public int getImgResource() {

        return imgResource;
    }

    public void setImgResource(int imgResource) {

        this.imgResource = imgResource;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaPemain);
        dest.writeString(this.nationality);
        dest.writeString(this.position);
        dest.writeString(this.career);
        dest.writeInt(this.appearances);
        dest.writeInt(this.goalCount);
        dest.writeInt(this.imgResource);
    }

    public Pemain() {
    }

    protected Pemain(Parcel in) {
        this.namaPemain = in.readString();
        this.nationality = in.readString();
        this.position = in.readString();
        this.career = in.readString();
        this.appearances = in.readInt();
        this.goalCount = in.readInt();
        this.imgResource = in.readInt();
    }

    public static final Creator<Pemain> CREATOR = new Creator<Pemain>() {
        @Override
        public Pemain[] newArray(int size) {
            return new Pemain[size];
        }
        @Override
        public Pemain createFromParcel(Parcel source) {
            return new Pemain(source);
        }
    };
}
