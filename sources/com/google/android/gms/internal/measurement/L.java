package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

/* loaded from: classes2.dex */
public final class L implements K {

    /* renamed from: a */
    static L f13379a;

    /* renamed from: b */
    private final Context f13380b;

    private L(Context context) {
        this.f13380b = context;
        this.f13380b.getContentResolver().registerContentObserver(zzru.CONTENT_URI, true, new N(this, null));
    }

    public static L a(Context context) {
        L l;
        synchronized (L.class) {
            if (f13379a == null) {
                f13379a = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new L(context) : new L();
            }
            l = f13379a;
        }
        return l;
    }

    @Override // com.google.android.gms.internal.measurement.K
    /* renamed from: b */
    public final String zzfn(String str) {
        if (this.f13380b == null) {
            return null;
        }
        try {
            return (String) zzsc.zza(new zzsd(this, str) { // from class: com.google.android.gms.internal.measurement.M

                /* renamed from: a, reason: collision with root package name */
                private final L f13382a;

                /* renamed from: b, reason: collision with root package name */
                private final String f13383b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13382a = this;
                    this.f13383b = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzsd
                public final Object zzto() {
                    return this.f13382a.a(this.f13383b);
                }
            });
        } catch (SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    private L() {
        this.f13380b = null;
    }

    public final /* synthetic */ String a(String str) {
        return zzru.zza(this.f13380b.getContentResolver(), str, (String) null);
    }
}
