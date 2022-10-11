public class Data {

    private static final String VALID_CHARS = "abcdefghiklmnoprstuvwxyzABCDEFGHIKLMNOPRSTUVWXYZ0123456789_";

    Data() {
    }

    public static boolean validateAuthorization(String login,
                                                String password,
                                                String confirmPassword) {
        try {
            checkAutorization(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private static void checkAutorization(String login,
                                          String password,
                                          String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!checkAlphabetAndSymbol(login)) {
            throw new WrongLoginException("Логин не валидный");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        if (!checkAlphabetAndSymbol(password)) {
            throw new WrongPasswordException("Пароль невалидный");
        }
    }


    private static boolean checkAlphabetAndSymbol(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARS.contains(String.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
