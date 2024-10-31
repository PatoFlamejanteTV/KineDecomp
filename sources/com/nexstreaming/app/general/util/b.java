package com.nexstreaming.app.general.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CSVReader.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Reader f3225a;
    private int b = 16;
    private boolean c = false;
    private int d = 0;
    private int e = 0;

    public b(InputStream inputStream) {
        this.f3225a = new BufferedReader(new InputStreamReader(inputStream));
    }

    public List<String> a() throws IOException {
        if (this.c) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.b);
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        while (true) {
            int read = this.f3225a.read();
            if (read < 0) {
                this.c = true;
                if (z) {
                    return null;
                }
            } else if (read == 10 && this.d == 13) {
                this.d = read;
            } else if (read == 13 || read == 10) {
                this.d = read;
                if (this.e == 0) {
                    break;
                }
                sb.append('\n');
            } else {
                if (this.e != 0) {
                    if (read == this.e) {
                        this.e = 0;
                    } else {
                        sb.append((char) read);
                    }
                } else if (read == 34) {
                    this.e = read;
                    if (this.d == this.e) {
                        sb.append((char) read);
                    }
                } else if (read == 44) {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append((char) read);
                }
                this.d = read;
                z = false;
            }
        }
        arrayList.add(sb.toString());
        if (arrayList.size() > this.b) {
            this.b = arrayList.size();
        }
        return arrayList;
    }

    public void b() throws IOException {
        this.f3225a.close();
    }
}
