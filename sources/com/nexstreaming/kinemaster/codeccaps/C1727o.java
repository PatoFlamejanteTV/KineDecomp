package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1702f;
import com.nextreaming.nexeditorui.EditorGlobal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1727o implements ResultTask.OnResultAvailableListener<u> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1728p f20111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1727o(C1728p c1728p) {
        this.f20111a = c1728p;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<u> resultTask, Task.Event event, u uVar) {
        Context context;
        Context context2;
        StringBuilder sb;
        StringBuilder sb2;
        String b2;
        String b3;
        String b4;
        String b5;
        com.nexstreaming.kinemaster.ui.a.r rVar;
        Context context3;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        Context context4;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        FileOutputStream fileOutputStream;
        StringBuilder sb3;
        context = this.f20111a.f20112a;
        WeakReference weakReference = new WeakReference((Activity) context);
        z.d(uVar).onSuccess(new C1724l(this, weakReference)).onFailure(new C1723k(this, weakReference));
        context2 = this.f20111a.f20112a;
        z.a(context2, uVar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        String a2 = z.a(uVar);
        sb = this.f20111a.f20116e;
        sb.append("\n\n======== TEST COMPLETE ========\n\n");
        sb2 = this.f20111a.f20116e;
        sb2.append(a2);
        File b6 = EditorGlobal.b();
        b6.mkdirs();
        StringBuilder sb4 = new StringBuilder();
        b2 = C1728p.b(c.d.b.a.a.f3576b.c());
        sb4.append(b2);
        sb4.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        b3 = C1728p.b(Build.MANUFACTURER);
        sb4.append(b3);
        sb4.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        b4 = C1728p.b(Build.MODEL);
        sb4.append(b4);
        sb4.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        b5 = C1728p.b(Build.PRODUCT);
        sb4.append(b5);
        sb4.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb4.append(Build.VERSION.SDK_INT);
        sb4.append(io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb4.append(simpleDateFormat.format(new Date()));
        String sb5 = sb4.toString();
        File file = new File(b6, "LOG_CCT_" + sb5 + ".txt");
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                sb3 = this.f20111a.f20116e;
                fileOutputStream.write(sb3.toString().getBytes());
                C1702f.a(fileOutputStream);
            } finally {
            }
        } catch (IOException e2) {
            Log.e("CapabilityCheckPopup", "Log write error", e2);
        }
        File file2 = new File(b6, "CCT_" + sb5 + ".json");
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(a2.getBytes());
                C1702f.a(fileOutputStream);
            } finally {
            }
        } catch (IOException e3) {
            Log.e("CapabilityCheckPopup", "Json write error", e3);
        }
        rVar = this.f20111a.f20113b;
        rVar.a(-2, "Close");
        context3 = this.f20111a.f20112a;
        if (context3 instanceof Activity) {
            context4 = this.f20111a.f20112a;
            rVar3 = this.f20111a.f20113b;
            rVar3.c("Send Mail", new DialogInterfaceOnClickListenerC1725m(this, (Activity) context4, file, file2));
        }
        rVar2 = this.f20111a.f20113b;
        rVar2.b("Copy to Clipboard", new DialogInterfaceOnClickListenerC1726n(this));
    }
}
