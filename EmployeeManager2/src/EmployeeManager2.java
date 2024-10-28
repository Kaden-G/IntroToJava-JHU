package src;

public class EmployeeManager2 {
    public static void main(String[] args) {
        // Creating salaried and hourly employees
        Name salariedName = new Name("Michael", "Scott");
        Address salariedAddress = new Address("1725 Slough Ave", "Scranton", "PA", "18505");
        Date hireDateSalaried = new Date(3, 15, 1992);

        // Creating a salaried employee - Michael Scott
        SalariedEmployee michaelScott = new SalariedEmployee(1001, salariedName, salariedAddress, hireDateSalaried, 120000);

        // Creating Name, Address, and Date objects for Hourly Employees (Dwight Schrute and Jim Halpert)
        Name hourlyName1 = new Name("Dwight", "Schrute");
        Address hourlyAddress1 = new Address("Schrute Farms", "Honesdale", "PA", "18431");
        Date hireDateHourly1 = new Date(6, 10, 2001);

        Name hourlyName2 = new Name("Jim", "Halpert");
        Address hourlyAddress2 = new Address("99 Paper St", "Scranton", "PA", "18505");
        Date hireDateHourly2 = new Date(2, 25, 2005);

        // Creating hourly employees - Dwight Schrute and Jim Halpert
        HourlyEmployee dwightSchrute = new HourlyEmployee(1002, hourlyName1, hourlyAddress1, hireDateHourly1, 25.0, 50); // Dwight works more than 40 hours
        HourlyEmployee jimHalpert = new HourlyEmployee(1003, hourlyName2, hourlyAddress2, hireDateHourly2, 22.0, 38);   // Jim works less than 40 hours

        // Displaying employee details
        System.out.println("Salaried Employee Details:");
        System.out.println(michaelScott);
        System.out.println("\nHourly Employee 1 Details:");
        System.out.println(dwightSchrute);
        System.out.println("\nHourly Employee 2 Details:");
        System.out.println(jimHalpert);
    }
}