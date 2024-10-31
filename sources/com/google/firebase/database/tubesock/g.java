package com.google.firebase.database.tubesock;

import android.util.Base64;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a */
    private URI f17248a;

    /* renamed from: b */
    private String f17249b;

    /* renamed from: c */
    private String f17250c;

    /* renamed from: d */
    private Map<String, String> f17251d;

    public g(URI uri, String str, Map<String, String> map) {
        this.f17248a = null;
        this.f17249b = null;
        this.f17250c = null;
        this.f17251d = null;
        this.f17248a = uri;
        this.f17249b = str;
        this.f17251d = map;
        this.f17250c = b();
    }

    private String b() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) a(0, 255);
        }
        return Base64.encodeToString(bArr, 2);
    }

    public byte[] a() {
        String path = this.f17248a.getPath();
        String query = this.f17248a.getQuery();
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        sb.append(query == null ? "" : "?" + query);
        String sb2 = sb.toString();
        String host = this.f17248a.getHost();
        if (this.f17248a.getPort() != -1) {
            host = host + ":" + this.f17248a.getPort();
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.f17250c);
        String str = this.f17249b;
        if (str != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", str);
        }
        Map<String, String> map = this.f17251d;
        if (map != null) {
            for (String str2 : map.keySet()) {
                if (!linkedHashMap.containsKey(str2)) {
                    linkedHashMap.put(str2, this.f17251d.get(str2));
                }
            }
        }
        byte[] bytes = ((("GET " + sb2 + " HTTP/1.1\r\n") + a(linkedHashMap)) + "\r\n").getBytes(Charset.defaultCharset());
        byte[] bArr = new byte[bytes.length];
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return bArr;
    }

    private String a(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        for (String str2 : linkedHashMap.keySet()) {
            str = str + str2 + ": " + linkedHashMap.get(str2) + "\r\n";
        }
        return str;
    }

    public void a(String str) {
        int parseInt = Integer.parseInt(str.substring(9, 12));
        if (parseInt == 407) {
            throw new WebSocketException("connection failed: proxy authentication not supported");
        }
        if (parseInt == 404) {
            throw new WebSocketException("connection failed: 404 not found");
        }
        if (parseInt == 101) {
            return;
        }
        throw new WebSocketException("connection failed: unknown status code " + parseInt);
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap.get("Upgrade").toLowerCase(Locale.US).equals("websocket")) {
            if (!hashMap.get("Connection").toLowerCase(Locale.US).equals("upgrade")) {
                throw new WebSocketException("connection failed: missing header field in server handshake: Connection");
            }
            return;
        }
        throw new WebSocketException("connection failed: missing header field in server handshake: Upgrade");
    }

    private int a(int i, int i2) {
        double random = Math.random();
        double d2 = i2;
        Double.isNaN(d2);
        double d3 = i;
        Double.isNaN(d3);
        return (int) ((random * d2) + d3);
    }
}
