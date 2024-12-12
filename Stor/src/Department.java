import java.util.ArrayList;
import java.util.List;

class Department {
    private String name;
    private String workingHours;

    public Department(String name, String workingHours) {
        this.name = name;
        this.workingHours = workingHours;
    }

    public String getName() {
        return name;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    @Override
    public String toString() {
        return "Отдел: " + name + ", Часы работы: " + workingHours;
    }
}
