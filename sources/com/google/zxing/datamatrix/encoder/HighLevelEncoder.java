package com.google.zxing.datamatrix.encoder;

import android.support.v7.widget.ActivityChooserView;
import com.google.zxing.Dimension;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class HighLevelEncoder {
    private HighLevelEncoder() {
    }

    private static char a(char c2, int i) {
        int i2 = c2 + ((i * 149) % 253) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    public static boolean b(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean c(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    private static boolean d(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean e(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    private static boolean f(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean g(char c2) {
        if (i(c2) || c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean h(char c2) {
        return false;
    }

    private static boolean i(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static String a(String str, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2) {
        int i = 0;
        f[] fVarArr = {new a(), new c(), new h(), new i(), new e(), new b()};
        g gVar = new g(str);
        gVar.a(symbolShapeHint);
        gVar.a(dimension, dimension2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            gVar.a((char) 236);
            gVar.a(2);
            gVar.f19127f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            gVar.a((char) 237);
            gVar.a(2);
            gVar.f19127f += 7;
        }
        while (gVar.h()) {
            fVarArr[i].a(gVar);
            if (gVar.e() >= 0) {
                i = gVar.e();
                gVar.i();
            }
        }
        int a2 = gVar.a();
        gVar.k();
        int a3 = gVar.g().a();
        if (a2 < a3 && i != 0 && i != 5) {
            gVar.a((char) 254);
        }
        StringBuilder b2 = gVar.b();
        if (b2.length() < a3) {
            b2.append((char) 129);
        }
        while (b2.length() < a3) {
            b2.append(a((char) 129, b2.length() + 1));
        }
        return gVar.b().toString();
    }

    public static int a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        char c2;
        if (i >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int a2 = a(fArr, iArr, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr);
                int a3 = a(bArr);
                if (iArr[0] == a2) {
                    return 0;
                }
                if (a3 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (a3 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (a3 != 1 || bArr[2] <= 0) {
                    return (a3 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence.charAt(i4);
            i3++;
            if (b(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (c(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (d(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (c(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (c(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (g(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (c(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (e(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (c(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (h(charAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i3 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, bArr2);
                int a4 = a(bArr2);
                if (iArr2[0] < iArr2[c2] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (a4 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (a4 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (a4 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i5 = i + i3 + 1; i5 < charSequence.length(); i5++) {
                            char charAt2 = charSequence.charAt(i5);
                            if (i(charAt2)) {
                                return 3;
                            }
                            if (!g(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil(fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (b(charAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    public static void a(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
