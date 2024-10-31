package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class zzru {
    private static HashMap<String, String> zzbqr;
    private static Object zzbqw;
    private static boolean zzbqx;
    public static final Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri zzbqn = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzbqo = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzbqp = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzbqq = new AtomicBoolean();
    private static final HashMap<String, Boolean> zzbqs = new HashMap<>();
    private static final HashMap<String, Integer> zzbqt = new HashMap<>();
    private static final HashMap<String, Long> zzbqu = new HashMap<>();
    private static final HashMap<String, Float> zzbqv = new HashMap<>();
    private static String[] zzbqy = new String[0];

    private static void zza(ContentResolver contentResolver) {
        if (zzbqr == null) {
            zzbqq.set(false);
            zzbqr = new HashMap<>();
            zzbqw = new Object();
            zzbqx = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new H(null));
            return;
        }
        if (zzbqq.getAndSet(false)) {
            zzbqr.clear();
            zzbqs.clear();
            zzbqt.clear();
            zzbqu.clear();
            zzbqv.clear();
            zzbqw = new Object();
            zzbqx = false;
        }
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzru.class) {
            zza(contentResolver);
            Object obj = zzbqw;
            if (zzbqr.containsKey(str)) {
                String str3 = zzbqr.get(str);
                if (str3 == null) {
                    str3 = null;
                }
                return str3;
            }
            for (String str4 : zzbqy) {
                if (str.startsWith(str4)) {
                    if (!zzbqx || zzbqr.isEmpty()) {
                        zzbqr.putAll(zza(contentResolver, zzbqy));
                        zzbqx = true;
                        if (zzbqr.containsKey(str)) {
                            String str5 = zzbqr.get(str);
                            if (str5 == null) {
                                str5 = null;
                            }
                            return str5;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    zza(obj, str, (String) null);
                    if (query != null) {
                        query.close();
                    }
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                zza(obj, str, string);
                if (string == null) {
                    string = null;
                }
                if (query != null) {
                    query.close();
                }
                return string;
            } finally {
                if (query != null) {
                    query.close();
                }
            }
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzru.class) {
            if (obj == zzbqw) {
                zzbqr.put(str, str2);
            }
        }
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzbqn, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }
}
