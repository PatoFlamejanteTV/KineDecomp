package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.DialogC2045ub;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;

/* compiled from: LayerSubMenuPopupEffectLayer.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.tb */
/* loaded from: classes2.dex */
public final class ViewOnTouchListenerC2013tb implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ DialogC2045ub f22535a;

    /* renamed from: b */
    final /* synthetic */ Context f22536b;

    public ViewOnTouchListenerC2013tb(DialogC2045ub dialogC2045ub, Context context) {
        this.f22535a = dialogC2045ub;
        this.f22536b = context;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        LayerSubMenuPopup.a aVar;
        LayerSubMenuPopup.LayerType layerType;
        LayerSubMenuPopup.a aVar2;
        LayerSubMenuPopup.LayerType layerType2;
        AngleMaskImageView angleMaskImageView;
        AngleMaskImageView angleMaskImageView2;
        DialogC2045ub.b a2;
        kotlin.jvm.internal.h.a((Object) motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getActionMasked() == 0) {
            angleMaskImageView = this.f22535a.f22718e;
            float height = angleMaskImageView.getHeight() / 2;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            angleMaskImageView2 = this.f22535a.f22718e;
            float f2 = y - height;
            float centerDistance = angleMaskImageView2.getCenterDistance() - x;
            float atan = (float) (Math.atan(f2 / centerDistance) * 57.29577951308232d);
            float sqrt = (float) Math.sqrt(Math.pow(centerDistance, 2.0d) + Math.pow(f2, 2.0d));
            if (sqrt > this.f22536b.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_returnValue)) {
                return false;
            }
            if (sqrt < this.f22536b.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_limitValue)) {
                this.f22535a.dismiss();
            }
            a2 = this.f22535a.a(atan);
            this.f22535a.i = a2.b();
            this.f22535a.a(a2);
        } else if (motionEvent.getActionMasked() == 1) {
            aVar = this.f22535a.f22721h;
            if (aVar != null) {
                layerType = this.f22535a.i;
                if (layerType != null) {
                    aVar2 = this.f22535a.f22721h;
                    if (aVar2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    DialogC2045ub dialogC2045ub = this.f22535a;
                    layerType2 = dialogC2045ub.i;
                    aVar2.a(dialogC2045ub, layerType2);
                }
            }
        }
        return true;
    }
}
