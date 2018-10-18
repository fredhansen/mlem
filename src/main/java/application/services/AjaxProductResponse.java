package application.services;

public class AjaxProductResponse {

    private String message;
    private Object object;

    public AjaxProductResponse(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public AjaxProductResponse(String message) {
        this.message = message;
    }

    public AjaxProductResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "AjaxProductResponse{" +
                "message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
