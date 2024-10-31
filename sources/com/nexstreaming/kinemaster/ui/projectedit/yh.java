package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.fontbrowser.FontBrowserActivity;

/* compiled from: TrackTextOptionFragment.java */
/* loaded from: classes2.dex */
public class yh extends Xc {
    private final int C = 101;
    private com.nexstreaming.kinemaster.editorwrapper.Ea D;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        this.D = aa();
        com.nexstreaming.kinemaster.editorwrapper.Ea ea = this.D;
        if (ea != null) {
            boolean n = ea.n();
            d(R.id.opt_text_font, n);
            d(R.id.opt_color, n);
            d(R.id.opt_shadow, n);
            d(R.id.opt_glow, n);
            d(R.id.opt_outline, n);
        }
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (aa() != null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_expand_preview, R.drawable.action_inset_preview);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (aa() != null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_expand_preview, R.drawable.action_inset_preview);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null && i == 101 && i2 == -1) {
            if (aa() == null) {
                return;
            }
            String stringExtra = intent.getStringExtra("selected_font_id");
            if (stringExtra != null && !stringExtra.equals(aa().g())) {
                aa().a(stringExtra);
                G();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        f(true);
        na();
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        if (aa() != null) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        if (i == R.id.opt_apply_style_to_all) {
            if (this.D != null) {
                a(i, !r0.n());
            }
            return true;
        }
        if (i != R.id.opt_text_font) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) FontBrowserActivity.class);
        if (da().t() != null) {
            intent.putExtra("SELECTED_PROJECT", da().t().getPath());
        }
        intent.putExtra("selected_font_id", this.D.g());
        startActivityForResult(intent, 101);
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean sa() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return new int[]{R.id.opt_apply_style_to_all, R.id.opt_text_font, R.id.opt_text_color, R.id.opt_shadow, R.id.opt_glow, R.id.opt_outline};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.opt_track_text);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean ya() {
        return true;
    }
}
