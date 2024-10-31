package com.google.android.gms.analytics.internal;

import android.util.Log;
import java.util.Map;

/* loaded from: classes.dex */
public class zzaf extends zzd {

    /* renamed from: a, reason: collision with root package name */
    private static String f731a = "3";
    private static String b = "01VDIWEA?";
    private static zzaf c;

    public zzaf(zzf zzfVar) {
        super(zzfVar);
    }

    public static zzaf b() {
        return c;
    }

    protected String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object l = obj instanceof Integer ? new Long(((Integer) obj).intValue()) : obj;
        if (!(l instanceof Long)) {
            return l instanceof Boolean ? String.valueOf(l) : l instanceof Throwable ? l.getClass().getCanonicalName() : "-";
        }
        if (Math.abs(((Long) l).longValue()) < 100) {
            return String.valueOf(l);
        }
        String str = String.valueOf(l).charAt(0) == '-' ? "-" : "";
        String valueOf = String.valueOf(Math.abs(((Long) l).longValue()));
        return str + Math.round(Math.pow(10.0d, valueOf.length() - 1)) + "..." + str + Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        synchronized (zzaf.class) {
            c = this;
        }
    }

    public void a(int i, String str, Object obj, Object obj2, Object obj3) {
        String a2 = zzy.c.a();
        if (Log.isLoggable(a2, i)) {
            Log.println(i, a2, c(str, obj, obj2, obj3));
        }
        if (i >= 5) {
            b(i, str, obj, obj2, obj3);
        }
    }

    public void a(zzab zzabVar, String str) {
        if (str == null) {
            str = "no reason provided";
        }
        d("Discarding hit. " + str, zzabVar != null ? zzabVar.toString() : "no hit data");
    }

    public void a(Map<String, String> map, String str) {
        String str2;
        if (str == null) {
            str = "no reason provided";
        }
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        d("Discarding hit. " + str, str2);
    }

    public synchronized void b(int i, String str, Object obj, Object obj2, Object obj3) {
        synchronized (this) {
            com.google.android.gms.common.internal.zzx.a(str);
            int i2 = i >= 0 ? i : 0;
            String str2 = f731a + b.charAt(i2 >= b.length() ? b.length() - 1 : i2) + (q().b() ? q().a() ? 'P' : 'C' : q().a() ? 'p' : 'c') + zze.f740a + ":" + c(str, a(obj), a(obj2), a(obj3));
            if (str2.length() > 1024) {
                str2 = str2.substring(0, 1024);
            }
            zzai n = k().n();
            if (n != null) {
                n.g().a(str2);
            }
        }
    }
}
