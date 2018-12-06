package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private String name;
    private int intSmall;
    private Integer integer;
    private long longSmall;
    private Long longLarge;
}
