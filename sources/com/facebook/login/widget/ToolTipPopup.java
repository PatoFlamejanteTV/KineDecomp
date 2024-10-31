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
import com.facebook.R;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
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
    private final ViewTreeObserver.OnScrollChangedListener mScrollListener = new g(this);

    /* loaded from: classes.dex */
    public enum Style {
        BLUE,
        BLACK
    }

    public ToolTipPopup(String str, View view) {
        this.mText = str;
        this.mAnchorViewRef = new WeakReference<>(view);
        this.mContext = view.getContext();
    }

    public void setStyle(Style style) {
        this.mStyle = style;
    }

    public void show() {
        if (this.mAnchorViewRef.get() != null) {
            this.mPopupContent = new a(this.mContext);
            ((TextView) this.mPopupContent.findViewById(R.id.com_facebook_tooltip_bubble_view_text_body)).setText(this.mText);
            if (this.mStyle == Style.BLUE) {
                this.mPopupContent.d.setBackgroundResource(R.drawable.com_facebook_tooltip_blue_background);
                this.mPopupContent.c.setImageResource(R.drawable.com_facebook_tooltip_blue_bottomnub);
                this.mPopupContent.b.setImageResource(R.drawable.com_facebook_tooltip_blue_topnub);
                this.mPopupContent.e.setImageResource(R.drawable.com_facebook_tooltip_blue_xout);
            } else {
                this.mPopupContent.d.setBackgroundResource(R.drawable.com_facebook_tooltip_black_background);
                this.mPopupContent.c.setImageResource(R.drawable.com_facebook_tooltip_black_bottomnub);
                this.mPopupContent.b.setImageResource(R.drawable.com_facebook_tooltip_black_topnub);
                this.mPopupContent.e.setImageResource(R.drawable.com_facebook_tooltip_black_xout);
            }
            View decorView = ((Activity) this.mContext).getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            registerObserver();
            this.mPopupContent.measure(View.MeasureSpec.makeMeasureSpec(width, NexEditorDeviceProfile.UNKNOWN), View.MeasureSpec.makeMeasureSpec(height, NexEditorDeviceProfile.UNKNOWN));
            this.mPopupWindow = new PopupWindow(this.mPopupContent, this.mPopupContent.getMeasuredWidth(), this.mPopupContent.getMeasuredHeight());
            this.mPopupWindow.showAsDropDown(this.mAnchorViewRef.get());
            updateArrows();
            if (this.mNuxDisplayTime > 0) {
                this.mPopupContent.postDelayed(new h(this), this.mNuxDisplayTime);
            }
            this.mPopupWindow.setTouchable(true);
            this.mPopupContent.setOnClickListener(new i(this));
        }
    }

    public void setNuxDisplayTime(long j) {
        this.mNuxDisplayTime = j;
    }

    private void updateArrows() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            if (this.mPopupWindow.isAboveAnchor()) {
                this.mPopupContent.b();
            } else {
                this.mPopupContent.a();
            }
        }
    }

    public void dismiss() {
        unregisterObserver();
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends FrameLayout {
        private ImageView b;
        private ImageView c;
        private View d;
        private ImageView e;

        public a(Context context) {
            super(context);
            c();
        }

        private void c() {
            LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
            this.b = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer);
            this.c = (ImageView) findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer);
            this.d = findViewById(R.id.com_facebook_body_frame);
            this.e = (ImageView) findViewById(R.id.com_facebook_button_xout);
        }

        public void a() {
            this.b.setVisibility(0);
            this.c.setVisibility(4);
        }

        public void b() {
            this.b.setVisibility(4);
            this.c.setVisibility(0);
        }
    }
}
