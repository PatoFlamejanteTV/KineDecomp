package h.a.a.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* compiled from: CalligraphyFactory.java */
/* loaded from: classes3.dex */
public class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f26792a;

    /* renamed from: b */
    final /* synthetic */ Context f26793b;

    /* renamed from: c */
    final /* synthetic */ e f26794c;

    public d(e eVar, ViewGroup viewGroup, Context context) {
        this.f26794c = eVar;
        this.f26792a = viewGroup;
        this.f26793b = context;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    @TargetApi(16)
    public void onGlobalLayout() {
        int childCount = this.f26792a.getChildCount();
        if (childCount != 0) {
            for (int i = 0; i < childCount; i++) {
                this.f26794c.a(this.f26792a.getChildAt(i), this.f26793b, null);
            }
        }
        if (Build.VERSION.SDK_INT < 16) {
            this.f26792a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f26792a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
