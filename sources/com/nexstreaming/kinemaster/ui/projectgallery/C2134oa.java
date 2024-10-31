package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import java.util.ArrayList;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.oa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2134oa implements KMCloud.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22963a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2134oa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22963a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud.b
    public void a(String str, KMCloud.KMCloudState kMCloudState) {
        KMCloud kMCloud;
        com.nexstreaming.kinemaster.project.k kVar;
        ArrayList arrayList;
        kMCloud = this.f22963a.Da;
        kVar = this.f22963a.va;
        String f2 = kVar.f();
        arrayList = this.f22963a.Ea;
        kMCloud.a(f2, arrayList);
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud.b
    public void b(String str, KMCloud.KMCloudReturnValue kMCloudReturnValue, KMCloud.KMCloudState kMCloudState) {
        this.f22963a.runOnUiThread(new RunnableC2127la(this));
        this.f22963a.runOnUiThread(new RunnableC2132na(this, kMCloudReturnValue, str));
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud.b
    public void a(String str, KMCloud.KMCloudReturnValue kMCloudReturnValue, KMCloud.KMCloudState kMCloudState) {
        KMCloud kMCloud;
        KMCloud kMCloud2;
        int i;
        ArrayList arrayList;
        if (kMCloudReturnValue == KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_UPLOAD_DONE) {
            Log.d("ProjectGalleryActivity", "!!!!!!!!!!!!!! All files uploaded !!!!!!!!!!!!!!");
            this.f22963a.runOnUiThread(new RunnableC2115ha(this, str));
            return;
        }
        int i2 = zb.f23010a[kMCloudState.ordinal()];
        if (i2 == 1) {
            this.f22963a.runOnUiThread(new RunnableC2118ia(this, str));
            kMCloud = this.f22963a.Da;
            kMCloud.e();
            return;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                this.f22963a.Q = 0;
                kMCloud2 = this.f22963a.Da;
                kMCloud2.b(null);
            } else {
                if (i2 != 4) {
                    return;
                }
                ProjectGalleryActivity.s(this.f22963a);
                StringBuilder sb = new StringBuilder();
                sb.append("File uploading done : ");
                i = this.f22963a.Q;
                sb.append(i);
                sb.append("/");
                arrayList = this.f22963a.Ea;
                sb.append(arrayList.size());
                Log.d("ProjectGalleryActivity", sb.toString());
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud.b
    public void a(String str, KMCloud.KMCloudState kMCloudState, String str2) {
        ProjectGalleryActivity.H = 0;
        this.f22963a.runOnUiThread(new RunnableC2121ja(this, str2));
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.KMCloud.b
    public void a(String str, KMCloud.KMCloudState kMCloudState, int i, int i2) {
        if (i >= ProjectGalleryActivity.H + 10) {
            ProjectGalleryActivity.H = i;
            this.f22963a.runOnUiThread(new RunnableC2124ka(this, i, i2));
        }
    }
}
