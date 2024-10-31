package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class PlusShare {

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2159a;
        private final Intent b = new Intent().setAction("android.intent.action.SEND");
        private boolean c;
        private ArrayList<Uri> d;

        public Builder(Activity activity) {
            this.f2159a = activity;
            this.b.addFlags(524288);
            if (activity == null || activity.getComponentName() == null) {
                return;
            }
            this.c = true;
        }

        public Intent a() {
            boolean z = true;
            boolean z2 = this.d != null && this.d.size() > 1;
            boolean equals = "android.intent.action.SEND_MULTIPLE".equals(this.b.getAction());
            boolean booleanExtra = this.b.getBooleanExtra("com.google.android.apps.plus.GOOGLE_INTERACTIVE_POST", false);
            zzx.a((z2 && booleanExtra) ? false : true, "Call-to-action buttons are only available for URLs.");
            zzx.a(!booleanExtra || this.b.hasExtra("com.google.android.apps.plus.CONTENT_URL"), "The content URL is required for interactive posts.");
            if (booleanExtra && !this.b.hasExtra("com.google.android.apps.plus.CONTENT_URL") && !this.b.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                z = false;
            }
            zzx.a(z, "Must set content URL or content deep-link ID to use a call-to-action button.");
            if (this.b.hasExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")) {
                zzx.a(PlusShare.a(this.b.getStringExtra("com.google.android.apps.plus.CONTENT_DEEP_LINK_ID")), "The specified deep-link ID was malformed.");
            }
            if (!z2 && equals) {
                this.b.setAction("android.intent.action.SEND");
                if (this.d == null || this.d.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putExtra("android.intent.extra.STREAM", this.d.get(0));
                }
                this.d = null;
            }
            if (z2 && !equals) {
                this.b.setAction("android.intent.action.SEND_MULTIPLE");
                if (this.d == null || this.d.isEmpty()) {
                    this.b.removeExtra("android.intent.extra.STREAM");
                } else {
                    this.b.putParcelableArrayListExtra("android.intent.extra.STREAM", this.d);
                }
            }
            if ("com.google.android.gms.plus.action.SHARE_INTERNAL_GOOGLE".equals(this.b.getAction())) {
                this.b.setPackage("com.google.android.gms");
                return this.b;
            }
            if (this.b.hasExtra("android.intent.extra.STREAM")) {
                this.b.setPackage("com.google.android.apps.plus");
                return this.b;
            }
            this.b.setAction("com.google.android.gms.plus.action.SHARE_GOOGLE");
            this.b.setPackage("com.google.android.gms");
            return this.b;
        }

        public Builder a(Uri uri) {
            this.d = null;
            this.b.putExtra("android.intent.extra.STREAM", uri);
            return this;
        }

        public Builder a(CharSequence charSequence) {
            this.b.putExtra("android.intent.extra.TEXT", charSequence);
            return this;
        }

        public Builder a(String str) {
            this.b.setType(str);
            return this;
        }

        public Builder b(Uri uri) {
            Uri uri2 = (Uri) this.b.getParcelableExtra("android.intent.extra.STREAM");
            if (uri2 == null) {
                return a(uri);
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            this.d.add(uri2);
            this.d.add(uri);
            return this;
        }
    }

    @Deprecated
    protected PlusShare() {
        throw new AssertionError();
    }

    protected static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
            return false;
        }
        if (!str.contains(" ")) {
            return true;
        }
        Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
        return false;
    }
}
