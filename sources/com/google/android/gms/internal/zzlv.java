package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public final class zzlv extends zzmg<zza, Drawable> {

    /* loaded from: classes.dex */
    public static final class zza {
        public final int zzaeE;
        public final int zzaeF;

        public zza(int i, int i2) {
            this.zzaeE = i;
            this.zzaeF = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return zzaVar.zzaeE == this.zzaeE && zzaVar.zzaeF == this.zzaeF;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzw.a(Integer.valueOf(this.zzaeE), Integer.valueOf(this.zzaeF));
        }
    }

    public zzlv() {
        super(10);
    }
}
