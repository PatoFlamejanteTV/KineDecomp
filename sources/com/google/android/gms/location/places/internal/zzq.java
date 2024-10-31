package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;

/* loaded from: classes.dex */
public class zzq implements PlacePhotoMetadata {

    /* renamed from: a, reason: collision with root package name */
    private final String f1897a;
    private final int b;
    private final int c;
    private final CharSequence d;
    private int e;

    public zzq(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.f1897a = str;
        this.b = i;
        this.c = i2;
        this.d = charSequence;
        this.e = i3;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata a() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return zzqVar.b == this.b && zzqVar.c == this.c && zzw.a(zzqVar.f1897a, this.f1897a) && zzw.a(zzqVar.d, this.d);
    }

    public int hashCode() {
        return zzw.a(Integer.valueOf(this.b), Integer.valueOf(this.c), this.f1897a, this.d);
    }
}
