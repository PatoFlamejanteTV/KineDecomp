package com.google.zxing.client.result;

/* loaded from: classes2.dex */
public abstract class ParsedResult {
    public static void a(String str, StringBuilder sb) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append('\n');
        }
        sb.append(str);
    }

    public abstract String a();

    public final String toString() {
        return a();
    }

    public static void a(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                a(str, sb);
            }
        }
    }
}
