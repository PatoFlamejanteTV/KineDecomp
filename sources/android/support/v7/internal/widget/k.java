package android.support.v7.internal.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.b.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
public class k extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f179a;

    public k(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ac a2 = ac.a(context, attributeSet, a.i.PopupWindow, i, 0);
        this.f179a = a2.a(a.i.PopupWindow_overlapAnchor, false);
        setBackgroundDrawable(a2.a(a.i.PopupWindow_android_popupBackground));
        a2.b();
        if (Build.VERSION.SDK_INT < 14) {
            a(this);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (Build.VERSION.SDK_INT < 21 && this.f179a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT < 21 && this.f179a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        super.update(view, i, (Build.VERSION.SDK_INT >= 21 || !this.f179a) ? i2 : i2 - view.getHeight(), i3, i4);
    }

    private static void a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new l(declaredField, popupWindow, (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Exception e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }
}
