package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@InAppMessageScope
/* loaded from: classes2.dex */
public class ImageBindingWrapper extends BindingWrapper {

    /* renamed from: d */
    private FiamFrameLayout f17586d;

    /* renamed from: e */
    private ViewGroup f17587e;

    /* renamed from: f */
    private ImageView f17588f;

    /* renamed from: g */
    private Button f17589g;

    @Inject
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewTreeObserver.OnGlobalLayoutListener a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View inflate = this.f17585c.inflate(R.layout.image, (ViewGroup) null);
        this.f17586d = (FiamFrameLayout) inflate.findViewById(R.id.image_root);
        this.f17587e = (ViewGroup) inflate.findViewById(R.id.image_content_root);
        this.f17588f = (ImageView) inflate.findViewById(R.id.image_view);
        this.f17589g = (Button) inflate.findViewById(R.id.collapse_button);
        this.f17588f.setMaxHeight(this.f17584b.e());
        this.f17588f.setMaxWidth(this.f17584b.f());
        this.f17588f.setVisibility(TextUtils.isEmpty(this.f17583a.getImageUrl()) ? 8 : 0);
        this.f17588f.setOnClickListener(onClickListener);
        this.f17586d.setDismissListener(onClickListener2);
        this.f17589g.setOnClickListener(onClickListener2);
        return null;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View c() {
        return this.f17587e;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView e() {
        return this.f17588f;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup f() {
        return this.f17586d;
    }
}
