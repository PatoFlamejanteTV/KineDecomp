package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements s {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f483a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f483a = gVar;
    }

    @Override // com.flurry.sdk.s
    public void a(int i, String str, String str2, String str3) {
        as.c(l.d, "FlurryDataSender: report " + str2 + " sent. HTTP response: " + i + " : " + str);
        if (as.a() <= 3 && as.b()) {
            ad.a().a(new i(this, i));
        }
        this.f483a.a(str2, str3, i);
        this.f483a.c();
    }

    @Override // com.flurry.sdk.s
    public void a(String str, String str2) {
        as.c(l.d, "FlurryDataSender: could not send report " + str);
        this.f483a.b(str, str2);
    }
}
