package transformer

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors

class Input {

    final List<String> fileData

    Input(String fileName) {
        fileData = Files.lines(Paths.get(fileName))
                .collect(Collectors.toList())
    }

    void run() {
        try {
            fileData.forEach( { d -> System.out.println(d) } )
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}

