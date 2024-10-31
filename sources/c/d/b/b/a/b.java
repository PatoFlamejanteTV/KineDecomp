package c.d.b.b.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.database.ServerValue;
import java.util.Map;

/* compiled from: Device.java */
/* loaded from: classes.dex */
public class b extends c {
    public static final Parcelable.Creator<b> CREATOR = new a();
    private static final String TAG = "b";
    private long lastAccess;

    public /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    public long getLastAccess() {
        return this.lastAccess;
    }

    public void setLastAccess(long j) {
        this.lastAccess = j;
    }

    @Override // c.d.b.b.a.c
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.put("lastAccess", ServerValue.f16646a);
        map.put("platform", "Android");
        return map;
    }

    @Override // c.d.b.b.a.c, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.lastAccess);
    }

    public b() {
    }

    private b(Parcel parcel) {
        super(parcel);
        this.lastAccess = parcel.readLong();
    }
}
