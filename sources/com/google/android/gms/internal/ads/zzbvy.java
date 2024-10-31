package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzbvy implements zzbd, Closeable, Iterator<zzbc> {
    protected zzbwa zzgcl;
    protected zzaz zzgcp;
    private static final zzbc zzgco = new C0946ij("eof ");
    private static zzbwg zzco = zzbwg.zzk(zzbvy.class);
    private zzbc zzgcq = null;
    long zzgcr = 0;
    long zzayz = 0;
    long zzaop = 0;
    private List<zzbc> zzgcs = new ArrayList();

    @Override // java.util.Iterator
    /* renamed from: zzaqi */
    public final zzbc next() {
        zzbc zza;
        zzbc zzbcVar = this.zzgcq;
        if (zzbcVar != null && zzbcVar != zzgco) {
            this.zzgcq = null;
            return zzbcVar;
        }
        zzbwa zzbwaVar = this.zzgcl;
        if (zzbwaVar != null && this.zzgcr < this.zzaop) {
            try {
                synchronized (zzbwaVar) {
                    this.zzgcl.zzaw(this.zzgcr);
                    zza = this.zzgcp.zza(this.zzgcl, this);
                    this.zzgcr = this.zzgcl.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        }
        this.zzgcq = zzgco;
        throw new NoSuchElementException();
    }

    public void close() throws IOException {
        this.zzgcl.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        zzbc zzbcVar = this.zzgcq;
        if (zzbcVar == zzgco) {
            return false;
        }
        if (zzbcVar != null) {
            return true;
        }
        try {
            this.zzgcq = (zzbc) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzgcq = zzgco;
            return false;
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzgcs.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzgcs.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void zza(zzbwa zzbwaVar, long j, zzaz zzazVar) throws IOException {
        this.zzgcl = zzbwaVar;
        long position = zzbwaVar.position();
        this.zzayz = position;
        this.zzgcr = position;
        zzbwaVar.zzaw(zzbwaVar.position() + j);
        this.zzaop = zzbwaVar.position();
        this.zzgcp = zzazVar;
    }

    public final List<zzbc> zzaqh() {
        if (this.zzgcl != null && this.zzgcq != zzgco) {
            return new zzbwe(this.zzgcs, this);
        }
        return this.zzgcs;
    }
}
