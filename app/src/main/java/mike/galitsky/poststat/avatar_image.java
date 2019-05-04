package mike.galitsky.poststat;

import android.os.Parcel;
import android.os.Parcelable;

public class avatar_image implements Parcelable {


    String url_small;

    public String getUrl_small() {
        return url_small;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url_small);
    }

    public avatar_image() {
    }

    protected avatar_image(Parcel in) {
        this.url_small = in.readString();
    }

    public static final Parcelable.Creator<avatar_image> CREATOR = new Parcelable.Creator<avatar_image>() {
        @Override
        public avatar_image createFromParcel(Parcel source) {
            return new avatar_image(source);
        }

        @Override
        public avatar_image[] newArray(int size) {
            return new avatar_image[size];
        }
    };
}
