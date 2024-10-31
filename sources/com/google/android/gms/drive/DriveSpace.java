package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class DriveSpace implements SafeParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    public static final DriveSpace f1057a = new DriveSpace("DRIVE");
    public static final DriveSpace b = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace c = new DriveSpace(ShareConstants.PHOTOS);
    public static final Set<DriveSpace> d = Collections.unmodifiableSet(new HashSet(Arrays.asList(f1057a, b, c)));
    public static final String e = TextUtils.join(",", d.toArray());
    private static final Pattern g = Pattern.compile("[A-Z0-9_]*");
    final int f;
    private final String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DriveSpace(int i, String str) {
        this.f = i;
        this.h = (String) zzx.a(str);
    }

    private DriveSpace(String str) {
        this(1, str);
    }

    public String a() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != DriveSpace.class) {
            return false;
        }
        return this.h.equals(((DriveSpace) obj).h);
    }

    public int hashCode() {
        return 1247068382 ^ this.h.hashCode();
    }

    public String toString() {
        return this.h;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.a(this, parcel, i);
    }
}
