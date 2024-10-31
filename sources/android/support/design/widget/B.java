package android.support.design.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* compiled from: StateListAnimator.java */
/* loaded from: classes.dex */
public final class B {

    /* renamed from: a */
    private final ArrayList<a> f320a = new ArrayList<>();

    /* renamed from: b */
    private a f321b = null;

    /* renamed from: c */
    ValueAnimator f322c = null;

    /* renamed from: d */
    private final Animator.AnimatorListener f323d = new A(this);

    /* compiled from: StateListAnimator.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        final int[] f324a;

        /* renamed from: b */
        final ValueAnimator f325b;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.f324a = iArr;
            this.f325b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f322c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f322c = null;
        }
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.f323d);
        this.f320a.add(aVar);
    }

    public void a(int[] iArr) {
        a aVar;
        int size = this.f320a.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f320a.get(i);
            if (StateSet.stateSetMatches(aVar.f324a, iArr)) {
                break;
            } else {
                i++;
            }
        }
        a aVar2 = this.f321b;
        if (aVar == aVar2) {
            return;
        }
        if (aVar2 != null) {
            b();
        }
        this.f321b = aVar;
        if (aVar != null) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        this.f322c = aVar.f325b;
        this.f322c.start();
    }

    public void a() {
        ValueAnimator valueAnimator = this.f322c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f322c = null;
        }
    }
}
