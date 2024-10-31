package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class UriTemplate {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Character, CompositeOutput> f2474a = new HashMap();

    static {
        CompositeOutput.values();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum CompositeOutput {
        PLUS('+', "", ",", false, true),
        HASH('#', "#", ",", false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH('/', "/", "/", false, false),
        SEMI_COLON(';', ";", ";", true, false),
        QUERY('?', "?", "&", true, false),
        AMP('&', "&", "&", true, false),
        SIMPLE(null, "", ",", false, false);

        private final String explodeJoiner;
        private final String outputPrefix;
        private final Character propertyPrefix;
        private final boolean requiresVarAssignment;
        private final boolean reservedExpansion;

        CompositeOutput(Character ch, String str, String str2, boolean z, boolean z2) {
            this.propertyPrefix = ch;
            this.outputPrefix = (String) Preconditions.a(str);
            this.explodeJoiner = (String) Preconditions.a(str2);
            this.requiresVarAssignment = z;
            this.reservedExpansion = z2;
            if (ch != null) {
                UriTemplate.f2474a.put(ch, this);
            }
        }

        String getOutputPrefix() {
            return this.outputPrefix;
        }

        String getExplodeJoiner() {
            return this.explodeJoiner;
        }

        boolean requiresVarAssignment() {
            return this.requiresVarAssignment;
        }

        int getVarNameStartIndex() {
            return this.propertyPrefix == null ? 0 : 1;
        }

        String getEncodedValue(String str) {
            if (this.reservedExpansion) {
                return CharEscapers.c(str);
            }
            return CharEscapers.a(str);
        }

        boolean getReservedExpansion() {
            return this.reservedExpansion;
        }
    }

    static CompositeOutput a(String str) {
        CompositeOutput compositeOutput = f2474a.get(Character.valueOf(str.charAt(0)));
        return compositeOutput == null ? CompositeOutput.SIMPLE : compositeOutput;
    }

    private static Map<String, Object> a(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.b(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.a(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    public static String a(String str, String str2, Object obj, boolean z) {
        String str3;
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.d(null);
            String valueOf = String.valueOf(genericUrl.j());
            String valueOf2 = String.valueOf(str2);
            str3 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else if (str2.startsWith("http://") || str2.startsWith("https://")) {
            str3 = str2;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(str2);
            str3 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
        return a(str3, obj, z);
    }

    public static String a(String str, Object obj, boolean z) {
        Map<String, Object> a2 = a(obj);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = str.length();
        while (true) {
            if (i >= length) {
                break;
            }
            int indexOf = str.indexOf(123, i);
            if (indexOf == -1) {
                if (i != 0 || z) {
                    sb.append(str.substring(i));
                } else {
                    return str;
                }
            } else {
                sb.append(str.substring(i, indexOf));
                int indexOf2 = str.indexOf(125, indexOf + 2);
                String substring = str.substring(indexOf + 1, indexOf2);
                int i2 = indexOf2 + 1;
                boolean endsWith = substring.endsWith("*");
                CompositeOutput a3 = a(substring);
                int varNameStartIndex = a3.getVarNameStartIndex();
                int length2 = substring.length();
                if (endsWith) {
                    length2--;
                }
                String substring2 = substring.substring(varNameStartIndex, length2);
                Object remove = a2.remove(substring2);
                if (remove == null) {
                    i = i2;
                } else {
                    if (remove instanceof Iterator) {
                        remove = a(substring2, (Iterator<?>) remove, endsWith, a3);
                    } else if ((remove instanceof Iterable) || remove.getClass().isArray()) {
                        remove = a(substring2, (Iterator<?>) Types.a(remove).iterator(), endsWith, a3);
                    } else if (remove.getClass().isEnum()) {
                        String b = FieldInfo.a((Enum<?>) remove).b();
                        if (b != null) {
                            remove = CharEscapers.c(b);
                        }
                    } else if (!Data.d(remove)) {
                        remove = a(substring2, a(remove), endsWith, a3);
                    } else if (a3.getReservedExpansion()) {
                        remove = CharEscapers.d(remove.toString());
                    } else {
                        remove = CharEscapers.c(remove.toString());
                    }
                    sb.append(remove);
                    i = i2;
                }
            }
        }
        if (z) {
            GenericUrl.a(a2.entrySet(), sb);
        }
        return sb.toString();
    }

    private static String a(String str, Iterator<?> it, boolean z, CompositeOutput compositeOutput) {
        String str2;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(compositeOutput.getOutputPrefix());
        if (z) {
            str2 = compositeOutput.getExplodeJoiner();
        } else {
            str2 = ",";
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.c(str));
                sb.append("=");
            }
        }
        while (it.hasNext()) {
            if (z && compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.c(str));
                sb.append("=");
            }
            sb.append(compositeOutput.getEncodedValue(it.next().toString()));
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    private static String a(String str, Map<String, Object> map, boolean z, CompositeOutput compositeOutput) {
        String str2;
        String str3;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(compositeOutput.getOutputPrefix());
        if (z) {
            str2 = "=";
            str3 = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.c(str));
                sb.append("=");
            }
            str2 = ",";
            str3 = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String encodedValue = compositeOutput.getEncodedValue(next.getKey());
            String encodedValue2 = compositeOutput.getEncodedValue(next.getValue().toString());
            sb.append(encodedValue);
            sb.append(str2);
            sb.append(encodedValue2);
            if (it.hasNext()) {
                sb.append(str3);
            }
        }
        return sb.toString();
    }
}
