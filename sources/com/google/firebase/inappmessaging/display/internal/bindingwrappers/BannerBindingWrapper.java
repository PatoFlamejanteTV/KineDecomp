package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@InAppMessageScope
/* loaded from: classes2.dex */
public class BannerBindingWrapper extends BindingWrapper {

    /* renamed from: d */
    private FiamFrameLayout f17575d;

    /* renamed from: e */
    private ViewGroup f17576e;

    /* renamed from: f */
    private TextView f17577f;

    /* renamed from: g */
    private ResizableImageView f17578g;

    /* renamed from: h */
    private TextView f17579h;
    private View.OnClickListener i;

    @Inject
    public BannerBindingWrapper(InAppMessage inAppMessage, LayoutInflater layoutInflater, InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    private void b(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        this.f17575d.setDismissListener(this.i);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewTreeObserver.OnGlobalLayoutListener a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View inflate = this.f17585c.inflate(R.layout.banner, (ViewGroup) null);
        this.f17575d = (FiamFrameLayout) inflate.findViewById(R.id.banner_root);
        this.f17576e = (ViewGroup) inflate.findViewById(R.id.banner_content_root);
        this.f17577f = (TextView) inflate.findViewById(R.id.banner_body);
        this.f17578g = (ResizableImageView) inflate.findViewById(R.id.banner_image);
        this.f17579h = (TextView) inflate.findViewById(R.id.banner_title);
        a(this.f17583a);
        a(this.f17584b);
        b(onClickListener2);
        a(onClickListener);
        return null;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public boolean a() {
        return true;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View c() {
        return this.f17576e;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View.OnClickListener d() {
        return this.i;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView e() {
        return this.f17578g;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup f() {
        return this.f17575d;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig b() {
        return this.f17584b;
    }

    private void a(InAppMessage inAppMessage) {
        if (!TextUtils.isEmpty(inAppMessage.getBackgroundHexColor())) {
            a(this.f17576e, inAppMessage.getBackgroundHexColor());
        }
        this.f17578g.setVisibility(TextUtils.isEmpty(inAppMessage.getImageUrl()) ? 8 : 0);
        if (inAppMessage.getTitle() != null) {
            if (!TextUtils.isEmpty(inAppMessage.getTitle().getText())) {
                this.f17579h.setText(inAppMessage.getTitle().getText());
            }
            if (!TextUtils.isEmpty(inAppMessage.getTitle().getHexColor())) {
                this.f17579h.setTextColor(Color.parseColor(inAppMessage.getTitle().getHexColor()));
            }
        }
        if (inAppMessage.getBody() != null) {
            if (!TextUtils.isEmpty(inAppMessage.getBody().getText())) {
                this.f17577f.setText(inAppMessage.getBody().getText());
            }
            if (TextUtils.isEmpty(inAppMessage.getBody().getHexColor())) {
                return;
            }
            this.f17577f.setTextColor(Color.parseColor(inAppMessage.getBody().getHexColor()));
        }
    }

    private void a(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        int min = Math.min(inAppMessageLayoutConfig.h().intValue(), inAppMessageLayoutConfig.g().intValue());
        ViewGroup.LayoutParams layoutParams = this.f17575d.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = min;
        this.f17575d.setLayoutParams(layoutParams);
        this.f17578g.setMaxHeight(inAppMessageLayoutConfig.e());
        this.f17578g.setMaxWidth(inAppMessageLayoutConfig.f());
    }

    private void a(View.OnClickListener onClickListener) {
        this.f17576e.setOnClickListener(onClickListener);
    }
}
