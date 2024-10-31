package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppUsage.java */
/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppUsage f3204a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AppUsage appUsage) {
        this.f3204a = appUsage;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Map map;
        Map map2;
        Context context;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        obj = this.f3204a.h;
        synchronized (obj) {
            try {
                dataOutputStream.writeInt(-1615982310);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(0);
                map = this.f3204a.e;
                dataOutputStream.writeInt(map.size());
                map2 = this.f3204a.e;
                for (Map.Entry entry : map2.entrySet()) {
                    dataOutputStream.writeLong(((Long) entry.getKey()).longValue());
                    dataOutputStream.writeInt(((Integer) entry.getValue()).intValue());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            context = this.f3204a.b;
            FileOutputStream openFileOutput = context.openFileOutput("nexau.dat", 0);
            openFileOutput.write(byteArrayOutputStream.toByteArray());
            openFileOutput.close();
        } catch (IOException e2) {
            Log.w("nexau", "io failure", e2);
        }
    }
}
