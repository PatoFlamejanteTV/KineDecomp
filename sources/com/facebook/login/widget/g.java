package com.facebook.login.widget;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.facebook.login.widget.ToolTipPopup;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolTipPopup.java */
/* loaded from: classes.dex */
public class g implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolTipPopup f328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ToolTipPopup toolTipPopup) {
        this.f328a = toolTipPopup;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        WeakReference weakReference;
        PopupWindow popupWindow;
        PopupWindow popupWindow2;
        PopupWindow popupWindow3;
        ToolTipPopup.a aVar;
        ToolTipPopup.a aVar2;
        weakReference = this.f328a.mAnchorViewRef;
        if (weakReference.get() != null) {
            popupWindow = this.f328a.mPopupWindow;
            if (popupWindow != null) {
                popupWindow2 = this.f328a.mPopupWindow;
                if (popupWindow2.isShowing()) {
                    popupWindow3 = this.f328a.mPopupWindow;
                    if (popupWindow3.isAboveAnchor()) {
                        aVar2 = this.f328a.mPopupContent;
                        aVar2.b();
                    } else {
                        aVar = this.f328a.mPopupContent;
                        aVar.a();
                    }
                }
            }
        }
    }
}
