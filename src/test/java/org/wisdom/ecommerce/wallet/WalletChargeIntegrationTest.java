package org.wisdom.ecommerce.wallet;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
public class WalletChargeIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void 비관적락_포인트_충전_연속_2번_따닥_응답시간_테스트() throws Exception {
    // given
    val requestJson = "{\"userId\": 1, \"amount\": 1000000.0}";
    val numberOfRequests = 2;
    val latch = new CountDownLatch(numberOfRequests);
    val executorService = Executors.newFixedThreadPool(numberOfRequests);
    // when
    for (int i = 0; i < numberOfRequests; i++) {
      executorService.submit(() -> {
        try {
          val startTime = System.currentTimeMillis();
          mockMvc.perform(MockMvcRequestBuilders.patch("/api/v1/wallet")
                  .contentType(MediaType.APPLICATION_JSON)
                  .content(requestJson))
              .andExpect(MockMvcResultMatchers.status().isOk());
          val endTime = System.currentTimeMillis();
          val duration = endTime - startTime;
          log.info("Response time for chargePoint: {} ms", duration);
        } catch (Exception e) {
          log.error("Error occurred during charge point request: {}", e.getMessage());
        } finally {
          latch.countDown();
        }
      });
    }
    latch.await();
    executorService.shutdown();
  }
}
