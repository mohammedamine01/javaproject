package emailapp;

public enum Departments {

    SALES(1),
    DEVELOPMENT(2),
    ACCOUNTING(3);

    private int departmentCode;

    Departments(int departmentCode) {
        this.departmentCode = departmentCode;
    }

    public int getDepartmentCode() {
        return departmentCode;
    }
}
