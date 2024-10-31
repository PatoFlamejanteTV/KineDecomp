package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class OrFileFilter extends a implements b, Serializable {
    private final List<d> fileFilters;

    public OrFileFilter() {
        this.fileFilters = new ArrayList();
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.d, java.io.FileFilter
    public boolean accept(File file) {
        Iterator<d> it = this.fileFilters.iterator();
        while (it.hasNext()) {
            if (it.next().accept(file)) {
                return true;
            }
        }
        return false;
    }

    public void addFileFilter(d dVar) {
        this.fileFilters.add(dVar);
    }

    public List<d> getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    public boolean removeFileFilter(d dVar) {
        return this.fileFilters.remove(dVar);
    }

    public void setFileFilters(List<d> list) {
        this.fileFilters.clear();
        this.fileFilters.addAll(list);
    }

    @Override // org.apache.commons.io.filefilter.a
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.fileFilters != null) {
            for (int i = 0; i < this.fileFilters.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                d dVar = this.fileFilters.get(i);
                sb.append(dVar == null ? "null" : dVar.toString());
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public OrFileFilter(List<d> list) {
        if (list == null) {
            this.fileFilters = new ArrayList();
        } else {
            this.fileFilters = new ArrayList(list);
        }
    }

    @Override // org.apache.commons.io.filefilter.a, org.apache.commons.io.filefilter.d, java.io.FilenameFilter
    public boolean accept(File file, String str) {
        Iterator<d> it = this.fileFilters.iterator();
        while (it.hasNext()) {
            if (it.next().accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    public OrFileFilter(d dVar, d dVar2) {
        if (dVar != null && dVar2 != null) {
            this.fileFilters = new ArrayList(2);
            addFileFilter(dVar);
            addFileFilter(dVar2);
            return;
        }
        throw new IllegalArgumentException("The filters must not be null");
    }
}
