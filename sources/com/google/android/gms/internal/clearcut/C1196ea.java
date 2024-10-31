package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.ea, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1196ea {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzdo zzdoVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(zzdoVar, sb, 0);
        return sb.toString();
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0226, code lost:            if (((java.lang.Double) r11).doubleValue() == 0.0d) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f2, code lost:            if (((java.lang.Boolean) r11).booleanValue() == false) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f4, code lost:            r7 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0203, code lost:            if (((java.lang.Integer) r11).intValue() == 0) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0214, code lost:            if (((java.lang.Float) r11).floatValue() == 0.0f) goto L80;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.google.android.gms.internal.clearcut.zzdo r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.C1196ea.a(com.google.android.gms.internal.clearcut.zzdo, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(Da.a(zzbb.zzf((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbb) {
            sb.append(": \"");
            sb.append(Da.a((zzbb) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzcg) {
            sb.append(" {");
            a((zzcg) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i + 2;
        a(sb, i4, "key", entry.getKey());
        a(sb, i4, "value", entry.getValue());
        sb.append("\n");
        while (i2 < i) {
            sb.append(' ');
            i2++;
        }
        sb.append("}");
    }
}
