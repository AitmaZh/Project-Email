package email_app;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int mailboxCapacity = 500; // По умолчанию
    private int defaultPasswordLength = 10;
    private String alternativeEmail;
    private String companySuffix = "aeycompany.com";

    // Определяем ФИ нового сотрудника
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Назначаем отдел
        this.department = setDepartment();

        // Отображаем пароль
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Генерируем email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Спрашиваем про отдел
    private String setDepartment() {
        System.out.print("New worker: " + firstName + ", " + "Department codes:\n1 for Sales\n2 for Development" +
                "\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "accounting";
        } else {
            return "none";
        }
    }

    // Условия для создания пароля
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] password = new char[length]; // security concern
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length()); // ?
            password[i] = passwordSet.charAt(rand); // charAt() возвращает символ из массива строки по указанному индексу
        }
        return new String(password);
    }

    // Расширение вместимости ящика
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Генерация альтернативного email-а
    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    // Смена пароля
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public String getPassword() {
        return password;
    }

    // Отображаем ФИ, email и вместимость эл.ящика в консоли
    public String showInfo() {
        System.out.println();
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}