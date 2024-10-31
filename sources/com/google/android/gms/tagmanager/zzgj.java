package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzgj {

    /* renamed from: a */
    private static Long f14252a = new Long(0);

    /* renamed from: b */
    private static Double f14253b = new Double(0.0d);

    /* renamed from: c */
    private static zzgi f14254c = zzgi.zzm(0);

    /* renamed from: d */
    private static String f14255d = new String("");

    /* renamed from: e */
    private static Boolean f14256e = new Boolean(false);

    /* renamed from: f */
    private static List<Object> f14257f = new ArrayList(0);

    /* renamed from: g */
    private static Map<Object, Object> f14258g = new HashMap();

    /* renamed from: h */
    private static zzl f14259h = a(f14255d);

    public static zzl a() {
        return f14259h;
    }

    private static String b(Object obj) {
        return obj == null ? f14255d : obj.toString();
    }

    private static boolean c(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).zzju();
    }

    private static boolean d(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).zzjv();
    }

    private static long e(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdi.c("getInt64 received non-Number");
        return 0L;
    }

    public static String a(zzl zzlVar) {
        return b(b(zzlVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:            return null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(com.google.android.gms.internal.gtm.zzl r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            int r1 = r6.type
            r2 = 0
            switch(r1) {
                case 1: goto Lc8;
                case 2: goto Lab;
                case 3: goto L5f;
                case 4: goto L59;
                case 5: goto L53;
                case 6: goto L4c;
                case 7: goto L28;
                case 8: goto L21;
                default: goto La;
            }
        La:
            r6 = 46
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r6)
            java.lang.String r6 = "Failed to convert a value of type: "
            r2.append(r6)
            r2.append(r1)
            java.lang.String r6 = r2.toString()
            com.google.android.gms.tagmanager.zzdi.c(r6)
            return r0
        L21:
            boolean r6 = r6.zzqt
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            return r6
        L28:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            com.google.android.gms.internal.gtm.zzl[] r6 = r6.zzqu
            int r3 = r6.length
        L30:
            if (r2 >= r3) goto L47
            r4 = r6[r2]
            java.lang.Object r4 = b(r4)
            java.lang.String r4 = b(r4)
            java.lang.String r5 = com.google.android.gms.tagmanager.zzgj.f14255d
            if (r4 != r5) goto L41
            return r0
        L41:
            r1.append(r4)
            int r2 = r2 + 1
            goto L30
        L47:
            java.lang.String r6 = r1.toString()
            return r6
        L4c:
            long r0 = r6.zzqs
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
            return r6
        L53:
            java.lang.String r6 = "Trying to convert a function id to object"
            com.google.android.gms.tagmanager.zzdi.c(r6)
            return r0
        L59:
            java.lang.String r6 = "Trying to convert a macro reference to object"
            com.google.android.gms.tagmanager.zzdi.c(r6)
            return r0
        L5f:
            com.google.android.gms.internal.gtm.zzl[] r1 = r6.zzqo
            int r1 = r1.length
            com.google.android.gms.internal.gtm.zzl[] r3 = r6.zzqp
            int r4 = r3.length
            if (r1 == r4) goto L85
            java.lang.String r1 = "Converting an invalid value to object: "
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r2 = r6.length()
            if (r2 == 0) goto L7c
            java.lang.String r6 = r1.concat(r6)
            goto L81
        L7c:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1)
        L81:
            com.google.android.gms.tagmanager.zzdi.c(r6)
            return r0
        L85:
            java.util.HashMap r1 = new java.util.HashMap
            int r3 = r3.length
            r1.<init>(r3)
        L8b:
            com.google.android.gms.internal.gtm.zzl[] r3 = r6.zzqo
            int r4 = r3.length
            if (r2 >= r4) goto Laa
            r3 = r3[r2]
            java.lang.Object r3 = b(r3)
            com.google.android.gms.internal.gtm.zzl[] r4 = r6.zzqp
            r4 = r4[r2]
            java.lang.Object r4 = b(r4)
            if (r3 == 0) goto La9
            if (r4 != 0) goto La3
            goto La9
        La3:
            r1.put(r3, r4)
            int r2 = r2 + 1
            goto L8b
        La9:
            return r0
        Laa:
            return r1
        Lab:
            java.util.ArrayList r1 = new java.util.ArrayList
            com.google.android.gms.internal.gtm.zzl[] r3 = r6.zzqn
            int r3 = r3.length
            r1.<init>(r3)
            com.google.android.gms.internal.gtm.zzl[] r6 = r6.zzqn
            int r3 = r6.length
        Lb6:
            if (r2 >= r3) goto Lc7
            r4 = r6[r2]
            java.lang.Object r4 = b(r4)
            if (r4 != 0) goto Lc1
            return r0
        Lc1:
            r1.add(r4)
            int r2 = r2 + 1
            goto Lb6
        Lc7:
            return r1
        Lc8:
            java.lang.String r6 = r6.string
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzgj.b(com.google.android.gms.internal.gtm.zzl):java.lang.Object");
    }

    public static zzl a(Object obj) {
        zzl zzlVar = new zzl();
        if (obj instanceof zzl) {
            return (zzl) obj;
        }
        boolean z = false;
        if (obj instanceof String) {
            zzlVar.type = 1;
            zzlVar.string = (String) obj;
        } else if (obj instanceof List) {
            zzlVar.type = 2;
            List list = (List) obj;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                zzl a2 = a(it.next());
                zzl zzlVar2 = f14259h;
                if (a2 == zzlVar2) {
                    return zzlVar2;
                }
                z2 = z2 || a2.zzqw;
                arrayList.add(a2);
            }
            zzlVar.zzqn = (zzl[]) arrayList.toArray(new zzl[0]);
            z = z2;
        } else if (obj instanceof Map) {
            zzlVar.type = 3;
            Set<Map.Entry> entrySet = ((Map) obj).entrySet();
            ArrayList arrayList2 = new ArrayList(entrySet.size());
            ArrayList arrayList3 = new ArrayList(entrySet.size());
            boolean z3 = false;
            for (Map.Entry entry : entrySet) {
                zzl a3 = a(entry.getKey());
                zzl a4 = a(entry.getValue());
                zzl zzlVar3 = f14259h;
                if (a3 != zzlVar3 && a4 != zzlVar3) {
                    z3 = z3 || a3.zzqw || a4.zzqw;
                    arrayList2.add(a3);
                    arrayList3.add(a4);
                } else {
                    return f14259h;
                }
            }
            zzlVar.zzqo = (zzl[]) arrayList2.toArray(new zzl[0]);
            zzlVar.zzqp = (zzl[]) arrayList3.toArray(new zzl[0]);
            z = z3;
        } else if (c(obj)) {
            zzlVar.type = 1;
            zzlVar.string = obj.toString();
        } else if (d(obj)) {
            zzlVar.type = 6;
            zzlVar.zzqs = e(obj);
        } else if (obj instanceof Boolean) {
            zzlVar.type = 8;
            zzlVar.zzqt = ((Boolean) obj).booleanValue();
        } else {
            String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
            zzdi.c(valueOf.length() != 0 ? "Converting to Value from unknown object type: ".concat(valueOf) : new String("Converting to Value from unknown object type: "));
            return f14259h;
        }
        zzlVar.zzqw = z;
        return zzlVar;
    }
}
