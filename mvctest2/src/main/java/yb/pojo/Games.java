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
public class Games {

  private Integer gameId;
  private String gameName;
  private String gameType;
  private String gameCompany;
  private Integer gameYear;
}
