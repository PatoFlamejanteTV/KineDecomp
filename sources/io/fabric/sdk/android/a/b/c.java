package io.fabric.sdk.android.a.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.m;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: EventsFilesManager.java */
/* loaded from: classes3.dex */
public abstract class c<T> {
    public static final int MAX_BYTE_SIZE_PER_FILE = 8000;
    public static final int MAX_FILES_IN_BATCH = 1;
    public static final int MAX_FILES_TO_KEEP = 100;
    public static final String ROLL_OVER_FILE_NAME_SEPARATOR = "_";
    protected final Context context;
    protected final m currentTimeProvider;
    private final int defaultMaxFilesToKeep;
    protected final d eventStorage;
    protected volatile long lastRollOverTime;
    protected final List<e> rollOverListeners = new CopyOnWriteArrayList();
    protected final io.fabric.sdk.android.a.b.a<T> transform;

    /* compiled from: EventsFilesManager.java */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        final File f26817a;

        /* renamed from: b */
        final long f26818b;

        public a(File file, long j) {
            this.f26817a = file;
            this.f26818b = j;
        }
    }

    public c(Context context, io.fabric.sdk.android.a.b.a<T> aVar, m mVar, d dVar, int i) throws IOException {
        this.context = context.getApplicationContext();
        this.transform = aVar;
        this.eventStorage = dVar;
        this.currentTimeProvider = mVar;
        this.lastRollOverTime = this.currentTimeProvider.a();
        this.defaultMaxFilesToKeep = i;
    }

    private void rollFileOverIfNeeded(int i) throws IOException {
        if (this.eventStorage.a(i, getMaxByteSizePerFile())) {
            return;
        }
        CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "session analytics events file is %d bytes, new event is %d bytes, this is over flush limit of %d, rolling it over", Integer.valueOf(this.eventStorage.a()), Integer.valueOf(i), Integer.valueOf(getMaxByteSizePerFile())));
        rollFileOver();
    }

    private void triggerRollOverOnListeners(String str) {
        Iterator<e> it = this.rollOverListeners.iterator();
        while (it.hasNext()) {
            try {
                it.next().onRollOver(str);
            } catch (Exception e2) {
                CommonUtils.a(this.context, "One of the roll over listeners threw an exception", e2);
            }
        }
    }

    public void deleteAllEventsFiles() {
        d dVar = this.eventStorage;
        dVar.a(dVar.b());
        this.eventStorage.d();
    }

    public void deleteOldestInRollOverIfOverMax() {
        List<File> b2 = this.eventStorage.b();
        int maxFilesToKeep = getMaxFilesToKeep();
        if (b2.size() <= maxFilesToKeep) {
            return;
        }
        int size = b2.size() - maxFilesToKeep;
        CommonUtils.c(this.context, String.format(Locale.US, "Found %d files in  roll over directory, this is greater than %d, deleting %d oldest files", Integer.valueOf(b2.size()), Integer.valueOf(maxFilesToKeep), Integer.valueOf(size)));
        TreeSet treeSet = new TreeSet(new b(this));
        for (File file : b2) {
            treeSet.add(new a(file, parseCreationTimestampFromFileName(file.getName())));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).f26817a);
            if (arrayList.size() == size) {
                break;
            }
        }
        this.eventStorage.a(arrayList);
    }

    public void deleteSentFiles(List<File> list) {
        this.eventStorage.a(list);
    }

    protected abstract String generateUniqueRollOverFileName();

    public List<File> getBatchOfFilesToSend() {
        return this.eventStorage.a(1);
    }

    public long getLastRollOverTime() {
        return this.lastRollOverTime;
    }

    public int getMaxByteSizePerFile() {
        return MAX_BYTE_SIZE_PER_FILE;
    }

    public int getMaxFilesToKeep() {
        return this.defaultMaxFilesToKeep;
    }

    public long parseCreationTimestampFromFileName(String str) {
        String[] split = str.split(ROLL_OVER_FILE_NAME_SEPARATOR);
        if (split.length != 3) {
            return 0L;
        }
        try {
            return Long.valueOf(split[2]).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public void registerRollOverListener(e eVar) {
        if (eVar != null) {
            this.rollOverListeners.add(eVar);
        }
    }

    public boolean rollFileOver() throws IOException {
        String str;
        boolean z = true;
        if (this.eventStorage.c()) {
            str = null;
            z = false;
        } else {
            str = generateUniqueRollOverFileName();
            this.eventStorage.a(str);
            CommonUtils.a(this.context, 4, "Fabric", String.format(Locale.US, "generated new file %s", str));
            this.lastRollOverTime = this.currentTimeProvider.a();
        }
        triggerRollOverOnListeners(str);
        return z;
    }

    public void writeEvent(T t) throws IOException {
        byte[] bytes = this.transform.toBytes(t);
        rollFileOverIfNeeded(bytes.length);
        this.eventStorage.a(bytes);
    }
}
