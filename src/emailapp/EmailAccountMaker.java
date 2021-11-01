package emailapp;

import java.util.Scanner;

public class EmailAccountMaker {

    public static final String DICTIONARY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
    public static final int DICTIONARY_LENGTH = DICTIONARY.length();
    public static final int PASSWORD_LENGTH = 8;
    public static final int SALES_DEPARTMENT_CODE = 1;
    public static final int DEVELOPMENT_DEPARTMENT_CODE = 2;
    public static final int ACCOUNTING_DEPARTMENT_CODE = 3;
    public static final String COMPANY_SUFFIX = "maecompany.com";
    public static final String EMPTY_STRING = "";
    public static final String DOTE = ".";
    public static final String AROBAS = "@";
    public static final String SALES_DEPARTMENT = "sales";
    public static final String DEVELOPMENT_DEPARTMENT = "development";
    public static final String ACCOUNTING_DEPARTMENT = "accounting";

    private String firstName;
    private String lastName;
    private String password;
    private String alternateEmail;
    private String department;
    private String email;
    private int mailBoxCapacity;

    private Scanner input = new Scanner(System.in);

    //Constructor to receive the first name and last name
    public EmailAccountMaker() {
        input = new Scanner(System.in);
    }

    public void setFirstNameAndLastNameAndAlternateEmail() {
        EmailAccountMakerPrinter.messageToEnterFirstName();
        this.firstName = toLowerCase(replaceSpaceByDash(getInputString()));
        EmailAccountMakerPrinter.messageToEnterLastName();
        this.lastName = toLowerCase(replaceSpaceByDash(getInputString()));
        EmailAccountMakerPrinter.messageToEnterAlternateEmail();
        this.alternateEmail = getInputString();
        EmailAccountMakerPrinter.recapForFirstNameAndLastNameAndAlternateEmail(firstName, lastName, alternateEmail);

    }

    //Ask fot the department
    public void setDepartment() {
        EmailAccountMakerPrinter.messageToChooseADepartment();
        this.department = EMPTY_STRING;
        int departmentChoice = getInputInteger();

        switch (departmentChoice) {
            case SALES_DEPARTMENT_CODE:
                this.department = toLowerCase(Departments.SALES.name());
                break;
            case DEVELOPMENT_DEPARTMENT_CODE:
                this.department = toLowerCase(Departments.DEVELOPMENT.name());
                break;
            case ACCOUNTING_DEPARTMENT_CODE:
                this.department = toLowerCase(Departments.ACCOUNTING.name());
                break;
        }

        EmailAccountMakerPrinter.recapForDepartment(this.department);
        closeInput();
    }

    //Generate a random password
    public void generateRandomTemporaryPassword() {
        char[] temporaryPassword = new char[PASSWORD_LENGTH];
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomNumber = getRandomNumberBetweenZeroAndLengthDictionary();
            temporaryPassword[i] = DICTIONARY.charAt(randomNumber);
        }
        this.password = toString(temporaryPassword);
        EmailAccountMakerPrinter.recapForGeneratedPassword(this.password);
    }

    private int getRandomNumberBetweenZeroAndLengthDictionary() {
        return (int) (Math.random() * DICTIONARY_LENGTH);
    }

    //Generate the email
    public void generateEmail() {
        StringBuilder emailBuilder = new StringBuilder();

        emailBuilder.append(this.firstName)
                .append(DOTE)
                .append(this.lastName)
                .append(AROBAS)
                .append(setDepartmentInEmail())
                .append(COMPANY_SUFFIX);

        this.email = emailBuilder.toString();
        this.mailBoxCapacity = getMailBoxCapacity();
        EmailAccountMakerPrinter.recapForGeneratedEmail(this.email, this.mailBoxCapacity);
    }

    private String setDepartmentInEmail() {
        if (!EMPTY_STRING.equals(this.department))
            return this.department + DOTE;
        return EMPTY_STRING;
    }

    //Set the mailbox capacity
    private int getMailBoxCapacity() {

        switch (this.department) {
            case SALES_DEPARTMENT:
                return MailBoxCapacity.SALES.getCapacity();
            case DEVELOPMENT_DEPARTMENT:
                return MailBoxCapacity.DEVELOPMENT.getCapacity();
            case ACCOUNTING_DEPARTMENT:
                return MailBoxCapacity.ACCOUNTING.getCapacity();
        }
        return MailBoxCapacity.NONE.getCapacity();
    }

    public void getRecap() {
        EmailAccountMakerPrinter.summary();
    }

    private String toLowerCase(String ss) {
        return EmailAccountMakerUtil.toLowerCase(ss);
    }

    private String replaceSpaceByDash(String ss) {
        return EmailAccountMakerUtil.replaceSpaceByDash(ss);
    }

    private String toString(char[] chars) {
        return EmailAccountMakerUtil.toString(chars);
    }

    private int getInputInteger() {
        return input.nextInt();
    }

    private String getInputString() {
        input.useDelimiter("\n");
        return input.nextLine();
    }

    private void closeInput() {
        input.close();
    }
}
