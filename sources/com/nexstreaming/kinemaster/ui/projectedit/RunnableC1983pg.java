package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.crashlytics.android.Crashlytics;
import com.facebook.stetho.dumpapp.Framer;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.umeng.commonsdk.proguard.ap;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1983pg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1983pg(ProjectEditActivity projectEditActivity) {
        this.f22481a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            PackageInfo packageInfo = this.f22481a.getPackageManager().getPackageInfo(this.f22481a.getPackageName(), 64);
            byte[] bArr = {80, 76, 80, 10, ap.l, 91, 72, Framer.STDIN_REQUEST_FRAME_PREFIX, ap.l, 103, 10, 107, ap.l, 107, 91, 41, 126, 126, 80, 72, 111, 111, 10, 107, 111, Framer.STDIN_REQUEST_FRAME_PREFIX, 76, 60, 10, 80, 10, 10};
            Signature[] signatureArr = packageInfo.signatures;
            int length = signatureArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String charsString = signatureArr[i].toCharsString();
                String a2 = com.nexstreaming.app.general.util.J.a("7G*_}edU4iWM}P9}{X}5QoW" + charsString.length() + charsString);
                int i3 = i2;
                for (int i4 = 0; i4 < bArr.length; i4++) {
                    if ((a2.charAt(i4) * 31) % 128 != bArr[i4]) {
                        i3++;
                    }
                }
                i++;
                i2 = i3;
            }
            if (i2 > 0) {
                boolean unused = ProjectEditActivity.H = true;
                if (EditorGlobal.p) {
                    Crashlytics.log("SA(s)");
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            if (EditorGlobal.p) {
                Crashlytics.log("SA pne=" + this.f22481a.getPackageName());
            }
            boolean unused3 = ProjectEditActivity.H = true;
        }
    }
}
