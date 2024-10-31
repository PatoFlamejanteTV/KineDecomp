package com.google.zxing.datamatrix.encoder;

/* compiled from: ASCIIEncoder.java */
/* loaded from: classes2.dex */
public final class a implements f {
    public int a() {
        return 0;
    }

    @Override // com.google.zxing.datamatrix.encoder.f
    public void a(g gVar) {
        if (HighLevelEncoder.a(gVar.d(), gVar.f19127f) >= 2) {
            gVar.a(a(gVar.d().charAt(gVar.f19127f), gVar.d().charAt(gVar.f19127f + 1)));
            gVar.f19127f += 2;
            return;
        }
        char c2 = gVar.c();
        int a2 = HighLevelEncoder.a(gVar.d(), gVar.f19127f, a());
        if (a2 == a()) {
            if (HighLevelEncoder.c(c2)) {
                gVar.a((char) 235);
                gVar.a((char) ((c2 - 128) + 1));
                gVar.f19127f++;
                return;
            } else {
                gVar.a((char) (c2 + 1));
                gVar.f19127f++;
                return;
            }
        }
        if (a2 == 1) {
            gVar.a((char) 230);
            gVar.b(1);
            return;
        }
        if (a2 == 2) {
            gVar.a((char) 239);
            gVar.b(2);
            return;
        }
        if (a2 == 3) {
            gVar.a((char) 238);
            gVar.b(3);
        } else if (a2 == 4) {
            gVar.a((char) 240);
            gVar.b(4);
        } else if (a2 == 5) {
            gVar.a((char) 231);
            gVar.b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + a2);
        }
    }

    private static char a(char c2, char c3) {
        if (HighLevelEncoder.b(c2) && HighLevelEncoder.b(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }
}
