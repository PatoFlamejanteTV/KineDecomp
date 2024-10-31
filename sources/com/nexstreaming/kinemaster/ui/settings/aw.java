package com.nexstreaming.kinemaster.ui.settings;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.ProductView;

/* compiled from: SubscriptionFragment.java */
/* loaded from: classes.dex */
public class aw extends com.nexstreaming.kinemaster.ui.settings.a {
    private int c = 0;
    private String d = null;
    private boolean e = false;
    private a f = null;

    /* compiled from: SubscriptionFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void w();
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() != null && (getActivity() instanceof a)) {
            this.f = (a) getActivity();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() != null && (getActivity() instanceof a)) {
            this.f = (a) getActivity();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected String a() {
        return this.c == 0 ? "Remove Watermark" : "Export Video";
    }

    public static aw a(com.nextreaming.nexeditorui.af afVar, int i, String str) {
        aw awVar = new aw();
        awVar.setArguments(new Bundle());
        awVar.b = afVar;
        awVar.c = i;
        awVar.d = str;
        return awVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a, android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (onCreateView != null && this.c == 0) {
            onCreateView.setOnClickListener(null);
            onCreateView.setBackgroundResource(R.color.new_project_background);
        }
        return onCreateView;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected View c(LayoutInflater layoutInflater, com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        return super.c(layoutInflater, afVar, purchaseType);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected View a(LayoutInflater layoutInflater, com.nextreaming.nexeditorui.af afVar, PurchaseType purchaseType) {
        View inflate = layoutInflater.inflate(R.layout.layout_subscribe_info_top, (ViewGroup) null);
        inflate.findViewById(R.id.tv_subscribe_info_top).setVisibility(afVar.E() ? 8 : 0);
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected void a(ProductView productView, SKUDetails sKUDetails, boolean z, boolean z2) {
        super.a(productView, sKUDetails, z, z2);
        if (productView != null && getActivity() != null) {
            int i = R.drawable.product_view_default_bg_n;
            int i2 = android.R.color.white;
            if (this.c == 1) {
                i = R.drawable.product_view_white_bg;
                i2 = R.color.product_view_dark;
            }
            productView.setProductViewBackgroundResource(i);
            productView.setPriceColor(getResources().getColor(i2));
            productView.setTitleColor(getResources().getColor(i2));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected void a(ProductView productView, String str, String str2, String str3) {
        super.a(productView, str, str2, str3);
        if (productView != null && getActivity() != null) {
            int i = R.drawable.product_view_default_bg_n;
            int i2 = android.R.color.white;
            if (this.c == 1) {
                i = R.drawable.product_view_white_bg;
                i2 = R.color.product_view_dark;
            }
            productView.setProductViewBackgroundResource(i);
            productView.setPriceColor(getResources().getColor(i2));
            productView.setTitleColor(getResources().getColor(i2));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected void a(View view, TextView textView) {
        if (view != null && textView != null) {
            view.setBackground(null);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams != null && getActivity() != null) {
                marginLayoutParams.bottomMargin = ((int) getResources().getDisplayMetrics().density) * 2;
            }
            if (getActivity() == null || !com.nexstreaming.kinemaster.tracelog.e.c(getActivity())) {
                textView.setText(R.string.sub_export_without_watermark_new);
            } else {
                textView.setText(String.format(getString(R.string.sub_export_without_watermark_limit_duration), Integer.valueOf(com.nexstreaming.kinemaster.tracelog.e.d())));
            }
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setCompoundDrawables(null, null, null, null);
            view.setOnClickListener(new ax(this));
        }
        new Handler().post(new ay(this, view, textView));
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.e) {
            getFragmentManager().popBackStackImmediate();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected String e() {
        return this.d == null ? super.e() : this.d;
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.a
    protected boolean b() {
        return true;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
