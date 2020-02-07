package ca.ulaval.ima.tp1;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

class Profil implements Parcelable {
    private String firstname;
    private String lastname;
    private Date birthday;
    private String idul;


    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstname);
        dest.writeString(this.lastname);
        dest.writeLong(birthday.getTime());
        dest.writeString(this.idul);

    }


    public static final Parcelable.Creator<Profil> CREATOR
            = new Parcelable.Creator<Profil>() {
        public Profil createFromParcel(Parcel in) {
            return new Profil(in);
        }

        public Profil[] newArray(int size) {
            return new Profil[size];
        }
    };

    public Profil(Parcel in){
        this.firstname = in.readString();
        this.lastname = in.readString();
        this.birthday = new Date(in.readLong());
        this.idul =  in.readString();
    }


    public Profil(String firstname, String lastname, Date birthday, String idul) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.idul = idul;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdul() {
        return idul;
    }

    public void setIdul(String idul) {
        this.idul = idul;
    }
}

