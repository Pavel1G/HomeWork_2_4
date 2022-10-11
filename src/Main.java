public class Main {
    public static void main(String[] args) {
        boolean success = Data.validateAuthorization("Pavel", "test123_", "test123_");
        System.out.println(success ? "Данные валидны" : "Данные невалидны");
    }
}