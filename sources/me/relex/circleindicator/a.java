package me.relex.circleindicator;

import android.animation.Animator;
import android.support.v4.view.ViewPager;
import android.view.View;

/* compiled from: CircleIndicator.java */
/* loaded from: classes3.dex */
public class a implements ViewPager.OnPageChangeListener {

    /* renamed from: a */
    final /* synthetic */ CircleIndicator f28740a;

    public a(CircleIndicator circleIndicator) {
        this.f28740a = circleIndicator;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager viewPager;
        ViewPager viewPager2;
        Animator animator;
        Animator animator2;
        int i2;
        int i3;
        Animator animator3;
        Animator animator4;
        int i4;
        int i5;
        Animator animator5;
        Animator animator6;
        Animator animator7;
        Animator animator8;
        Animator animator9;
        Animator animator10;
        viewPager = this.f28740a.f28731a;
        if (viewPager.getAdapter() != null) {
            viewPager2 = this.f28740a.f28731a;
            if (viewPager2.getAdapter().getCount() <= 0) {
                return;
            }
            animator = this.f28740a.j;
            if (animator.isRunning()) {
                animator9 = this.f28740a.j;
                animator9.end();
                animator10 = this.f28740a.j;
                animator10.cancel();
            }
            animator2 = this.f28740a.i;
            if (animator2.isRunning()) {
                animator7 = this.f28740a.i;
                animator7.end();
                animator8 = this.f28740a.i;
                animator8.cancel();
            }
            i2 = this.f28740a.m;
            if (i2 >= 0) {
                CircleIndicator circleIndicator = this.f28740a;
                i4 = circleIndicator.m;
                View childAt = circleIndicator.getChildAt(i4);
                if (childAt != null) {
                    i5 = this.f28740a.f28738h;
                    childAt.setBackgroundResource(i5);
                    animator5 = this.f28740a.j;
                    animator5.setTarget(childAt);
                    animator6 = this.f28740a.j;
                    animator6.start();
                }
            }
            View childAt2 = this.f28740a.getChildAt(i);
            if (childAt2 != null) {
                i3 = this.f28740a.f28737g;
                childAt2.setBackgroundResource(i3);
                animator3 = this.f28740a.i;
                animator3.setTarget(childAt2);
                animator4 = this.f28740a.i;
                animator4.start();
            }
            this.f28740a.m = i;
        }
    }
}
