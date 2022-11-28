//: refactoring.catalog.replace.loop.domain.service.ReaderService


package refactoring.catalog.replace.loop.domain.service;


import com.google.common.collect.ImmutableSet;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;


@AllArgsConstructor(staticName = "of")
class ReaderService {

    private final BookReadingService readingService;

// WITH LOOP ---->
//    Set<String> booksReadOn(@NonNull final List<String> readers,
//                            @NonNull final List<String> books,
//                            @NonNull final LocalDate date) {
//
//        Map<String, List<String>> data = readingService.readingDataOnDate(date);
//
//        Set<String> result = Sets.newHashSet();
//        for (Map.Entry<String, List<String>> e : data.entrySet()) {
//            for (String bookId : books) {
//                if (e.getValue().contains(bookId) && readers.contains(e.getKey())) {
//                    result.add(e.getKey());
//                }
//            }
//        }
//
//        return result;
//    }

    // WITH COLLECTION PIPELINE ---->
    Set<String> booksReadOn(@NonNull final List<String> readers,
                            @NonNull final List<String> books,
                            @NonNull final LocalDate date) {

        Map<String, List<String>> data = readingService.readingDataOnDate(date);

        return data.entrySet().stream()
                .filter(entry -> bookFilter(entry, readers, books))
                .map(Map.Entry::getKey)
                .collect(ImmutableSet.toImmutableSet());
    }

    boolean bookFilter(@NonNull final Map.Entry<String, List<String>> entry,
                       @NonNull final List<String> readers,
                       @NonNull final List<String> books) {

        return readers.contains(entry.getKey()) &&
                !CollectionUtils.intersection(entry.getValue(), books).isEmpty();
    }

}///:~