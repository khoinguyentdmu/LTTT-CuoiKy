package tdmu.exception;

public class PhoneNotFoundException extends RuntimeException {
    public PhoneNotFoundException(Long id) {
        super("Could not find phone " + id);
    }
}