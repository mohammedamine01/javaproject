package emailapp;

public class Main {

    public static void main(String[] args) {

        EmailAccountMaker emailAccountMaker = new EmailAccountMaker();
        emailAccountMaker.setFirstNameAndLastNameAndAlternateEmail();
        emailAccountMaker.setDepartment();
        emailAccountMaker.generateRandomTemporaryPassword();
        emailAccountMaker.generateEmail();
        emailAccountMaker.getRecap();
    }
}
