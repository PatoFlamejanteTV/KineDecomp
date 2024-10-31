package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class zzc {

    /* renamed from: a, reason: collision with root package name */
    static String f1430a = null;
    static int b = 0;
    static int c = 0;
    static int d = 0;
    Context e;
    Map<String, Object> f = new HashMap();
    Messenger g;
    Messenger h;
    MessengerCompat i;
    PendingIntent j;
    long k;
    long l;
    int m;
    int n;
    long o;

    public zzc(Context context) {
        this.e = context;
    }

    public static String a(Context context) {
        if (f1430a != null) {
            return f1430a;
        }
        b = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    c = applicationInfo.uid;
                    f1430a = resolveInfo.serviceInfo.packageName;
                    return f1430a;
                } catch (PackageManager.NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares com.google.android.c2dm.intent.REGISTER without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            f1430a = applicationInfo2.packageName;
            c = applicationInfo2.uid;
            return f1430a;
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                f1430a = applicationInfo3.packageName;
                c = applicationInfo3.uid;
                return f1430a;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    static String a(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes(Keyczar.DEFAULT_ENCODING);
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature signature = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                signature.initSign(privateKey);
                signature.update(bytes);
                return InstanceID.a(signature.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    private void a(Object obj) {
        synchronized (getClass()) {
            for (String str : this.f.keySet()) {
                Object obj2 = this.f.get(str);
                this.f.put(str, obj);
                a(obj2, obj);
            }
        }
    }

    private void a(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void a(String str) {
        if ("com.google.android.gsf".equals(f1430a)) {
            this.m++;
            if (this.m >= 3) {
                if (this.m == 3) {
                    this.n = new Random().nextInt(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) + LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                }
                this.n *= 2;
                this.o = SystemClock.elapsedRealtime() + this.n;
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.n);
            }
        }
    }

    private void a(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.f.get(str);
            this.f.put(str, obj);
            a(obj2, obj);
        }
    }

    private Intent b(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String b2 = b();
        synchronized (getClass()) {
            this.f.put(b2, conditionVariable);
        }
        a(bundle, keyPair, b2);
        conditionVariable.block(30000L);
        synchronized (getClass()) {
            Object remove = this.f.remove(b2);
            if (!(remove instanceof Intent)) {
                if (remove instanceof String) {
                    throw new IOException((String) remove);
                }
                Log.w("InstanceID/Rpc", "No response " + remove);
                throw new IOException("TIMEOUT");
            }
            intent = (Intent) remove;
        }
        return intent;
    }

    public static synchronized String b() {
        String num;
        synchronized (zzc.class) {
            int i = d;
            d = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Intent a(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent b2 = b(bundle, keyPair);
        return (b2 == null || !b2.hasExtra("google.messenger")) ? b2 : b(bundle, keyPair);
    }

    void a() {
        if (this.g != null) {
            return;
        }
        a(this.e);
        this.g = new Messenger(new d(this, Looper.getMainLooper()));
    }

    synchronized void a(Intent intent) {
        if (this.j == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.j = PendingIntent.getBroadcast(this.e, 0, intent2, 0);
        }
        intent.putExtra("app", this.j);
    }

    protected void a(Intent intent, String str) {
        this.k = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + "|");
        intent.putExtra("X-kid", "|ID|" + str + "|");
        boolean equals = "com.google.android.gsf".equals(f1430a);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.h != null) {
            intent.putExtra("google.messenger", this.g);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.h.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.e.getPackageName());
            intent2.putExtra("GSF", intent);
            this.e.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.g);
        intent.putExtra("messenger2", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        if (this.i != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.i.b(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.e.startService(intent);
    }

    void a(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.o != 0 && elapsedRealtime <= this.o) {
            Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.o - elapsedRealtime) + " interval: " + this.n);
            throw new IOException("RETRY_LATER");
        }
        a();
        if (f1430a == null) {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        }
        this.k = SystemClock.elapsedRealtime();
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage(f1430a);
        bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.c(this.e)));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.a(this.e)));
        bundle.putString("cliv", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        bundle.putString("appid", InstanceID.a(keyPair));
        String a2 = InstanceID.a(keyPair.getPublic().getEncoded());
        bundle.putString("pub2", a2);
        bundle.putString("sig", a(keyPair, this.e.getPackageName(), a2));
        intent.putExtras(bundle);
        a(intent);
        a(intent, str);
    }

    public void a(Message message) {
        if (message == null) {
            return;
        }
        if (!(message.obj instanceof Intent)) {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.i = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.h = (Messenger) parcelableExtra;
            }
        }
        d((Intent) message.obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0L);
        if (stringExtra != null) {
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    void c(Intent intent) {
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (split.length > 2) {
                str = split[2];
                stringExtra = split[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra("error", stringExtra);
        }
        if (str == null) {
            a((Object) stringExtra);
        } else {
            a(str, (Object) stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0L);
        if (longExtra > 0) {
            this.l = SystemClock.elapsedRealtime();
            this.n = ((int) longExtra) * LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            this.o = SystemClock.elapsedRealtime() + this.n;
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.n);
            return;
        }
        if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            a(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Intent intent) {
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !"com.google.android.gms.iid.InstanceID".equals(action)) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        String stringExtra2 = stringExtra == null ? intent.getStringExtra("unregistered") : stringExtra;
        if (stringExtra2 == null) {
            c(intent);
            return;
        }
        this.k = SystemClock.elapsedRealtime();
        this.o = 0L;
        this.m = 0;
        this.n = 0;
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "AppIDResponse: " + stringExtra2 + " " + intent.getExtras());
        }
        String str = null;
        if (stringExtra2.startsWith("|")) {
            String[] split = stringExtra2.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra2);
            }
            String str2 = split[2];
            if (split.length > 4) {
                if ("SYNC".equals(split[3])) {
                    InstanceIDListenerService.a(this.e);
                } else if ("RST".equals(split[3])) {
                    InstanceIDListenerService.a(this.e, InstanceID.b(this.e).d());
                    intent.removeExtra("registration_id");
                    a(str2, (Object) intent);
                    return;
                }
            }
            String str3 = split[split.length - 1];
            if (str3.startsWith(":")) {
                str3 = str3.substring(1);
            }
            intent.putExtra("registration_id", str3);
            str = str2;
        }
        if (str == null) {
            a((Object) intent);
        } else {
            a(str, (Object) intent);
        }
    }
}
