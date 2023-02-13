package oa.bean;

import java.util.Objects;

public class Department {
    private String deptno;
    private String dname;
    private String loc;

    public Department(){}
    public Department(String deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getDeptno() {
        return deptno;
    }

    public String getDname() {
        return dname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptno='" + deptno + '\'' +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return deptno.equals(that.deptno) && dname.equals(that.dname) && loc.equals(that.loc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptno, dname, loc);
    }

    public String getLoc() {
        return loc;
    }
}
