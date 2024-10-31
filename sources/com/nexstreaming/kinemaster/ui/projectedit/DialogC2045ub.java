package com.nexstreaming.kinemaster.ui.projectedit;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: LayerSubMenuPopupEffectLayer.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ub */
/* loaded from: classes2.dex */
public final class DialogC2045ub extends LayerSubMenuPopup {

    /* renamed from: c */
    private final LinearLayout f22716c;

    /* renamed from: d */
    private final ObjectAnimator f22717d;

    /* renamed from: e */
    private final AngleMaskImageView f22718e;

    /* renamed from: f */
    private final int f22719f;

    /* renamed from: g */
    private final int[] f22720g;

    /* renamed from: h */
    private LayerSubMenuPopup.a f22721h;
    private LayerSubMenuPopup.LayerType i;
    private int j;
    private boolean k;
    private final boolean l;

    /* renamed from: b */
    public static final a f22715b = new a(null);

    /* renamed from: a */
    private static final String f22714a = DialogC2045ub.class.getSimpleName();

    /* compiled from: LayerSubMenuPopupEffectLayer.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ub$a */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: LayerSubMenuPopupEffectLayer.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ub$b */
    /* loaded from: classes2.dex */
    public final class b {

        /* renamed from: a */
        private int f22722a;

        /* renamed from: b */
        private int f22723b;

        /* renamed from: c */
        private LayerSubMenuPopup.LayerType f22724c;

        public b(int i, int i2, LayerSubMenuPopup.LayerType layerType) {
            this.f22722a = i;
            this.f22723b = i2;
            this.f22724c = layerType;
        }

        public final int a() {
            return this.f22722a;
        }

        public final LayerSubMenuPopup.LayerType b() {
            return this.f22724c;
        }

        public final int c() {
            return this.f22723b;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2045ub(Context context, int i, int i2, boolean z) {
        super(context);
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        this.l = z;
        this.f22720g = new int[]{R.id.media_tv, R.id.stickers_tv, R.id.text_tv, R.id.handwriting_tv, R.id.effect_tv};
        this.j = -1;
        requestWindowFeature(1);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = getWindow();
            if (window2 != null) {
                window2.clearFlags(2);
                setContentView(R.layout.layer_popup_effect_layer);
                setCanceledOnTouchOutside(true);
                Window window3 = getWindow();
                if (window3 != null) {
                    WindowManager.LayoutParams attributes = window3.getAttributes();
                    attributes.gravity = 8388661;
                    Rect a2 = EditorGlobal.a((Activity) context);
                    int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_margin);
                    int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.layer_popup__maskview_h) / 2;
                    attributes.x = (a2.width() - i) - dimensionPixelOffset;
                    attributes.y = (i2 - dimensionPixelOffset2) - EditorGlobal.h(context);
                    Window window4 = getWindow();
                    if (window4 != null) {
                        window4.setAttributes(attributes);
                        View findViewById = findViewById(R.id.maskView);
                        kotlin.jvm.internal.h.a((Object) findViewById, "findViewById(R.id.maskView)");
                        this.f22718e = (AngleMaskImageView) findViewById;
                        if (this.l) {
                            this.f22718e.setBitmapResource(R.drawable.layer_menu_for_effect_nosel);
                        } else {
                            this.f22718e.setBitmapResource(R.drawable.layer_menu_for_fximg_nosel);
                        }
                        this.f22718e.setCenterDistance(context.getResources().getDimensionPixelOffset(R.dimen.mask_center_distance));
                        this.f22717d = ObjectAnimator.ofFloat(this.f22718e, "MaskAngle", 0.0f, 110.0f);
                        ObjectAnimator objectAnimator = this.f22717d;
                        if (objectAnimator != null) {
                            objectAnimator.setDuration(350L);
                            this.f22717d.addUpdateListener(new C2004sb(this));
                            this.f22716c = (LinearLayout) findViewById(R.id.text_holder);
                            LinearLayout linearLayout = this.f22716c;
                            if (linearLayout != null) {
                                linearLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.layer_text_slide));
                                ((TextView) findViewById(R.id.stickers_tv)).setText(R.string.layer_menu_overlay);
                                if (!this.l) {
                                    TextView textView = (TextView) findViewById(R.id.media_tv);
                                    kotlin.jvm.internal.h.a((Object) textView, "textView");
                                    textView.setText(context.getResources().getString(R.string.layer_menu_image));
                                }
                                this.f22718e.setOnTouchListener(new ViewOnTouchListenerC2013tb(this, context));
                                this.f22719f = context.getResources().getDimensionPixelOffset(R.dimen.layer_popup_radius_limitValue);
                                return;
                            }
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:            if (r0 < 0) goto L41;     */
    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.h.b(r8, r0)
            int r0 = r6.j
            r1 = 4
            r2 = 66
            r3 = 0
            r4 = 1
            if (r0 >= 0) goto L1a
            r1 = 21
            if (r7 == r1) goto L18
            if (r7 == r2) goto L15
            goto L46
        L15:
            r6.k = r4
            goto L46
        L18:
            r0 = 0
            goto L46
        L1a:
            r5 = 19
            if (r7 == r5) goto L41
            r5 = 20
            if (r7 == r5) goto L3b
            r1 = 22
            if (r7 == r1) goto L39
            if (r7 == r2) goto L29
            goto L46
        L29:
            r6.k = r4
            com.nexstreaming.kinemaster.ui.projectedit.ub$b r7 = r6.a(r0, r4)
            com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup$LayerType r8 = r7.b()
            r6.i = r8
            r6.a(r7)
            return r3
        L39:
            r0 = -1
            goto L46
        L3b:
            int r0 = r0 + 1
            if (r0 <= r1) goto L46
            r0 = 4
            goto L46
        L41:
            int r0 = r0 + (-1)
            if (r0 >= 0) goto L46
            goto L18
        L46:
            int r1 = r6.j
            if (r0 == r1) goto L55
            r1 = 2
            r2 = 0
            com.nexstreaming.kinemaster.ui.projectedit.ub$b r1 = a(r6, r0, r3, r1, r2)
            r6.j = r0
            r6.a(r1)
        L55:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.DialogC2045ub.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        LayerSubMenuPopup.a aVar;
        kotlin.jvm.internal.h.b(keyEvent, NotificationCompat.CATEGORY_EVENT);
        if (i == 66) {
            if (this.k && (aVar = this.f22721h) != null) {
                if (aVar == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                aVar.a(this, this.i);
            }
            this.k = false;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        kotlin.jvm.internal.h.b(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (motionEvent.getActionMasked() == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY() - (this.f22718e.getHeight() / 2.0f);
            float centerDistance = (this.f22718e.getCenterDistance() * 2) - x;
            float atan = (float) (Math.atan(y / centerDistance) * 57.29577951308232d);
            if (((float) Math.sqrt(Math.pow(centerDistance, 2.0d) + Math.pow(y, 2.0d))) < this.f22719f) {
                dismiss();
            }
            if (atan > 35 || atan < -35) {
                dismiss();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    static /* synthetic */ b a(DialogC2045ub dialogC2045ub, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return dialogC2045ub.a(i, z);
    }

    private final b a(int i, boolean z) {
        int i2;
        int i3;
        LayerSubMenuPopup.LayerType layerType;
        if (i == 0) {
            i2 = z ? R.drawable.layer_menu_for_effect_media : R.drawable.layer_menu_for_effect_media_focused;
            i3 = R.id.media_tv;
            layerType = LayerSubMenuPopup.LayerType.MEDIA;
        } else if (i == 1) {
            i2 = z ? R.drawable.layer_menu_for_effect_effect : R.drawable.layer_menu_for_effect_effect_focused;
            i3 = R.id.effect_tv;
            layerType = LayerSubMenuPopup.LayerType.EFFECT;
        } else if (i == 2) {
            i2 = z ? R.drawable.layer_menu_for_effect_sticker : R.drawable.layer_menu_for_effect_sticker_focused;
            i3 = R.id.stickers_tv;
            layerType = LayerSubMenuPopup.LayerType.STICKERS;
        } else if (i == 3) {
            i2 = z ? R.drawable.layer_menu_for_effect_text : R.drawable.layer_menu_for_effect_text_focused;
            i3 = R.id.text_tv;
            layerType = LayerSubMenuPopup.LayerType.TEXT;
        } else if (i != 4) {
            layerType = null;
            i2 = R.drawable.layer_menu_for_effect_nosel;
            i3 = -1;
        } else {
            i2 = z ? R.drawable.layer_menu_for_effect_handwriting : R.drawable.layer_menu_for_effect_handwriting_focused;
            i3 = R.id.handwriting_tv;
            layerType = LayerSubMenuPopup.LayerType.HANDWRITING;
        }
        return new b(i2, i3, layerType);
    }

    public final b a(float f2) {
        int i;
        boolean z = this.l;
        int i2 = R.id.media_tv;
        LayerSubMenuPopup.LayerType layerType = null;
        if (z) {
            float f3 = -11;
            if (f2 > f3 && f2 < 11) {
                i = R.drawable.layer_menu_for_effect_sticker;
                layerType = LayerSubMenuPopup.LayerType.STICKERS;
                i2 = R.id.stickers_tv;
            } else if (f2 > 11 && f2 < 33) {
                i = R.drawable.layer_menu_for_effect_text;
                layerType = LayerSubMenuPopup.LayerType.TEXT;
                i2 = R.id.text_tv;
            } else if (f2 < f3 && f2 > -33) {
                i = R.drawable.layer_menu_for_effect_effect;
                layerType = LayerSubMenuPopup.LayerType.EFFECT;
                i2 = R.id.effect_tv;
            } else if (f2 < 55 && f2 > 33) {
                i = R.drawable.layer_menu_for_effect_handwriting;
                layerType = LayerSubMenuPopup.LayerType.HANDWRITING;
                i2 = R.id.handwriting_tv;
            } else if (f2 >= -33 || f2 <= -55) {
                i = R.drawable.layer_menu_for_effect_nosel;
                i2 = -1;
            } else {
                i = R.drawable.layer_menu_for_effect_media;
                layerType = LayerSubMenuPopup.LayerType.MEDIA;
            }
        } else {
            float f4 = -11;
            if (f2 > f4 && f2 < 11) {
                i = R.drawable.layer_menu_for_fximg_sticker;
                layerType = LayerSubMenuPopup.LayerType.STICKERS;
                i2 = R.id.stickers_tv;
            } else if (f2 > 11 && f2 < 33) {
                i = R.drawable.layer_menu_for_fximg_text;
                layerType = LayerSubMenuPopup.LayerType.TEXT;
                i2 = R.id.text_tv;
            } else if (f2 < f4 && f2 > -33) {
                i = R.drawable.layer_menu_for_fximg_effect;
                layerType = LayerSubMenuPopup.LayerType.EFFECT;
                i2 = R.id.effect_tv;
            } else if (f2 < 55 && f2 > 33) {
                i = R.drawable.layer_menu_for_fximg_handwriting;
                layerType = LayerSubMenuPopup.LayerType.HANDWRITING;
                i2 = R.id.handwriting_tv;
            } else if (f2 >= -33 || f2 <= -55) {
                i = R.drawable.layer_menu_for_fximg_nosel;
                i2 = -1;
            } else {
                i = R.drawable.layer_menu_for_fximg_image;
                layerType = LayerSubMenuPopup.LayerType.IMAGE;
            }
        }
        return new b(i, i2, layerType);
    }

    public final void a(b bVar) {
        int dimensionPixelSize;
        this.f22718e.setBitmapResource(bVar.a());
        for (int i : this.f22720g) {
            TextView textView = (TextView) findViewById(i);
            if (i == R.id.media_tv && !this.l) {
                kotlin.jvm.internal.h.a((Object) textView, "textView");
                Context context = getContext();
                kotlin.jvm.internal.h.a((Object) context, com.umeng.analytics.pro.b.Q);
                textView.setText(context.getResources().getString(R.string.layer_menu_image));
            }
            if (bVar.c() == i) {
                Context context2 = getContext();
                kotlin.jvm.internal.h.a((Object) context2, com.umeng.analytics.pro.b.Q);
                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.layer_popup_selected_text_size);
            } else {
                Context context3 = getContext();
                kotlin.jvm.internal.h.a((Object) context3, com.umeng.analytics.pro.b.Q);
                dimensionPixelSize = context3.getResources().getDimensionPixelSize(R.dimen.layer_popup_text_size);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.LayerSubMenuPopup
    public void a() {
        ObjectAnimator objectAnimator = this.f22717d;
        if (objectAnimator == null || this.f22716c == null) {
            return;
        }
        objectAnimator.start();
        this.f22716c.animate();
    }

    public void a(LayerSubMenuPopup.a aVar) {
        kotlin.jvm.internal.h.b(aVar, "listener");
        this.f22721h = aVar;
    }
}
