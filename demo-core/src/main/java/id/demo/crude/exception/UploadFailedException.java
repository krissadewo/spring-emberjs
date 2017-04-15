package id.demo.crude.exception;

public class UploadFailedException extends RuntimeException {

    public UploadFailedException(String message) {
        super(message);
    }
}
