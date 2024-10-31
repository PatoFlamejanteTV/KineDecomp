package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.appcompat.R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: classes.dex */
class TooltipPopup {

    /* renamed from: a */
    private final Context f3154a;

    /* renamed from: b */
    private final View f3155b;

    /* renamed from: c */
    private final TextView f3156c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f3157d = new WindowManager.LayoutParams();

    /* renamed from: e */
    private final Rect f3158e = new Rect();

    /* renamed from: f */
    private final int[] f3159f = new int[2];

    /* renamed from: g */
    private final int[] f3160g = new int[2];

    public TooltipPopup(Context context) {
        this.f3154a = context;
        this.f3155b = LayoutInflater.from(this.f3154a).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f3156c = (TextView) this.f3155b.findViewById(R.id.message);
        this.f3157d.setTitle(TooltipPopup.class.getSimpleName());
        this.f3157d.packageName = this.f3154a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f3157d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public void a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.f3156c.setText(charSequence);
        a(view, i, i2, z, this.f3157d);
        ((WindowManager) this.f3154a.getSystemService("window")).addView(this.f3155b, this.f3157d);
    }

    boolean b() {
        return this.f3155b.getParent() != null;
    }

    public void a() {
        if (b()) {
            ((WindowManager) this.f3154a.getSystemService("window")).removeView(this.f3155b);
        }
    }

    private void a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f3154a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f3154a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f3154a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View a2 = a(view);
        if (a2 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a2.getWindowVisibleDisplayFrame(this.f3158e);
        Rect rect = this.f3158e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f3154a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f3158e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a2.getLocationOnScreen(this.f3160g);
        view.getLocationOnScreen(this.f3159f);
        int[] iArr = this.f3159f;
        int i4 = iArr[0];
        int[] iArr2 = this.f3160g;
        iArr[0] = i4 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (a2.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f3155b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f3155b.getMeasuredHeight();
        int[] iArr3 = this.f3159f;
        int i5 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i6 = iArr3[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i5 >= 0) {
                layoutParams.y = i5;
                return;
            } else {
                layoutParams.y = i6;
                return;
            }
        }
        if (measuredHeight + i6 <= this.f3158e.height()) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i5;
        }
    }

    private static View a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
