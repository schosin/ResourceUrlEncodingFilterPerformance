package de.schosins.resourceresolverperformance;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Duration;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @ParameterizedTest
    @ValueSource(ints = { 0, 0, 0, 1, 1, 1, 10, 10, 10, 500, 500, 500, 2000, 2000, 2000 })
    void testIndex(int links) throws Exception {
        var start = System.nanoTime();
        mockMvc.perform(get("/").param("links", Integer.toString(links)))
                .andExpect(status().isOk());

        var duration = Duration.ofNanos(System.nanoTime() - start);
        System.out.println(String.format("Default: %03d: %s", links, duration));
    }

}
