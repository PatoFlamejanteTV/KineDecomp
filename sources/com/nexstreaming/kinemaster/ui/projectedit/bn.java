package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LayerSubMenuPopupVideoLayer.java */
/* loaded from: classes.dex */
public class bn implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3794a;
    final /* synthetic */ bl b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bl blVar, Context context) {
        this.b = blVar;
        this.f3794a = context;
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
            if (sqrt <= this.f3794a.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_returnValue)) {
                if (sqrt < this.f3794a.getResources().getDimensionPixelOffset(R.dimen.layer_view_radius_limitValue)) {
                    this.b.dismiss();
                }
                if (atan > -11.0f && atan < 11.0f) {
                    this.b.h = LayerSubMenuPopup.LayerType.STICKERS;
                    i = R.drawable.layer_menu_unlock_sticker;
                    i2 = R.id.stickers_tv;
                } else if (atan > 11.0f && atan < 33.0f) {
                    this.b.h = LayerSubMenuPopup.LayerType.TEXT;
                    i = R.drawable.layer_menu_unlock_text;
                    i2 = R.id.text_tv;
                } else if (atan < -11.0f && atan > -33.0f) {
                    this.b.h = LayerSubMenuPopup.LayerType.IMAGE;
                    i = R.drawable.layer_menu_unlock_picture;
                    i2 = R.id.image_tv;
                } else if (atan < 55.0f && atan > 33.0f) {
                    this.b.h = LayerSubMenuPopup.LayerType.HANDWRITING;
                    i = R.drawable.layer_menu_unlock_handwriting;
                    i2 = R.id.handwriting_tv;
                } else if (atan >= -33.0f || atan <= -55.0f) {
                    this.b.h = null;
                    i = R.drawable.layer_menu_unlock_nosel;
                    i2 = -1;
                } else {
                    this.b.h = LayerSubMenuPopup.LayerType.VIDEO;
                    i = R.drawable.layer_menu_unlock_video;
                    i2 = R.id.video_tv;
                }
                angleMaskImageView3 = this.b.c;
                angleMaskImageView3.setBitmapResource(i);
                iArr = this.b.f;
                for (int i3 : iArr) {
                    if (i2 == i3) {
                        ((TextView) this.b.findViewById(i3)).setTextSize(0, this.f3794a.getResources().getDimensionPixelSize(R.dimen.layer_popup_selected_text_size));
                    } else {
                        ((TextView) this.b.findViewById(i3)).setTextSize(0, this.f3794a.getResources().getDimensionPixelSize(R.dimen.layer_popup_text_size));
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
                    bl blVar = this.b;
                    layerType2 = this.b.h;
                    aVar2.a(blVar, layerType2);
                }
            }
        }
        return true;
    }
}
