package APIAutomation;

public class UserResponse {
    private int code;
    private String type;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String description) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printResponseBody(){
        System.out.println("Code: "+ getCode()+"\n"+"Type"+ getType() + "\n"+"message:" +getMessage());
    }
}
