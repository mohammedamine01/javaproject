package emailapp;

public class EmailAccountMakerPrinter {


    public static String messageToChooseADepartment() {
        StringBuilder message = new StringBuilder();
        message.append("Enter the department\n")
                .append("1 for Sales\n")
                .append("2 for Development\n")
                .append("3 for Accounting\n")
                .append("0 for none");
        return message.toString();
    }
}
