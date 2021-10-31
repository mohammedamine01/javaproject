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

    //Constructor to receive the first name and last name
    public EmailAccountMaker(String firstName, String lastName) {

        this.firstName = toLowerCase(replaceSpaceByDash(firstName));
        this.lastName = toLowerCase(replaceSpaceByDash(lastName));

        print("Person name:" + this.firstName + " " + this.lastName);

        // Set the choosing department
        this.department = getChosenDepartment();
        print("DEPARTMENT:"+department);

        //Set a random password
        this.password = getRandomTemporaryPassword();
        print("PASSWORD:"+password);

        // Set an Email based on first name, last name and chosen department
        this.email = getEmail();
        print("EMAIL:"+email);

        // Set MailBox Capacity
        this.mailBoxCapacity = getMailBoxCapacity();
        print("MAILBOX CAPACITY:"+mailBoxCapacity);

        // Set Alternate Email
        this.alternateEmail = getAlternateEmail();
        print("Alternate Email:"+alternateEmail);

        // Set New Password


    }



    //Ask fot the department
    private String getChosenDepartment() {
        print(EmailAccountMakerPrinter.messageToChooseADepartment());
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();

        switch (departmentChoice) {
            case SALES_DEPARTMENT_CODE:
                return toLowerCase(Departments.SALES.name());
            case DEVELOPMENT_DEPARTMENT_CODE:
                return toLowerCase(Departments.DEVELOPMENT.name());
            case ACCOUNTING_DEPARTMENT_CODE:
                return toLowerCase(Departments.ACCOUNTING.name());
        }
        return EMPTY_STRING;

    }

    //Generate a random password
    private String getRandomTemporaryPassword() {
        char[] temporaryPassword = new char[PASSWORD_LENGTH];
        int randomNumber = 0;
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            randomNumber = getRandomNumberBetweenZeroAndLengthDictionary();
            temporaryPassword[i] = DICTIONARY.charAt(randomNumber);
        }
        return toString(temporaryPassword);
    }

    private int getRandomNumberBetweenZeroAndLengthDictionary() {
        return (int) (Math.random() * DICTIONARY_LENGTH);
    }

    //Generate the email
    private String getEmail() {
        StringBuilder email = new StringBuilder();

        email.append(this.firstName)
                .append(DOTE)
                .append(this.lastName)
                .append(AROBAS)
                .append(setDepartmentInEmail())
                .append(COMPANY_SUFFIX);

        return email.toString();
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
        return 0;
    }

    //Set and Get the alternate email
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }


    //Change the password
    public void setNewPassword(String password) {
        this.password = password;
    }

    private void print(Object message) {
        EmailAccountMakerUtil.print(message.toString());
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

}
