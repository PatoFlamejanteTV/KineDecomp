package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzsp implements K {
    static final Map<String, zzsp> zzbrz = new HashMap();
    private volatile Map<String, ?> zzbre;
    private final SharedPreferences zzbsa;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzbsb = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.U

        /* renamed from: a, reason: collision with root package name */
        private final zzsp f13396a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f13396a = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.f13396a.zza(sharedPreferences, str);
        }
    };
    private final Object zzbrd = new Object();
    private final List<zzsa> zzbrf = new ArrayList();

    private zzsp(SharedPreferences sharedPreferences) {
        this.zzbsa = sharedPreferences;
        this.zzbsa.registerOnSharedPreferenceChangeListener(this.zzbsb);
    }

    public static zzsp zzi(Context context, String str) {
        zzsp zzspVar;
        SharedPreferences sharedPreferences;
        if (!((!zzrw.zztj() || str.startsWith("direct_boot:")) ? true : zzrw.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzsp.class) {
            zzspVar = zzbrz.get(str);
            if (zzspVar == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzrw.zztj()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzspVar = new zzsp(sharedPreferences);
                zzbrz.put(str, zzspVar);
            }
        }
        return zzspVar;
    }

    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zzbrd) {
            this.zzbre = null;
            zzsi.zztq();
        }
        synchronized (this) {
            Iterator<zzsa> it = this.zzbrf.iterator();
            while (it.hasNext()) {
                it.next().zztp();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.K
    public final Object zzfn(String str) {
        Map<String, ?> map = this.zzbre;
        if (map == null) {
            synchronized (this.zzbrd) {
                map = this.zzbre;
                if (map == null) {
                    map = this.zzbsa.getAll();
                    this.zzbre = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
