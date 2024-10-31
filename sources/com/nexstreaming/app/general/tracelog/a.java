package com.nexstreaming.app.general.tracelog;

import android.content.Context;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/* compiled from: AppUsage.java */
/* loaded from: classes2.dex */
public class a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppUsage f19779a;

    public a(AppUsage appUsage) {
        this.f19779a = appUsage;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Map map;
        Map map2;
        Context context;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        obj = this.f19779a.f19767g;
        synchronized (obj) {
            try {
                dataOutputStream.writeInt(-1615982310);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt(0);
                map = this.f19779a.f19764d;
                dataOutputStream.writeInt(map.size());
                map2 = this.f19779a.f19764d;
                for (Map.Entry entry : map2.entrySet()) {
                    dataOutputStream.writeLong(((Long) entry.getKey()).longValue());
                    dataOutputStream.writeInt(((Integer) entry.getValue()).intValue());
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        try {
            context = this.f19779a.f19762b;
            FileOutputStream openFileOutput = context.openFileOutput("nexau.dat", 0);
            openFileOutput.write(byteArrayOutputStream.toByteArray());
            openFileOutput.close();
        } catch (IOException e3) {
            Log.w("nexau", "io failure", e3);
        }
    }
}
