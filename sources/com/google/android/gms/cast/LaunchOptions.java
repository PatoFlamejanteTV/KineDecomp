package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* loaded from: classes.dex */
public class LaunchOptions implements SafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    private final int f827a;
    private boolean b;
    private String c;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private LaunchOptions f828a = new LaunchOptions();
    }

    public LaunchOptions() {
        this(1, false, zzf.a(Locale.getDefault()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LaunchOptions(int i, boolean z, String str) {
        this.f827a = i;
        this.b = z;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f827a;
    }

    public boolean b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.b == launchOptions.b && zzf.a(this.c, launchOptions.c);
    }

    public int hashCode() {
        return zzw.a(Boolean.valueOf(this.b), this.c);
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", Boolean.valueOf(this.b), this.c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
