package com.nexstreaming.kinemaster.ui.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2229m implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ V f23366a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.e f23367b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23368c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2229m(ExportAndShareActivity exportAndShareActivity, V v, com.nexstreaming.kinemaster.ui.a.e eVar) {
        this.f23368c = exportAndShareActivity;
        this.f23366a = v;
        this.f23367b = eVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Activity u;
        Uri b2;
        Intent intent = (Intent) adapterView.getItemAtPosition(i);
        String str = intent.getPackage();
        if (str != null) {
            if (str.contains("com.google.android.youtube") && this.f23366a.f23319h) {
                this.f23368c.fa = intent;
                this.f23368c.h(R.string.export_muserk_notice_youtube_msg);
            } else {
                if (str.contains(ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME)) {
                    u = this.f23368c.u();
                    b2 = ExportAndShareActivity.b(u, new File(this.f23366a.f23316e));
                    intent.putExtra("android.intent.extra.STREAM", b2);
                }
                this.f23368c.startActivity(intent);
            }
        }
        this.f23367b.dismiss();
        new File(this.f23366a.f23316e).length();
        HashMap hashMap = new HashMap();
        hashMap.put("target", intent.getStringExtra("displayName"));
        hashMap.put("duration", Integer.toString(this.f23368c.H().g()));
        hashMap.put("result", "Success");
        KMEvents.SHARE_VIDEO.logEvent(hashMap);
    }
}
