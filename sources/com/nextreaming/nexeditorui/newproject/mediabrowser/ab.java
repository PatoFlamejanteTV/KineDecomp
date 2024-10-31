package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class ab implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ u f4698a;

    public ab(u uVar) {
        this.f4698a = uVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        View view;
        View view2;
        View view3;
        View view4;
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        View view5;
        View view6;
        View view7;
        if (this.f4698a.f4743a.getResources().getConfiguration().screenWidthDp >= this.f4698a.f4743a.getResources().getConfiguration().screenHeightDp) {
            view = this.f4698a.f4743a.j;
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton_media_detail_delete);
            view2 = this.f4698a.f4743a.j;
            View findViewById = view2.findViewById(R.id.detailBtnAndTitleHolder);
            Rect rect = new Rect();
            imageButton.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.right >= rect2.right) {
                this.f4698a.f4743a.B = true;
                view5 = this.f4698a.f4743a.j;
                view5.findViewById(R.id.imageButton_media_detail_previous).setVisibility(8);
                view6 = this.f4698a.f4743a.j;
                view6.findViewById(R.id.imageButton_media_detail_next).setVisibility(8);
                view7 = this.f4698a.f4743a.j;
                View findViewById2 = view7.findViewById(R.id.linear_detail_body);
                findViewById2.setPadding(0, 0, 0, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
                marginLayoutParams.setMargins(0, 0, 0, 0);
                findViewById2.setLayoutParams(marginLayoutParams);
            } else {
                this.f4698a.f4743a.B = false;
                view3 = this.f4698a.f4743a.j;
                View findViewById3 = view3.findViewById(R.id.linear_detail_body);
                findViewById3.setPadding(this.f4698a.f4743a.getResources().getDimensionPixelOffset(R.dimen.mb_detailview_body_padding), 0, this.f4698a.f4743a.getResources().getDimensionPixelOffset(R.dimen.mb_detailview_body_padding), 0);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) findViewById3.getLayoutParams();
                int dimensionPixelOffset = this.f4698a.f4743a.getResources().getDimensionPixelOffset(R.dimen.mb_detailview_body_margin);
                marginLayoutParams2.setMargins(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
                findViewById3.setLayoutParams(marginLayoutParams2);
            }
            view4 = this.f4698a.f4743a.j;
            ViewTreeObserver viewTreeObserver = view4.getViewTreeObserver();
            onGlobalLayoutListener = this.f4698a.f4743a.C;
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }
}
