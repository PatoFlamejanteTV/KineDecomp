package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* loaded from: classes.dex */
public class lo extends OptionTabFragment implements ht {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f4069a;
    private String b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private Layout.Alignment k;
    private LayerTransformTouchHandler l;
    private MarchingAnts m = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private VideoEditor.b n = new lp(this);
    private boolean o = true;
    private View.OnLayoutChangeListener p = new lr(this);
    private ViewTreeObserver.OnGlobalLayoutListener q = new ls(this);

    @Override // android.app.Fragment
    public void onStop() {
        this.m = null;
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f4069a = null;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        this.l = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b(OptionTabFragment.TabId.ItemOptionTab);
        this.l = new LayerTransformTouchHandler(getActivity(), H(), o());
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, com.nexstreaming.kinemaster.ui.projectedit.a
    public boolean a(int i) {
        switch (i) {
            case R.id.action_align_center_horizontal /* 2131820544 */:
                TextLayer H = H();
                H.getClosestKeyframe(H.getScaledTime(o().u())).c = 640.0f;
                o().a(NexEditor.FastPreviewOption.normal, 0, true);
                o().l();
                return true;
            case R.id.action_align_center_vertical /* 2131820545 */:
                TextLayer H2 = H();
                H2.getClosestKeyframe(H2.getScaledTime(o().u())).d = 360.0f;
                o().a(NexEditor.FastPreviewOption.normal, 0, true);
                o().l();
                return true;
            default:
                return super.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    public void a(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            g(0);
            if (H() != null) {
                o().a((NexLayerItem) m(), (VideoEditor.b) null, this.n);
                startActivityForResult(FullScreenInputActivity.a(getActivity()).c(true).a(H().getText()).b(H().getFontId()).a(), FullScreenInputActivity.a());
                this.o = false;
            } else {
                o().a((NexLayerItem) null, (VideoEditor.b) null, this.n);
                b(OptionTabFragment.TabId.ItemOptionTab);
            }
        } else {
            g(R.id.editmode_trim);
            if (H() != null) {
                if (this.m == null) {
                    this.m = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                }
                Rect rect = new Rect();
                H().getBounds(rect);
                this.m.a(rect);
                if (w() != null) {
                    w().addOnLayoutChangeListener(this.p);
                    w().getViewTreeObserver().addOnGlobalLayoutListener(this.q);
                }
            }
        }
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int h() {
        return R.drawable.opthdr_keyboard;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return getString(R.string.layer_menu_text);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return new int[]{R.id.opt_text_font, R.id.opt_split_trim, R.id.opt_text_color, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_alpha_adj, R.id.opt_rotate, R.id.opt_text_align, R.id.opt_shadow, R.id.opt_glow, R.id.opt_outline, R.id.opt_background_color, R.id.opt_background_extend, R.id.opt_layer_mask, R.id.opt_layer_name};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        switch (i) {
            case R.id.opt_background_extend /* 2131820638 */:
                a(R.id.opt_background_extend, m().getSwitchOption(R.id.opt_background_extend) ? false : true);
                return true;
            case R.id.opt_text_font /* 2131820686 */:
                Intent intent = new Intent(getActivity(), (Class<?>) FontBrowserActivity.class);
                intent.putExtra("selected_font_id", H().getFontId());
                startActivityForResult(intent, 100);
                return true;
            default:
                return false;
        }
    }

    public static String a(String str) {
        char charAt;
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (55296 <= charAt2 && charAt2 <= 56319) {
                i++;
                if (i < length && 56320 <= (charAt = str.charAt(i)) && charAt2 <= 65535) {
                    stringBuffer.append(charAt2);
                    stringBuffer.append(charAt);
                }
            } else {
                stringBuffer.append(charAt2);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (getView() != null) {
            getView().postDelayed(new lq(this, intent, i, i2), 60L);
            super.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TextLayer H() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof TextLayer)) {
            return null;
        }
        return (TextLayer) m;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        if (!isAdded() || H() == null || this.l == null) {
            return false;
        }
        return this.l.a(view, motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        if (isAdded()) {
            super.f();
            if (H() != null) {
                TextLayer H = H();
                this.b = H.getText();
                this.c = H.getTextColor();
                this.d = H.getShadowColor();
                this.g = H.isEnableShadow();
                this.e = H.getGlowColor();
                this.h = H.isEnableGlow();
                this.f = H.getOutlineColor();
                this.i = H.isEnableOutline();
                this.j = H.getFontId();
                this.k = H.getTextAlign();
                b(R.id.opt_background_extend, H().getSwitchOption(R.id.opt_background_color));
                this.f4069a = null;
                this.l.a((NexLayerItem) m());
                if (this.m == null) {
                    this.m = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                }
                Rect rect = new Rect();
                H().getBounds(rect);
                this.m.a(rect);
                if (w() != null) {
                    w().addOnLayoutChangeListener(this.p);
                    w().getViewTreeObserver().addOnGlobalLayoutListener(this.q);
                }
                d(R.id.action_animation, true);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
        if (i == R.id.opt_text_align) {
            d();
        }
    }
}
