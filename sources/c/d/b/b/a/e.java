package c.d.b.b.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;
import java.util.Map;

/* compiled from: User.java */
/* loaded from: classes.dex */
public class e extends c {
    public static final Parcelable.Creator<e> CREATOR = new d();
    private static final String TAG = "e";
    private long accountExpiration;
    private String accountType;
    private boolean admin;
    private String displayName;
    private String email;
    private long lastSeen;
    private int privacy_consent_android;
    private long privacy_consent_time;
    private String signUpPlatform;

    public /* synthetic */ e(Parcel parcel, d dVar) {
        this(parcel);
    }

    public static e from(DataSnapshot dataSnapshot) {
        e eVar = (e) dataSnapshot.a(e.class);
        if (eVar != null) {
            eVar.id = dataSnapshot.b();
            if (dataSnapshot.b("privacy_consent_android")) {
                eVar.setPrivacyVersion(((Integer) dataSnapshot.a("privacy_consent_android").a(Integer.class)).intValue());
            }
            if (dataSnapshot.b("privacy_consent_time")) {
                eVar.setPrivacyAgreeTime(((Long) dataSnapshot.a("privacy_consent_time").a(Long.class)).longValue());
            }
        }
        return eVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            String str = this.email;
            if (str != null && !str.equals(eVar.email)) {
                return false;
            }
            String str2 = this.displayName;
            if (str2 != null && !str2.equals(eVar.displayName)) {
                return false;
            }
            String str3 = this.accountType;
            return (str3 == null || str3.equals(eVar.accountType)) && this.accountExpiration == eVar.accountExpiration && this.admin == eVar.admin && this.lastSeen == eVar.lastSeen && this.signUpPlatform == eVar.signUpPlatform && this.privacy_consent_android == eVar.privacy_consent_android && this.privacy_consent_time == eVar.privacy_consent_time;
        }
        return super.equals(obj);
    }

    public long getAccountExpiration() {
        return this.accountExpiration;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public long getLastSeen() {
        return this.lastSeen;
    }

    public long getPrivacyAgreeTime() {
        return this.privacy_consent_time;
    }

    public int getPrivacyVersion() {
        return this.privacy_consent_android;
    }

    public String getSignUpPlatform() {
        return this.signUpPlatform;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    @Exclude
    public void set(e eVar) {
        if (eVar != null) {
            this.email = eVar.email;
            this.displayName = eVar.displayName;
            this.accountType = eVar.accountType;
            this.accountExpiration = eVar.accountExpiration;
            this.admin = eVar.admin;
            this.lastSeen = eVar.lastSeen;
            this.signUpPlatform = eVar.signUpPlatform;
            this.privacy_consent_android = eVar.privacy_consent_android;
            this.privacy_consent_time = eVar.privacy_consent_time;
        }
    }

    public void setAccountExpiration(long j) {
        this.accountExpiration = j;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public void setAdmin(boolean z) {
        this.admin = z;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setLastSeen(long j) {
        this.lastSeen = j;
    }

    public void setPrivacyAgreeTime(long j) {
        this.privacy_consent_time = j;
    }

    public void setPrivacyVersion(int i) {
        this.privacy_consent_android = i;
    }

    public void setSignUpPlatform(String str) {
        this.signUpPlatform = str;
    }

    @Override // c.d.b.b.a.c
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.put(NotificationCompat.CATEGORY_EMAIL, this.email);
        map.put("displayName", this.displayName);
        map.put("lastSeen", ServerValue.f16646a);
        return map;
    }

    public String toString() {
        return "{ id: " + this.id + ", email: " + this.email + ", displayName: " + this.displayName + ", accountType: " + this.accountType + ", accountExpiration: " + this.accountExpiration + ", admin: " + this.admin + ", lastSeen: " + this.lastSeen + ", signUpPlatform: " + this.signUpPlatform + ", privacyVersion: " + this.privacy_consent_android + ", privacyAgreeTime: " + this.privacy_consent_time + " }";
    }

    @Override // c.d.b.b.a.c, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.email);
        parcel.writeString(this.accountType);
        parcel.writeLong(this.accountExpiration);
        parcel.writeInt(this.admin ? 1 : 0);
        parcel.writeLong(this.lastSeen);
        parcel.writeString(this.signUpPlatform);
        parcel.writeInt(this.privacy_consent_android);
        parcel.writeLong(this.privacy_consent_time);
    }

    public e() {
    }

    public e(String str) {
        super(str);
    }

    public e(String str, String str2, String str3) {
        super(str);
        this.email = str2;
        this.displayName = str3;
    }

    private e(Parcel parcel) {
        super(parcel);
        this.email = parcel.readString();
        this.displayName = parcel.readString();
        this.accountType = parcel.readString();
        this.accountExpiration = parcel.readLong();
        this.admin = parcel.readInt() != 0;
        this.lastSeen = parcel.readLong();
        this.signUpPlatform = parcel.readString();
        this.privacy_consent_android = parcel.readInt();
        this.privacy_consent_time = parcel.readLong();
    }
}
