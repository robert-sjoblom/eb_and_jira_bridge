package se.standout.robert;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeLog {
  public int id;
  public String billing_title;
  public String billing_description;
  public int user_id;
  public int duration;
  public int task_id;
  public int project_id;
  public String title;
  public String description;

  public static TimeLog getTimeLog(String jsonTimeLog)
      throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper objectMapper = new ObjectMapper();

    TimeLog log = objectMapper.readValue(jsonTimeLog, TimeLog.class);
    return log;
  }
}
