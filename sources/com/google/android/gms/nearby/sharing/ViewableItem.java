package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewableItem implements SafeParcelable {
    public static final Parcelable.Creator<ViewableItem> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    private final int f2133a;
    private String[] b;

    private ViewableItem() {
        this.f2133a = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewableItem(int i, String[] strArr) {
        this.f2133a = i;
        this.b = strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2133a;
    }

    public String[] b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ViewableItem) {
            return zzw.a(this.b, ((ViewableItem) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return zzw.a(this.b);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.b) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzf.a(this, parcel, i);
    }
}
