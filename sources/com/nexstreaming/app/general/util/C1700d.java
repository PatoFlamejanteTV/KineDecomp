package com.nexstreaming.app.general.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CSVReader.java */
/* renamed from: com.nexstreaming.app.general.util.d */
/* loaded from: classes2.dex */
public class C1700d {

    /* renamed from: a */
    private Reader f19859a;

    /* renamed from: b */
    private int f19860b = 16;

    /* renamed from: c */
    private boolean f19861c = false;

    /* renamed from: d */
    private int f19862d = 0;

    /* renamed from: e */
    private int f19863e = 0;

    public C1700d(InputStream inputStream) {
        this.f19859a = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void a() throws IOException {
        this.f19859a.close();
    }

    public List<String> b() throws IOException {
        if (this.f19861c) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f19860b);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            int read = this.f19859a.read();
            if (read < 0) {
                this.f19861c = true;
                if (z) {
                    return null;
                }
            } else if (read == 10 && this.f19862d == 13) {
                this.f19862d = read;
            } else if (read != 13 && read != 10) {
                int i = this.f19863e;
                if (i != 0) {
                    if (read == i) {
                        this.f19863e = 0;
                    } else {
                        sb.append((char) read);
                    }
                } else if (read == 34) {
                    this.f19863e = read;
                    if (this.f19862d == this.f19863e) {
                        sb.append((char) read);
                    }
                } else if (read == 44) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append((char) read);
                }
                this.f19862d = read;
                z = false;
            } else {
                this.f19862d = read;
                if (this.f19863e == 0) {
                    break;
                }
                sb.append('\n');
            }
        }
        arrayList.add(sb.toString());
        if (arrayList.size() > this.f19860b) {
            this.f19860b = arrayList.size();
        }
        return arrayList;
    }
}
