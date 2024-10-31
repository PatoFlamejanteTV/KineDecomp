package b.b.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.BundleCompat;
import android.support.v4.content.ContextCompat;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    public final Intent f3280a;

    /* renamed from: b */
    public final Bundle f3281b;

    /* compiled from: CustomTabsIntent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        private final Intent f3282a;

        /* renamed from: b */
        private ArrayList<Bundle> f3283b;

        /* renamed from: c */
        private Bundle f3284c;

        /* renamed from: d */
        private ArrayList<Bundle> f3285d;

        /* renamed from: e */
        private boolean f3286e;

        public a() {
            this(null);
        }

        public a a(int i) {
            this.f3282a.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i);
            return this;
        }

        public a(m mVar) {
            this.f3282a = new Intent("android.intent.action.VIEW");
            this.f3283b = null;
            this.f3284c = null;
            this.f3285d = null;
            this.f3286e = true;
            if (mVar != null) {
                this.f3282a.setPackage(mVar.b().getPackageName());
            }
            Bundle bundle = new Bundle();
            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", mVar != null ? mVar.a() : null);
            this.f3282a.putExtras(bundle);
        }

        public a a(boolean z) {
            this.f3282a.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", z ? 1 : 0);
            return this;
        }

        public j a() {
            ArrayList<Bundle> arrayList = this.f3283b;
            if (arrayList != null) {
                this.f3282a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f3285d;
            if (arrayList2 != null) {
                this.f3282a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f3282a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f3286e);
            return new j(this.f3282a, this.f3284c);
        }
    }

    /* synthetic */ j(Intent intent, Bundle bundle, i iVar) {
        this(intent, bundle);
    }

    public void a(Context context, Uri uri) {
        this.f3280a.setData(uri);
        ContextCompat.startActivity(context, this.f3280a, this.f3281b);
    }

    private j(Intent intent, Bundle bundle) {
        this.f3280a = intent;
        this.f3281b = bundle;
    }
}
