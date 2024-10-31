package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerSubMenuPopupNoVideoLayer.java */
/* loaded from: classes.dex */
public class bk implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3791a;
    final /* synthetic */ bi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bi biVar, Context context) {
        this.b = biVar;
        this.f3791a = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        LayerSubMenuPopup.a aVar;
        LayerSubMenuPopup.LayerType layerType;
        LayerSubMenuPopup.a aVar2;
        LayerSubMenuPopup.LayerType layerType2;
        AngleMaskImageView angleMaskImageView;
        AngleMaskImageView angleMaskImageView2;
        int i;
        int i2;
        AngleMaskImageView angleMaskImageView3;
        int[] iArr;
        if (motionEvent.getActionMasked() == 0) {
            angleMaskImageView = this.b.c;
            float height = angleMaskImageView.getHeight() / 2;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            angleMaskImageView2 = this.b.c;
            float centerDistance = angleMaskImageView2.getCenterDistance();
            float atan = (float) (Math.atan((y - height) / (centerDistance - x)) * 57.29577951308232d);
            float sqrt = (float) Math.sqrt(Math.pow(y - height, 2.0d) + Math.pow(centerDistance - x, 2.0d));
            if (sqrt <= this.f3791a.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_returnValue)) {
                if (sqrt < this.f3791a.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_limitValue)) {
                    this.b.dismiss();
                }
                if (atan > 0.0f && atan < 22.5d) {
                    this.b.h = LayerSubMenuPopup.LayerType.TEXT;
                    i = R.drawable.layer_menu_text;
                    i2 = R.id.text_tv;
                } else if (atan > 22.5d && atan < 45.0f) {
                    this.b.h = LayerSubMenuPopup.LayerType.HANDWRITING;
                    i = R.drawable.layer_menu_handwriting;
                    i2 = R.id.handwriting_tv;
                } else if (atan < 0.0f && atan > -22.5d) {
                    this.b.h = LayerSubMenuPopup.LayerType.STICKERS;
                    i = R.drawable.layer_menu_sticker;
                    i2 = R.id.stickers_tv;
                } else if (atan >= -22.5d || atan <= -45.0f) {
                    this.b.h = null;
                    i = R.drawable.layer_menu_nosel;
                    i2 = -1;
                } else {
                    this.b.h = LayerSubMenuPopup.LayerType.IMAGE;
                    i = R.drawable.layer_menu_img;
                    i2 = R.id.image_tv;
                }
                angleMaskImageView3 = this.b.c;
                angleMaskImageView3.setBitmapResource(i);
                iArr = this.b.f;
                for (int i3 : iArr) {
                    if (i2 == i3) {
                        ((TextView) this.b.findViewById(i3)).setTextSize(0, this.f3791a.getResources().getDimensionPixelSize(R.dimen.layer_popup_novideo_selected_text_size));
                    } else {
                        ((TextView) this.b.findViewById(i3)).setTextSize(0, this.f3791a.getResources().getDimensionPixelSize(R.dimen.layer_popup_novideo_text_size));
                    }
                }
            } else {
                return false;
            }
        } else if (motionEvent.getActionMasked() == 1) {
            aVar = this.b.g;
            if (aVar != null) {
                layerType = this.b.h;
                if (layerType != null) {
                    aVar2 = this.b.g;
                    bi biVar = this.b;
                    layerType2 = this.b.h;
                    aVar2.a(biVar, layerType2);
                }
            }
        }
        return true;
    }
}
