package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznd;

/* loaded from: classes2.dex */
public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private a b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends Metadata {

        /* renamed from: a, reason: collision with root package name */
        private final DataHolder f1060a;
        private final int b;
        private final int c;

        public a(DataHolder dataHolder, int i) {
            this.f1060a = dataHolder;
            this.b = i;
            this.c = dataHolder.a(i);
        }

        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Metadata a() {
            MetadataBundle a2 = MetadataBundle.a();
            for (MetadataField<?> metadataField : com.google.android.gms.drive.metadata.internal.zze.a()) {
                if (metadataField != zznd.zzano) {
                    metadataField.zza(this.f1060a, a2, this.b, this.c);
                }
            }
            return new zzp(a2);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.f().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    @Override // com.google.android.gms.common.data.DataBuffer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Metadata a(int i) {
        a aVar = this.b;
        if (aVar != null && aVar.b == i) {
            return aVar;
        }
        a aVar2 = new a(this.f982a, i);
        this.b = aVar2;
        return aVar2;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        if (this.f982a != null) {
            com.google.android.gms.drive.metadata.internal.zze.a(this.f982a);
        }
        super.release();
    }
}
