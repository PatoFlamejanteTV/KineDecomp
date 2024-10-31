package com.facebook.login.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.facebook.login.widget.ToolTipPopup;
import java.lang.ref.WeakReference;

/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
public class h implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a */
    final /* synthetic */ ToolTipPopup f9416a;

    public h(ToolTipPopup toolTipPopup) {
        this.f9416a = toolTipPopup;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        WeakReference weakReference;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        ToolTipPopup.a aVar;
        ToolTipPopup.a aVar2;
        weakReference = this.f9416a.mAnchorViewRef;
        if (weakReference.get() != null) {
            popupWindow = this.f9416a.mPopupWindow;
            if (popupWindow != null) {
                popupWindow2 = this.f9416a.mPopupWindow;
                if (popupWindow2.isShowing()) {
                    popupWindow3 = this.f9416a.mPopupWindow;
                    if (popupWindow3.isAboveAnchor()) {
                        aVar2 = this.f9416a.mPopupContent;
                        aVar2.a();
                    } else {
                        aVar = this.f9416a.mPopupContent;
                        aVar.b();
                    }
                }
            }
        }
    }
}
