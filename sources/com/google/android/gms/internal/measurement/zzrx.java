package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzrx implements K {
    static final Map<Uri, zzrx> zzbrb = new ArrayMap();
    private static final String[] zzbrg = {"key", "value"};
    private final Uri uri;
    private final ContentResolver zzbrc;
    private volatile Map<String, String> zzbre;
    private final Object zzbrd = new Object();
    private final List<zzsa> zzbrf = new ArrayList();

    private zzrx(ContentResolver contentResolver, Uri uri) {
        this.zzbrc = contentResolver;
        this.uri = uri;
        this.zzbrc.registerContentObserver(uri, false, new J(this, null));
    }

    public static zzrx zza(ContentResolver contentResolver, Uri uri) {
        zzrx zzrxVar;
        synchronized (zzrx.class) {
            zzrxVar = zzbrb.get(uri);
            if (zzrxVar == null) {
                try {
                    zzrx zzrxVar2 = new zzrx(contentResolver, uri);
                    try {
                        zzbrb.put(uri, zzrxVar2);
                    } catch (SecurityException unused) {
                    }
                    zzrxVar = zzrxVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzrxVar;
    }

    private final Map<String, String> zztm() {
        try {
            return (Map) zzsc.zza(new zzsd(this) { // from class: com.google.android.gms.internal.measurement.I

                /* renamed from: a, reason: collision with root package name */
                private final zzrx f13372a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13372a = this;
                }

                @Override // com.google.android.gms.internal.measurement.zzsd
                public final Object zzto() {
                    return this.f13372a.zztn();
                }
            });
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.K
    public final /* synthetic */ Object zzfn(String str) {
        return zztk().get(str);
    }

    public final Map<String, String> zztk() {
        Map<String, String> map = this.zzbre;
        if (map == null) {
            synchronized (this.zzbrd) {
                map = this.zzbre;
                if (map == null) {
                    map = zztm();
                    this.zzbre = map;
                }
            }
        }
        return map != null ? map : Collections.emptyMap();
    }

    public final void zztl() {
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

    public final /* synthetic */ Map zztn() {
        Map hashMap;
        Cursor query = this.zzbrc.query(this.uri, zzbrg, null, null, null);
        if (query == null) {
            return Collections.emptyMap();
        }
        try {
            int count = query.getCount();
            if (count == 0) {
                return Collections.emptyMap();
            }
            if (count <= 256) {
                hashMap = new ArrayMap(count);
            } else {
                hashMap = new HashMap(count, 1.0f);
            }
            while (query.moveToNext()) {
                hashMap.put(query.getString(0), query.getString(1));
            }
            return hashMap;
        } finally {
            query.close();
        }
    }
}
