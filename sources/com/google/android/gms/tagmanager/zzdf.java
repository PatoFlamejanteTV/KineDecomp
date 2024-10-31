package com.google.android.gms.tagmanager;

import com.facebook.internal.ServerProtocol;
import com.google.android.gms.internal.zzag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzdf {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2238a = null;
    private static Long b = new Long(0);
    private static Double c = new Double(0.0d);
    private static zzde d = zzde.zzW(0);
    private static String e = new String("");
    private static Boolean f = new Boolean(false);
    private static List<Object> g = new ArrayList(0);
    private static Map<Object, Object> h = new HashMap();
    private static zzag.zza i = c(e);

    private static Boolean a(String str) {
        return ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str) ? Boolean.TRUE : "false".equalsIgnoreCase(str) ? Boolean.FALSE : f;
    }

    public static String a() {
        return e;
    }

    public static String a(zzag.zza zzaVar) {
        return a(c(zzaVar));
    }

    public static String a(Object obj) {
        return obj == null ? e : obj.toString();
    }

    public static zzag.zza b() {
        return i;
    }

    public static Boolean b(zzag.zza zzaVar) {
        return b(c(zzaVar));
    }

    public static Boolean b(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : a(a(obj));
    }

    public static zzag.zza c(Object obj) {
        boolean z = false;
        zzag.zza zzaVar = new zzag.zza();
        if (obj instanceof zzag.zza) {
            return (zzag.zza) obj;
        }
        if (obj instanceof String) {
            zzaVar.type = 1;
            zzaVar.zziU = (String) obj;
        } else if (obj instanceof List) {
            zzaVar.type = 2;
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                zzag.zza c2 = c(it.next());
                if (c2 == i) {
                    return i;
                }
                boolean z3 = z2 || c2.zzje;
                arrayList.add(c2);
                z2 = z3;
            }
            zzaVar.zziV = (zzag.zza[]) arrayList.toArray(new zzag.zza[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zzaVar.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z4 = false;
            for (Map.Entry entry : entrySet) {
                zzag.zza c3 = c(entry.getKey());
                zzag.zza c4 = c(entry.getValue());
                if (c3 == i || c4 == i) {
                    return i;
                }
                boolean z5 = z4 || c3.zzje || c4.zzje;
                arrayList2.add(c3);
                arrayList3.add(c4);
                z4 = z5;
            }
            zzaVar.zziW = (zzag.zza[]) arrayList2.toArray(new zzag.zza[0]);
            zzaVar.zziX = (zzag.zza[]) arrayList3.toArray(new zzag.zza[0]);
            z = z4;
        } else if (d(obj)) {
            zzaVar.type = 1;
            zzaVar.zziU = obj.toString();
        } else if (e(obj)) {
            zzaVar.type = 6;
            zzaVar.zzja = f(obj);
        } else {
            if (!(obj instanceof Boolean)) {
                zzbg.a("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
                return i;
            }
            zzaVar.type = 8;
            zzaVar.zzjb = ((Boolean) obj).booleanValue();
        }
        zzaVar.zzje = z;
        return zzaVar;
    }

    public static Object c(zzag.zza zzaVar) {
        int i2 = 0;
        if (zzaVar == null) {
            return f2238a;
        }
        switch (zzaVar.type) {
            case 1:
                return zzaVar.zziU;
            case 2:
                ArrayList arrayList = new ArrayList(zzaVar.zziV.length);
                zzag.zza[] zzaVarArr = zzaVar.zziV;
                int length = zzaVarArr.length;
                while (i2 < length) {
                    Object c2 = c(zzaVarArr[i2]);
                    if (c2 == f2238a) {
                        return f2238a;
                    }
                    arrayList.add(c2);
                    i2++;
                }
                return arrayList;
            case 3:
                if (zzaVar.zziW.length != zzaVar.zziX.length) {
                    zzbg.a("Converting an invalid value to object: " + zzaVar.toString());
                    return f2238a;
                }
                HashMap hashMap = new HashMap(zzaVar.zziX.length);
                while (i2 < zzaVar.zziW.length) {
                    Object c3 = c(zzaVar.zziW[i2]);
                    Object c4 = c(zzaVar.zziX[i2]);
                    if (c3 == f2238a || c4 == f2238a) {
                        return f2238a;
                    }
                    hashMap.put(c3, c4);
                    i2++;
                }
                return hashMap;
            case 4:
                zzbg.a("Trying to convert a macro reference to object");
                return f2238a;
            case 5:
                zzbg.a("Trying to convert a function id to object");
                return f2238a;
            case 6:
                return Long.valueOf(zzaVar.zzja);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                zzag.zza[] zzaVarArr2 = zzaVar.zzjc;
                int length2 = zzaVarArr2.length;
                while (i2 < length2) {
                    String a2 = a(zzaVarArr2[i2]);
                    if (a2 == e) {
                        return f2238a;
                    }
                    stringBuffer.append(a2);
                    i2++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(zzaVar.zzjb);
            default:
                zzbg.a("Failed to convert a value of type: " + zzaVar.type);
                return f2238a;
        }
    }

    private static boolean d(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof zzde) && ((zzde) obj).zzDM());
    }

    private static boolean e(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof zzde) && ((zzde) obj).zzDN());
    }

    private static long f(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzbg.a("getInt64 received non-Number");
        return 0L;
    }
}
