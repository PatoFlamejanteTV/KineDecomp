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
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: TextEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.kh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1939kh extends OptionTabFragment implements InterfaceC1866cf {
    private Bitmap E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private boolean M;
    private String N;
    private Layout.Alignment O;
    private LayerTransformTouchHandler Q;
    private Object P = this;
    private MarchingAnts R = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
    private VideoEditor.b S = new C1904gh(this);
    private boolean T = true;
    private View.OnLayoutChangeListener U = new ViewOnLayoutChangeListenerC1921ih(this);
    private ViewTreeObserver.OnGlobalLayoutListener V = new ViewTreeObserverOnGlobalLayoutListenerC1930jh(this);

    /* JADX INFO: Access modifiers changed from: private */
    public TextLayer Aa() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof TextLayer)) {
            return null;
        }
        return (TextLayer) Y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        if (isAdded()) {
            super.na();
            if (Aa() != null) {
                TextLayer Aa = Aa();
                this.F = Aa.getText();
                this.G = Aa.getTextColor();
                this.H = Aa.getShadowColor();
                this.K = Aa.isEnableShadow();
                this.I = Aa.getGlowColor();
                this.L = Aa.isEnableGlow();
                this.J = Aa.getOutlineColor();
                this.M = Aa.isEnableOutline();
                this.N = Aa.getFontId();
                this.O = Aa.getTextAlign();
                d(R.id.opt_background_extend, Aa().getSwitchOption(R.id.opt_background_color));
                this.E = null;
                this.Q.a((NexLayerItem) Y());
                if (this.R == null) {
                    this.R = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                }
                Rect rect = new Rect();
                Aa().getBounds(rect);
                this.R.a(rect);
                if (Q() != null) {
                    Q().addOnLayoutChangeListener(this.U);
                    Q().getViewTreeObserver().addOnGlobalLayoutListener(this.V);
                }
                c(R.id.action_animation, true);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (Y() instanceof NexLayerItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else {
            super.oa();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (getView() == null) {
            return;
        }
        getView().postDelayed(new RunnableC1913hh(this, intent, i, i2), 60L);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        this.E = null;
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.Q = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.R = null;
        da().a(this.P, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i == R.id.opt_background_extend) {
            a(R.id.opt_background_extend, !Y().getSwitchOption(R.id.opt_background_extend));
            return true;
        }
        if (i != R.id.opt_text_font) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) FontBrowserActivity.class);
        if (da().t() != null) {
            intent.putExtra("SELECTED_PROJECT", da().t().getPath());
        }
        intent.putExtra("selected_font_id", Aa().getFontId());
        startActivityForResult(intent, 100);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return new int[]{R.id.opt_text_font, R.id.opt_split_trim, R.id.opt_text_color, R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_alpha_adj, R.id.opt_rotate, R.id.opt_layer_nudge, R.id.opt_text_align, R.id.opt_shadow, R.id.opt_glow, R.id.opt_outline, R.id.opt_background_color, R.id.opt_background_extend, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_information};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.layer_menu_text);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int za() {
        return R.drawable.opthdr_keyboard;
    }

    public static String h(String str) {
        char charAt;
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (55296 > charAt2 || charAt2 > 56319) {
                stringBuffer.append(charAt2);
            } else {
                i++;
                if (i < length && 56320 <= (charAt = str.charAt(i)) && charAt2 <= 65535) {
                    stringBuffer.append(charAt2);
                    stringBuffer.append(charAt);
                }
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    public void c(OptionTabFragment.TabId tabId) {
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            o(0);
            if (Aa() != null) {
                da().a(this.P, (NexLayerItem) Y(), (VideoEditor.b) null, this.S);
                FullScreenInputActivity.a a2 = FullScreenInputActivity.a(getActivity());
                a2.c(true);
                a2.b(Aa().getText());
                a2.a(Aa().getFontId());
                startActivityForResult(a2.a(), FullScreenInputActivity.s());
                this.T = false;
            } else {
                da().a(this.P, (NexLayerItem) null, (VideoEditor.b) null, this.S);
                d(OptionTabFragment.TabId.ItemOptionTab);
            }
        } else {
            o(R.id.editmode_trim);
            if (Aa() != null) {
                if (this.R == null) {
                    this.R = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
                }
                Rect rect = new Rect();
                Aa().getBounds(rect);
                this.R.a(rect);
                if (Q() != null) {
                    Q().addOnLayoutChangeListener(this.U);
                    Q().getViewTreeObserver().addOnGlobalLayoutListener(this.V);
                }
            }
        }
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        d(OptionTabFragment.TabId.ItemOptionTab);
        this.Q = new LayerTransformTouchHandler(getActivity(), Aa(), da());
        return null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!isAdded() || Aa() == null || (layerTransformTouchHandler = this.Q) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        if (i == R.id.opt_text_align) {
            G();
        }
        super.a(i);
    }
}
