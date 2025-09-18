package com.example.ss3_bai_1.entity;

public class Email {
    private String language;
    private int pageSize;
    private boolean filter;   // 👈 phải là boolean để map với <form:checkbox>
    private String signature;

    public Email() {
    }

    public Email(String language, int pageSize, boolean filter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {   // 👈 quan trọng: phải là isFilter()
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "language='" + language + '\'' +
                ", pageSize=" + pageSize +
                ", filter=" + filter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
