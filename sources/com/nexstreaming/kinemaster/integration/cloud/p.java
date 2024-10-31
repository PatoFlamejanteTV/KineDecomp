package com.nexstreaming.kinemaster.integration.cloud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.adobe.creativesdk.foundation.auth.j;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0578la;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
public class p extends KMCloud {
    private com.adobe.creativesdk.foundation.auth.k i;
    private AdobeAuthSessionHelper j;
    private C0578la k;
    private AdobeAuthSessionHelper.a l;

    public p(Activity activity, KMCloud.b bVar) {
        super(activity, "Adobe Creative Cloud", bVar);
        this.i = com.adobe.creativesdk.foundation.auth.k.a();
        this.l = new g(this);
    }

    private void d(String str) {
        a((C0578la) null, str, new k(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        j.a aVar = new j.a();
        aVar.a((Context) this.f20420d);
        aVar.a(((KineMasterApplication) this.f20420d.getApplicationContext()).c());
        aVar.a(((KineMasterApplication) this.f20420d.getApplicationContext()).d());
        aVar.a(1001);
        this.i.a(aVar.a());
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public String a() {
        return "Adobe Creative Cloud";
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public int d() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public void e() {
        this.f20419c.a("Adobe Creative Cloud", this.f20418b);
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.a
    public void onActivityResult(int i, int i2, Intent intent) {
        this.j.a(i2, i2, intent);
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.a
    public void onPause() {
        this.j.b();
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.a
    public void onResume() {
        if (this.f20418b == KMCloud.KMCloudState.KM_CLOUD_STATE_LOG_IN_TRY) {
            this.j.c();
        }
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.a
    public void onStop() {
        this.j.e();
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public int c() {
        this.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOG_IN_TRY;
        this.j = new AdobeAuthSessionHelper(this.l);
        this.j.a(null);
        this.j.c();
        return 0;
    }

    private void a(C0578la c0578la, String str, b bVar) {
        if (c0578la == null) {
            c0578la = C0578la.b();
        }
        if (c0578la.c()) {
            c0578la.a(1024, new h(this, str, bVar));
        }
    }

    public int c(String str) {
        if (b() == KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT) {
            return -1;
        }
        C0578la.b().getHref();
        l lVar = new l(this);
        m mVar = new m(this);
        this.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER;
        C0578la.a(str, C0578la.b(), lVar, mVar);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0578la c0578la, c cVar) {
        if (c0578la.c()) {
            c0578la.a(1024, new i(this, cVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<? extends KMCloud.a> list) {
        if (list == null || list.size() <= 0 || this.f20422f.size() <= 0) {
            return;
        }
        for (KMCloud.a aVar : list) {
            if (!aVar.f20427c.equals("text/xml")) {
                String str = aVar.f20426b;
                Iterator<String> it = this.f20422f.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next.substring(next.lastIndexOf("/") + 1).equals(str)) {
                        it.remove();
                    }
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public int a(String str, List<String> list) {
        if (str == null || list == null || list.size() <= 0) {
            return -1;
        }
        this.f20422f = list;
        this.f20423g = list.size();
        this.f20421e = str;
        d(str);
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud
    public Task a(String str) {
        Task task = new Task();
        if (this.k == null) {
            task.sendFailure(KMCloud.CloudError.UPLOADING_ERROR);
        }
        File file = new File(str);
        URL url = null;
        try {
            url = file.toURI().toURL();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
        }
        AdobeAssetFile.create(file.getName(), this.k, url, c.d.b.d.e.a.e(file.getAbsolutePath()), new n(this, task), null);
        this.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FILE;
        return task;
    }
}
