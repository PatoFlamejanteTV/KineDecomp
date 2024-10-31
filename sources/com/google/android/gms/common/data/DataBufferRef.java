package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
/* loaded from: classes.dex */
public class DataBufferRef {

    /* renamed from: a */
    @KeepForSdk
    protected final DataHolder f10999a;

    /* renamed from: b */
    @KeepForSdk
    protected int f11000b;

    /* renamed from: c */
    private int f11001c;

    public final void a(int i) {
        Preconditions.b(i >= 0 && i < this.f10999a.getCount());
        this.f11000b = i;
        this.f11001c = this.f10999a.j(this.f11000b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof DataBufferRef) {
            DataBufferRef dataBufferRef = (DataBufferRef) obj;
            if (Objects.a(Integer.valueOf(dataBufferRef.f11000b), Integer.valueOf(this.f11000b)) && Objects.a(Integer.valueOf(dataBufferRef.f11001c), Integer.valueOf(this.f11001c)) && dataBufferRef.f10999a == this.f10999a) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.a(Integer.valueOf(this.f11000b), Integer.valueOf(this.f11001c), this.f10999a);
    }
}
