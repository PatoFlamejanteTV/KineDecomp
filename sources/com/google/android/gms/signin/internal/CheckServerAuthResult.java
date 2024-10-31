package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class CheckServerAuthResult implements SafeParcelable {
    public static final Parcelable.Creator<CheckServerAuthResult> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    final int f2194a;
    final boolean b;
    final List<Scope> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f2194a = i;
        this.b = z;
        this.c = list;
    }

    public CheckServerAuthResult(boolean z, Set<Scope> set) {
        this(1, z, a(set));
    }

    private static List<Scope> a(Set<Scope> set) {
        return set == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(set));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc.a(this, parcel, i);
    }
}
