package com.grf.Enum;

enum Size {
    SMALL(1, "S", "小号"), MEDIUM(2, "M", "中号"), LARGE(3, "L", "大号");

    private int i;
    private String abbr;
    private String title;

    Size(int i, String abbr, String title) {
        this.i = i;
        this.abbr = abbr;
        this.title = title;
    }

/*    //这些就别写了吧，恶心
    public void setI(int i) {
        this.i = i;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public void setTitle(String title) {
        this.title = title;
    }*/

    public int getIndex() {
        return i;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getTitle() {
        return title;
    }
}