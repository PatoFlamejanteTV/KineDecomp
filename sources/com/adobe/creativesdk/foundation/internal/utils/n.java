package com.adobe.creativesdk.foundation.internal.utils;

import android.util.Base64;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: AdobeNetworkUtils.java */
/* loaded from: classes.dex */
public class n {
    public static Map<String, List<String>> a(Map<String, List<String>> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < value.size(); i++) {
                arrayList.add(b(value.get(i)));
            }
            if (key != null) {
                hashMap.put(key.toLowerCase(), arrayList);
            }
        }
        return hashMap;
    }

    public static String b(String str) {
        if (str == null || !str.startsWith("=?") || !str.endsWith("?=")) {
            return str;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length < 4) {
            return str;
        }
        String str2 = split[3];
        String str3 = split[2];
        if (!split[1].startsWith("utf-8")) {
            return str;
        }
        if (str3.startsWith("b")) {
            return new String(Base64.decode(str2, 0), org.apache.commons.io.a.f29306f);
        }
        return str3.startsWith("q") ? new String(str2.getBytes(org.apache.commons.io.a.f29306f), org.apache.commons.io.a.f29306f) : str;
    }

    public static Map<String, List<String>> c(String str) {
        String[] split = str.split("\r\n");
        HashMap hashMap = new HashMap(split.length);
        Pattern compile = Pattern.compile("^([^:]+):(.*)$");
        String str2 = null;
        for (String str3 : split) {
            if (str3.length() != 0) {
                char charAt = str3.charAt(0);
                if (str2 != null && (charAt == '\t' || charAt == ' ')) {
                    String str4 = hashMap.get(str2) != null ? (String) ((List) hashMap.get(str2)).get(0) : null;
                    if (str4 != null) {
                        String concat = str4.concat(String.format(",%s", str3.trim()));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(concat);
                        hashMap.put(str2, arrayList);
                    }
                } else {
                    Matcher matcher = compile.matcher(str3);
                    if (matcher != null && matcher.find() && matcher.groupCount() == 2) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        String str5 = hashMap.get(group) != null ? (String) ((List) hashMap.get(group)).get(0) : null;
                        if (str5 != null) {
                            String concat2 = str5.concat(String.format(",%s", group2));
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(concat2);
                            hashMap.put(group, arrayList2);
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(group2);
                            hashMap.put(group, arrayList3);
                        }
                        str2 = group;
                    } else {
                        str2 = null;
                    }
                }
            }
        }
        return a(hashMap);
    }

    public static String a() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    static int a(String str) {
        if (str.toLowerCase().equals("http")) {
            return 80;
        }
        return str.toLowerCase().equals("https") ? 443 : -1;
    }

    public static boolean b(URI uri, URI uri2) {
        if (uri == null || uri2 == null) {
            return true;
        }
        String host = uri.getHost();
        String host2 = uri2.getHost();
        if (host == null || host2 == null) {
            return false;
        }
        return !a(uri, uri2);
    }

    static boolean a(URI uri, URI uri2) {
        if (uri2 == null || uri == null) {
            return false;
        }
        if (uri2.equals(uri)) {
            return true;
        }
        String host = uri2.getHost();
        String host2 = uri.getHost();
        if (host == null) {
            return false;
        }
        if (host2 == null) {
            return true;
        }
        if (!host.toLowerCase().equals(host2.toLowerCase())) {
            return false;
        }
        String scheme = uri2.getScheme();
        if (scheme == null) {
            scheme = "http";
        }
        String scheme2 = uri.getScheme();
        String str = scheme2 != null ? scheme2 : "http";
        int port = uri2.getPort();
        if (port == -1) {
            port = a(scheme);
        }
        int port2 = uri.getPort();
        if (port2 == -1) {
            port2 = a(str);
        }
        return port == port2 && scheme.toLowerCase().equals(str.toLowerCase());
    }
}
