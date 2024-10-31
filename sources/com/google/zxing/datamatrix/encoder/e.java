package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EdifactEncoder.java */
/* loaded from: classes2.dex */
public final class e implements f {
    public int a() {
        return 4;
    }

    @Override // com.google.zxing.datamatrix.encoder.f
    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.h()) {
                break;
            }
            a(gVar.c(), sb);
            gVar.f19127f++;
            if (sb.length() >= 4) {
                gVar.a(a(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.a(gVar.d(), gVar.f19127f, a()) != a()) {
                    gVar.b(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        a(gVar, sb);
    }

    private static void a(g gVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                gVar.k();
                int a2 = gVar.g().a() - gVar.a();
                if (gVar.f() == 0 && a2 <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i = length - 1;
                String a3 = a(charSequence, 0);
                if (!(!gVar.h()) || i > 2) {
                    z = false;
                }
                if (i <= 2) {
                    gVar.c(gVar.a() + i);
                    if (gVar.g().a() - gVar.a() >= 3) {
                        gVar.c(gVar.a() + a3.length());
                        z = false;
                    }
                }
                if (z) {
                    gVar.j();
                    gVar.f19127f -= i;
                } else {
                    gVar.a(a3);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            gVar.b(0);
        }
    }

    private static void a(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            HighLevelEncoder.a(c2);
            throw null;
        }
    }

    private static String a(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length != 0) {
            int charAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
            char c2 = (char) ((charAt >> 16) & 255);
            char c3 = (char) ((charAt >> 8) & 255);
            char c4 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append(c2);
            if (length >= 2) {
                sb.append(c3);
            }
            if (length >= 3) {
                sb.append(c4);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }
}
