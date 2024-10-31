package com.nexstreaming.app.general.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CSVReaderV2.java */
/* renamed from: com.nexstreaming.app.general.util.e */
/* loaded from: classes2.dex */
public class C1701e {

    /* renamed from: a */
    private BufferedReader f19864a;

    /* renamed from: b */
    private int f19865b = 16;

    /* renamed from: c */
    private boolean f19866c = false;

    public C1701e(InputStream inputStream) {
        this.f19864a = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void a() throws IOException {
        this.f19864a.close();
    }

    public Map<String, String> b() throws IOException {
        if (this.f19866c) {
            return null;
        }
        HashMap hashMap = new HashMap();
        this.f19864a.readLine();
        while (true) {
            String readLine = this.f19864a.readLine();
            if (readLine != null) {
                int indexOf = readLine.indexOf(44);
                String substring = readLine.substring(0, indexOf);
                hashMap.put(substring.toLowerCase(), readLine.substring(indexOf + 1, readLine.length()));
            } else {
                this.f19866c = true;
                return hashMap;
            }
        }
    }
}
