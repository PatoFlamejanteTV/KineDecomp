package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes.dex */
public class zzd {

    /* renamed from: a, reason: collision with root package name */
    SharedPreferences f1431a;
    Context b;

    public zzd(Context context) {
        this(context, "com.google.android.gms.appid");
    }

    public zzd(Context context, String str) {
        this.b = context;
        this.f1431a = context.getSharedPreferences(str, 4);
        g(str + "-no-backup");
    }

    private String b(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    private void g(String str) {
        File file = new File(new android.support.v4.a.a().a(this.b), str);
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || a()) {
                return;
            }
            Log.i("InstanceID/Store", "App restored, clearing state");
            InstanceIDListenerService.a(this.b, this);
        } catch (IOException e) {
            if (Log.isLoggable("InstanceID/Store", 3)) {
                Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(String str) {
        return this.f1431a.getString(str, null);
    }

    synchronized String a(String str, String str2) {
        return this.f1431a.getString(str + "|S|" + str2, null);
    }

    public synchronized String a(String str, String str2, String str3) {
        return this.f1431a.getString(b(str, str2, str3), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized KeyPair a(String str, long j) {
        KeyPair a2;
        a2 = zza.a();
        SharedPreferences.Editor edit = this.f1431a.edit();
        a(edit, str, "|P|", InstanceID.a(a2.getPublic().getEncoded()));
        a(edit, str, "|K|", InstanceID.a(a2.getPrivate().getEncoded()));
        a(edit, str, "cre", Long.toString(j));
        edit.commit();
        return a2;
    }

    synchronized void a(SharedPreferences.Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String b = b(str, str2, str3);
        SharedPreferences.Editor edit = this.f1431a.edit();
        edit.putString(b, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f1431a.getAll().isEmpty();
    }

    public synchronized void b() {
        this.f1431a.edit().clear().commit();
    }

    public synchronized void b(String str) {
        SharedPreferences.Editor edit = this.f1431a.edit();
        for (String str2 : this.f1431a.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair c(String str) {
        return f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        b(str + "|");
    }

    public void e(String str) {
        b(str + "|T|");
    }

    KeyPair f(String str) {
        String a2 = a(str, "|P|");
        String a3 = a(str, "|K|");
        if (a3 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(a2, 8);
            byte[] decode2 = Base64.decode(a3, 8);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(decode)), keyFactory.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            InstanceIDListenerService.a(this.b, this);
            return null;
        }
    }
}
