package yb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StudentInfo {

  private Integer sid;
  private String sname;
  private String sgender;
  private Integer sage;
  private String saddress;
  private String semail;
}
