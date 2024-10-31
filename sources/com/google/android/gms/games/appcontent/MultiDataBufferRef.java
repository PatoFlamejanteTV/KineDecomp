package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class MultiDataBufferRef extends zzc {
    protected final ArrayList<DataHolder> c;

    /* JADX INFO: Access modifiers changed from: protected */
    public MultiDataBufferRef(ArrayList<DataHolder> arrayList, int i, int i2) {
        super(arrayList.get(i), i2);
        this.c = arrayList;
    }
}
