package com.nexstreaming.kinemaster.support;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.nexstreaming.app.kinemasterfree.R;

/* loaded from: classes.dex */
public class SupportAppsActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_support);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.container, a.a());
        beginTransaction.commit();
    }
}
