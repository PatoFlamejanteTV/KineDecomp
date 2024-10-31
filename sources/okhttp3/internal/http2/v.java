package okhttp3.internal.http2;

import android.support.v4.internal.view.SupportMenu;
import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes3.dex */
public final class v {

    /* renamed from: a */
    private int f29156a;

    /* renamed from: b */
    private final int[] f29157b = new int[10];

    public void a() {
        this.f29156a = 0;
        Arrays.fill(this.f29157b, 0);
    }

    public int b() {
        if ((this.f29156a & 2) != 0) {
            return this.f29157b[1];
        }
        return -1;
    }

    public int c(int i) {
        return (this.f29156a & 32) != 0 ? this.f29157b[5] : i;
    }

    public boolean d(int i) {
        return ((1 << i) & this.f29156a) != 0;
    }

    public int b(int i) {
        return (this.f29156a & 16) != 0 ? this.f29157b[4] : i;
    }

    public int c() {
        return (this.f29156a & 128) != 0 ? this.f29157b[7] : SupportMenu.USER_MASK;
    }

    public int d() {
        return Integer.bitCount(this.f29156a);
    }

    public v a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f29157b;
            if (i < iArr.length) {
                this.f29156a = (1 << i) | this.f29156a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public int a(int i) {
        return this.f29157b[i];
    }

    public void a(v vVar) {
        for (int i = 0; i < 10; i++) {
            if (vVar.d(i)) {
                a(i, vVar.a(i));
            }
        }
    }
}
