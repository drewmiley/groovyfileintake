package transformer

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class FileReader {

    final List<String> fileData

    FileReader(String fileName) {
        fileData = Files.lines(Paths.get(fileName))
                .collect(Collectors.toList())
    }

    void print() {
        try {
            fileData.forEach( { d -> System.out.println(d) } )
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}

