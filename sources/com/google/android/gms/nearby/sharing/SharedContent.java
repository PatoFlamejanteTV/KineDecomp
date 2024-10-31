package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* loaded from: classes.dex */
public class SharedContent implements SafeParcelable {
    public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    private final int f2132a;

    @Deprecated
    private String b;
    private ViewableItem[] c;
    private LocalContent[] d;

    private SharedContent() {
        this.f2132a = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedContent(int i, String str, ViewableItem[] viewableItemArr, LocalContent[] localContentArr) {
        this.f2132a = i;
        this.b = str;
        this.c = viewableItemArr;
        this.d = localContentArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f2132a;
    }

    public String b() {
        return this.b;
    }

    public ViewableItem[] c() {
        return this.c;
    }

    public LocalContent[] d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) obj;
        return zzw.a(this.c, sharedContent.c) && zzw.a(this.d, sharedContent.d) && zzw.a(this.b, sharedContent.b);
    }

    public int hashCode() {
        return zzw.a(this.c, this.d, this.b);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.c) + ", localContents=" + Arrays.toString(this.d) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
