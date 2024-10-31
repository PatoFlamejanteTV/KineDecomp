package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import com.google.firebase.inappmessaging.display.internal.PicassoErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.squareup.okhttp.C;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.v;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
/* loaded from: classes2.dex */
public class PicassoModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    @FirebaseAppScope
    public Picasso a(Application application, PicassoErrorListener picassoErrorListener) {
        C c2 = new C();
        c2.u().add(new b(this));
        Picasso.a aVar = new Picasso.a(application);
        aVar.a(picassoErrorListener);
        aVar.a(new v(c2));
        return aVar.a();
    }
}
