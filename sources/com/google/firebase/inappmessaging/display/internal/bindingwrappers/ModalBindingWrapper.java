package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.InAppMessage;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@InAppMessageScope
/* loaded from: classes2.dex */
public class ModalBindingWrapper extends BindingWrapper {

    /* renamed from: d */
    private FiamRelativeLayout f17593d;

    /* renamed from: e */
    private ViewGroup f17594e;

    /* renamed from: f */
    private ScrollView f17595f;

    /* renamed from: g */
    private Button f17596g;

    /* renamed from: h */
    private View f17597h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private ViewTreeObserver.OnGlobalLayoutListener l;

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public ScrollViewAdjustableListener() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ModalBindingWrapper.this.i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Inject
    public ModalBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater, InAppMessage inAppMessage) {
        super(inAppMessageLayoutConfig, layoutInflater, inAppMessage);
        this.l = new ScrollViewAdjustableListener();
    }

    private void g() {
        if (this.f17596g != null && this.f17583a.getActionButton() != null && this.f17583a.getActionButton().getButtonHexColor() != null) {
            int parseColor = Color.parseColor(this.f17583a.getActionButton().getButtonHexColor());
            Drawable wrap = DrawableCompat.wrap(this.f17596g.getBackground());
            DrawableCompat.setTint(wrap, parseColor);
            this.f17596g.setBackground(wrap);
            if (this.f17583a.getActionButton() == null || this.f17583a.getActionButton().getText() == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f17583a.getActionButton().getText().getText())) {
                this.f17596g.setVisibility(0);
                this.f17596g.setText(this.f17583a.getActionButton().getText().getText());
            } else {
                this.f17596g.setVisibility(8);
            }
            String hexColor = this.f17583a.getActionButton().getText().getHexColor();
            if (TextUtils.isEmpty(hexColor)) {
                return;
            }
            this.f17596g.setTextColor(Color.parseColor(hexColor));
            return;
        }
        this.f17596g.setVisibility(8);
    }

    private void h() {
        ViewGroup viewGroup = this.f17594e;
        if (viewGroup != null) {
            a(viewGroup, this.f17583a.getBackgroundHexColor());
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig b() {
        return this.f17584b;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View c() {
        return this.f17594e;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView e() {
        return this.i;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup f() {
        return this.f17593d;
    }

    private void b(View.OnClickListener onClickListener) {
        this.f17597h.setOnClickListener(onClickListener);
        this.f17593d.setDismissListener(onClickListener);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewTreeObserver.OnGlobalLayoutListener a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        View inflate = this.f17585c.inflate(R.layout.modal, (ViewGroup) null);
        this.f17595f = (ScrollView) inflate.findViewById(R.id.body_scroll);
        this.f17596g = (Button) inflate.findViewById(R.id.button);
        this.f17597h = inflate.findViewById(R.id.collapse_button);
        this.i = (ImageView) inflate.findViewById(R.id.image_view);
        this.j = (TextView) inflate.findViewById(R.id.message_body);
        this.k = (TextView) inflate.findViewById(R.id.message_title);
        this.f17593d = (FiamRelativeLayout) inflate.findViewById(R.id.modal_root);
        this.f17594e = (ViewGroup) inflate.findViewById(R.id.modal_content_root);
        a(this.f17583a);
        a(this.f17584b);
        b(onClickListener2);
        a(onClickListener);
        h();
        g();
        return this.l;
    }

    private void a(InAppMessage inAppMessage) {
        if (TextUtils.isEmpty(inAppMessage.getImageUrl())) {
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
        }
        if (inAppMessage.getTitle() != null) {
            if (!TextUtils.isEmpty(inAppMessage.getTitle().getText())) {
                this.k.setVisibility(0);
                this.k.setText(inAppMessage.getTitle().getText());
            } else {
                this.k.setVisibility(8);
            }
            if (!TextUtils.isEmpty(inAppMessage.getTitle().getHexColor())) {
                this.k.setTextColor(Color.parseColor(inAppMessage.getTitle().getHexColor()));
            }
        }
        if (inAppMessage.getBody() != null && !TextUtils.isEmpty(inAppMessage.getBody().getText())) {
            this.f17595f.setVisibility(0);
        } else {
            this.f17595f.setVisibility(8);
        }
        if (inAppMessage.getBody() != null) {
            if (!TextUtils.isEmpty(inAppMessage.getBody().getText())) {
                this.j.setVisibility(0);
                this.j.setText(inAppMessage.getBody().getText());
            } else {
                this.j.setVisibility(8);
            }
            if (TextUtils.isEmpty(inAppMessage.getBody().getHexColor())) {
                return;
            }
            this.j.setTextColor(Color.parseColor(inAppMessage.getBody().getHexColor()));
        }
    }

    private void a(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.i.setMaxHeight(inAppMessageLayoutConfig.e());
        this.i.setMaxWidth(inAppMessageLayoutConfig.f());
    }

    private void a(View.OnClickListener onClickListener) {
        this.f17596g.setOnClickListener(onClickListener);
    }
}
