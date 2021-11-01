package emailapp;

public class EmailAccountMakerPrinter {

    public static final String EMPTY_STRING = "";
    public static final String NONE = "None";
    private static StringBuilder message;
    private static StringBuilder recap = new StringBuilder();

    public static void messageToEnterFirstName() {
        message = new StringBuilder();
        message.append("Enter the first name:\n");
        print(message);
    }

    public static void messageToEnterLastName() {
        message = new StringBuilder();
        message.append("Enter the last name:\n");
        print(message);
    }

    public static void messageToEnterAlternateEmail() {
        message = new StringBuilder();
        message.append("Enter the Alternate Email:\n");
        print(message);
    }

    public static void recapForFirstNameAndLastNameAndAlternateEmail(String firstName, String lastName, String alternateEmail) {
        message = new StringBuilder();
        message.append("\nFirst name is: ")
                .append(firstName)
                .append("\n")
                .append("Last name is: ")
                .append(lastName)
                .append("\n")
                .append("Alternate Email is: ")
                .append(alternateEmail);
        print(message);

        recap.append(message);
    }

    public static void messageToChooseADepartment() {
        message = new StringBuilder();
        message.append("Enter the department\n")
                .append("1 for Sales\n")
                .append("2 for Development\n")
                .append("3 for Accounting\n")
                .append("0 for None");
        print(message);
    }

    public static void recapForDepartment(String department) {
        message = new StringBuilder();
        message.append("\nThe chosen department is: ")
                .append(setDepartment(department));
        print(message);
    }

    private static String setDepartment(String department) {
        if (!EMPTY_STRING.equals(department))
            return department;
        return NONE;
    }

    public static void recapForGeneratedPassword(String generatedPassword) {
        message = new StringBuilder();
        message.append("\nGenerated Password: ")
                .append(generatedPassword);
        print(message);

        recap.append(message);
    }

    public static void recapForGeneratedEmail(String generatedEmail, int emailBoxCapacity) {
        message = new StringBuilder();
        message.append("\nGenerated Email: ")
                .append(generatedEmail)
                .append("\n")
                .append("Capacity is: ")
                .append(emailBoxCapacity)
                .append(" per Month");
        print(message);

        recap.append(message);
    }

    public static void summary() {
        print("----------------------------------");
        print("Summary:\n");
        print(recap);
    }

    private static void print(Object message) {
        EmailAccountMakerUtil.print(message.toString());
    }
}
