package android.support.v7.internal.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
final class l implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Field f180a;
    final /* synthetic */ PopupWindow b;
    final /* synthetic */ ViewTreeObserver.OnScrollChangedListener c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Field field, PopupWindow popupWindow, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.f180a = field;
        this.b = popupWindow;
        this.c = onScrollChangedListener;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            WeakReference weakReference = (WeakReference) this.f180a.get(this.b);
            if (weakReference != null && weakReference.get() != null) {
                this.c.onScrollChanged();
            }
        } catch (IllegalAccessException e) {
        }
    }
}
