package se.standout.robert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class TimeLogTest {
  TimeLog log;
  String json =
      "{\"id\":125768,\"billing_title\":\"Konsult - Robert Sjoblom\",\"billing_description\":\"Outnorth september 2020\",\"user_id\":166,\"duration\":32881,\"duration_humanized\":\"9 h 8m\",\"started_at\":\"2020-09-07 T19:43:38.669+02:00\",\"created_at\":\"2020-09-07T07:30:48.290+02:00\",\"day\":\"2020-09-07\",\"updated_at\":\"2020-09-07T20:25:45.426+02:00\",\"task_id\":25916,\"project_id\":1095,\"project_title\":\"Outnorth\",\"charging\":\"pay_per_hour\",\"title\":\"Konsult-Robert\",\"description\":\"Konsult-Robert\",\"running\":false,\"money\":7306.888888888889,\"hourly_rate\":638.0,\"customer_name\":\"Outnorth AB\"}";

  @Before
  public void setUp() {
    try {
      log = TimeLog.getTimeLog(json);
    } catch (IOException e) {
      e.printStackTrace();
      log = null;
    }
  }

  @Test
  public void whenGivenEbJsonString_itCreates_aNewTimeLog() {
    assertNotNull(log);
  }

  @Test
  public void whenGivenString_itSets_ValueOfId() {
    assertEquals(125768, log.id);
  }

  @Test
  public void whenGivenString_itSets_ValueOfTaskId() {
    assertEquals(25916, log.task_id);
  }

  @Test
  public void whenGivenString_itSets_ValueOfBillingTitle() {
    assertEquals("Konsult - Robert Sjoblom", log.billing_title);
  }
}
