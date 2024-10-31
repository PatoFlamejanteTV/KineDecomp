package com.facebook.login.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.facebook.login.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ToolTipPopup {
    public static final long DEFAULT_POPUP_DISPLAY_TIME = 6000;
    private final WeakReference<View> mAnchorViewRef;
    private final Context mContext;
    private a mPopupContent;
    private PopupWindow mPopupWindow;
    private final String mText;
    private Style mStyle = Style.BLUE;
    private long mNuxDisplayTime = DEFAULT_POPUP_DISPLAY_TIME;
    private final ViewTreeObserver.OnScrollChangedListener mScrollListener = new h(this);

    /* loaded from: classes.dex */
    public enum Style {
        BLUE,
        BLACK
    }

    /* loaded from: classes.dex */
    public class a extends FrameLayout {

        /* renamed from: a */
        private ImageView f9402a;

        /* renamed from: b */
        private ImageView f9403b;

        /* renamed from: c */
        private View f9404c;

        /* renamed from: d */
        private ImageView f9405d;

        public a(Context context) {
            super(context);
            c();
        }

        private void c() {
            LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
            this.f9402a = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer);
            this.f9403b = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.f9404c = findViewById(R.id.com_facebook_body_frame);
            this.f9405d = (ImageView) findViewById(R.id.com_facebook_button_xout);
        }

        public void a() {
            this.f9402a.setVisibility(4);
            this.f9403b.setVisibility(0);
        }

        public void b() {
            this.f9402a.setVisibility(0);
            this.f9403b.setVisibility(4);
        }
    }

    public ToolTipPopup(String str, View view) {
        this.mText = str;
        this.mAnchorViewRef = new WeakReference<>(view);
        this.mContext = view.getContext();
    }

    private void registerObserver() {
        unregisterObserver();
        if (this.mAnchorViewRef.get() != null) {
            this.mAnchorViewRef.get().getViewTreeObserver().addOnScrollChangedListener(this.mScrollListener);
        }
    }

    private void unregisterObserver() {
        if (this.mAnchorViewRef.get() != null) {
            this.mAnchorViewRef.get().getViewTreeObserver().removeOnScrollChangedListener(this.mScrollListener);
        }
    }

    private void updateArrows() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        if (this.mPopupWindow.isAboveAnchor()) {
            this.mPopupContent.a();
        } else {
            this.mPopupContent.b();
        }
    }

    public void dismiss() {
        unregisterObserver();
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void setNuxDisplayTime(long j) {
        this.mNuxDisplayTime = j;
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new a(this.mContext);
            ((TextView) this.mPopupContent.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.f9404c.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
                this.mPopupContent.f9403b.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                this.mPopupContent.f9402a.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                this.mPopupContent.f9405d.setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
            } else {
                this.mPopupContent.f9404c.setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
                this.mPopupContent.f9403b.setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
                this.mPopupContent.f9402a.setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
                this.mPopupContent.f9405d.setImageResource(R.drawable.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(View.MeasureSpec.makeMeasureSpec(width, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(height, Integer.MIN_VALUE));
            a aVar = this.mPopupContent;
            this.mPopupWindow = new PopupWindow(aVar, aVar.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown(this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new i(this), this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new j(this));
        }
    }
}
