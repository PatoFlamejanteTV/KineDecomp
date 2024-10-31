package com.nextreaming.nexeditorui.newproject;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
class j implements View.OnDragListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NewProjectActivity f4691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewProjectActivity newProjectActivity) {
        this.f4691a = newProjectActivity;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(View view, DragEvent dragEvent) {
        HorizontalScrollView horizontalScrollView;
        LinearLayout linearLayout;
        int[] iArr;
        int i;
        int i2;
        int[] iArr2;
        HorizontalScrollView horizontalScrollView2;
        LinearLayout linearLayout2;
        HorizontalScrollView horizontalScrollView3;
        LinearLayout linearLayout3;
        int i3;
        int i4;
        LinearLayout linearLayout4;
        int i5;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        int i6;
        int i7;
        LinearLayout linearLayout7;
        ArrayList arrayList;
        int i8;
        int[] iArr3;
        int i9;
        int i10;
        HorizontalScrollView horizontalScrollView4;
        HorizontalScrollView horizontalScrollView5;
        int i11;
        HorizontalScrollView horizontalScrollView6;
        HorizontalScrollView horizontalScrollView7;
        int i12;
        int i13;
        int i14;
        View view2 = null;
        if (dragEvent.getLocalState() instanceof View) {
            view2 = (View) dragEvent.getLocalState();
        }
        if (view2 == null) {
            return false;
        }
        float x = dragEvent.getX();
        horizontalScrollView = this.f4691a.u;
        float scrollX = x + horizontalScrollView.getScrollX();
        view2.setAlpha(0.5f);
        this.f4691a.v = new int[2];
        linearLayout = this.f4691a.t;
        iArr = this.f4691a.v;
        linearLayout.getLocationInWindow(iArr);
        switch (dragEvent.getAction()) {
            case 1:
                Log.i("NewProjectActivity", "ACTION_DRAG_STARTED");
                NewProjectActivity newProjectActivity = this.f4691a;
                i14 = this.f4691a.w;
                newProjectActivity.x = i14;
                break;
            case 2:
                iArr2 = this.f4691a.v;
                int i15 = iArr2[0];
                horizontalScrollView2 = this.f4691a.u;
                int scrollX2 = i15 + horizontalScrollView2.getScrollX();
                linearLayout2 = this.f4691a.t;
                if (linearLayout2.getChildCount() >= 2) {
                    if (dragEvent.getX() < scrollX2) {
                        horizontalScrollView6 = this.f4691a.u;
                        horizontalScrollView7 = this.f4691a.u;
                        horizontalScrollView6.setScrollX(horizontalScrollView7.getScrollX() - 5);
                        i12 = this.f4691a.z;
                        if (i12 > 0) {
                            this.f4691a.z = 0;
                        }
                        NewProjectActivity newProjectActivity2 = this.f4691a;
                        i13 = this.f4691a.z;
                        newProjectActivity2.z = i13 + 5;
                        break;
                    } else {
                        float x2 = dragEvent.getX();
                        horizontalScrollView3 = this.f4691a.u;
                        if (x2 > scrollX2 + horizontalScrollView3.getWidth()) {
                            i10 = this.f4691a.z;
                            if (i10 < 0) {
                                this.f4691a.z = 0;
                            }
                            horizontalScrollView4 = this.f4691a.u;
                            horizontalScrollView5 = this.f4691a.u;
                            horizontalScrollView4.setScrollX(horizontalScrollView5.getScrollX() + 5);
                            NewProjectActivity newProjectActivity3 = this.f4691a;
                            i11 = this.f4691a.z;
                            newProjectActivity3.z = i11 - 5;
                            break;
                        } else {
                            int i16 = 0;
                            while (true) {
                                linearLayout3 = this.f4691a.t;
                                if (i16 < linearLayout3.getChildCount()) {
                                    linearLayout7 = this.f4691a.t;
                                    View childAt = linearLayout7.getChildAt(i16);
                                    arrayList = this.f4691a.h;
                                    ((Integer) arrayList.get(i16)).intValue();
                                    float x3 = dragEvent.getX();
                                    i8 = this.f4691a.z;
                                    float f = x3 + i8;
                                    iArr3 = this.f4691a.v;
                                    if (f < childAt.getRight() + iArr3[0]) {
                                        this.f4691a.y = i16;
                                        i9 = this.f4691a.y;
                                        if (i9 < 0) {
                                            this.f4691a.y = 0;
                                        }
                                    } else {
                                        i16++;
                                    }
                                }
                            }
                            i3 = this.f4691a.x;
                            i4 = this.f4691a.y;
                            if (i3 != i4) {
                                linearLayout4 = this.f4691a.t;
                                i5 = this.f4691a.x;
                                View childAt2 = linearLayout4.getChildAt(i5);
                                linearLayout5 = this.f4691a.t;
                                linearLayout5.removeView(childAt2);
                                linearLayout6 = this.f4691a.t;
                                i6 = this.f4691a.y;
                                linearLayout6.addView(childAt2, i6);
                                NewProjectActivity newProjectActivity4 = this.f4691a;
                                i7 = this.f4691a.y;
                                newProjectActivity4.x = i7;
                                this.f4691a.c();
                                break;
                            }
                        }
                    }
                }
                break;
            case 3:
                Log.i("NewProjectActivity", "ACTION_DROP");
                break;
            case 4:
                Log.i("NewProjectActivity", "ACTION_DRAG_ENDED");
                this.f4691a.z = 0;
                NewProjectActivity newProjectActivity5 = this.f4691a;
                i = this.f4691a.w;
                i2 = this.f4691a.x;
                newProjectActivity5.a(i, i2);
                this.f4691a.c();
                view2.setAlpha(1.0f);
                break;
            case 5:
                Log.i("NewProjectActivity", "ACTION_DRAG_ENTERED");
                break;
            case 6:
                Log.i("NewProjectActivity", "ACTION_DRAG_EXITED");
                break;
        }
        return true;
    }
}
