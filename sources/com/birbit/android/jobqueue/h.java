package com.birbit.android.jobqueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Constraint.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    private int f8158a;

    /* renamed from: b */
    private TagConstraint f8159b;

    /* renamed from: c */
    private final Set<String> f8160c = new HashSet();

    /* renamed from: d */
    private final List<String> f8161d = new ArrayList();

    /* renamed from: e */
    private final List<String> f8162e = new ArrayList();

    /* renamed from: f */
    private boolean f8163f;

    /* renamed from: g */
    private Long f8164g;

    /* renamed from: h */
    private long f8165h;

    public void a(int i) {
        this.f8158a = i;
    }

    public boolean b() {
        return this.f8163f;
    }

    public List<String> c() {
        return this.f8161d;
    }

    public List<String> d() {
        return this.f8162e;
    }

    public int e() {
        return this.f8158a;
    }

    public long f() {
        return this.f8165h;
    }

    public TagConstraint g() {
        return this.f8159b;
    }

    public Set<String> h() {
        return this.f8160c;
    }

    public Long i() {
        return this.f8164g;
    }

    public void a(TagConstraint tagConstraint) {
        this.f8159b = tagConstraint;
    }

    public void b(Collection<String> collection) {
        this.f8162e.clear();
        if (collection != null) {
            this.f8162e.addAll(collection);
        }
    }

    public void a(boolean z) {
        this.f8163f = z;
    }

    public void a(String[] strArr) {
        this.f8160c.clear();
        if (strArr != null) {
            Collections.addAll(this.f8160c, strArr);
        }
    }

    public void a(long j) {
        this.f8165h = j;
    }

    public void a(Collection<String> collection) {
        this.f8161d.clear();
        if (collection != null) {
            this.f8161d.addAll(collection);
        }
    }

    public void a(Long l) {
        this.f8164g = l;
    }

    public void a() {
        this.f8158a = 2;
        this.f8159b = null;
        this.f8160c.clear();
        this.f8161d.clear();
        this.f8162e.clear();
        this.f8163f = false;
        this.f8164g = null;
        this.f8165h = Long.MIN_VALUE;
    }
}
