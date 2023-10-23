package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Errordto
{
             int status=0;
             String error;
            String message;
        //"path": "string"
}
