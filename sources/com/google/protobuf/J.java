package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MessageLiteToString.java */
/* loaded from: classes2.dex */
public final class J {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(messageLite, sb, 0);
        return sb.toString();
    }

    private static void a(MessageLite messageLite, StringBuilder sb, int i) {
        boolean booleanValue;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        for (java.lang.reflect.Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String replaceFirst = ((String) it.next()).replaceFirst("get", "");
            if (replaceFirst.endsWith("List") && !replaceFirst.endsWith("OrBuilderList")) {
                String str = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1, replaceFirst.length() - 4);
                java.lang.reflect.Method method2 = (java.lang.reflect.Method) hashMap.get("get" + replaceFirst);
                if (method2 != null) {
                    a(sb, i, a(str), GeneratedMessageLite.a(method2, messageLite, new Object[0]));
                }
            }
            if (((java.lang.reflect.Method) hashMap2.get("set" + replaceFirst)) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst.substring(0, replaceFirst.length() - 5))) {
                    }
                }
                String str2 = replaceFirst.substring(0, 1).toLowerCase() + replaceFirst.substring(1);
                java.lang.reflect.Method method3 = (java.lang.reflect.Method) hashMap.get("get" + replaceFirst);
                java.lang.reflect.Method method4 = (java.lang.reflect.Method) hashMap.get("has" + replaceFirst);
                if (method3 != null) {
                    Object a2 = GeneratedMessageLite.a(method3, messageLite, new Object[0]);
                    if (method4 == null) {
                        booleanValue = !a(a2);
                    } else {
                        booleanValue = ((Boolean) GeneratedMessageLite.a(method4, messageLite, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        a(sb, i, a(str2), a2);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.a, Object>> d2 = ((GeneratedMessageLite.ExtendableMessage) messageLite).f18591d.d();
            while (d2.hasNext()) {
                Map.Entry<GeneratedMessageLite.a, Object> next = d2.next();
                a(sb, i, "[" + next.getKey().getNumber() + "]", next.getValue());
            }
        }
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) messageLite).f18583b;
        if (unknownFieldSetLite != null) {
            unknownFieldSetLite.a(sb, i);
        }
    }

    private static boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d;
        }
        if (obj instanceof String) {
            return obj.equals("");
        }
        if (obj instanceof ByteString) {
            return obj.equals(ByteString.EMPTY);
        }
        return obj instanceof MessageLite ? obj == ((MessageLite) obj).a() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
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
        sb.append('\n');
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(aa.a((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(aa.a((ByteString) obj));
            sb.append('\"');
        } else {
            if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                a((GeneratedMessageLite) obj, sb, i + 2);
                sb.append("\n");
                for (int i3 = 0; i3 < i; i3++) {
                    sb.append(' ');
                }
                sb.append("}");
                return;
            }
            sb.append(": ");
            sb.append(obj.toString());
        }
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
}
