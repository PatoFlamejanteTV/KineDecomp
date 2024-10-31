package com.nexstreaming.kinemaster.support;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.newproject.toolbar.ToolbarLayout;

/* loaded from: classes.dex */
public class SupportAppsActivity extends I {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        super.j(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_support);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        ((ToolbarLayout) findViewById(R.id.toolbar_settings)).setTitle(R.string.help_support_toolbar_title);
        beginTransaction.replace(R.id.container, SupportInfoV4Fragment.z());
        beginTransaction.commit();
    }
}
