package yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Commodity {

  private Integer commodityId;
  private String commodityName;
  private Float commodityPrice;
  private Integer commodityCount;
  private Integer typeId;

  private Type type;
}
