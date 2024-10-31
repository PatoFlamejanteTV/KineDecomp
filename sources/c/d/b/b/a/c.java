package c.d.b.b.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.database.Exclude;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ItemBase.java */
/* loaded from: classes.dex */
public abstract class c implements Parcelable {
    private static final String TAG = "c";
    protected String id;

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    @Exclude
    public Map<String, Object> toMap() {
        return new HashMap();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    public c(Parcel parcel) {
        this.id = parcel.readString();
    }

    public c(String str) {
        this.id = str;
    }
}
