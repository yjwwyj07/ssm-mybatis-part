package generator.com.atguigu.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * @TableName student
 */
@Data
public class Student implements Serializable {
    private Integer sid;

    private byte[] sname;

    private static final long serialVersionUID = 1L;
}