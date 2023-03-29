package tendencias.desafio01.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tendencias.desafio01.entity.Genre;
import tendencias.desafio01.entity.Movie;
import tendencias.desafio01.repository.MovieRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
@Service
@RequiredArgsConstructor
public class LeitorCsvService {
    private final MovieRepository movieRepository;

    public void read() {
        String isExit = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Informe o nome do arquivo CSV: ");
            String arquivoCSV = scanner.nextLine();
            CSVReader leitorCSV = null;

            try {
                leitorCSV = new CSVReader(new FileReader(arquivoCSV));
                String[] linha = null;
                List<Movie> movieList = new ArrayList<>();
                long init = System.currentTimeMillis();
                while ((linha = leitorCSV.readNext()) != null) {
                    List<Genre> genereList = new ArrayList<>();
                    String genere = linha[2];
                    String[] partes = genere.split("\\|");
                    ArrayList<String> lista = new ArrayList<String>();
                    Movie movie = Movie.builder()
                            .title(linha[0])
                            .years(Integer.valueOf(linha[1].trim()))
                            .genres(genereList)
                            .build();
                    movieList.add(movie);

                    for (String parte : partes) {
                        Genre genre = Genre.builder()
                                .decription(parte.trim())
                                .movie(movie)
                                .build();
                        genereList.add(genre);
                    }
                    System.out.println(lista);
                }
                movieRepository.saveAll(movieList);
                log.info("TIME: " + (System.currentTimeMillis() - init));
            } catch (IOException e) {
                log.error("File Invalid");
            } catch (CsvValidationException e) {
                log.error("File csv Invalid");
            } finally {
                if (leitorCSV != null) {
                    try {
                        leitorCSV.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Digite: S para sair ou C para continuar: ");
            isExit = StringUtils.upperCase(scanner.nextLine());
        } while (isExit.equals("C"));
    }
}
