package com.nextreaming.nexeditorui.newproject;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes3.dex */
class h implements View.OnDragListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f24370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewProjectActivity newProjectActivity) {
        this.f24370a = newProjectActivity;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        LinearLayout linearLayout;
        int[] iArr;
        int i;
        int[] iArr2;
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout2;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout3;
        int i2;
        int i3;
        LinearLayout linearLayout4;
        int i4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        int i5;
        int i6;
        LinearLayout linearLayout7;
        ArrayList arrayList;
        int i7;
        int[] iArr3;
        int i8;
        int i9;
        HorizontalScrollView horizontalScrollView3;
        HorizontalScrollView horizontalScrollView4;
        int i10;
        HorizontalScrollView horizontalScrollView5;
        HorizontalScrollView horizontalScrollView6;
        int i11;
        int i12;
        int i13;
        int i14;
        View view2 = dragEvent.getLocalState() instanceof View ? (View) dragEvent.getLocalState() : null;
        if (view2 == null) {
            return false;
        }
        view2.setAlpha(0.5f);
        this.f24370a.I = new int[2];
        linearLayout = this.f24370a.ea;
        iArr = this.f24370a.I;
        linearLayout.getLocationInWindow(iArr);
        switch (dragEvent.getAction()) {
            case 1:
                Log.i("NewProjectActivity", "ACTION_DRAG_STARTED");
                NewProjectActivity newProjectActivity = this.f24370a;
                i = newProjectActivity.J;
                newProjectActivity.K = i;
                return true;
            case 2:
                iArr2 = this.f24370a.I;
                int i15 = iArr2[0];
                horizontalScrollView = this.f24370a.fa;
                int scrollX = i15 + horizontalScrollView.getScrollX();
                linearLayout2 = this.f24370a.ea;
                if (linearLayout2.getChildCount() < 2) {
                    return true;
                }
                if (dragEvent.getX() < scrollX) {
                    horizontalScrollView5 = this.f24370a.fa;
                    horizontalScrollView6 = this.f24370a.fa;
                    horizontalScrollView5.setScrollX(horizontalScrollView6.getScrollX() - 5);
                    i11 = this.f24370a.M;
                    if (i11 > 0) {
                        this.f24370a.M = 0;
                    }
                    NewProjectActivity newProjectActivity2 = this.f24370a;
                    i12 = newProjectActivity2.M;
                    newProjectActivity2.M = i12 + 5;
                    return true;
                }
                float x = dragEvent.getX();
                horizontalScrollView2 = this.f24370a.fa;
                if (x > scrollX + horizontalScrollView2.getWidth()) {
                    i9 = this.f24370a.M;
                    if (i9 < 0) {
                        this.f24370a.M = 0;
                    }
                    horizontalScrollView3 = this.f24370a.fa;
                    horizontalScrollView4 = this.f24370a.fa;
                    horizontalScrollView3.setScrollX(horizontalScrollView4.getScrollX() + 5);
                    NewProjectActivity newProjectActivity3 = this.f24370a;
                    i10 = newProjectActivity3.M;
                    newProjectActivity3.M = i10 - 5;
                    return true;
                }
                int i16 = 0;
                while (true) {
                    linearLayout3 = this.f24370a.ea;
                    if (i16 < linearLayout3.getChildCount()) {
                        linearLayout7 = this.f24370a.ea;
                        View childAt = linearLayout7.getChildAt(i16);
                        arrayList = this.f24370a.T;
                        ((Integer) arrayList.get(i16)).intValue();
                        float x2 = dragEvent.getX();
                        i7 = this.f24370a.M;
                        float f2 = x2 + i7;
                        iArr3 = this.f24370a.I;
                        if (f2 < iArr3[0] + childAt.getRight()) {
                            this.f24370a.L = i16;
                            i8 = this.f24370a.L;
                            if (i8 < 0) {
                                this.f24370a.L = 0;
                            }
                        } else {
                            i16++;
                        }
                    }
                }
                i2 = this.f24370a.K;
                i3 = this.f24370a.L;
                if (i2 == i3) {
                    return true;
                }
                linearLayout4 = this.f24370a.ea;
                i4 = this.f24370a.K;
                View childAt2 = linearLayout4.getChildAt(i4);
                linearLayout5 = this.f24370a.ea;
                linearLayout5.removeView(childAt2);
                linearLayout6 = this.f24370a.ea;
                i5 = this.f24370a.L;
                linearLayout6.addView(childAt2, i5);
                NewProjectActivity newProjectActivity4 = this.f24370a;
                i6 = newProjectActivity4.L;
                newProjectActivity4.K = i6;
                this.f24370a.L();
                return true;
            case 3:
                Log.i("NewProjectActivity", "ACTION_DROP");
                return true;
            case 4:
                Log.i("NewProjectActivity", "ACTION_DRAG_ENDED");
                this.f24370a.M = 0;
                NewProjectActivity newProjectActivity5 = this.f24370a;
                i13 = newProjectActivity5.J;
                i14 = this.f24370a.K;
                newProjectActivity5.b(i13, i14);
                this.f24370a.L();
                view2.setAlpha(1.0f);
                return true;
            case 5:
                Log.i("NewProjectActivity", "ACTION_DRAG_ENTERED");
                return true;
            case 6:
                Log.i("NewProjectActivity", "ACTION_DRAG_EXITED");
                return true;
            default:
                return true;
        }
    }
}
