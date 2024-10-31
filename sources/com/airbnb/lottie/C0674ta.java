package com.airbnb.lottie;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* renamed from: com.airbnb.lottie.ta, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0674ta implements InterfaceC0684ya {

    /* renamed from: d, reason: collision with root package name */
    private final String f7825d;

    /* renamed from: f, reason: collision with root package name */
    private final MergePaths f7827f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7822a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f7823b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f7824c = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final List<InterfaceC0684ya> f7826e = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0674ta(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f7825d = mergePaths.b();
            this.f7827f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(J j) {
        if (j instanceof InterfaceC0684ya) {
            this.f7826e.add((InterfaceC0684ya) j);
        }
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7825d;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        this.f7824c.reset();
        int i = C0672sa.f7815a[this.f7827f.a().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            a(Path.Op.UNION);
        } else if (i == 3) {
            a(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            a(Path.Op.INTERSECT);
        } else if (i == 5) {
            a(Path.Op.XOR);
        }
        return this.f7824c;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < this.f7826e.size(); i++) {
            this.f7826e.get(i).a(list, list2);
        }
    }

    private void a() {
        for (int i = 0; i < this.f7826e.size(); i++) {
            this.f7824c.addPath(this.f7826e.get(i).getPath());
        }
    }

    @TargetApi(19)
    private void a(Path.Op op) {
        this.f7823b.reset();
        this.f7822a.reset();
        for (int size = this.f7826e.size() - 1; size >= 1; size--) {
            InterfaceC0684ya interfaceC0684ya = this.f7826e.get(size);
            if (interfaceC0684ya instanceof K) {
                K k = (K) interfaceC0684ya;
                List<InterfaceC0684ya> b2 = k.b();
                for (int size2 = b2.size() - 1; size2 >= 0; size2--) {
                    Path path = b2.get(size2).getPath();
                    path.transform(k.c());
                    this.f7823b.addPath(path);
                }
            } else {
                this.f7823b.addPath(interfaceC0684ya.getPath());
            }
        }
        InterfaceC0684ya interfaceC0684ya2 = this.f7826e.get(0);
        if (interfaceC0684ya2 instanceof K) {
            K k2 = (K) interfaceC0684ya2;
            List<InterfaceC0684ya> b3 = k2.b();
            for (int i = 0; i < b3.size(); i++) {
                Path path2 = b3.get(i).getPath();
                path2.transform(k2.c());
                this.f7822a.addPath(path2);
            }
        } else {
            this.f7822a.set(interfaceC0684ya2.getPath());
        }
        this.f7824c.op(this.f7822a, this.f7823b, op);
    }
}
