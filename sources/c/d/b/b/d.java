package c.d.b.b;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import c.d.b.b.i;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.nexstreaming.app.general.util.N;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: Account.java */
/* loaded from: classes.dex */
public final class d implements FirebaseAuth.AuthStateListener {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3598a = "d";

    /* renamed from: b, reason: collision with root package name */
    private final Context f3599b;

    /* renamed from: c, reason: collision with root package name */
    private final FirebaseAuth f3600c = FirebaseAuth.getInstance();

    /* renamed from: d, reason: collision with root package name */
    private b f3601d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f3602e;

    /* compiled from: Account.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(d dVar, c.d.b.b.a.e eVar);
    }

    /* compiled from: Account.java */
    /* loaded from: classes.dex */
    public class b extends i.a {

        /* renamed from: b, reason: collision with root package name */
        private final c.d.b.b.a.e f3603b;

        public b(String str, String str2, String str3) {
            super(String.format("users/%s", str));
            this.f3603b = new c.d.b.b.a.e(str, str2, str3);
        }

        public c.d.b.b.a.e b() {
            return this.f3603b;
        }

        public void c() {
            c.d.b.b.a.e eVar = this.f3603b;
            if (eVar == null) {
                return;
            }
            Map<String, Object> map = eVar.toMap();
            map.put("privacy_consent_android", Integer.valueOf(this.f3603b.getPrivacyVersion()));
            map.put("privacy_consent_time", Long.valueOf(this.f3603b.getPrivacyAgreeTime()));
            i.a("users").a(this.f3603b.getId()).a(map).a(new h(this)).a(new g(this));
        }

        public String toString() {
            return this.f3603b.toString();
        }

        public void a(String str, String str2, boolean z) {
            this.f3603b.setEmail(str);
            this.f3603b.setDisplayName(str2);
            Map<String, Object> map = this.f3603b.toMap();
            if (!z) {
                map.put("signUpPlatform", "Android");
                map.put("privacy_consent_android", Integer.valueOf(this.f3603b.getPrivacyVersion()));
                map.put("privacy_consent_time", Long.valueOf(this.f3603b.getPrivacyAgreeTime()));
            }
            i.a("users").a(this.f3603b.getId()).a(map).a(new f(this)).a(new e(this));
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void a(DataSnapshot dataSnapshot) {
            if (!dataSnapshot.a()) {
                Log.w(d.f3598a, "[UserWrapper][onDataChange] User data does not exist!");
                return;
            }
            c.d.b.b.a.e from = c.d.b.b.a.e.from(dataSnapshot);
            if (from == null || from.equals(this.f3603b)) {
                return;
            }
            this.f3603b.set(from);
            d.this.a(this.f3603b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context) {
        this.f3599b = context;
        this.f3600c.a(this);
    }

    public void c() {
        if (this.f3600c.a() != null) {
            this.f3600c.b();
        }
        b bVar = this.f3601d;
        if (bVar != null) {
            a(bVar.b().getId());
            this.f3601d.a();
            this.f3601d = null;
        }
    }

    public void d() {
        b bVar = this.f3601d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public c.d.b.b.a.e b() {
        b bVar = this.f3601d;
        if (bVar != null) {
            return bVar.b();
        }
        return null;
    }

    public void b(a aVar) {
        List<a> list = this.f3602e;
        if (list != null) {
            list.remove(aVar);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i.a("devices").a(str).a(N.c(this.f3599b)).a(new c.d.b.b.a.b().toMap()).a(new c.d.b.b.b(this, str)).a(new c.d.b.b.a(this, str));
    }

    public void a(Activity activity) {
        AuthUI.IdpConfig[] idpConfigArr = {new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()};
        try {
            activity.startActivityForResult(((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) AuthUI.getInstance().createSignInIntentBuilder().setTitle(this.f3599b.getString(R.string.pref_information_about_account))).setAvailableProviders(Arrays.asList(idpConfigArr))).setPrivacyPolicyUrl(c.d.b.m.h.a(Locale.getDefault()) ? "http://www.kinemaster.com/privacy/ko" : "http://www.kinemaster.com/privacy/en")).setTosUrl(Locale.getDefault().getLanguage().equals("ko") ? "https://support.kinemaster.com/hc/ko/articles/206376422-Terms-of-Service" : "https://support.kinemaster.com/hc/en-us/articles/206376422-Terms-of-Service")).setIsSmartLockEnabled(false)).build(), 20496);
        } catch (ActivityNotFoundException e2) {
            Log.e(f3598a, e2.getMessage(), e2);
        }
    }

    public boolean a(int i, int i2, Intent intent) {
        if (i != 20496) {
            return false;
        }
        if (i2 != -1) {
            return true;
        }
        IdpResponse fromResultIntent = IdpResponse.fromResultIntent(intent);
        if (fromResultIntent != null && fromResultIntent.getErrorCode() == -1 && this.f3601d != null) {
            i.a("users").a(this.f3601d.b().getId()).a(new c(this));
            return true;
        }
        this.f3600c.b();
        return true;
    }

    public void a(a aVar) {
        if (this.f3602e == null) {
            this.f3602e = new ArrayList();
        }
        if (this.f3602e.contains(aVar)) {
            return;
        }
        this.f3602e.add(aVar);
        if (b() != null) {
            aVar.a(this, b());
        }
    }

    @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
    public void a(FirebaseAuth firebaseAuth) {
        b bVar = this.f3601d;
        if (bVar != null) {
            bVar.a();
            this.f3601d = null;
        }
        FirebaseUser a2 = firebaseAuth.a();
        if (a2 != null) {
            this.f3601d = new b(a2.R(), a2.getEmail(), a2.getDisplayName());
            a(a2.R());
        } else {
            a((c.d.b.b.a.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c.d.b.b.a.e eVar) {
        List<a> list = this.f3602e;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3602e.get(size).a(this, eVar);
            }
        }
    }
}
