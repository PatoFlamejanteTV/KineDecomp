package com.nexstreaming.kinemaster.codeccaps.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nextreaming.nexeditorui.I;

/* loaded from: classes.dex */
public class CapabilityTestIntroActivity extends I {
    public static boolean H = false;

    public static Intent a(Context context, boolean z) {
        return a(context, null, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        setContentView(R.layout.activity_capability_test_intro);
        boolean booleanExtra = getIntent().getBooleanExtra("force_start", false);
        if (!booleanExtra && CapabilityManager.f20040b.s()) {
            finish();
        } else if (H) {
            H = false;
            finish();
        } else {
            findViewById(R.id.toolbar).post(new a(this, booleanExtra));
        }
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (H) {
            H = false;
            finish();
        }
    }

    public static Intent a(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) CapabilityTestIntroActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("device_id", str);
        }
        intent.putExtra("force_start", z);
        return intent;
    }
}
