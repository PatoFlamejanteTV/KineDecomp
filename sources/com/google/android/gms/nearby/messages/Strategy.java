package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* loaded from: classes.dex */
public class Strategy implements SafeParcelable {
    public static final Parcelable.Creator<Strategy> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public static final Strategy f2101a = new Builder().a();
    public static final Strategy b = new Builder().a(2).b(Integer.MAX_VALUE).a();

    @Deprecated
    public static final Strategy c = b;
    final int d;

    @Deprecated
    final int e;
    final int f;
    final int g;

    @Deprecated
    final boolean h;
    final int i;
    final int j;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f2102a = 3;
        private int b = 300;
        private int c = 0;
        private int d = 1;

        public Builder a(int i) {
            this.d = i;
            return this;
        }

        public Strategy a() {
            if (this.d == 2) {
                if (this.f2102a != 3) {
                    throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
                }
                if (this.c == 1) {
                    throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
                }
            }
            return new Strategy(2, 0, this.b, this.c, false, this.d, this.f2102a);
        }

        public Builder b(int i) {
            zzx.b(i == Integer.MAX_VALUE || (i > 0 && i <= 86400), "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), 86400);
            this.b = i;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6) {
        this.d = i;
        this.e = i2;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    this.j = 1;
                    break;
                case 3:
                    this.j = 2;
                    break;
                default:
                    this.j = 3;
                    break;
            }
        } else {
            this.j = i6;
        }
        this.g = i4;
        this.h = z;
        if (z) {
            this.i = 2;
            this.f = Integer.MAX_VALUE;
        } else if (i5 == 0) {
            this.i = 1;
            this.f = i3;
        } else {
            this.i = i5;
            this.f = i3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.d == strategy.d && this.j == strategy.j && this.f == strategy.f && this.g == strategy.g && this.i == strategy.i;
    }

    public int hashCode() {
        return (((((((this.d * 31) + this.j) * 31) + this.f) * 31) + this.g) * 31) + this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzd.a(this, parcel, i);
    }
}
