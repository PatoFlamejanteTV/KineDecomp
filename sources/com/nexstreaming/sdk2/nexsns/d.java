package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.widget.ShareDialog;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Facebook.java */
/* loaded from: classes.dex */
public class d extends SNS {

    /* renamed from: a, reason: collision with root package name */
    private CallbackManager f4422a;
    private ShareDialog b;
    private Context c;
    private Task d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity) {
        super(activity);
        this.c = activity.getApplicationContext();
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean b() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean c() {
        return true;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean d() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public int e() {
        return 0;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c_(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String a(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b_(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ad a(File file) {
        return a(Uri.fromFile(file));
    }

    public ad a(Uri uri) {
        return new e(this, uri);
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public Task f() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String g() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public SNS.PrivacyManagementProfile h() {
        return SNS.PrivacyManagementProfile.MANAGED_BY_SNS;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public List<Privacy> i() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ResultTask<List<ac>> j() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a_(Bundle bundle) {
        FacebookSdk.sdkInitialize(p());
        this.f4422a = CallbackManager.Factory.create();
        this.b = new ShareDialog(r());
        this.b.registerCallback(this.f4422a, new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context p() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void n() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a(Activity activity, int i, int i2, Intent intent) {
        this.f4422a.onActivityResult(i, i2, intent);
    }
}
