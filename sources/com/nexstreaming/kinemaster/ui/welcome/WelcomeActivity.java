package com.nexstreaming.kinemaster.ui.welcome;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import c.d.b.m.i;
import com.nexstreaming.app.general.iab.IABError;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.general.iab.SKUDetails;
import com.nexstreaming.app.general.iab.Utils.IABConstant;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.t;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nextreaming.nexeditorui.I;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

/* compiled from: WelcomeActivity.kt */
/* loaded from: classes2.dex */
public final class WelcomeActivity extends I implements tb.a, tb.b, com.nexstreaming.app.general.iab.a.a {
    static final /* synthetic */ kotlin.reflect.g[] H;
    private final kotlin.d I;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(j.a(WelcomeActivity.class), "mPreparePurchaseDialog", "getMPreparePurchaseDialog()Lcom/nexstreaming/kinemaster/ui/dialog/NexSimpleLoadingDialog;");
        j.a(propertyReference1Impl);
        H = new kotlin.reflect.g[]{propertyReference1Impl};
    }

    public WelcomeActivity() {
        kotlin.d a2;
        a2 = kotlin.f.a(new kotlin.jvm.a.a<t>() { // from class: com.nexstreaming.kinemaster.ui.welcome.WelcomeActivity$mPreparePurchaseDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final t invoke() {
                return new t(WelcomeActivity.this);
            }
        });
        this.I = a2;
    }

    private final void K() {
        if (isFinishing() || !L().isShowing()) {
            return;
        }
        L().dismiss();
    }

    private final t L() {
        kotlin.d dVar = this.I;
        kotlin.reflect.g gVar = H[0];
        return (t) dVar.getValue();
    }

    private final void M() {
        c.d.b.m.c.d(this);
        getIntent().setClass(this, ProjectGalleryActivity.class);
        startActivity(getIntent());
        finish();
    }

    private final void N() {
        if (isFinishing() || L().isShowing()) {
            return;
        }
        L().a(60000L);
        L().show();
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.a
    public void a(String str) {
        M();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, LinkedHashMap<String, SKUDetails>> linkedHashMap) {
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.tb.b
    public void i() {
        N();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String localClassName = getLocalClassName();
        h.a((Object) localClassName, "this.localClassName");
        com.nexstreaming.kinemaster.usage.analytics.b.a(localClassName);
        super.onCreate(bundle);
        y().a((com.nexstreaming.app.general.iab.a.a) this);
        setContentView(R.layout.activity_welcome);
        try {
            c a2 = c.f23695b.a(true);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            h.a((Object) supportFragmentManager, "supportFragmentManager");
            a2.show(supportFragmentManager);
        } catch (Exception unused) {
            M();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        y().b((com.nexstreaming.app.general.iab.a.a) this);
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, int i, boolean z2) {
        if (!z) {
            K();
        }
        if ((!i.f(this)) && z2) {
            K();
            Toast.makeText(this, getString(R.string.theme_download_server_connection_error), 0).show();
        }
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(LinkedHashMap<IABConstant.SKUType, List<Purchase>> linkedHashMap, IABError iABError, String str) {
        h.b(iABError, "error");
        K();
    }

    @Override // com.nexstreaming.app.general.iab.a.a
    public void a(boolean z, Purchase purchase, String str) {
        super.b(z, purchase, str);
        if (z) {
            M();
        }
    }
}
