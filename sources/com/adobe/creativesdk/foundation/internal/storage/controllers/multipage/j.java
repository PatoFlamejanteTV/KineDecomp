package com.adobe.creativesdk.foundation.internal.storage.controllers.multipage;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAssetOneUpRecyclerViewController.java */
/* loaded from: classes.dex */
public class j extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f6287a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(o oVar) {
        this.f6287a = oVar;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        o oVar = this.f6287a;
        if (oVar.l > 1) {
            int findFirstVisibleItemPosition = oVar.f6304f.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.f6287a.f6304f.findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
                View findViewByPosition = this.f6287a.f6304f.findViewByPosition(findFirstVisibleItemPosition);
                int i3 = findFirstVisibleItemPosition + 1;
                View findViewByPosition2 = this.f6287a.f6304f.findViewByPosition(i3);
                if (findViewByPosition != null && findViewByPosition2 != null) {
                    int top = findViewByPosition.getTop() < 0 ? 0 : findViewByPosition.getTop();
                    int bottom = findViewByPosition.getBottom() < 0 ? 0 : findViewByPosition.getBottom();
                    int top2 = findViewByPosition2.getTop() < 0 ? 0 : findViewByPosition2.getTop();
                    int bottom2 = findViewByPosition2.getBottom() < 0 ? 0 : findViewByPosition2.getBottom();
                    if ((top2 > bottom2 ? top2 - bottom2 : bottom2 - top2) > (top > bottom ? top - bottom : bottom - top)) {
                        findFirstVisibleItemPosition = i3;
                    }
                }
            }
            o oVar2 = this.f6287a;
            oVar2.f6306h.setText(String.format(oVar2.f6302d.getResources().getString(c.a.a.a.b.i.adobe_csdk_asset_view_multi_page_numbering), Integer.valueOf(findFirstVisibleItemPosition + 1), Integer.valueOf(this.f6287a.l)));
        }
    }
}
