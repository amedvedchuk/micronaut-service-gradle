package example.converter;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

/**
 *
 */
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class ConvertDto {

    private String result;
    private Long time;

    public ConvertDto() {
    }

    public ConvertDto(final String result, final Long time) {
        this.result = result;
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(final String result) {
        this.result = result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(final Long time) {
        this.time = time;
    }
}
