package android.support.v7.widget;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;

    /* renamed from: a */
    private int f2990a = 0;

    /* renamed from: b */
    private int f2991b = 0;

    /* renamed from: c */
    private int f2992c = Integer.MIN_VALUE;

    /* renamed from: d */
    private int f2993d = Integer.MIN_VALUE;

    /* renamed from: e */
    private int f2994e = 0;

    /* renamed from: f */
    private int f2995f = 0;

    /* renamed from: g */
    private boolean f2996g = false;

    /* renamed from: h */
    private boolean f2997h = false;

    public int getEnd() {
        return this.f2996g ? this.f2990a : this.f2991b;
    }

    public int getLeft() {
        return this.f2990a;
    }

    public int getRight() {
        return this.f2991b;
    }

    public int getStart() {
        return this.f2996g ? this.f2991b : this.f2990a;
    }

    public void setAbsolute(int i, int i2) {
        this.f2997h = false;
        if (i != Integer.MIN_VALUE) {
            this.f2994e = i;
            this.f2990a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2995f = i2;
            this.f2991b = i2;
        }
    }

    public void setDirection(boolean z) {
        if (z == this.f2996g) {
            return;
        }
        this.f2996g = z;
        if (!this.f2997h) {
            this.f2990a = this.f2994e;
            this.f2991b = this.f2995f;
            return;
        }
        if (z) {
            int i = this.f2993d;
            if (i == Integer.MIN_VALUE) {
                i = this.f2994e;
            }
            this.f2990a = i;
            int i2 = this.f2992c;
            if (i2 == Integer.MIN_VALUE) {
                i2 = this.f2995f;
            }
            this.f2991b = i2;
            return;
        }
        int i3 = this.f2992c;
        if (i3 == Integer.MIN_VALUE) {
            i3 = this.f2994e;
        }
        this.f2990a = i3;
        int i4 = this.f2993d;
        if (i4 == Integer.MIN_VALUE) {
            i4 = this.f2995f;
        }
        this.f2991b = i4;
    }

    public void setRelative(int i, int i2) {
        this.f2992c = i;
        this.f2993d = i2;
        this.f2997h = true;
        if (this.f2996g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f2990a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f2991b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f2990a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f2991b = i2;
        }
    }
}
