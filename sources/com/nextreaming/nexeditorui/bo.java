package com.nextreaming.nexeditorui;

import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KineMasterBaseActivity.java */
/* loaded from: classes.dex */
public class bo implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f4552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(ba baVar) {
        this.f4552a = baVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        String b = InstanceID.b(this.f4552a).b();
        Intent intent = new Intent();
        intent.putExtra("authAccount", b);
        this.f4552a.onActivityResult(R.id.choose_google_account_promocode, -1, intent);
        Log.i("BaseActivity", "app instanceId = " + b);
    }
}
