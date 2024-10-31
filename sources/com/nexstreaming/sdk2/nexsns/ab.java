package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: SNSManager.java */
/* loaded from: classes.dex */
public class ab {
    private static boolean b = true;
    private static boolean c = true;

    /* renamed from: a, reason: collision with root package name */
    private final a f4414a;
    private WeakReference<Activity> g;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private Set<String> h = new HashSet();
    private Map<String, SNS> i = new HashMap();
    private HashMap<String, String> j = new HashMap<>();
    private HashMap<String, String> k = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2) {
        if (b) {
            Log.d(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, Throwable th) {
        if (b) {
            Log.d(str, str2, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2) {
        if (c) {
            Log.e(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str, String str2, Throwable th) {
        if (c) {
            Log.e(str, str2, th);
        }
    }

    public ab(Activity activity, String... strArr) {
        boolean z;
        int i = 1;
        this.f4414a = new a(i, 0, i, 46);
        this.g = new WeakReference<>(activity);
        String[] strArr2 = {"dropbox", "facebook", "grivedownload", "google+", "youtube", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE};
        int length = strArr2.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr2[i2];
            if (strArr.length > 0) {
                int length2 = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        z = false;
                        break;
                    }
                    String str2 = strArr[i3];
                    if (!str2.equals(str)) {
                        i3++;
                    } else {
                        e(str2, null);
                        z = true;
                        break;
                    }
                }
                i2 = z ? i2 : i2 + 1;
            }
            this.h.add(str);
        }
    }

    private Activity f() {
        Activity activity = this.g.get();
        if (activity == null) {
            throw new RuntimeException("Activity lost");
        }
        return activity;
    }

    /* compiled from: SNSManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f4415a;
        public final int b;
        public final int c;
        public final int d;

        public String toString() {
            return this.f4415a + "." + this.b + "." + this.c + "." + this.d;
        }

        private a(int i, int i2, int i3, int i4) {
            this.f4415a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    public void a(Bundle bundle) {
        this.d = true;
        Iterator<SNS> it = this.i.values().iterator();
        while (it.hasNext()) {
            it.next().a_(bundle);
        }
    }

    public void a() {
        this.d = false;
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.n();
            }
        }
    }

    public void b() {
        this.e = true;
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.k();
            }
        }
    }

    public void c() {
        this.e = false;
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.l();
            }
        }
    }

    public void d() {
        this.f = false;
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.m();
            }
        }
    }

    public void e() {
        this.f = true;
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.o();
            }
        }
    }

    public void b(Bundle bundle) {
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.b(bundle);
            }
        }
    }

    public void a(Activity activity, int i, int i2, Intent intent) {
        for (SNS sns : this.i.values()) {
            if (sns != null) {
                sns.a(activity, i, i2, intent);
            }
        }
    }

    private SNS e(String str, String str2) {
        SNS aeVar;
        String str3 = str2 != null ? str + "!!" + str2 : str;
        if (str.equals("facebook")) {
            aeVar = new d(f());
        } else if (str.equals("google+")) {
            aeVar = new x(f());
        } else if (str.equals("youtube")) {
            aeVar = new ag(f());
        } else if (str.equals("dropbox")) {
            aeVar = new b(f());
        } else if (str.equals("grivedownload")) {
            aeVar = new GoogleDriveMediaDownload(f());
        } else {
            if (!str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                return null;
            }
            aeVar = new ae(f());
        }
        if (str2 != null) {
            aeVar.c_(str2);
        }
        Log.d("SNSManager", "New SNS Instance : " + str);
        this.i.put(str3, aeVar);
        if (this.d) {
            aeVar.a_(null);
        }
        if (this.f) {
            aeVar.o();
        }
        if (this.e) {
            aeVar.k();
        }
        return aeVar;
    }

    public SNS a(String str) {
        return c(str, null);
    }

    public SNS c(String str, String str2) {
        String str3 = str2 != null ? str + "!!" + str2 : str;
        a("SNSManager", "get instance : " + str);
        SNS sns = this.i.get(str3);
        SNS e = sns == null ? e(str, str2) : sns;
        if (e != null) {
            e.b_(this.j.get(str));
            e.c(this.k.get(str));
        }
        return e;
    }

    public void d(String str, String str2) {
        this.j.put(str, str2);
    }
}
