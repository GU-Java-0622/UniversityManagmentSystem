package web.exception;

public class AuthServiceAppError extends AppError{
    public enum AuthServiceError {
        PROFILE_NOT_FOUND
    }

    public AuthServiceAppError(String code, String message) {
        super(code, message);
    }
}
