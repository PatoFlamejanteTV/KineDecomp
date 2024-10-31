package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.r;
import com.nexstreaming.kinemaster.ui.settings.Ua;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1728p {

    /* renamed from: a, reason: collision with root package name */
    private final Context f20112a;

    /* renamed from: b, reason: collision with root package name */
    private com.nexstreaming.kinemaster.ui.a.r f20113b;

    /* renamed from: d, reason: collision with root package name */
    private String[] f20115d = {"", "", "", "", "", "", "", "", "", "", ""};

    /* renamed from: e, reason: collision with root package name */
    private StringBuilder f20116e = new StringBuilder();

    /* renamed from: c, reason: collision with root package name */
    private CapabilityChecker f20114c = new CapabilityChecker(C1719g.a());

    public C1728p(Context context) {
        this.f20112a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        return str == null ? "NULL" : str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public void a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.US);
        this.f20116e.append("======== CODEC CAPABILITY TEST ========\n");
        this.f20116e.append("Test Date: " + simpleDateFormat.format(new Date()) + "\n");
        this.f20116e.append("======== DIAGNOSTIC INFO ========\n");
        this.f20116e.append(Ua.b(this.f20112a));
        this.f20116e.append("\n\n");
        this.f20116e.append("======== BEGIN TEST ========\n");
        if (this.f20113b == null) {
            r.a aVar = new r.a(this.f20112a);
            aVar.b("Capability Test");
            aVar.a(R.string.button_cancel, new DialogInterfaceOnClickListenerC1720h(this));
            aVar.a(false);
            this.f20113b = aVar.a();
            this.f20113b.show();
            this.f20113b.getWindow().addFlags(128);
            this.f20113b.a();
            this.f20114c.a(new C1721i(this));
            this.f20114c.a((Activity) this.f20112a).onResultAvailable(new C1727o(this)).onProgress((Task.OnProgressListener) new C1722j(this));
            return;
        }
        throw new IllegalStateException();
    }
}
