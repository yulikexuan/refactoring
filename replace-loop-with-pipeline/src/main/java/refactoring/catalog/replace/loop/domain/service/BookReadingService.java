//: refactoring.catalog.replace.loop.domain.service.BookReadingService


package refactoring.catalog.replace.loop.domain.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public interface BookReadingService {

    Map<String, List<String>> readingDataOnDate(LocalDate date);

}///:~