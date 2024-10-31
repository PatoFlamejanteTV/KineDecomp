package kotlin.c;

import java.util.NoSuchElementException;
import kotlin.collections.v;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes3.dex */
public final class c extends v {

    /* renamed from: a */
    private final int f28503a;

    /* renamed from: b */
    private boolean f28504b;

    /* renamed from: c */
    private int f28505c;

    /* renamed from: d */
    private final int f28506d;

    public c(int i, int i2, int i3) {
        this.f28506d = i3;
        this.f28503a = i2;
        boolean z = true;
        if (this.f28506d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f28504b = z;
        this.f28505c = this.f28504b ? i : this.f28503a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f28504b;
    }

    @Override // kotlin.collections.v
    public int nextInt() {
        int i = this.f28505c;
        if (i == this.f28503a) {
            if (this.f28504b) {
                this.f28504b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f28505c = this.f28506d + i;
        }
        return i;
    }
}
