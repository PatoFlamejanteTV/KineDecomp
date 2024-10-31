package com.google.api.client.http;

import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import com.google.common.base.Splitter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class UriTemplate {

    /* renamed from: a, reason: collision with root package name */
    static final Map<Character, CompositeOutput> f14799a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            Preconditions.a(str);
            this.outputPrefix = str;
            Preconditions.a(str2);
            this.explodeJoiner = str2;
            this.requiresVarAssignment = z;
            this.reservedExpansion = z2;
            if (ch != null) {
                UriTemplate.f14799a.put(ch, this);
            }
        }

        String getEncodedValue(String str) {
            if (this.reservedExpansion) {
                return CharEscapers.c(str);
            }
            return CharEscapers.b(str);
        }

        String getExplodeJoiner() {
            return this.explodeJoiner;
        }

        String getOutputPrefix() {
            return this.outputPrefix;
        }

        boolean getReservedExpansion() {
            return this.reservedExpansion;
        }

        int getVarNameStartIndex() {
            return this.propertyPrefix == null ? 0 : 1;
        }

        boolean requiresVarAssignment() {
            return this.requiresVarAssignment;
        }
    }

    static {
        CompositeOutput.values();
    }

    static CompositeOutput a(String str) {
        CompositeOutput compositeOutput = f14799a.get(Character.valueOf(str.charAt(0)));
        return compositeOutput == null ? CompositeOutput.SIMPLE : compositeOutput;
    }

    private static Map<String, Object> a(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.d(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.b(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    public static String a(String str, String str2, Object obj, boolean z) {
        if (str2.startsWith("/")) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.b(null);
            str2 = genericUrl.build() + str2;
        } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            str2 = str + str2;
        }
        return a(str2, obj, z);
    }

    public static String a(String str, Object obj, boolean z) {
        Object a2;
        Map<String, Object> a3 = a(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int indexOf = str.indexOf(123, i);
            if (indexOf != -1) {
                sb.append(str.substring(i, indexOf));
                int indexOf2 = str.indexOf(125, indexOf + 2);
                int i2 = indexOf2 + 1;
                String substring = str.substring(indexOf + 1, indexOf2);
                CompositeOutput a4 = a(substring);
                ListIterator<String> listIterator = Splitter.a(',').b(substring).listIterator();
                boolean z2 = true;
                while (listIterator.hasNext()) {
                    String next = listIterator.next();
                    boolean endsWith = next.endsWith("*");
                    int varNameStartIndex = listIterator.nextIndex() == 1 ? a4.getVarNameStartIndex() : 0;
                    int length2 = next.length();
                    if (endsWith) {
                        length2--;
                    }
                    String substring2 = next.substring(varNameStartIndex, length2);
                    Object remove = a3.remove(substring2);
                    if (remove != null) {
                        if (!z2) {
                            sb.append(a4.getExplodeJoiner());
                        } else {
                            sb.append(a4.getOutputPrefix());
                            z2 = false;
                        }
                        if (remove instanceof Iterator) {
                            a2 = a(substring2, (Iterator<?>) remove, endsWith, a4);
                        } else if (!(remove instanceof Iterable) && !remove.getClass().isArray()) {
                            if (remove.getClass().isEnum()) {
                                if (FieldInfo.a((Enum<?>) remove).d() != null) {
                                    if (a4.requiresVarAssignment()) {
                                        remove = String.format("%s=%s", substring2, remove);
                                    }
                                    remove = CharEscapers.c(remove.toString());
                                }
                                a2 = remove;
                            } else if (!Data.c(remove)) {
                                a2 = a(substring2, a(remove), endsWith, a4);
                            } else {
                                if (a4.requiresVarAssignment()) {
                                    remove = String.format("%s=%s", substring2, remove);
                                }
                                if (a4.getReservedExpansion()) {
                                    a2 = CharEscapers.d(remove.toString());
                                } else {
                                    a2 = CharEscapers.c(remove.toString());
                                }
                            }
                        } else {
                            a2 = a(substring2, (Iterator<?>) Types.a(remove).iterator(), endsWith, a4);
                        }
                        sb.append(a2);
                    }
                }
                i = i2;
            } else {
                if (i == 0 && !z) {
                    return str;
                }
                sb.append(str.substring(i));
            }
        }
        if (z) {
            GenericUrl.a(a3.entrySet(), sb);
        }
        return sb.toString();
    }

    private static String a(String str, Iterator<?> it, boolean z, CompositeOutput compositeOutput) {
        String str2;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            str2 = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.c(str));
                sb.append("=");
            }
            str2 = ",";
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
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str2 = "=";
        String str3 = ",";
        if (z) {
            str3 = compositeOutput.getExplodeJoiner();
        } else {
            if (compositeOutput.requiresVarAssignment()) {
                sb.append(CharEscapers.c(str));
                sb.append("=");
            }
            str2 = ",";
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
