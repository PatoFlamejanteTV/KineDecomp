package com.google.zxing.datamatrix.encoder;

/* compiled from: C40Encoder.java */
/* loaded from: classes2.dex */
public class c implements f {
    public static void b(g gVar, StringBuilder sb) {
        gVar.a(a(sb, 0));
        sb.delete(0, 3);
    }

    public int a() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.f
    public void a(g gVar) {
        int a2;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.h()) {
                break;
            }
            char c2 = gVar.c();
            gVar.f19127f++;
            int a3 = a(c2, sb);
            int a4 = gVar.a() + ((sb.length() / 3) << 1);
            gVar.c(a4);
            int a5 = gVar.g().a() - a4;
            if (!gVar.h()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (a5 < 2 || a5 > 2)) {
                    a3 = a(gVar, sb, sb2, a3);
                }
                while (sb.length() % 3 == 1 && ((a3 <= 3 && a5 != 1) || a3 > 3)) {
                    a3 = a(gVar, sb, sb2, a3);
                }
            } else if (sb.length() % 3 == 0 && (a2 = HighLevelEncoder.a(gVar.d(), gVar.f19127f, a())) != a()) {
                gVar.b(a2);
                break;
            }
        }
        a(gVar, sb);
    }

    private int a(g gVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        gVar.f19127f--;
        int a2 = a(gVar.c(), sb2);
        gVar.j();
        return a2;
    }

    void a(g gVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int a2 = gVar.a() + length;
        gVar.c(a2);
        int a3 = gVar.g().a() - a2;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(gVar, sb);
            }
            if (gVar.h()) {
                gVar.a((char) 254);
            }
        } else if (a3 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(gVar, sb);
            }
            if (gVar.h()) {
                gVar.a((char) 254);
            }
            gVar.f19127f--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(gVar, sb);
            }
            if (a3 > 0 || gVar.h()) {
                gVar.a((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        gVar.b(0);
    }

    int a(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        }
        if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return a((char) (c2 - 128), sb) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c2);
    }

    private static String a(CharSequence charSequence, int i) {
        int charAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
