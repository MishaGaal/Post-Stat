package mike.galitsky.poststat;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Person implements Parcelable {


    private int id;
    private String nickname;
    private avatar_image avatar_image;

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public avatar_image getAvatar() {
        return avatar_image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.nickname);
        dest.writeParcelable(this.avatar_image, flags);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.id = in.readInt();
        this.nickname = in.readString();
        this.avatar_image = in.readParcelable(mike.galitsky.poststat.avatar_image.class.getClassLoader());
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
