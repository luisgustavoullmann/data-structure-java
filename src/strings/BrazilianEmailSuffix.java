package strings;

public class BrazilianEmailSuffix {

    public static void main(String[] args) {
        EmailInfo emailInfo1 = extractEmailInformation("jose.carlo@gmail.com");
        System.out.println("Username: " + emailInfo1.username);
        System.out.println("User domain :" + emailInfo1.domain);
        System.out.println("Is Brazilian?: " + (emailInfo1.isBrazilian ? "sim" : "não"));

        System.out.println("");
        EmailInfo emailInfo2 = extractEmailInformation("joao.barata@gmail.com.br");
        System.out.println("Username: " + emailInfo2.username);
        System.out.println("User domain :" + emailInfo2.domain);
        System.out.println("Is Brazilian?: " + (emailInfo2.isBrazilian ? "sim" : "não"));
    }

    public static EmailInfo extractEmailInformation(String email) {
        String[] parts = email.split("@");
        String username = parts[0];
        String domain = parts[1];

        boolean isBrazilian = domain.endsWith(".br");
        return new EmailInfo(username, domain, isBrazilian);
    }
}

class EmailInfo {
    String username;
    String domain;
    boolean isBrazilian;

    public EmailInfo(String username, String domain, boolean isBrazilian) {
        this.username = username;
        this.domain = domain;
        this.isBrazilian = isBrazilian;
    }
}
