package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NameValueBlockReader.java */
/* loaded from: classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final okio.o f25404a;

    /* renamed from: b, reason: collision with root package name */
    private int f25405b;

    /* renamed from: c, reason: collision with root package name */
    private final okio.i f25406c;

    public w(okio.i iVar) {
        this.f25404a = new okio.o(new u(this, iVar), new v(this));
        this.f25406c = okio.s.a(this.f25404a);
    }

    private void b() throws IOException {
        if (this.f25405b > 0) {
            this.f25404a.a();
            if (this.f25405b == 0) {
                return;
            }
            throw new IOException("compressedLimit > 0: " + this.f25405b);
        }
    }

    private ByteString c() throws IOException {
        return this.f25406c.e(this.f25406c.readInt());
    }

    public List<q> a(int i) throws IOException {
        this.f25405b += i;
        int readInt = this.f25406c.readInt();
        if (readInt < 0) {
            throw new IOException("numberOfPairs < 0: " + readInt);
        }
        if (readInt <= 1024) {
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                ByteString asciiLowercase = c().toAsciiLowercase();
                ByteString c2 = c();
                if (asciiLowercase.size() != 0) {
                    arrayList.add(new q(asciiLowercase, c2));
                } else {
                    throw new IOException("name.size == 0");
                }
            }
            b();
            return arrayList;
        }
        throw new IOException("numberOfPairs > 1024: " + readInt);
    }

    public void a() throws IOException {
        this.f25406c.close();
    }
}
