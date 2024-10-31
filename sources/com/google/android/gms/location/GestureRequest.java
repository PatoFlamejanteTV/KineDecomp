package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class GestureRequest implements SafeParcelable {
    private final int e;
    private final List<Integer> f;

    /* renamed from: a, reason: collision with root package name */
    private static final List<Integer> f1842a = Collections.unmodifiableList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19));
    private static final List<Integer> b = Collections.unmodifiableList(Arrays.asList(1));
    private static final List<Integer> c = Collections.unmodifiableList(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 19));
    private static final List<Integer> d = Collections.unmodifiableList(Arrays.asList(3, 5, 7, 9, 11, 13, 15, 17));
    public static final zzb CREATOR = new zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GestureRequest(int i, List<Integer> list) {
        this.e = i;
        this.f = list;
    }

    public int a() {
        return this.e;
    }

    public List<Integer> b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.a(this, parcel, i);
    }
}
