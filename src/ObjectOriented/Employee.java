package ObjectOriented;

/**
 * Created by anton on 2017-10-25.
 */
public class Employee {

    private int id;
    private int salary;
    private String firstname;
    private String lastname;

    public Employee(int id, int salary, String firstname, String lastname) {
        this.id = id;
        this.salary = salary;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void raiseSalary(int percent) {
        salary *= 1 / percent;
    }

    public String toString() {
        return "Emloyee[id=" + id + ",name=" + firstname + " " + lastname + ",salary=" + salary + "]";
    }
}
