package com.nexstreaming.kinemaster.itemstore;

import android.view.View;
import android.webkit.WebView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;

/* compiled from: KMAssetStore.java */
/* loaded from: classes.dex */
class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ KMAssetStore f3408a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(KMAssetStore kMAssetStore) {
        this.f3408a = kMAssetStore;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Toolbar toolbar;
        WebView webView;
        Toolbar toolbar2;
        Toolbar toolbar3;
        Toolbar toolbar4;
        Toolbar toolbar5;
        Toolbar toolbar6;
        WebView webView2;
        WebView webView3;
        switch (view.getId()) {
            case R.id.titleHolder /* 2131821574 */:
                toolbar = this.f3408a.f3405a;
                if (toolbar.getTitleMode() == Toolbar.TitleMode.Back) {
                    this.f3408a.onBackPressed();
                    return;
                }
                return;
            case R.id.toolbar_button /* 2131821584 */:
                webView = this.f3408a.b;
                if (webView != null) {
                    webView3 = this.f3408a.b;
                    webView3.setVisibility(8);
                }
                toolbar2 = this.f3408a.f3405a;
                if (toolbar2.getTitleMode() == Toolbar.TitleMode.Back) {
                    KMAssetStore kMAssetStore = this.f3408a;
                    webView2 = this.f3408a.b;
                    kMAssetStore.e = webView2.getTitle();
                }
                toolbar3 = this.f3408a.f3405a;
                toolbar3.setRightButtonVisiblity(false);
                toolbar4 = this.f3408a.f3405a;
                toolbar4.setTitleMode(Toolbar.TitleMode.Back);
                toolbar5 = this.f3408a.f3405a;
                toolbar5.setLogoVisiblity(false);
                toolbar6 = this.f3408a.f3405a;
                toolbar6.setTitle(this.f3408a.getResources().getString(R.string.my_asset_title));
                this.f3408a.getFragmentManager().beginTransaction().replace(R.id.fragmentHolder, new d()).addToBackStack("myAsset").commit();
                return;
            case R.id.cancel_button /* 2131821586 */:
                this.f3408a.finish();
                return;
            default:
                return;
        }
    }
}
