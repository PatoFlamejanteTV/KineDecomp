package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;

/* compiled from: LayerSubMenuPopupNoVideoLayer.java */
/* loaded from: classes.dex */
public class bi extends LayerSubMenuPopup {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f3789a;
    private ObjectAnimator b;
    private AngleMaskImageView c;
    private int d;
    private int e;
    private int[] f;
    private LayerSubMenuPopup.a g;
    private LayerSubMenuPopup.LayerType h;

    public bi(Context context, int i, int i2) {
        super(context);
        this.f = new int[]{R.id.image_tv, R.id.stickers_tv, R.id.text_tv, R.id.handwriting_tv};
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.x = (i - context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_novideo_text_holder_w)) - context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_novideo_x);
        attributes.y = ((i2 - (context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_novideo__maskview_h) / 2)) - context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_novideo_y)) - context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_novideo__y_diff);
        attributes.gravity = 51;
        getWindow().setAttributes(attributes);
        requestWindowFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().clearFlags(2);
        setContentView(R.layout.layer_popup_no_video_layer);
        setCanceledOnTouchOutside(true);
        this.c = (AngleMaskImageView) findViewById(R.id.maskView);
        this.c.setCenterDistance(context.getResources().getDimensionPixelOffset(R.dimen.mask_center_distance));
        this.c.setBitmapResource(R.drawable.layer_menu_nosel);
        new ObjectAnimator();
        this.b = ObjectAnimator.ofFloat(this.c, "MaskAngle", 0.0f, 90.0f);
        this.b.setDuration(350L);
        this.b.addUpdateListener(new bj(this));
        this.f3789a = (LinearLayout) findViewById(R.id.text_holder);
        this.f3789a.setAnimation(AnimationUtils.loadAnimation(context, R.anim.layer_text_slide));
        this.c.setOnTouchListener(new bk(this, context));
        this.e = context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_angle_limitValue);
        this.d = context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_radius_limitValue);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup
    public void a() {
        if (this.b != null && this.f3789a != null) {
            this.b.start();
            this.f3789a.animate();
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            float height = this.c.getHeight() / 2;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float centerDistance = this.c.getCenterDistance() * 2.0f;
            float atan = (float) (Math.atan((y - height) / (centerDistance - x)) * 57.29577951308232d);
            if (((float) Math.sqrt(Math.pow(y - height, 2.0d) + Math.pow(centerDistance - x, 2.0d))) < this.d) {
                dismiss();
            }
            if (atan > 35.0f || atan < -35.0f) {
                dismiss();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup
    public void a(LayerSubMenuPopup.a aVar) {
        this.g = aVar;
    }
}
