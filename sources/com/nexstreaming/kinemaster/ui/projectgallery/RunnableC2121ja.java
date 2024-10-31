package com.nexstreaming.kinemaster.ui.projectgallery;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ja, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2121ja implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22938a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C2134oa f22939b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2121ja(C2134oa c2134oa, String str) {
        this.f22939b = c2134oa;
        this.f22938a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        rVar = this.f22939b.f22963a.za;
        if (rVar != null) {
            rVar2 = this.f22939b.f22963a.za;
            if (rVar2.isShowing()) {
                rVar3 = this.f22939b.f22963a.za;
                StringBuilder sb = new StringBuilder();
                sb.append("Uploading ");
                String str = this.f22938a;
                sb.append(str.substring(str.lastIndexOf("/") + 1));
                rVar3.d(sb.toString());
            }
        }
    }
}
