package yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condition {
    private String commodityName;
    private Float minPrice;
    private Float maxPrice;
    private Integer typeId;

}
