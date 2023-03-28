package tendencias.desafio01.start;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tendencias.desafio01.service.LeitorCsvService;

@Component
@RequiredArgsConstructor
public class ReadCsvInit {
    private final LeitorCsvService leitorCsvService;

    @Bean
    @Order(Integer.MAX_VALUE)
    public void initReadCsv() {
        leitorCsvService.read();
    }
}
