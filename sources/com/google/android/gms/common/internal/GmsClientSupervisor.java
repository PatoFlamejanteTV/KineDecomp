package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {

    /* renamed from: a */
    private static final Object f11102a = new Object();

    /* renamed from: b */
    private static GmsClientSupervisor f11103b;

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a */
        private final String f11104a;

        /* renamed from: b */
        private final String f11105b;

        /* renamed from: c */
        private final ComponentName f11106c;

        /* renamed from: d */
        private final int f11107d;

        public zza(String str, String str2, int i) {
            Preconditions.b(str);
            this.f11104a = str;
            Preconditions.b(str2);
            this.f11105b = str2;
            this.f11106c = null;
            this.f11107d = i;
        }

        public final ComponentName a() {
            return this.f11106c;
        }

        public final String b() {
            return this.f11105b;
        }

        public final int c() {
            return this.f11107d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return Objects.a(this.f11104a, zzaVar.f11104a) && Objects.a(this.f11105b, zzaVar.f11105b) && Objects.a(this.f11106c, zzaVar.f11106c) && this.f11107d == zzaVar.f11107d;
        }

        public final int hashCode() {
            return Objects.a(this.f11104a, this.f11105b, this.f11106c, Integer.valueOf(this.f11107d));
        }

        public final String toString() {
            String str = this.f11104a;
            return str == null ? this.f11106c.flattenToString() : str;
        }

        public final Intent a(Context context) {
            String str = this.f11104a;
            if (str != null) {
                return new Intent(str).setPackage(this.f11105b);
            }
            return new Intent().setComponent(this.f11106c);
        }

        public zza(ComponentName componentName, int i) {
            this.f11104a = null;
            this.f11105b = null;
            Preconditions.a(componentName);
            this.f11106c = componentName;
            this.f11107d = 129;
        }
    }

    @KeepForSdk
    public static GmsClientSupervisor a(Context context) {
        synchronized (f11102a) {
            if (f11103b == null) {
                f11103b = new j(context.getApplicationContext());
            }
        }
        return f11103b;
    }

    public abstract boolean a(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        b(new zza(componentName, 129), serviceConnection, str);
    }

    protected abstract void b(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new zza(componentName, 129), serviceConnection, str);
    }

    public final void a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new zza(str, str2, i), serviceConnection, str3);
    }
}
