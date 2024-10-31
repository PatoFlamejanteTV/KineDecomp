package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zze {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, MetadataField<?>> f1150a = new HashMap();
    private static final Map<String, zza> b = new HashMap();

    /* loaded from: classes2.dex */
    public interface zza {
        String a();

        void a(DataHolder dataHolder);
    }

    static {
        a(zznd.zzamJ);
        a(zznd.zzanp);
        a(zznd.zzang);
        a(zznd.zzann);
        a(zznd.zzanq);
        a(zznd.zzamW);
        a(zznd.zzamV);
        a(zznd.zzamX);
        a(zznd.zzamY);
        a(zznd.zzamZ);
        a(zznd.zzamT);
        a(zznd.zzanb);
        a(zznd.zzanc);
        a(zznd.zzand);
        a(zznd.zzanl);
        a(zznd.zzamK);
        a(zznd.zzani);
        a(zznd.zzamM);
        a(zznd.zzamU);
        a(zznd.zzamN);
        a(zznd.zzamO);
        a(zznd.zzamP);
        a(zznd.zzamQ);
        a(zznd.zzanf);
        a(zznd.zzana);
        a(zznd.zzanh);
        a(zznd.zzanj);
        a(zznd.zzank);
        a(zznd.zzanm);
        a(zznd.zzanr);
        a(zznd.zzans);
        a(zznd.zzamS);
        a(zznd.zzamR);
        a(zznd.zzano);
        a(zznd.zzane);
        a(zznd.zzamL);
        a(zznd.zzant);
        a(zznd.zzanu);
        a(zznd.zzanv);
        a(zznd.zzanw);
        a(zznd.zzanx);
        a(zznd.zzany);
        a(zznd.zzanz);
        a(zznf.zzanB);
        a(zznf.zzanD);
        a(zznf.zzanE);
        a(zznf.zzanF);
        a(zznf.zzanC);
        a(zznf.zzanG);
        a(zznh.zzanI);
        a(zznh.zzanJ);
        zzl zzlVar = zznd.zzanl;
        a(zzl.f1151a);
        a(zzne.zzanA);
    }

    public static MetadataField<?> a(String str) {
        return f1150a.get(str);
    }

    public static Collection<MetadataField<?>> a() {
        return Collections.unmodifiableCollection(f1150a.values());
    }

    public static void a(DataHolder dataHolder) {
        Iterator<zza> it = b.values().iterator();
        while (it.hasNext()) {
            it.next().a(dataHolder);
        }
    }

    private static void a(MetadataField<?> metadataField) {
        if (f1150a.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        f1150a.put(metadataField.getName(), metadataField);
    }

    private static void a(zza zzaVar) {
        if (b.put(zzaVar.a(), zzaVar) != null) {
            throw new IllegalStateException("A cleaner for key " + zzaVar.a() + " has already been registered");
        }
    }
}
