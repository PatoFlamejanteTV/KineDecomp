package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class zzdz<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhc {
    private static boolean zzsg = false;
    protected int zzsf = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfv.checkNotNull(iterable);
        if (iterable instanceof zzgl) {
            List<?> zzic = ((zzgl) iterable).zzic();
            zzgl zzglVar = (zzgl) list;
            int size = list.size();
            for (Object obj : zzic) {
                if (obj == null) {
                    int size2 = zzglVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size3 = zzglVar.size() - 1; size3 >= size; size3--) {
                        zzglVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                }
                if (obj instanceof zzeh) {
                    zzglVar.zzc((zzeh) obj);
                } else {
                    zzglVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof InterfaceC1247ea) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("Element at index ");
                sb3.append(size5);
                sb3.append(" is null.");
                String sb4 = sb3.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(sb4);
            }
            list.add(t);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgw()];
            zzfa zzb = zzfa.zzb(bArr);
            zzb(zzb);
            zzb.zzgj();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzhc
    public final zzeh zzer() {
        try {
            C1260l zzm = zzeh.zzm(zzgw());
            zzb(zzm.b());
            return zzm.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public int zzes() {
        throw new UnsupportedOperationException();
    }

    public void zzg(int i) {
        throw new UnsupportedOperationException();
    }
}
