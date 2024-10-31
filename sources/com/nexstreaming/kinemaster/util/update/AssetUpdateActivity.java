package com.nexstreaming.kinemaster.util.update;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nextreaming.nexeditorui.AbstractActivityC2299ba;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AssetUpdateActivity extends AbstractActivityC2299ba<com.nexstreaming.app.kinemasterfree.a.a> {
    private static final String TAG = "AssetUpdateActivity";
    private ResultTask I;
    private final List<com.nexstreaming.app.general.nexasset.assetpackage.b> J = new ArrayList();
    private int K;
    private int L;
    private boolean M;

    private void K() {
        AssetUpdateChecker.a(this).b().onResultAvailable(new e(this));
    }

    public void L() {
        if (c.d.b.m.i.f(this)) {
            H().y.setVisibility(0);
            K();
            return;
        }
        H().y.setVisibility(8);
        e.a aVar = new e.a(this);
        aVar.c(R.string.theme_download_server_connection_error);
        aVar.c(R.string.button_ok, new b(this));
        aVar.a(R.string.button_cancel, new a(this));
        aVar.a().show();
    }

    public void M() {
        this.M = true;
        H().y.setVisibility(8);
        e.a aVar = new e.a(u());
        aVar.a(getString(R.string.asset_update_confirm_update_done));
        aVar.a(new g(this));
        aVar.c(R.string.button_ok, new f(this));
        aVar.a().show();
    }

    public void N() {
        this.K = this.J.size() * 2;
        this.L = 0;
        Q();
    }

    public void O() {
        if (this.J.size() > 0) {
            P();
            return;
        }
        ResultTask resultTask = this.I;
        if (resultTask != null) {
            resultTask.sendResult(true);
        } else {
            finish();
        }
    }

    public ResultTask P() {
        if (this.I == null) {
            this.I = new ResultTask();
        }
        com.nexstreaming.app.general.nexasset.assetpackage.b remove = this.J.remove(0);
        if (remove != null) {
            KineMasterApplication.m().q().a(remove.getAssetIdx(), false).onResultAvailable(new n(this, remove));
            this.L++;
        }
        return this.I;
    }

    private void Q() {
        H().z.postOnAnimationDelayed(new o(this), 50L);
    }

    public static /* synthetic */ int k(AssetUpdateActivity assetUpdateActivity) {
        int i = assetUpdateActivity.L;
        assetUpdateActivity.L = i + 1;
        return i;
    }

    @Override // com.nextreaming.nexeditorui.AbstractActivityC2299ba
    protected int G() {
        return R.layout.activity_asset_update;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.nextreaming.nexeditorui.AbstractActivityC2299ba, com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags = 2;
        attributes.dimAmount = 0.7f;
        getWindow().setAttributes(attributes);
        overridePendingTransition(0, 0);
        L();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AssetUpdateChecker.a(this).a();
        super.onDestroy();
    }

    public static Intent c(Context context) {
        return new Intent(context, (Class<?>) AssetUpdateActivity.class);
    }

    public void d(int i) {
        this.M = true;
        H().y.setVisibility(8);
        e.a aVar = new e.a(u());
        aVar.a(getString(i));
        aVar.a(new i(this));
        aVar.c(R.string.button_ok, new h(this));
        aVar.a().show();
    }

    @Override // com.nextreaming.nexeditorui.I
    public void a(Context context) {
        if (this.M) {
            return;
        }
        d(R.string.theme_download_server_connection_error);
    }
}
