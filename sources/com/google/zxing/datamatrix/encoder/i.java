package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: X12Encoder.java */
/* loaded from: classes2.dex */
public final class i extends c {
    @Override // com.google.zxing.datamatrix.encoder.c
    public int a() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.f
    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.h()) {
                break;
            }
            char c2 = gVar.c();
            gVar.f19127f++;
            a(c2, sb);
            if (sb.length() % 3 == 0) {
                c.b(gVar, sb);
                int a2 = HighLevelEncoder.a(gVar.d(), gVar.f19127f, a());
                if (a2 != a()) {
                    gVar.b(a2);
                    break;
                }
            }
        }
        a(gVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int a(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
        } else {
            HighLevelEncoder.a(c2);
            throw null;
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void a(g gVar, StringBuilder sb) {
        gVar.k();
        int a2 = gVar.g().a() - gVar.a();
        gVar.f19127f -= sb.length();
        if (gVar.f() > 1 || a2 > 1 || gVar.f() != a2) {
            gVar.a((char) 254);
        }
        if (gVar.e() < 0) {
            gVar.b(0);
        }
    }
}
